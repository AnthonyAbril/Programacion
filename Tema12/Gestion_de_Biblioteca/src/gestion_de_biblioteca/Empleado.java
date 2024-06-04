
package gestion_de_biblioteca;

import java.io.Serializable;

class Empleado implements Serializable{
    private static final long serialVersionUID = 6L;
    String nombre;
    
    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
