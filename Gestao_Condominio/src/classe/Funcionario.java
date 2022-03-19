
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Ayrton Hasegawa
 */
public class Funcionario {

    private String cpf, nome, cargo, telefone, endereco, ativo, login;
    private String sql, usuario_Atual, senha, senha_Atual;
    private int cod_Fun;
    
    Connection conFuncionario;
    PreparedStatement psFuncionario;
    Statement stFuncionario;
    ResultSet rsFuncionario;
    
    //-----Getter-----
    public Funcionario() {
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getLogin() {
        return login;
    }

    public int getCod_Fun() {
        return cod_Fun;
    }

    public String getSenha() {
        return senha;
    }

    public String getAtivo() {
        return ativo;
    }

    public String getUsuario_Atual() {
        return usuario_Atual;
    }

    public String getSenha_Atual() {
        return senha_Atual;
    }
    
    
    
    //-----Setter-----

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCod_Fun(int cod_Fun) {
        this.cod_Fun = cod_Fun;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public void setUsuario_Atual(String usuario_Atual) {
        this.usuario_Atual = usuario_Atual;
    }

    public void setSenha_Atual(String senha_Atual) {
        this.senha_Atual = senha_Atual;
    }
    
    //-----
    
    public boolean verificaCampoVazio(Funcionario funcionario){
        boolean status = false;
        
        if (funcionario.getCpf().equals("") || funcionario.getNome().equals("") ||
                funcionario.getCargo().equals("") || funcionario.getTelefone().equals("") ||
                funcionario.getEndereco().equals("") || funcionario.getLogin().equals("") ||
                funcionario.getSenha().equals("") || funcionario.getAtivo().equals("Vazio")) {
            status = false;
        }else{
            status = true;
        }
        
        return status;
    }
    
    public String validaCPF(Funcionario funcionario) {
        String cpf = funcionario.getCpf(), msg = "";
        long numCpf = cpf.length(), cpfint;                
        
        try {
            cpfint = Long.parseLong(cpf);
            
            if (numCpf == 11) {
                msg = "ok";
            }else {
                msg = "Um CPF válido contém 11 números";
            }
            
        } catch (Exception e) {
            msg = "Por Favor digite apenas números sem ponto ou espaço";
        }               
       
        return msg;
    }
    
    public boolean validaNome(Funcionario funcionario) {
        String nome = funcionario.getNome();
        boolean valida = false;
        
        if (!nome.matches("[a-zA-ZÁÀÃÂÇÉÈÊÍÓÒÕÔÚÙáàãâçéèêíóòõôúù ]*")) {
            return valida = false;
        }else {
            valida = true;
        }
       
        return valida;
    }
    
    public String validaTelefone(Funcionario funcionario) {
        String  tel = funcionario.getTelefone(), msg = "";
        int numTel = tel.length();
        
        try {
            int telInt = Integer.parseInt(tel);
            if (numTel == 8 || numTel == 9) {
                return msg = "ok";
            }else if (numTel < 8 || numTel >9) {
                msg = "Por Favor, insira 8 dígitos para telefone fixo ou 9 dígitos para celular sem espaço";
            }
        } catch (Exception e) {
            msg = "Por Favor digite apenas números e sem espaço.";
        }
        
        return msg;
    }
    //
    
}
