
package tema7ejpractico01;

public class Fecha {
    private int dia;
    private int mes;
    private int anyo;
    
    public Fecha (int dia, int m, int a){
        this.dia = dia;
        this.mes = m;
        anyo = a;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAnyo(){
        return anyo;
    }
    
    @Override
    public String toString(){
        return ((dia < 10 ? "0" + dia : dia) + "/" + ((mes < 10 ? "0" + mes : mes) + "/" + anyo));
    }
}
