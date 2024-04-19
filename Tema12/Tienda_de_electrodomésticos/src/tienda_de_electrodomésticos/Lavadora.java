
package tienda_de_electrodomésticos;

public final class Lavadora extends Electrodoméstico {
    
    //ATRIBUTOS:
    //● Carga (no visible)      Por defecto, la carga es de 5 kg
    private int carga;
    
    //CONSTRUCTORES:
    //○ Un constructor por defecto.
    
    public Lavadora() {
        this.carga = 5;
    }
    
    //○ Un constructor con la carga y el resto de atributos heredados.
    public Lavadora(String Modelo, int base, String color, char CE, int peso, int carga) {
        super(Modelo, base, color, CE, peso);
        this.carga = carga;
    }
    
    //○ Un constructor con el precio y peso. El resto por defecto.
    public Lavadora(int base, int peso) {
        super(base, peso);
        this.carga = 5;
    }
    
    //○ Un constructor de copia.
    public Lavadora(Lavadora l) {
        super(l.getModelo(), l.getBase(), l.getColor(), l.getCE(), l.getPeso());
        this.carga = l.carga;
    }
    
    //MÉTODOS:
        //1. double precioFinal(): devuelve el precio final de venta, teniendo en cuenta que al
        //precio base se le deben aplicar los incrementos de la clase Electrodoméstico más
        //el incremento propio de esta clase, que es el siguiente:
            //➢ si tiene una carga mayor de 30 kg, se aumenta el precio 50 €, si no es así, no se incrementa el precio.
    public double precioFinal(){
        int IncLav=(carga>30)?50:0;
        return this.getBase()+this.incrementoPrecio()+IncLav;
    }
    
        //2. String toString(): devuelve en una cadena toda la información del objeto, además
        //del precio final de venta. Quizás sea conveniente hacer previamente el método toString de la superclase.

    @Override
    public String toString() {
        
        return "Lavadora" + super.toString()+"\n\tcarga=" + carga + "\n\tprecio final=" + precioFinal() ;
    }
    
}
