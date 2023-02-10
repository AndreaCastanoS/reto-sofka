package reto.sofka;
import Controlador.CtrlNave;
import Modelo.ConsultasNave;
import Modelo.Nave;
import Vista.CrearNave;

/**
 *
 * @author Andrea
 */

//Se utiliza nuestra clase principal para llamar y enviar todo
public class RetoSofka {
    public static void  main(String[] args) {
         Nave  mod;
        mod = new  Nave() {
             @Override
             public void despegar() {
                 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             }

             @Override
             public void volar() {
             }

             @Override
             public void aterrizar() {
                 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             }
         };
        
        ConsultasNave modC = new ConsultasNave();
        CrearNave form = new CrearNave();
        CtrlNave ctrl = new CtrlNave(mod, modC, form);
        //utilicamos el objeto del controlador para iniciar la vista
        ctrl.iniciar();
        form.setVisible( true);
    }
    
}
