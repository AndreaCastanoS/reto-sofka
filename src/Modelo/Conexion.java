package Modelo;
/* @author Andrea
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//Creo la clase conexion para conectar con mySql
public class Conexion {
    
    //Creo las constantes con sus respectivos datos para mi conexion
    private final String base = "naves";
     private final String user = "root";
      private final String password = "87654321";
       private final String url = "jdbc:mysql://localhost:3306/" + base;
       private Connection con;
       
       
       //Creamos un metodo de tipo Connection para realizar nuestra conexion 
    public Connection getConexion(){
        //Ejecutamos nuestra conexion dentro de un try catch para que en caso de no funcionar nos muestre el error
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          //Establecemos la conexion con el DriveManager
          con = DriverManager.getConnection(this.url, this.user, this.password);
          
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e);
            
        }
        return con;
    }
}
