package Vista;
import Modelo.Conexion;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Andrea
 */
public class InventarioNave extends javax.swing.JFrame {
     
    public  InventarioNave() {
        initComponents();
        this.setLocationRelativeTo(null);
        
      try{
          //Se crean las tablas para pintar los datos de las naves
            DefaultTableModel modelo = new DefaultTableModel();
            //llamo el id de la tabla para pintarlos sobre esta
            jTableNaves.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            //Realizo la conexion con la base de datos
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
              
            //Se hace la consulta a la base de datos para pintar los datos por categoria
             String sql = "SELECT * FROM naves WHERE categoria='Nave Lanzadera'";  
             ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
              
               ResultSetMetaData rsM = (ResultSetMetaData) rs.getMetaData();
               int cantidadColumnas = rsM.getColumnCount();
               
              //Agrego el nombre a cada columna
              modelo.addColumn("ID");
              modelo.addColumn("NOMBRE");
              modelo.addColumn("ALTURA");
              modelo.addColumn("EMPUJE");
              modelo.addColumn("COMBUSTIBLE");
              modelo.addColumn("VELOCIDAD");
              modelo.addColumn("CATEGORIA");
              modelo.addColumn("PAIS");
              modelo.addColumn("PESO");
               
              //Creo un while para pintar cada dato que coincida
               while(rs.next()){
                   Object[] filas = new Object[cantidadColumnas];
                   for(int i=0; i< cantidadColumnas;i++){
                       filas[i] = rs.getObject(i + 1);
                       
                   }
                   modelo.addRow(filas);
               }
               
        
      }catch(SQLException ex){
          System.err.println(ex.toString());
            
        }
      try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTableNaves1.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
              Connection con = conn.getConexion();
              
             // String sql = ("SELECT id, nombre, altura, empuje, combustible, velocidad, categoria, pais,peso FROM naves");
             String sql = "SELECT * FROM naves WHERE categoria='Naves no Tripuladas'";  
             ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
              
               ResultSetMetaData rsM = (ResultSetMetaData) rs.getMetaData();
               int cantidadColumnas = rsM.getColumnCount();
               
              modelo.addColumn("ID");
              modelo.addColumn("NOMBRE");
              modelo.addColumn("ALTURA");
              modelo.addColumn("EMPUJE");
              modelo.addColumn("COMBUSTIBLE");
              modelo.addColumn("VELOCIDAD");
              modelo.addColumn("CATEGORIA");
              modelo.addColumn("PAIS");
              modelo.addColumn("PESO");
               
               while(rs.next()){
                   Object[] filas = new Object[cantidadColumnas];
                   for(int i=0; i< cantidadColumnas;i++){
                       filas[i] = rs.getObject(i + 1);
                       
                   }
                   modelo.addRow(filas);
               }
               
        
      }catch(SQLException ex){
          System.err.println(ex.toString());
            
        }
      try{
            DefaultTableModel modelo = new DefaultTableModel();
            jTableNaves2.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
              Connection con = conn.getConexion();
              
             // String sql = ("SELECT id, nombre, altura, empuje, combustible, velocidad, categoria, pais,peso FROM naves");
             String sql = "SELECT * FROM naves WHERE categoria='Naves Tripuladas'";  
             ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
              
               ResultSetMetaData rsM = (ResultSetMetaData) rs.getMetaData();
               int cantidadColumnas = rsM.getColumnCount();
               
              modelo.addColumn("ID");
              modelo.addColumn("NOMBRE");
              modelo.addColumn("ALTURA");
              modelo.addColumn("EMPUJE");
              modelo.addColumn("COMBUSTIBLE");
              modelo.addColumn("VELOCIDAD");
              modelo.addColumn("CATEGORIA");
              modelo.addColumn("PAIS");
              modelo.addColumn("PESO");
               
               while(rs.next()){
                   Object[] filas = new Object[cantidadColumnas];
                   for(int i=0; i< cantidadColumnas;i++){
                       filas[i] = rs.getObject(i + 1);
                       
                   }
                   modelo.addRow(filas);
               }
               
        
      }catch(SQLException ex){
          System.err.println(ex.toString());
            
        }


        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNaves = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableNaves1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNaves2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText(" Crear Nave");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar Nave");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Inventario Naves");

        jTableNaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "ALTURA", "EMPUJE", "COMBUSTIBLE", "VELOCIDAD", "CATEGORIA", "PAIS", "PESO"
            }
        ));
        jScrollPane1.setViewportView(jTableNaves);
        if (jTableNaves.getColumnModel().getColumnCount() > 0) {
            jTableNaves.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTableNaves.getColumnModel().getColumn(1).setHeaderValue("NOMBRE");
            jTableNaves.getColumnModel().getColumn(2).setHeaderValue("ALTURA");
            jTableNaves.getColumnModel().getColumn(3).setHeaderValue("EMPUJE");
            jTableNaves.getColumnModel().getColumn(4).setHeaderValue("COMBUSTIBLE");
            jTableNaves.getColumnModel().getColumn(5).setHeaderValue("VELOCIDAD");
            jTableNaves.getColumnModel().getColumn(6).setHeaderValue("CATEGORIA");
            jTableNaves.getColumnModel().getColumn(7).setHeaderValue("PAIS");
            jTableNaves.getColumnModel().getColumn(8).setHeaderValue("PESO");
        }

        jTableNaves1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "ALTURA", "EMPUJE", "COMBUSTIBLE", "VELOCIDAD", "CATEGORIA", "PAIS", "PESO"
            }
        ));
        jScrollPane2.setViewportView(jTableNaves1);
        if (jTableNaves1.getColumnModel().getColumnCount() > 0) {
            jTableNaves1.getColumnModel().getColumn(0).setHeaderValue("ID");
            jTableNaves1.getColumnModel().getColumn(1).setHeaderValue("NOMBRE");
            jTableNaves1.getColumnModel().getColumn(2).setHeaderValue("ALTURA");
            jTableNaves1.getColumnModel().getColumn(3).setHeaderValue("EMPUJE");
            jTableNaves1.getColumnModel().getColumn(4).setHeaderValue("COMBUSTIBLE");
            jTableNaves1.getColumnModel().getColumn(5).setHeaderValue("VELOCIDAD");
            jTableNaves1.getColumnModel().getColumn(6).setHeaderValue("CATEGORIA");
            jTableNaves1.getColumnModel().getColumn(7).setHeaderValue("PAIS");
            jTableNaves1.getColumnModel().getColumn(8).setHeaderValue("PESO");
        }

        jTableNaves2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTableNaves2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Naves Tripuladas");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Naves Lanzadera");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Naves No Tripuladas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1)
                .addContainerGap(299, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        BuscarNave naveBuscar = new BuscarNave();
        naveBuscar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              CrearNave naveCrear = new CrearNave();
              naveCrear.setVisible(true);
              this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioNave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTableNaves;
    public javax.swing.JTable jTableNaves1;
    public javax.swing.JTable jTableNaves2;
    // End of variables declaration//GEN-END:variables
}
