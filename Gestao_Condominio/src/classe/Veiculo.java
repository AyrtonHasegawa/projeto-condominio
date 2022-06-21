
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author ayrton.hasegawa
 */
public class Veiculo {
    String placa, modelo, fabricante, cor, cpfMorador, nomeMorador, blocoApartamento, NumeroApartamento, vaga;
    int codigoApartamento;
    
    Connection conVeiculo;
    PreparedStatement psVeiculo;
    Statement stVeiculo;
    ResultSet rsVeiculo;

    //-----Getter-----
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getCor() {
        return cor;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public String getBlocoApartamento() {
        return blocoApartamento;
    }

    public String getNumeroApartamento() {
        return NumeroApartamento;
    }

    public String getVaga() {
        return vaga;
    }

    public int getCodigoApartamento() {
        return codigoApartamento;
    }
    
    //-----Setter-----

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public void setBlocoApartamento(String blocoApartamento) {
        this.blocoApartamento = blocoApartamento;
    }

    public void setNumeroApartamento(String NumeroApartamento) {
        this.NumeroApartamento = NumeroApartamento;
    }

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }

    public void setCodigoApartamento(int codigoApartamento) {
        this.codigoApartamento = codigoApartamento;
    }
    
    //------------- Verifica Campo vazio-------------------
     public boolean verificaCampoVazioVeiculo(Veiculo veiculo){
        boolean status = false;
        
        if (veiculo.getPlaca().equals("") || veiculo.getModelo().equals("") || 
                veiculo.getCor().equals("") || veiculo.getFabricante().equals("") || 
                veiculo.getCpfMorador().equals("")) {
            status = false;
        }else{
            status = true;
        }
        
        return status;
    }
     
     public static String validaPlaca(String placa) {
         String msg;
         //placa = placa.replaceAll("[^a-zA-Z0-9]", "");
         if(placa.length() == 7 && placa.substring(0, 3).matches("[a-zA-Z]*") && 
                placa.substring(3, 4).matches("[0-9]*") && placa.substring(5).matches("[0-9]*") ) {
             msg = "Ok";
         } else {
             msg = "Placa inválida, digite corretamente a placa!";
         }
         return msg;
     }
}
