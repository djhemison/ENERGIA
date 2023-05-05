
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private final String database ="energia";
    private final String user ="root";
    private final String password ="";
    
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?userSSL=false",user, password);
        }catch(SQLException ex){
            System.out.println("Erro ao tentar realizar conexão com o banco de dados");
            throw new RuntimeException(ex);
        }
        
    }
    
    
}
