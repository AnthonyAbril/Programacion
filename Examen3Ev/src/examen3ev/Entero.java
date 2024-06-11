
package examen3ev;

import java.util.ArrayList;

public class Entero extends Numero {

    private static int totalE;
    
    public Entero(int parteentera, String signo) {
        super(parteentera, signo);
        totalE++;
    }

    @Override
    public String toString() {
        return "Entero:\t"+super.toString()+getParteentera();
    }

    @Override
    public String getTexto() {
        return super.getTexto()+getParteentera();
    }
    
    public double getValor(){
        return (Integer.parseInt(getSigno()+1))*(getParteentera());
    }
    
    public ArrayList<Integer> getDivisoresPropios(){
        ArrayList <Integer> divisores = new ArrayList<>();
        
        //devolver una coleccion con los divisores propios del entero (no usar signo)
        for(int a=1;a<getParteentera();a++){
            if(getParteentera()%a==0){
                divisores.add(a);
            }
        }
        return divisores;
    }
    
    public int getSumDivPropios(){
        int suma=0;
        for(int a=0;a<this.getDivisoresPropios().size();a++){
            suma+=this.getDivisoresPropios().get(a);
        }
        return suma;
    }

    public static int getTotalE() {
        return totalE;
    }

    public static void setTotalE(int totalE) {
        Entero.totalE = totalE;
    }
    
    
}
