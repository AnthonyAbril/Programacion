
package examen;

public class Enfermero extends Empleado {
    
    private static int NtotalEnfermero;

    public Enfermero(String Categoria, String Nombre, String Servicio, boolean Turnicidad) {
        super(Categoria, Nombre, Servicio, Turnicidad);
        NtotalEnfermero++;
        
        generarCodigo(2);
    }
    
    @Override
    public String toString() {
        return "Enfermero\n" + super.toString();
    }
    
    
}
