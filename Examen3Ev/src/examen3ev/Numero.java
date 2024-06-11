
package examen3ev;

import java.io.Serializable;

public abstract class Numero implements Serializable{
    private static final long serialVersionUID = 6L;
    private int parteentera;
    private String signo;
    private static int totalN;

    public int getParteentera() {
        return parteentera;
    }

    public String getSigno() {
        return signo;
    }

    public Numero(int parteentera, String signo) {
        this.parteentera = parteentera;
        this.signo = signo;
        totalN++;
    }
    
    @Override
    public String toString() {
        return signo;
    }
    
    public String getTexto(){
        return signo;
    }
    
    public abstract double getValor();

    public static int getTotalN() {
        return totalN;
    }

    public static void setTotalN(int totalN) {
        Numero.totalN = totalN;
    }
}
