
package classe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows_10
 */
public class ConectaBD {
    private String driver, endBanco, usuarioBanco, senhaBanco, msg;
    private Connection conexao;
    
    public String setConecta()
    {
        driver = "com.mysql.jdbc.Driver";
        endBanco = /*"jdbc:mysql://localhost/gestao_con"*/ "jdbc:mysql://localhost/teste_condominio";
        usuarioBanco = "root";
        senhaBanco = "";
        
        try
        {
            Class.forName(driver);
            conexao = DriverManager.getConnection(endBanco, usuarioBanco, senhaBanco);
            msg = "Banco de Dados Conectado com Sucesso!";
        } catch (Exception e)
        {
            msg = "Erro de Conexão: " + e.getMessage();
        }
        return(msg);
    }
    public Connection getConecta()
    {
        return conexao;
    }
}
