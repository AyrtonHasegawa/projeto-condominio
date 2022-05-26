
package classe;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

/**
 *
 * @author ayrton.hasegawa
 */
public class Visitante {
    private String cpfVisitante, nomeVisitante;
    
    Connection conVisitante;
    PreparedStatement psVisitante;
    Statement stVisitante;
    ResultSet rsVisitante;
    
    //-----Getter-----

    public String getCpfVisitante() {
        return cpfVisitante;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }
    
    //-----Setter-----

    public void setCpfVisitante(String cpfVisitante) {
        this.cpfVisitante = cpfVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }
    
    public String verificaCampoCpfVazio(String cpfVisitante) {
        //verificar campo vazio, se é numero
        String msg ="";
        if(cpfVisitante.isEmpty()) {
            msg = "Digite um CPF no campo do CPF";
        } else {
            msg = "Ok";
        }
        return msg;
    }
    
    public String verificaCampoVazio(Visitante visitante) {
        //verificar campo vazio, se é numero
        String msg ="";
        if(visitante.getCpfVisitante().isEmpty() || visitante.getNomeVisitante().isEmpty()) {
            msg = "Digite todos os campos.";
        } else {
            msg = "Ok";
        }
        return msg;
    }
}
