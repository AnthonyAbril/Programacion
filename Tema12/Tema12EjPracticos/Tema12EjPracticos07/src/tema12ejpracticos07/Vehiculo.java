
package tema12ejpracticos07;

import java.io.*;


public class Vehiculo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    private String matricula;
    private String marca;
    private String modelo;
    transient private double tamanyo;
    
    public Vehiculo (String matricula, String marca, String modelo, double tamanyo){
        this.matricula=matricula;
        this.tamanyo=tamanyo;
        this.marca=marca;
        this.modelo=modelo;
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
    public double getTamañoDeposito() {
        return tamanyo;
    }
    @Override
    public String toString(){
        return "El vehículo tiene una matricula "+matricula+
        ", su marca es "+marca+" y su modelo es "+modelo;
    }

}
