
package tema7ejpractico01;

public class Hora {
    private int h;
    private int m;
    
    public Hora(int h, int m){
        this.h = h;
        this.m = m;
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }
    
    @Override
    public String toString(){
        return ((h < 10 ? "0" + h : h) + ":" + ((m < 10 ? "0" + m : m)));
    }
}
