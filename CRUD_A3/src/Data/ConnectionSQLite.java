
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
 
    private Connection connect;
    
    // Método de conexão com o banco de dados - Lógica Booleana
    public boolean conectar(){
        
        try{ 
            //String de conexão com o banco "users.db"
            String jdbcURL = "jdbc:sqlite:db/users.db";
            
            //Estabelecendo conexão com o driver - SQLite 3.36.0.3
            this.connect = DriverManager.getConnection(jdbcURL);     
        
        }
        catch(SQLException e){
            // Relatando problemas com a conexão
            System.out.println("Erro! Não foi possível conectar ao banco de dados");
            System.err.println(e.getMessage());
            
            return false;
        }
        
        System.out.println("Conexão estabelecida com sucesso!");
        return true;
    }
    
    // Método para desconectar do banco - Lógica Booleana
    public boolean desconectar(){
        
        try{
            if(this.connect.isClosed() == false){
                this.connect.close();
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        
        System.out.println("Banco de dados desconectado com sucesso!");
        return true;
    }
    
}
