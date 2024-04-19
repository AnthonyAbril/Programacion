
package tienda_de_electrodomésticos;

import java.util.HashMap;

public abstract class Electrodoméstico {
    
    //● Modelo (no visible)
    private String Modelo;
    
    //● Precio base (no visible)
    private int base;
    
    //● Consumo energético
        //➝ accesible desde la subclase
        //➝ posibles valores: letras entre A y F
    protected char CE;    
    
    //● Peso (no visible)
    private int peso;
    
    //Además, comunes a todos los objetos de la clase, y visibles desde cualquier clase:
        //■ Número total de electrodomésticos en la tienda
    public static int Ntotal;
    
        //■ HashMap con los siguientes elementos:
    public static HashMap<Character, Integer> LetraPrecio = new HashMap<>();
            //LETRA PRECIO
            //  A 100 €
            //  B 80 €
            //  C 60 €
            //  D 50 €
            //  E 30 €
            //  F 10 €
    
    //Por defecto, el modelo es “Desconocido”, el precio base es 100 €, el consumo energético es F y el peso es 5 kg
    
    //CONSTRUCTORES:
        //Un constructor con todos los parámetros
    public Electrodoméstico(String Modelo, int base, char CE, int peso) {
        
        this.Modelo = Modelo;
        this.base = base;
        comprobarConsumo(CE);
        this.peso = peso;
        Ntotal++;
        
    }
    
        //Un constructor por defecto
    public Electrodoméstico() {
        this.Modelo = "Desconocido";
        this.base = 100;
        this.CE = 'F';
        this.peso = 5;
        Ntotal++;
    }
    
    //MÉTODOS:
        //1. rellenarLetras(): introduce los datos arriba indicados en el HashMap.
    public void rellenarLetras(){
        
    }
    
        //2. Métodos get de los atributos que lo necesiten.
    public String getModelo() {
        return Modelo;
    }

    public int getBase() {
        return base;
    }

    public char getCE() {
        return CE;
    }

    public static int getNtotal(){
        return Ntotal;
    }
    
    public int getPeso() {
        return peso;
    }
    
        //3. Métodos set de los atributos que lo necesiten.
     public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setCE(char CE) {
        comprobarConsumo(CE);
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
        //4. comprobarConsumo (char letra): comprueba que la letra es correcta.
            //Si no es correcta, usa la letra por defecto.
            //Se invoca al crear un objeto.
            //No es visible.
    private void comprobarConsumo (char letra){
        if(letra!='A'&&letra!='B'&&letra!='C'&&letra!='D'&&letra!='E'&&letra!='F'){
            this.CE = 'F';  //Si no es correcta, usa la letra por defecto.
        }else{
            this.CE = letra;    
        }
    }
    
        //5. double incrementoPrecio(): en función del consumo energético y del peso,
        //aumenta el precio. Devuelve el incremento correspondiente.
        //No puede ser sobreescrito por la subclase.
            //-La información relacionada con el incremento de precio según el consumo
            //energético es la que está almacenada en el HashMap arriba indicado.
            //-La correspondiente al peso es la que se muestra a continuación:
                //PESO PRECIO
                //Entre 0 y 19 kg 10 €
                //Entre 20 y 49 kg 50 €
                //Entre 50 y 79 kg 80 €
                //Mayor que 80 kg 100 €
    protected int incrementoPrecio(){
        int PesInc;
        int PrecInc=LetraPrecio.get(CE);
        
        if(peso<=0 && peso>=19){
            PesInc=10;
        }else if(peso<=20 && peso>=49){
            PesInc=50;
        }else if(peso<=50 && peso>=79){
            PesInc=80;
        }else{
            PesInc=100;
        }
        
        return PesInc+PrecInc;
    }

    @Override
    public String toString() {
        return "Electrodomestico\n\t" + "Modelo=" + Modelo + "\n\tbase=" + base + "\n\tCE=" + CE + "\n\tpeso=" + peso;
    }

}
