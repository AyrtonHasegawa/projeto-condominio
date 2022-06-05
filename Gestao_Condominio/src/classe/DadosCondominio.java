
package classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ayrton Hasegawa
 */
public class DadosCondominio {

    String melhotia_Morador;

    ConectaBD conecta = new ConectaBD();
    Funcionario funcionario = new Funcionario();
    Apartamento apartamento = new Apartamento();
    Morador morador = new Morador();
    Visita visita = new Visita();
    Visitante visitante = new Visitante();
    Veiculo veiculo = new Veiculo();
    
    Connection conCondominio;
    String sql, msg, statusConexao;  //listar
    PreparedStatement psCondominio;
    Statement stCondominio;
    ResultSet rsCondominio;
    ResultSet rsDadosUsuario;
    ResultSet rsDadosFuncionario;

    public DadosCondominio() {
        statusConexao = conecta.setConecta();
        conCondominio = conecta.getConecta();
    }

    public String getCon() {
        return statusConexao;
    }

    public boolean consultaLogin(String usuario, String senha) {
        boolean autenticado = false;
        sql = "select Fun_Login, Fun_Senha from Tb_Funcionario "
                + "where Fun_Login = ? and Fun_Senha = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, usuario);
            psCondominio.setString(2, senha);
            rsDadosFuncionario = psCondominio.executeQuery();

            if (rsDadosFuncionario.first()) {

                autenticado = true;
            }
            return autenticado;
        } catch (Exception e) {
            rsDadosFuncionario = null;
        }
        return autenticado;
    }

    //-------------- Valida Número -----------------
    public String validaNumero(String stringCheck, int radix) {
        String valida;
        if (stringCheck.isEmpty()) {
            return valida = "Vazio";
        }
        for (int i = 0; i < stringCheck.length(); i++) {
            if (i == 0 && stringCheck.charAt(i) == '-') {
                if (stringCheck.length() == 1) {
                    return valida = "Negativo";
                } else {
                    continue;
                }
            }
            if (Character.digit(stringCheck.charAt(i), radix) < 0) {
                return valida = "Letra";
            }
        }
        return valida = "Numero";
    }

    //-------------- Valida CPF -----------------
    public String validaCpf(String cpf) {
        long tamanhoCpf = cpf.length();

        if (tamanhoCpf == 11) {
            if(validaNumero(cpf, 20).equals("Numero")) {
                msg = "Ok";
            }            
        } else {
            msg = "Um CPF válido comtém 11 dígitos";
        }
        return msg;
    }

    //-------------- Valida Nome -----------------
    public boolean validaNome(String nome) {
        boolean valida = false;

        if (!nome.matches("[a-zA-ZÁÀÃÂÇÉÈÊÍÓÒÕÔÚÙáàãâçéèêíóòõôúù ]*")) {
            return valida = false;
        } else {
            valida = true;
        }

        return valida;
    }

    //-------------- Novo Funcionario Aprovado-----------------
    public ResultSet consultaGeralFuncionario() {
        sql = "select * from Tb_Funcionario";
        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }

    public Funcionario consultaCpfFuncionario(String cpf) {

        sql = "select * from Tb_Funcionario where Fun_CPF = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpf);
            rsCondominio = psCondominio.executeQuery();

            if (rsCondominio.next()) {
                funcionario.setCod_Fun(rsCondominio.getInt("Fun_Cod_Funcionario"));
                funcionario.setCpf(rsCondominio.getString("Fun_CPF"));
                funcionario.setNome(rsCondominio.getString("Fun_Nome"));
                funcionario.setCargo(rsCondominio.getString("Fun_Cargo"));
                funcionario.setTelefone(rsCondominio.getString("Fun_Telefone"));
                funcionario.setEndereco(rsCondominio.getString("Fun_Endereco"));
                funcionario.setAtivo(rsCondominio.getString("Fun_Ativo"));
                funcionario.setLogin(rsCondominio.getString("Fun_Login"));
                funcionario.setSenha(rsCondominio.getString("Fun_Senha"));
                return funcionario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public String alteraFuncionario(Funcionario funcionario) {
        sql = "update Tb_Funcionario set Fun_CPF = ?, Fun_Nome = ?, Fun_Cargo = ?,"
                + "Fun_Telefone = ?, Fun_Endereco = ?, Fun_Ativo = ?, Fun_Login = ?,"
                + "Fun_Senha = ? where Fun_Cod_Funcionario = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(9, funcionario.getCod_Fun());
            psCondominio.setString(1, funcionario.getCpf());
            psCondominio.setString(2, funcionario.getNome());
            psCondominio.setString(3, funcionario.getCargo());
            psCondominio.setString(4, funcionario.getTelefone());
            psCondominio.setString(5, funcionario.getEndereco());
            psCondominio.setString(6, funcionario.getAtivo());
            psCondominio.setString(7, funcionario.getLogin());
            psCondominio.setString(8, funcionario.getSenha());
            psCondominio.executeUpdate();
            msg = "Dados do Funcionário alterado com sucesso!";
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }

    public String insereFuncionario(Funcionario funcionario) {
        sql = "insert into Tb_Funcionario(Fun_CPF, "
                + "Fun_Nome, Fun_Cargo, Fun_Telefone, Fun_Endereco, Fun_Ativo, "
                + "Fun_Login, Fun_Senha) values(?,?,?,?,?,?,?,?)";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, funcionario.getCpf());
            psCondominio.setString(2, funcionario.getNome());
            psCondominio.setString(3, funcionario.getCargo());
            psCondominio.setString(4, funcionario.getTelefone());
            psCondominio.setString(5, funcionario.getEndereco());
            psCondominio.setString(6, funcionario.getAtivo());
            psCondominio.setString(7, funcionario.getLogin());
            psCondominio.setString(8, funcionario.getSenha());

            psCondominio.executeUpdate();
            msg = "Funcionário inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }

    public String excluiFuncionario(String codigo) {
        try {
            sql = "delete from Tb_Funcionario where Fun_Cod_Funcionario = ?";
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, codigo);
            psCondominio.executeUpdate();
            msg = "Funcionario excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }

    public Funcionario consultaCodigoFuncionario(int codigo) {
        sql = "select * from Tb_Funcionario where Fun_Cod_Funcionario = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigo);
            rsCondominio = psCondominio.executeQuery();
            if (rsCondominio.next()) {
                funcionario.setCod_Fun(rsCondominio.getInt("Fun_Cod_Funcionario"));
                funcionario.setCpf(rsCondominio.getString("Fun_CPF"));
                funcionario.setNome(rsCondominio.getString("Fun_Nome"));
                funcionario.setCargo(rsCondominio.getString("Fun_Cargo"));
                funcionario.setTelefone(rsCondominio.getString("Fun_Telefone"));
                funcionario.setEndereco(rsCondominio.getString("Fun_Endereco"));
                funcionario.setAtivo(rsCondominio.getString("Fun_Ativo"));
                funcionario.setLogin(rsCondominio.getString("Fun_Login"));
                funcionario.setSenha(rsCondominio.getString("Fun_Senha"));
                return funcionario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Funcionario consultaLogin(String login) {
        sql = "select * from Tb_Funcionario where Fun_Login = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, login);
            rsCondominio = psCondominio.executeQuery();
            if (rsCondominio.next()) {
                funcionario.setCod_Fun(rsCondominio.getInt("Fun_Cod_Funcionario"));
                funcionario.setCpf(rsCondominio.getString("Fun_CPF"));
                funcionario.setNome(rsCondominio.getString("Fun_Nome"));
                funcionario.setCargo(rsCondominio.getString("Fun_Cargo"));
                funcionario.setTelefone(rsCondominio.getString("Fun_Telefone"));
                funcionario.setEndereco(rsCondominio.getString("Fun_Endereco"));
                funcionario.setAtivo(rsCondominio.getString("Fun_Ativo"));
                funcionario.setLogin(rsCondominio.getString("Fun_Login"));
                funcionario.setSenha(rsCondominio.getString("Fun_Senha"));
                return funcionario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int duplicidadeCpf(long cpf) {
        int qnt = 0;
        sql = "select Fun_CPF, count(*) from Tb_Funcionario where Fun_CPF = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setLong(1, cpf);
            rsCondominio = psCondominio.executeQuery();
            qnt = rsCondominio.getInt(1);
        } catch (Exception e) {
        }

        return qnt;
    }
    //------------ Apartamento --------------

    public ResultSet consultaGeralApartamento() {
        sql = "SELECT * FROM tb_apartamento";
        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }

    public Apartamento consultaBlocoApartamento(String bloco) {
        sql = "SELECT * FROM tb_apartamento WHERE Ap_Bloco_Predio = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, bloco);
            rsCondominio = psCondominio.executeQuery();

            if (rsCondominio.next()) {
                apartamento.setCodigoAparatamento(rsCondominio.getInt("Ap_Cod_Apartamento"));
                apartamento.setNumeroApartamento(rsCondominio.getString("Ap_Num_Apartamento"));
                apartamento.setBlocoApartamento(rsCondominio.getString("Ap_Bloco_Predio"));
                apartamento.setVagaApartamento_1(rsCondominio.getString("Ap_Num_Vaga1"));
                apartamento.setVagaApartamento_2(rsCondominio.getString("Ap_Num_Vaga2"));

                return apartamento;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }

    public Apartamento consultaNumeroApartamento(int num) {
        sql = "SELECT * FROM tb_apartamento WHERE Ap_Num_Apartamento = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, num);
            rsCondominio = psCondominio.executeQuery();

            if (rsCondominio.next()) {
                apartamento.setCodigoAparatamento(rsCondominio.getInt("Ap_Cod_Apartamento"));
                apartamento.setNumeroApartamento(rsCondominio.getString("Ap_Num_Apartamento"));
                apartamento.setBlocoApartamento(rsCondominio.getString("Ap_Bloco_Predio"));
                apartamento.setVagaApartamento_1(rsCondominio.getString("Ap_Num_Vaga1"));
                apartamento.setVagaApartamento_2(rsCondominio.getString("Ap_Num_Vaga2"));

                return apartamento;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Apartamento consultaCodigoApartamento(int codigoApartamento) {
        sql = "SELECT * FROM tb_apartamento WHERE Ap_Cod_Apartamento = ?";
        System.out.println("codigoApartamento consulta cod ----> " + codigoApartamento);
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigoApartamento);
            rsCondominio = psCondominio.executeQuery();
            
            if(rsCondominio.next()) {
                apartamento.setCodigoAparatamento(rsCondominio.getInt("Ap_Cod_Apartamento"));
                System.out.println("setCodigoAparatamento ----> " + rsCondominio.getInt("Ap_Cod_Apartamento"));
                apartamento.setNumeroApartamento(rsCondominio.getString("Ap_Num_Apartamento"));
                apartamento.setBlocoApartamento(rsCondominio.getString("Ap_Bloco_Predio"));
                apartamento.setVagaApartamento_1(rsCondominio.getString("Ap_Num_Vaga1"));
                apartamento.setVagaApartamento_2(rsCondominio.getString("Ap_Num_Vaga2"));
                
                return apartamento;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    //verifica se já existe o apartamento no bloco
    public Apartamento verificaExisteApartamento(String bloco, int numero) {

        sql = "SELECT * FROM tb_apartamento WHERE Ap_Bloco_Predio = ? AND Ap_Num_Apartamento = ?";

        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, bloco);
            psCondominio.setInt(2, numero);
            rsCondominio = psCondominio.executeQuery();

            if (rsCondominio.next()) {
                apartamento.setCodigoAparatamento(rsCondominio.getInt("Ap_Cod_Apartamento"));
                apartamento.setNumeroApartamento(rsCondominio.getString("Ap_Num_Apartamento"));
                apartamento.setBlocoApartamento(rsCondominio.getString("Ap_Bloco_Predio"));
                apartamento.setVagaApartamento_1(rsCondominio.getString("Ap_Num_Vaga1"));
                apartamento.setVagaApartamento_2(rsCondominio.getString("Ap_Num_Vaga2"));

                return apartamento;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String insereApartamento(Apartamento apartamento) {
        sql = "INSERT INTO tb_apartamento (Ap_Bloco_Predio, Ap_Num_Apartamento,"
                + "Ap_Num_Vaga1, Ap_Num_Vaga2) VALUES(?,?,?,?)";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, apartamento.getBlocoApartamento());
            psCondominio.setString(2, apartamento.getNumeroApartamento());
            psCondominio.setString(3, apartamento.getVagaApartamento_1());
            psCondominio.setString(4, apartamento.getVagaApartamento_2());

            psCondominio.executeUpdate();
            msg = "Apartamento inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }

    public String excluiApartamento(String codigo) {
        try {
            sql = "DELETE FROM tb_apartamento WHERE Ap_Cod_Apartamento = ?";
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, codigo);
            psCondominio.executeUpdate();
            msg = "Apartamento excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }

    public String alterarApartamento(Apartamento apartamento) {
        sql = "UPDATE tb_apartamento SET Ap_Bloco_Predio = ?, Ap_Num_Apartamento = ?, "
                + "Ap_Num_Vaga1 = ?, Ap_Num_Vaga2 = ? WHERE Ap_Cod_Apartamento = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, apartamento.getBlocoApartamento());
            psCondominio.setString(2, apartamento.getNumeroApartamento());
            psCondominio.setString(3, apartamento.getVagaApartamento_1());
            psCondominio.setString(4, apartamento.getVagaApartamento_2());
            psCondominio.setInt(5, apartamento.getCodigoApartamento());
            psCondominio.executeUpdate();
            msg = "Dados do Funcionário alterado com sucesso!";
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }
    
    //------------ Morador --------------
    public ResultSet consultaGeralMorador() {
        sql = "SELECT * FROM tb_morador";

        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }

    public String insereMorador(Morador morador, int codigoApartamento) {

        sql = "INSERT INTO tb_morador(Mor_CPF, Mor_Nome, Mor_Email, Mor_Telefone, "
                + "Mor_Ativo, Mor_Cod_Apartamento) VALUES(?,?,?,?,?,?)";
               
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, morador.getCpfMorador());
            psCondominio.setString(2, morador.getNomeMorador());
            psCondominio.setString(3, morador.getEmailMorador());
            psCondominio.setString(4, morador.getTelefoneMorador());
            psCondominio.setString(5, morador.getAtivoMorador());
            psCondominio.setInt(6, codigoApartamento);

            psCondominio.executeUpdate();
            msg = "Morador inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }

    public String alteraMorador(Morador morador, String cpfAntigo) {
        System.out.println("");
        sql = "UPDATE tb_morador SET Mor_CPF = ?, Mor_Nome = ?, Mor_Email = ?,"
                + " Mor_Telefone = ?, Mor_Ativo = ?, Mor_Cod_Apartamento = ?"
                + " WHERE Mor_CPF = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(7, cpfAntigo);
            psCondominio.setString(1, morador.getCpfMorador());
            psCondominio.setString(2, morador.getNomeMorador());
            psCondominio.setString(3, morador.getEmailMorador());
            psCondominio.setString(4, morador.getTelefoneMorador());
            psCondominio.setString(5, morador.getAtivoMorador());
            psCondominio.setInt(6, morador.getCodigoApartamento());
            
            System.out.println("morador.getCpfMorador() ----> " + morador.getCpfMorador());
            psCondominio.executeUpdate();
            msg = "Dados do Morador alterado com sucesso!";
            
            
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }
    
    public Morador consultaCpfMorador(String cpf) {

        sql = "SELECT * FROM tb_morador WHERE Mor_CPF = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpf);
            rsCondominio = psCondominio.executeQuery();

            if (rsCondominio.next()) {
                
                morador.setCpfMorador(rsCondominio.getString("Mor_CPF"));
                morador.setNomeMorador(rsCondominio.getString("Mor_Nome"));
                morador.setEmailMorador(rsCondominio.getString("Mor_Email"));
                morador.setTelefoneMorador(rsCondominio.getString("Mor_Telefone"));
                morador.setAtivoMorador(rsCondominio.getString("Mor_Ativo"));
                morador.setCodigoApartamento(rsCondominio.getInt("Mor_Cod_Apartamento"));
                
                return morador;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Morador> consultaMoradorCodigoApartamento(int codigoApartamentoMorador) {
        sql = "SELECT * FROM tb_morador WHERE Mor_Cod_Apartamento = ?";
        List<Morador> listMorador = new LinkedList<>();
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigoApartamentoMorador);
            rsCondominio = psCondominio.executeQuery();
            
            while(rsCondominio.next()) {
                Morador pegaMorador = new Morador();
                
                pegaMorador.setCpfMorador(rsCondominio.getString("Mor_CPF"));
                pegaMorador.setNomeMorador(rsCondominio.getString("Mor_Nome"));
                pegaMorador.setEmailMorador(rsCondominio.getString("Mor_Email"));
                pegaMorador.setTelefoneMorador(rsCondominio.getString("Mor_Telefone"));
                pegaMorador.setAtivoMorador(rsCondominio.getString("Mor_Ativo"));
                pegaMorador.setCodigoApartamento(Integer.parseInt(rsCondominio.getString("Mor_Cod_Apartamento")));
                
                listMorador.add(pegaMorador);
            }
            
            return listMorador;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public String excluiMorador(String cpfMorador) {
        try {
            sql = "DELETE FROM tb_morador WHERE Mor_CPF = ?";
            
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfMorador);
            psCondominio.executeUpdate();
            msg = "Morador excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }
    
    //------------ Visita --------------
    public ResultSet consultaGeralVisita() {
        sql = "SELECT * FROM tb_visita";

        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }
    
    public String insereVisita(Visita visita) {
        
        sql = "INSERT INTO tb_visita(Vs_Data, Vs_Hora_Entrada, Vs_CPF_Morador, "
                + "Vs_CPF_Visitante) VALUES(?,?,?,?)";
               
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, visita.getData());
            System.out.println("setDate ----> " + visita.getData());
            psCondominio.setString(2, visita.getHora());
            System.out.println("setTime ----> " + visita.getHora());
            psCondominio.setString(3, visita.getCpfMoradorVisita());
            psCondominio.setString(4, visita.getCpfVisitanteVisita());

            psCondominio.executeUpdate();
            msg = "Visita inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }
    
    public String alteraVisita(Visita visita) {
        
        sql = "UPDATE tb_visita SET Vs_Data = ?, Vs_Hora_Entrada = ?, Vs_CPF_Morador = ?,"
                + "Vs_CPF_Visitante = ? WHERE Vs_Cod_Visita = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, visita.getData());
            psCondominio.setString(2, visita.getHora());
            psCondominio.setString(3, visita.getCpfMoradorVisita());
            psCondominio.setString(4, visita.getCpfVisitanteVisita());
            psCondominio.setInt(5, visita.getCodVisita());
            psCondominio.executeUpdate();
            msg = "Dados da Visita alterado com sucesso!";
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }
    
    public String excluiVisita(int codigoVisita) {
        
        try {
            sql = "DELETE FROM tb_visita WHERE Vs_Cod_Visita = ?";
            
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigoVisita);
            psCondominio.executeUpdate();
            msg = "Visita excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }
    
    public Visita consultaCodigoVisita(int codigoVisita) {
        sql = "SELECT * FROM tb_visita WHERE Vs_Cod_Visita = ?";
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigoVisita);
            rsCondominio = psCondominio.executeQuery();
            
            if(rsCondominio.next()) {
                visita.setCodVisita(rsCondominio.getInt("Vs_Cod_Visita"));
                visita.setData(rsCondominio.getString("Vs_Data"));
                visita.setHora(rsCondominio.getString("Vs_Hora_Entrada"));
                visita.setCpfMoradorVisita(rsCondominio.getString("Vs_CPF_Morador"));
                visita.setCpfVisitanteVisita(rsCondominio.getString("Vs_CPF_Visitante"));
                
                return visita;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Visita> consultaVisitaPeloCpfMorador(String cpfMorador) {
        sql = "SELECT * FROM tb_visita WHERE Vs_CPF_Morador = ?";
        List<Visita> listaVisita = new LinkedList<>();
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfMorador);
            rsCondominio = psCondominio.executeQuery();
            
            while(rsCondominio.next()) {
                Visita pegaVisita = new Visita();
                
                pegaVisita.setCodVisita(Integer.parseInt(rsCondominio.getString("Vs_Cod_Visita")));
                pegaVisita.setData(rsCondominio.getString("Vs_Data"));
                pegaVisita.setHora(rsCondominio.getString("Vs_Hora_Entrada"));
                pegaVisita.setCpfMoradorVisita(rsCondominio.getString("Vs_CPF_Morador"));
                pegaVisita.setCpfVisitanteVisita(rsCondominio.getString("Vs_CPF_Visitante"));
                
                listaVisita.add(pegaVisita);
            }
            
            return listaVisita;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Visita> consultaVisitaPeloCpfVisitante(String cpfVisitante) {
        sql = "SELECT * FROM tb_visita WHERE Vs_CPF_Visitante = ?";
        List<Visita> listaVisita = new LinkedList<>();
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfVisitante);
            rsCondominio = psCondominio.executeQuery();
            
            while(rsCondominio.next()) {
                Visita pegaVisita = new Visita();
                
                pegaVisita.setCodVisita(Integer.parseInt(rsCondominio.getString("Vs_Cod_Visita")));
                pegaVisita.setData(rsCondominio.getString("Vs_Data"));
                pegaVisita.setHora(rsCondominio.getString("Vs_Hora_Entrada"));
                pegaVisita.setCpfMoradorVisita(rsCondominio.getString("Vs_CPF_Morador"));
                pegaVisita.setCpfVisitanteVisita(rsCondominio.getString("Vs_CPF_Visitante"));
                
                listaVisita.add(pegaVisita);
            }
            
            return listaVisita;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    //------------ Visitante --------------
    public ResultSet consultaGeralVisitante() {
        sql = "SELECT * FROM tb_visitante";

        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }
    
    public String insereVisitante(Visitante visitante) {
        
        sql = "INSERT INTO tb_visitante(Vst_CPF , Vst_Nome) VALUE(?,?)";
               
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, visitante.getCpfVisitante());
            psCondominio.setString(2, visitante.getNomeVisitante());

            psCondominio.executeUpdate();
            msg = "Visitante inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }
    
    public String alteraVisitante(Visitante visitante, String cpfAntigo) {
        
        sql = "UPDATE tb_visitante SET Vst_CPF = ?, Vst_Nome = ? WHERE Vst_CPF = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(3, cpfAntigo);
            psCondominio.setString(1, visitante.getCpfVisitante());
            psCondominio.setString(2, visitante.getNomeVisitante());
            
            psCondominio.executeUpdate();
            msg = "Dados do Visitante alterado com sucesso!";
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }
    
    public String excluiVisitante(String cpfVisitante) {
        
        try {
            sql = "DELETE FROM tb_visitante WHERE Vst_CPF = ?";
            
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfVisitante);
            psCondominio.executeUpdate();
            msg = "Visitante excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }
    
    public Visitante consultaCpfVisitante(String cpfVisitante) {
        
        sql = "SELECT * FROM tb_visitante WHERE Vst_CPF = ?";
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfVisitante);
            rsCondominio = psCondominio.executeQuery();
            
            if(rsCondominio.next()) {
                visitante.setCpfVisitante(rsCondominio.getString("Vst_CPF"));
                visitante.setNomeVisitante(rsCondominio.getString("Vst_Nome"));
                
                return visitante;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    //------------ Veículo --------------
    public ResultSet consultaGeralVeiculo() {
        sql = "SELECT * FROM tb_veiculo";

        try {
            stCondominio = conCondominio.createStatement();
            rsCondominio = stCondominio.executeQuery(sql);
            rsCondominio.first();
        } catch (Exception e) {
            rsCondominio = null;
        }
        return rsCondominio;
    }
    
    public String insereVeiculo(Veiculo veiculo) {
        sql = "INSERT INTO tb_veiculo(Vei_Placa , Vei_Modelo, Vei_Fabricante,"
                + "Vei_Cor, Vei_CPF_Morador, Vei_Cod_Apartamento) VALUE(?,?,?,?,?,?)";
               
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, veiculo.getPlaca());
            psCondominio.setString(2, veiculo.getModelo());
            psCondominio.setString(3, veiculo.getFabricante());
            psCondominio.setString(4, veiculo.getCor());
            psCondominio.setString(5, veiculo.getCpfMorador());
            psCondominio.setInt(6, veiculo.getCodigoApartamento());

            psCondominio.executeUpdate();
            msg = "Veiculo inserido com sucesso!";
        } catch (Exception e) {
            msg = "Erro de Inclusão";
        }
        return msg;
    }
    
    public String alteraVeiculo(Veiculo veiculo) {
        sql = "UPDATE tb_veiculo SET Vei_Placa = ?, Vei_Modelo = ?,"
                + "Vei_Fabricante = ?, Vei_Cor = ?, Vei_CPF_Morador =?,"
                + "Vei_Cod_Apartamento = ? WHERE Vei_Placa = ?";
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, veiculo.getPlaca());
            psCondominio.setString(2, veiculo.getModelo());
            psCondominio.setString(3, veiculo.getFabricante());
            psCondominio.setString(4, veiculo.getCor());
            psCondominio.setString(5, veiculo.getCpfMorador());
            psCondominio.setInt(6, veiculo.getCodigoApartamento());
            psCondominio.setString(7, veiculo.getPlaca());
            psCondominio.executeUpdate();
            msg = "Dados do Veiculo alterado com sucesso!";
        } catch (Exception e) {
            msg = "Erro na alteração!";
        }
        return msg;
    }
    
    public String excluiVeiculo(String placaVeiculo) {
        try {
            sql = "DELETE FROM tb_veiculo WHERE Vei_Placa = ?";
            
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, placaVeiculo);
            psCondominio.executeUpdate();
            msg = "Veiculo excluido com sucesso! ";
        } catch (Exception e) {
            msg = "Erro de exclusão " + e.getMessage();
        }
        return msg;
    }
    
    public Veiculo consultaPlacaVeiculo(String placaVeiculo) {
        sql = "SELECT * FROM tb_veiculo WHERE Vei_Placa = ?";
        
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, placaVeiculo);
            rsCondominio = psCondominio.executeQuery();
            
            if(rsCondominio.next()) {
               
                        
                veiculo.setPlaca(rsCondominio.getString("Vei_Placa"));
                veiculo.setModelo(rsCondominio.getString("Vei_Modelo"));
                veiculo.setFabricante(rsCondominio.getString("Vei_Fabricante"));
                veiculo.setCor(rsCondominio.getString("Vei_Cor"));
                veiculo.setCpfMorador(rsCondominio.getString("Vei_CPF_Morador"));
                //veiculo.setNomeMorador(retornaMorador.getNomeMorador());
                //veiculo.setBlocoApartamento(retornaApartamento.getBlocoApartamento());
                //veiculo.setNumeroApartamento(retornaApartamento.getNumeroApartamento());
                veiculo.setCodigoApartamento(rsCondominio.getInt("Vei_Cod_Apartamento"));
                
                return veiculo;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public int consultaVagaVeiculo(Veiculo veiculo) {
        int codigoApartamento = veiculo.getCodigoApartamento();
        int quantidade = 0;
        sql = "SELECT COUNT(*) AS num_item FROM tb_veiculo WHERE Vei_Cod_Apartamento = ?";
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setInt(1, codigoApartamento);
            rsCondominio = psCondominio.executeQuery();
            
            while(rsCondominio.next()) {
                quantidade = rsCondominio.getInt("num_item");
            }
            return quantidade;
        } catch (Exception e) {
            return quantidade;
        }
    }
    
    public List<Veiculo> consultaVeiculoPeloCpfMorador(String cpfMorador) {
        sql = "SELECT * FROM tb_veiculo WHERE Vei_CPF_Morador = ?";
        List<Veiculo> listaVeiculo = new LinkedList<>();
        
        try {
            psCondominio = conCondominio.prepareStatement(sql);
            psCondominio.setString(1, cpfMorador);
            rsCondominio = psCondominio.executeQuery();
            
            while(rsCondominio.next()) {
                Veiculo insereVeiculo = new Veiculo();
                
                insereVeiculo.setPlaca(rsCondominio.getString("Vei_Placa"));
                insereVeiculo.setModelo(rsCondominio.getString("Vei_Modelo"));
                insereVeiculo.setFabricante(rsCondominio.getString("Vei_Fabricante"));
                insereVeiculo.setCor(rsCondominio.getString("Vei_Cor"));
                insereVeiculo.setCpfMorador(rsCondominio.getString("Vei_CPF_Morador"));
                insereVeiculo.setCodigoApartamento(rsCondominio.getInt("Vei_Cod_Apartamento"));
                
                listaVeiculo.add(insereVeiculo);
            }
            
            return listaVeiculo;
            
        } catch (Exception e) {
            return null;
        }
    }
}
