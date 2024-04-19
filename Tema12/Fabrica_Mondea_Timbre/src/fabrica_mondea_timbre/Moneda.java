
package fabrica_mondea_timbre;

public class Moneda extends Dinero {
    private double Diametro;    //Diámetro de la moneda, en milímetros (double)
    private double Peso;    //Peso de la moneda, en gramos (double)

    public Moneda(double V, int AE, double Diametro, double Peso) {
        super(V, AE);
        this.Diametro = Diametro;
        this.Peso = Peso;
    }

    public Moneda(Moneda m) {
        super(m);
        this.Diametro = m.Diametro;
        this.Peso = m.Peso;
    }

    @Override
    public String toString() {
        return "MONEDA{" + "Diametro=" + Diametro + ", Peso=" + Peso + super.toString();
    }

    
    
    public double getDiametro() {
        return Diametro;
    }

    public void setDiametro(double Diametro) {
        this.Diametro = Diametro;
    }
}
