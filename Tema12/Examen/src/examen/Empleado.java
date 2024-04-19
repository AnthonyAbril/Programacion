
package examen;

import java.io.*;
import java.util.HashMap;

abstract public class Empleado implements Serializable{
    private static final long serialVersionUID = 6L;
    
    private String CodigoEmpleado;  
    //cadena de 1 letra mayuscula (correspondiente a la categoria profesional) y 6 cifras numericas,
    //la primera de las cuales sera diferente en funcion de la categoria, tal y como se especifica a continuacion:
        //Puesto        categoria   primer digito codigo
        //Medico            A               1
        //Enfermero     B               2
        //Auxiliares        C               3  
    
    private String Categoria;   //indicada en la tabla anterior
    
    private String Nombre;      //completo
    
    private String Servicio;    //servicio en el que desarrolla su trabajo (dermatologia, oftalmologia, etc)
    
    private boolean Turnicidad; //si realiza turnicidad o no
    
    private static int NtotalEmpleados; //numero total de empleados
    
    private static final HashMap<String, Integer> TablaSueldosBase = new HashMap<>(); //sueldos base en funcion de la categoria profesional
    
    private static final HashMap<String, Integer> TablaSuplementos = new HashMap<>(); //suplementos con el incremento en el sueldo por servicio:
                                                                        //el resto de servicios no tiene un suplemento en el sueldo.
    private static final double IncrementoTurnicidad = 0.05;

    public Empleado(String Categoria, String Nombre, String Servicio, boolean Turnicidad) {
        NtotalEmpleados++;
        this.Categoria = Categoria;
        this.Nombre = Nombre;
        this.Servicio = Servicio;
        this.Turnicidad = Turnicidad;
    }
    
    public static void LlenarTablas(){
        TablaSueldosBase.put("A", 2000);
        TablaSueldosBase.put("B", 1800);
        TablaSueldosBase.put("C", 1500);
        
        TablaSuplementos.put("trasplantes", 15);
        TablaSuplementos.put("cirugia", 10);
        TablaSuplementos.put("quemados", 5);
    }

    @Override
    public String toString() {
        return " CodigoEmpleado=" + CodigoEmpleado + ", Nombre=" + Nombre + ", Servicio=" + Servicio + ", Turnicidad=" + (Turnicidad?"si":"no") + ", Sueldo=" + getSFinal();
    }
    
    public double getSFinal(){
        double sueldobase=TablaSueldosBase.get(this.Categoria);
        String s = Servicio.toLowerCase();
        double porcentajeservicio=0;
        if(TablaSuplementos.containsKey(s)){
            porcentajeservicio=(TablaSuplementos.get(s))/100;
        }
        double agregadoservicio=sueldobase*porcentajeservicio;
        double agregadoturnicidad;
        if(Turnicidad){
            agregadoturnicidad=sueldobase*IncrementoTurnicidad;
        }else{
            agregadoturnicidad=0;
        }
        return sueldobase+agregadoservicio+agregadoturnicidad;
    }
    
    public void generarCodigo(int numero){
        String codigo=Categoria+numero;
        
        for(int a=0;a<5;a++){
            codigo=codigo+(int) ((Math.random()*9+0));
        }
        this.CodigoEmpleado=codigo;
    }
    
    public String getCodigo(){
        return CodigoEmpleado;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getCategoria(){
        return Categoria;
    }

    public static HashMap<String, Integer> getTablaSueldosBase(){
        return TablaSueldosBase;
    }
    
}
