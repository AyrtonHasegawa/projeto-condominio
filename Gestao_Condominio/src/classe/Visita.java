
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author ayrton.hasegawa
 */
public class Visita {
    private int codVisita;
    private String data, hora, cpfVisitanteVisita, nomeVisitanteVisita;
    private String cpfMoradorVisita, NomeMoradorVisita;
    
    Connection conVisita;
    PreparedStatement psVisita;
    Statement stVisita;
    ResultSet rsVisita;

    //-----Getter-----
    public int getCodVisita() {
        return codVisita;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getCpfVisitanteVisita() {
        return cpfVisitanteVisita;
    }

    public String getNomeVisitanteVisita() {
        return nomeVisitanteVisita;
    }

    public String getCpfMoradorVisita() {
        return cpfMoradorVisita;
    }

    public String getNomeMoradorVisita() {
        return NomeMoradorVisita;
    }
    
    //-----Setter-----

    public void setCodVisita(int codVisita) {
        this.codVisita = codVisita;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setCpfVisitanteVisita(String cpfVisitanteVisita) {
        this.cpfVisitanteVisita = cpfVisitanteVisita;
    }

    public void setNomeVisitanteVisita(String nomeVisitanteVisita) {
        this.nomeVisitanteVisita = nomeVisitanteVisita;
    }

    public void setCpfMoradorVisita(String cpfMoradorVisita) {
        this.cpfMoradorVisita = cpfMoradorVisita;
    }

    public void setNomeMoradorVisita(String NomeMoradorVisita) {
        this.NomeMoradorVisita = NomeMoradorVisita;
    }
    
    public boolean verificaCampoVazio(Visita visita) {
        boolean status = false;
        if(visita.getData().equals(null) || visita.getHora().equals(null) || 
                visita.getCpfVisitanteVisita().equals(null) || visita.getNomeVisitanteVisita().equals(null) || 
                visita.getCpfMoradorVisita().equals(null) || visita.getNomeVisitanteVisita().equals(null)) {
            status = false;
        } else {
            status = true;
        }
        return status;
    }
}
