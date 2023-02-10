package Modelo;
/* @author Andrea
 */


//Creo una clase abstracta para realizar el modelo de nuestra tabla de naves
public abstract class Nave {
    
    //Creo cada una de las propiedades de las naves con su debido tipo
    int id;
    String nombre;
    Double altura;
    Double empuje;
    String combustible;
    Double velocidad;
    String categoria ;
    String pais;
    Double peso;
    
    //Le implemento a cada una de las propiedades el Setter y Getter para estableces sus valores

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getEmpuje() {
        return empuje;
    }

    public void setEmpuje(Double empuje) {
        this.empuje = empuje;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
       
    // Creamos metodos abstractos 
    
    public abstract void despegar();
        
    public abstract void volar();
    
    public abstract void aterrizar();
    
}
