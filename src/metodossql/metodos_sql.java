/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodossql;

import java.sql.PreparedStatement;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class metodos_sql {
    public static conexion conexion1= new conexion();
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero=0;
    
    public int registrar(String usuario,String contraseña){
        int resultado =0;
        Connection conexion1=null;
        String sentencia_guardar ="INSERT INTO usuarios(usuario,contraseña) VALUES (?,?)";
        try {
            conexion1 =conexion.Conectar();
            sentencia_preparada= conexion1.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1,usuario);
            sentencia_preparada.setString(2,contraseña);
            
            resultado=sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            conexion1.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultado;
    }
    
    public static String buscarusuario_contraseña(String usuario, String contraseña){
    String buscar_usuario=null;
    Connection conexion1=null;
        try {
            conexion1=conexion.Conectar();
            String sentencia_buscar= ("SELECT usuario,contraseña FROM usuarios WHERE usuario ='"+usuario+"'&& contraseña='"+contraseña+"'");
            sentencia_preparada =conexion1.prepareStatement(sentencia_buscar);
            resultado= sentencia_preparada.executeQuery();
            if(resultado.next()) {
                buscar_usuario="usuario encontrado";        
            }
            else{
                buscar_usuario="usuario no encontrado"; 
            }
            conexion1.close();
                    
        } catch (SQLException e) {
            System.out.println(e);
        }
        return buscar_usuario;
    }
     public static String buscarusuario(String usuario){
    String buscar_usuario=null;
    Connection conexion1=null;
        try {
            conexion1=conexion.Conectar();
            String sentencia_buscar= ("SELECT usuario FROM usuarios WHERE usuario ='"+usuario+"'");
            sentencia_preparada =conexion1.prepareStatement(sentencia_buscar);
            resultado= sentencia_preparada.executeQuery();
            if(resultado.next()) {
                buscar_usuario="usuario encontrado";        
            }
            else{
                buscar_usuario="usuario no encontrado"; 
            }
            conexion1.close();
                    
        } catch (SQLException e) {
            System.out.println(e);
        }
        return buscar_usuario;
    }
    
}
