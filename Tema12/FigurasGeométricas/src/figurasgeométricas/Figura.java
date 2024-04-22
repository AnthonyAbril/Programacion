
package figurasgeométricas;

import java.util.HashMap;

public abstract class Figura {

    int base, altura;

    public Figura(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    abstract double getArea();

    abstract double getPerimetro();

    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    static HashMap<Integer, String> simbolos = new HashMap<>();
    public static void RellenarTabla(){
        simbolos.put(1, "*");
        simbolos.put(2, "$");
        simbolos.put(3, "@");
        simbolos.put(4, "&");
        simbolos.put(5, " €");
    }
    
    abstract void Dibujar();
    
    //public boolean tipofigura(){
    //    return this instanceof;
    //}
}
