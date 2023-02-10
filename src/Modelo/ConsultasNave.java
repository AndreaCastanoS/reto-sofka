package Modelo;
/* @author Andrea
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



//Con extends se trae la herencia de la conexion para utilizar directamente esta y no realizar instancias de la clase
public class ConsultasNave extends Conexion {
       
   //Se crea el metodo registrar para crear nuestras naves 
    public boolean registrar (Nave nav){
        //Preparamos nuestra consulta y establecemos la conexion
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //SE CREA UNA CONDICION BOOLEANA PARA QUE EN CASO DE QUE ESTA NO SE CUMPLA NO SE PUEDE CREAR LA NAVE
        if(nav.getPeso()<10){
             JOptionPane.showMessageDialog(null, "Nave no cumple con el peso estipulado");
            
        }else{
            
        
        /*Se hace la consulta a la base de datos en este caso con un INSERT a nuestra tabla "naves"*/
        String sql = "INSERT INTO naves(nombre, altura, empuje, combustible, velocidad, categoria, pais, peso) VALUES (?,?,?,?,?,?,?,?)";
        try{
            //Se envia la variable sql a nuestra conexion
            ps= con.prepareStatement(sql);
            
            //Se envian los datos para la creacion
             ps.setString(1, nav.getNombre());
              ps.setDouble(2, nav.getAltura());
               ps.setDouble(3, nav.getEmpuje());
                ps.setString(4, nav.getCombustible());
                  ps.setDouble(5, nav.getVelocidad());
                   ps.setString(6, nav.getCategoria());
                    ps.setString(7, nav.getPais());
                     ps.setDouble(8, nav.getPeso());
                    
                      ps.execute();
                        return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
          }finally{
            //Se hace nuevo try catch para cerrar la conexion
            try{
                con.close();
             }catch(SQLException e){
                   System.err.println(e); 
                
              }
           }
        }
        return false;
    }
    
    //Se crea el metodo para modificar los datos de mi nave
     public boolean modificar(Nave nav){
        PreparedStatement ps = null;
        Connection con = getConexion();
        //En este caso la consulta a la base de datos se hace con UPDATE para que me modifique
        String sql = "UPDATE naves SET nombre=?, altura=?, empuje=?, combustible=?, velocidad=?, categoria=?, pais=?, peso=? WHERE id=? ";
        try{
            ps= con.prepareStatement(sql);
            
            //Se traen todos los datos a modificar
             ps.setString(1, nav.getNombre());
              ps.setDouble(2, nav.getAltura());
               ps.setDouble(3, nav.getEmpuje());
                ps.setString(4, nav.getCombustible());
                  ps.setDouble(5, nav.getVelocidad());
                   ps.setString(6, nav.getCategoria());
                     ps.setString(7, nav.getPais());
                      ps.setDouble(8, nav.getPeso());
                       ps.setInt(9, nav.getId());
                        ps.execute();
                         return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                   System.err.println(e); 
                
            }
        }
    }
     //Se crea el metodo para eliminar una nave
      public boolean eliminar(Nave nav){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //La consulta se hace con DELETE y la eliminamos por el id
        String sql = "DELETE FROM naves WHERE id=? ";
        try{
            ps= con.prepareStatement(sql);
               ps.setInt(1, nav.getId());
                        ps.execute();
                         return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                   System.err.println(e); 
                
            }
        }
    }
      
      //Se crea el metodo para filtrar una nave por su nombre
      public boolean buscar(Nave nav) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
         
        /*Se hace la consulta con el from y se compara con el nombre*/
        String sql = "SELECT * FROM naves WHERE nombre=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nav.getNombre());
            rs = ps.executeQuery();

            if (rs.next()) {
                //Se traen todos los datos obtenidos
                nav.setId(Integer.parseInt(rs.getString("id")));
                nav.setNombre(rs.getString("nombre"));
                nav.setAltura(Double.parseDouble(rs.getString("altura")));
                nav.setEmpuje(Double.parseDouble(rs.getString("empuje")));
                nav.setCombustible(rs.getString("combustible"));
                nav.setVelocidad(Double.parseDouble(rs.getString("velocidad")));
                nav.setCategoria(rs.getString("categoria"));
                nav.setPais(rs.getString("pais"));
                nav.setPeso(Double.parseDouble(rs.getString("peso")));
               
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
      
      
     //Se crea un metodo de tipo DefaultTableModel para hacer el filtro de busqueda en nuestra tabla 
     public DefaultTableModel buscarPor(String buscar){
         //Se crean lo nombres de las columnas de la tabla
         String[] nombreColumna={"Id", "Nombre", "Altura","Empuje", "Combustible", "Velocidad", "Categoria", "Pais", "Peso"};
         String [] registros=new String[9];
         DefaultTableModel modelo= new DefaultTableModel(null, nombreColumna);
         
         
         //Se realiza la consulta a la base de datos para hacer el filtro por cada letra ingresada
         //ya sea por nombre, pais o categoria
         String sql="select* from naves where nombre like'%"+buscar+"%' or pais like'%"+buscar+"%' or categoria like'%"+buscar+"%'";
         
         Connection cn=null;
         PreparedStatement pst=null;
         ResultSet rs=null;
         
         try{
               Connection con = getConexion();
               pst=con.prepareStatement(sql);
               rs=pst.executeQuery();
               
               //Se hace el recorrido por nuestros registros
               while(rs.next()){
                   registros[0]=rs.getString("id");
                   registros[1]=rs.getString("nombre");
                   registros[2]=rs.getString("altura");
                   registros[3]=rs.getString("empuje");
                   registros[4]=rs.getString("combustible");
                   registros[5]=rs.getString("velocidad");
                   registros[6]=rs.getString("categoria");
                   registros[7]=rs.getString("pais");
                   registros[8]=rs.getString("peso");
                   modelo.addRow(registros);
               }
             
         }catch(Exception e){
             System.out.println("e");
             
         }
        return modelo;  
     }
    
}
