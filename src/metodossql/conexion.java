/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodossql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





/**
 *
 * @author dianapaola
 */
public class conexion {
    public static String url= "jdbc:mysql://localhost/login";
    public static String usuario= "root";
    public static String contraseña="root";
    public static String clase= "com.mysql.jdbc.Driver";
    
    public static Connection Conectar() throws SQLException{
        
     Connection Conexion=null;
     try {
         Class.forName(clase);
         Conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
         System.out.println("conexion exitosa");
     }
     catch(ClassNotFoundException e){
         System.out.println(e);     
     }
     return Conexion;
    }
}
