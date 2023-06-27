/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistência;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author edmar
 */
public class DB {
    static final String URL_BD ="jdbc:mysql://localhost:3306/recursoshumanos";
    static final String USUÁRIO ="root";
    static final String SENHA ="admin";
    public static Connection conexão = null;
    
    public static void criaConexão(){
        try{
            conexão = DriverManager.getConnection(URL_BD, USUÁRIO, SENHA);
        }catch (SQLException exceção_sql) {exceção_sql.printStackTrace();}
    }
    
    public static void fechaConexão(){
        try{
            conexão.close();
        }catch (SQLException exceção_sql) {exceção_sql.printStackTrace();}
    }
}
