
package fabrica_mondea_timbre;

public class Billete extends Dinero{
    private double Altura;  //Altura del billete, en mm (double)
    private double Anchura; //Anchura del billete, en mm (double)

    public Billete( double V, int AE, double Altura, double Anchura) {
        super(V, AE);
        this.Altura = Altura;
        this.Anchura = Anchura;
    }

    public Billete(Billete b) {
        super(b);
        this.Altura = b.Altura;
        this.Anchura = b.Anchura;
    }

    @Override
    public String toString() {
        return "BILLETE{" + "Altura=" + Altura + ", Anchura=" + Anchura + super.toString();
    }
    
    
    

    public double getAltura() {
        return Altura;
    }

    public double getAnchura() {
        return Anchura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public void setAnchura(double Anchura) {
        this.Anchura = Anchura;
    }
}
