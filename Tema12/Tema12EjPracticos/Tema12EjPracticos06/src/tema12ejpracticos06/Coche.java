package tema12ejpracticos06;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private double TamañoDeDeposito;

    public Coche(String matricula, String marca, String modelo, double TamañoDeDeposito) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.TamañoDeDeposito = TamañoDeDeposito;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getTamañoDeDeposito() {
        return TamañoDeDeposito;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", Tama\u00f1oDeDeposito=" + TamañoDeDeposito + '}';
    }
    
    
}
