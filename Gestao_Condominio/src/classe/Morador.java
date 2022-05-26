
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection; 

/**
 *
 * @author Ayrton Hasegawa
 */
public class Morador {
    private int codigoMorador, codigoApartamento;
    private String cpfMorador, nomeMorador, telefoneMorador, emailMorador, 
            blocoApartamentoMorador, numeroApartamentoMorador, ativo;
    
    Connection conMorador;
    PreparedStatement psMorador;
    Statement stMorador;
    ResultSet rsMorador;

    //-----Getter-----
    public int getCodigoMorador() {
        return codigoMorador;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public String getTelefoneMorador() {
        return telefoneMorador;
    }

    public String getEmailMorador() {
        return emailMorador;
    }

    public String getBlocoApartamentoMorador() {
        return blocoApartamentoMorador;
    }

    public String getNumeroApartamentoMorador() {
        return numeroApartamentoMorador;
    }

    public String getAtivoMorador() {
        return ativo;
    }

    public int getCodigoApartamento() {
        return codigoApartamento;
    }
        
//-----Setter-----
    public void setCodigoMorador(int codigoMorador) {
        this.codigoMorador = codigoMorador;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public void setNomeMorador(String nomeMorador) {
        this.nomeMorador = nomeMorador;
    }

    public void setTelefoneMorador(String telefoneMorador) {
        this.telefoneMorador = telefoneMorador;
    }

    public void setEmailMorador(String emailMorador) {
        this.emailMorador = emailMorador;
    }

    public void setBlocoApartamentoMorador(String blocoApartamentoMorador) {
        this.blocoApartamentoMorador = blocoApartamentoMorador;
    }

    public void setNumeroApartamentoMorador(String numeroApartamentoMorador) {
        this.numeroApartamentoMorador = numeroApartamentoMorador;
    }

    public void setAtivoMorador(String ativo) {
        this.ativo = ativo;
    }

    public void setCodigoApartamento(int codigoApartamento) {
        this.codigoApartamento = codigoApartamento;
    }
    
    public boolean verificaCampoVazio(Morador morador) {
        boolean status = false;
        
        if(morador.getCpfMorador().equals("") || morador.getNomeMorador().equals("") || 
                morador.getTelefoneMorador().equals("") || morador.getEmailMorador().equals("") ||
                morador.getBlocoApartamentoMorador().equals("") || 
                morador.getNumeroApartamentoMorador().equals("") || 
                morador.getAtivoMorador().equals("Vazio")) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
}
