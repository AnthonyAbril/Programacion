
package pruebacomparacionfiguras;

public class Figura {
   private int altura;
   private double anchura;

    public Figura(int altura, double anchura) {
        this.altura = altura;
        this.anchura = anchura;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Figura other = (Figura) obj;
        if (this.altura != other.altura) {
            return false;
        }
        return Double.doubleToLongBits(this.anchura) == Double.doubleToLongBits(other.anchura);
    }

    public String getDatos() {
        return altura + " / " + anchura;
    }
   
   
}
