
package examen;

public class AuxiliarDeEnfermeria extends Empleado {
    
    private static int NtotalAux;
    private boolean Discapacidad;
    private static final double IncrementoDiscapacidad=0.03;

    public AuxiliarDeEnfermeria(String Categoria, String Nombre, String Servicio, boolean Turnicidad, boolean Discapacidad) {
        super(Categoria, Nombre, Servicio, Turnicidad);
        NtotalAux++;
        this.Discapacidad = Discapacidad;
        generarCodigo(3);
    }

    @Override
    public String toString() {
        return "AuxiliarDeEnfermeria\n" + "Discapacidad=" + (Discapacidad?"si":"no") + super.toString();
    }
    
    @Override
    public double getSFinal() {
        double disc;
        if((this.Discapacidad)){
            disc = (getTablaSueldosBase().get(this.getCategoria()))*IncrementoDiscapacidad;
        }else{
            disc=0;
        }
        
        return super.getSFinal()+disc;
    }
    
    
}
