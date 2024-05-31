
package gestion_de_biblioteca;

import java.io.Serializable;

class Usuario implements Serializable{
    private static final long serialVersionUID = 6L;
    String nombre;
    
    public void Usuario(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
