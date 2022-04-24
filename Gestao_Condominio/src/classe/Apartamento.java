
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Ayrton Hasegawa
 */
public class Apartamento {
    private int codigoAparatamento;
    private String blocoApartamento, vagaApartamento_1, vagaApartamento_2, numeroApartamento;
    
    Connection conApartamento;
    PreparedStatement psApartamento;
    Statement stApartamento;
    ResultSet rsApartamento;

    //-----Getter-----
    public int getCodigoApartamento() {
        return codigoAparatamento;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public String getBlocoApartamento() {
        return blocoApartamento;
    }

    public String getVagaApartamento_1() {
        return vagaApartamento_1;
    }

    public String getVagaApartamento_2() {
        return vagaApartamento_2;
    }
    //-----Setter-----

    public void setCodigoAparatamento(int codigoAparatamento) {
        this.codigoAparatamento = codigoAparatamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public void setBlocoApartamento(String blocoApartamento) {
        this.blocoApartamento = blocoApartamento;
    }

    public void setVagaApartamento_1(String vagaApartamento_1) {
        this.vagaApartamento_1 = vagaApartamento_1;
    }

    public void setVagaApartamento_2(String vagaApartamento_2) {
        this.vagaApartamento_2 = vagaApartamento_2;
    }
    
    //------------- Verifica Campo vazio-------------------
     public boolean verificaCampoVazioApartamento(Apartamento apartamento){
        boolean status = false;
        
        if (apartamento.getNumeroApartamento().equals("") || apartamento.getBlocoApartamento().equals("")) {
            status = false;
        }else{
            status = true;
        }
        
        return status;
    }
     
    //------------- Valida número do Apartamento -------------------
     public Boolean validaNumeroApartamento(Apartamento apartamento) {
         Boolean status = false;
         
         
         try {
             int numeroApartamento = Integer.parseInt(apartamento.getNumeroApartamento());
             if(numeroApartamento <= 0) {
                 status = false;
             } else {
                 status = true;
             }
             
         } catch (Exception e) {
             status = false;
         }
         
         return status;
     }
     
    //------------- Valida código do Apartamento -------------------
     public Boolean validaCodigoApartameto(String cod) {
         Boolean status = false;
         
         try {
             int num = Integer.parseInt(cod);
             status = true;
         } catch (Exception e) {
             status = false;
         }
         return status;
     }
}
