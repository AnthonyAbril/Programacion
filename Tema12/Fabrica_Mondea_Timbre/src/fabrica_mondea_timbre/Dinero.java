
package fabrica_mondea_timbre;

import java.io.*;

public abstract class Dinero implements Serializable{
    private static final long serialVersionUID = 6L;
    
    private double Valor;   //Valor de la moneda o billete, en euros
    private int AnyoEmision;    //Año en que fue emitida la moneda o billet
    
    public Dinero(double V, int AE){//constructor normal
        Valor = V;
        AnyoEmision = AE;
    }
    
    public Dinero(Dinero d){//constructor normal
        Valor = d.Valor;
        AnyoEmision = d.AnyoEmision;
    }

    @Override
    public boolean equals(Object obj) { //Dos monedas o billetes son iguales si tienen el mismo año de emisión y valor.
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dinero other = (Dinero) obj;
        return (this.Valor == other.Valor && this.AnyoEmision == other.AnyoEmision);
    }
    
    public int compareTo(Dinero j){
        //Es menor (mayor) el de menor (mayor) año de emisión; a igual año, es
        //menor (mayor) el de menor (mayor) valor.
        
        if(this.AnyoEmision<j.AnyoEmision){
            return -1;
        }
        else if(this.AnyoEmision==j.AnyoEmision){//son iguales en año de emision
            if(this.Valor<j.Valor){
                return -1;
            }
            if(this.Valor==j.Valor){
                return 0;//son iguales en Valor
            }
        }
        return 1;
    }

    @Override
    public String toString() {
        return ", Valor=" + Valor + ", AnyoEmision=" + AnyoEmision + '}';
    }
    
}
