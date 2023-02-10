
package Modelo;

/**
  @author Andrea
 */

//Se crea la clase categoria e implementamos un metodo abstracto
public class Categoria extends Nave {
      @Override
    public void despegar() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     }

    @Override
    public void volar() {
       
     //Creamos un condicional para poder implementar nuestro metodo
       if (velocidad>1000) {
            System.out.println("Velocidad adecuada para volar");
        } else {
            System.out.println("La velocidad no es suficiente, su nave caera");
        }
    }

    @Override
    public void aterrizar() {
        //Creamos un condicional para poder implementar nuestro metodo
   if (altura<100) {
            System.out.println("Puedes aterrizar sin problemas");
        } else {
            System.out.println("Imposible aterrizar, su nave esta muy alta");
        }
    }   
}
