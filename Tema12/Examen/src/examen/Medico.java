
package examen;

public class Medico extends Empleado {
 
    private static int NtotalMedico;
    
    private int Nguardias;
    
    private static final double IncrementoNguardias = 30;
    private static final int GuardiasMaximas = 5;


    public Medico(int Nguardias, String Categoria, String Nombre, String Servicio, boolean Turnicidad) {
        super(Categoria, Nombre, Servicio, Turnicidad);
        this.Nguardias = Nguardias;
        NtotalMedico++;
        
        generarCodigo(1);
    }

    @Override
    public String toString() {
        return "Medico\n" + "Nguardias=" + Nguardias + super.toString();
    }

    @Override
    public double getSFinal() {
        return super.getSFinal()+(IncrementoNguardias*Nguardias);
    }

    public void setNguardias(int Nguardias) {
        this.Nguardias = Nguardias;
    }

    public static int getGuardiasMaximas() {
        return GuardiasMaximas;
    }
}
