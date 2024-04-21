
package ejerciciosarraylist04;

public class Persona {
    //Se tiene la siguiente información de n personas: dni, apellidos, nombres, sexo, edad y peso.
    private String dni, apellido, nombre, sexo;
    private int edad, peso;
    
    Persona(String dni, String ape, String nom, String sx, int edad, int peso){
        this.dni = dni;
        this.apellido = ape;
        this.nombre = nom;
        this.sexo = sx;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String GetDni(){
        return this.dni;
    }
    
    public String GetApellido(){
        return this.apellido;
    }
}
