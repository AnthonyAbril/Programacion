
package examen3ev;

public class Racional extends Numero {
    
    private static int totalR;
    private double partedecimal;

    public Racional(int parteentera, String signo, double partedecimal) {
        super(parteentera, signo);
        this.partedecimal = partedecimal;
        totalR++;
    }
    
    
    @Override
    public String toString() {
        return "Racional:\t"+super.toString()+(getParteentera()+partedecimal);
    }
    
    @Override
    public String getTexto() {
        return super.getTexto()+(getParteentera()+partedecimal);
    }
    
    public double getValor(){
        return (Integer.parseInt(getSigno()+1))*( getParteentera()+partedecimal);
    }

    public static int getTotalR() {
        return totalR;
    }

    public static void setTotalR(int totalR) {
        Racional.totalR = totalR;
    }
}
