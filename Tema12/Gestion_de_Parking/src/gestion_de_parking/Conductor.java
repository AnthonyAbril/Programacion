
package gestion_de_parking;

import java.io.Serializable;

public class Conductor implements Serializable{
    private static final long serialVersionUID = 6L;
    //Cada una de estas plazas estará
    //asignada a uno de esos dueños, y se deberán guardar sus datos de identificación: dni,
    //nombre, apellidos, dirección, teléfono y cuenta bancaria, así como su coche, del que se
    //guardarán los mismos datos que para las plazas de alquiler.
    
    String dni,nombre,apellido1,apellido2,direccion,telefono,cuentabanco;
    
    
}
