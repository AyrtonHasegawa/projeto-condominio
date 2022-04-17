/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author Windows_10
 */
public class Apartamento {
    private int codigoAparatamento, numeroApartamento;
    private String blocoApartamento, vagaApartamento_1, vagaApartamento_2;
    
    Connection conApartamento;
    PreparedStatement psApartamento;
    Statement stApartamento;
    ResultSet rsApartamento;

    //-----Getter-----
    public int getCodigoAparatamento() {
        return codigoAparatamento;
    }

    public int getNumeroApartamento() {
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

    public void setNumeroApartamento(int numeroApartamento) {
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
        
        if (apartamento.getNumeroApartamento() <= 0 || apartamento.getBlocoApartamento().equals("")) {
            status = false;
        }else{
            status = true;
        }
        
        return status;
    }
}
