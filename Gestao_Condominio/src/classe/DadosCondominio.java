/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows_10
 */
public class DadosCondominio {
    ConectaBD conecta = new ConectaBD();
    Funcionario funcionario = new Funcionario();
    Connection conCondominio;
    String sql, msg, statusConexao;  //listar
    PreparedStatement psCondominio;
    Statement stCondominio;
    ResultSet rsCondominio;
    ResultSet rsDadosUsuario;
    ResultSet rsDadosFuncionario;
    
    public DadosCondominio()
    {
        statusConexao = conecta.setConecta();
        conCondominio = conecta.getConecta();
    }
    public String getCon()
    {
        return statusConexao;
    }
    
    public boolean consultaLogin(String usuario, String senha)
    {
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
    
    //-------------- Novo Funcionario Aprovado-----------------
    public ResultSet consultaGeral()
    {
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
    
    public Funcionario consultaCpf(String cpf){
        
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
            } else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    public String alteraFuncionario(Funcionario funcionario){
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
    public String insereFuncionario(Funcionario funcionario){
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
    public String excluiFuncionario(String codigo)
    {
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
    public Funcionario consultaCodigoFuncionario(int codigo){
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
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public Funcionario consultaLogin(String login){
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
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public int duplicidadeCpf(long cpf){
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
    //------------Consulta codigo Antigo--------------
    
    
  
    
    
    
}
