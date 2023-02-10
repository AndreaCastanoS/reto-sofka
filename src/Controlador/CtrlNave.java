package Controlador;
/* @author Andrea
 */

import Modelo.ConsultasNave;
import Modelo.Nave;
import Vista.CrearNave;
import Vista.InventarioNave;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


//Se crea la clase CONTROLADOR donde se van a implementar los ActionListener
//para detectar los clic, enviar los valores de las cajas de texto  y poderlos insertar a la base de datos

public class CtrlNave implements ActionListener{
    //Se importan las clases que hemos creado y creamos variables
    private Nave mod;
    private ConsultasNave modC;
    private CrearNave form;
    private InventarioNave inv;
    
    //Se crea la clase que recibe el modelo y la vista    
    public CtrlNave (Nave mod, ConsultasNave modC, CrearNave form){
       
        this.mod = mod;
        this.modC = modC;
        this.form = form;
        
        //Se declara los action para cada uno de los botones
        this.form.btnGuardar.addActionListener(this);
        this.form.btnModificar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);
        this.form.btnLimpiar.addActionListener(this);
        this.form.btnBuscar.addActionListener(this);
            
    }
    
    //Se crea el metodo para poder iniciar la vita
    public void iniciar(){
        form.setTitle("Naves");
        form.setLocationRelativeTo(null);
        form.txtId.setVisible(false);
    }
    
    @Override
    
    //Se crean los metodos que van a escuchar los clic de los botones
    public void actionPerformed(ActionEvent e){
        /*traemos el evento del boton que se presiono*/
        if(e.getSource()==form.btnGuardar){
            
            /* se toman los valores de la caja de texto y se meten al model*/
            mod.setNombre(form.txtNombre.getText());
             mod.setAltura(Double.parseDouble(form.txtAltura.getText()));
              mod.setEmpuje(Double.parseDouble(form.txtEmpuje.getText()));
               mod.setCombustible(form.txtCombustible.getText());
                 mod.setVelocidad(Double.parseDouble(form.txtVelocidad.getText()));
                  mod.setCategoria(form.txtCategoria.getText());
                   mod.setPais(form.txtPais.getText());
                    mod.setPeso(Double.parseDouble(form.txtPeso.getText()));
                    
                    /*Se evalua con un if que el registro si se haya realizado*/
                    if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                
                
                limpiar();
                //llamamos al metodo limpiar para limpiar el formulari
            }
            
        }
        // se detecta el evento del boton modificar
         if(e.getSource()==form.btnModificar){
             
             mod.setId(Integer.parseInt(form.txtId.getText()));
              mod.setNombre(form.txtNombre.getText());
               mod.setAltura(Double.parseDouble(form.txtAltura.getText()));
                mod.setEmpuje(Double.parseDouble(form.txtEmpuje.getText()));
                 mod.setCombustible(form.txtCombustible.getText());
                  mod.setVelocidad(Double.parseDouble(form.txtVelocidad.getText()));
                   mod.setCategoria(form.txtCategoria.getText());
                    mod.setPais(form.txtPais.getText());
                     mod.setPeso(Double.parseDouble(form.txtPeso.getText()));
                    
                     //se verificar la ejecucion del metodo
                    if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
            
        }
         //se detecta la accion de eliminar
          if(e.getSource()==form.btnEliminar){
              //se hace relacion con el Iid
                   mod.setId(Integer.parseInt(form.txtId.getText()));
                      
                   //se verifica la ejecucion del metodo
                    if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
            
        }
          
          //se detecta la accion de buscar
           if(e.getSource()==form.btnBuscar){
               //se busca por nombre
                   mod.setNombre(form.txtNombre.getText());
                              
                    if (modC.buscar(mod)) {
                        //Se traen todos los datos que corresponden
                        form.txtId.setText(String.valueOf(mod.getId()));
                         form.txtNombre.setText(mod.getNombre());
                          form.txtAltura.setText(String.valueOf(mod.getAltura()));
                           form.txtEmpuje.setText(String.valueOf(mod.getEmpuje()));
                             form.txtCombustible.setText(mod.getCombustible());
                              form.txtVelocidad.setText(String.valueOf(mod.getVelocidad()));
                               form.txtCategoria.setText(mod.getCategoria());
                                form.txtPais.setText(mod.getPais());
                                 form.txtPeso.setText(String.valueOf(mod.getPeso()));
                        
            } else {
                JOptionPane.showMessageDialog(null, "NO se encontro registro");
                limpiar();
            }
                    
            
        }
            if(e.getSource()==form.btnLimpiar){
                limpiar();
                
            }
        
    }
    
    //Se crea el metodo limpiar y lo invocamos para limpiar nuestro formulario
   public void limpiar() {
        form.txtId.setText(null);
        form.txtNombre.setText(null);
        form.txtAltura.setText(null);
        form.txtEmpuje.setText(null);
        form.txtCombustible.setText(null);
        form.txtVelocidad.setText(null);
        form.txtCategoria.setText(null);
        form.txtPais.setText(null);
        form.txtPeso.setText(null);
    }
  
}
