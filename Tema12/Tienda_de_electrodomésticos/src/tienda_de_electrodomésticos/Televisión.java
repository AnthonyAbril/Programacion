
package tienda_de_electrodomésticos;

public final class Televisión extends Electrodoméstico{
    //Resolución, en pulgadas (no visible)
    private int resolucion;
    
    //SintonizadorTDT, boolean (no visible)
    private boolean sintonizador;

    //○ Un constructor por defecto.
    public Televisión() {
        //Por defecto, la resolución es de 20 pulgadas y el sintonizador es false.
        this.resolucion=20;
        this.sintonizador=false;
    }
    
    //○ Un constructor con el precio y peso. El resto por defecto.
    public Televisión(int base,int peso){
        super(base, peso);
        this.resolucion=20;
        this.sintonizador=false;
    }
    
    //○ Un constructor con la resolución, sintonizador TDT y el resto de atributos heredados.
    public Televisión(int resolucion, boolean sintonizador, String Modelo, int base, String color, char CE, int peso) {
        super(Modelo, base, color, CE, peso);
        this.resolucion = resolucion;
        this.sintonizador = sintonizador;
    }
    
    //○ Un constructor de copia.
    public Televisión(Televisión T) {
        super(T.getModelo(), T.getBase(), T.getColor(), T.getCE(), T.getPeso());
        this.resolucion = T.resolucion;
        this.sintonizador = T.sintonizador;
    }

    public double precioFinal(){
        //devuelve el precio final de venta, teniendo en cuenta que al
        //precio base se le deben aplicar los incrementos de la clase Electrodoméstico más
        //el incremento propio de esta clase, que es el siguiente:
        double PF= this.getBase()+this.incrementoPrecio();
        
        if(resolucion>40)
            //➢ si tiene una resolución mayor de 40 pulgadas, se aumenta el precio un 30%.
            PF=PF*1.3;
        if(sintonizador)
            //➢ si tiene un sintonizador TDT incorporado, aumenta 50 €.
            PF=PF+50;
        
        return PF;
    }

    @Override
    public String toString() {
        return  "Televisión" + super.toString()+"\n\tresolucion=" + resolucion +"\n\tsintonizador=" + sintonizador + "\n\tprecio final=" + precioFinal();
    }
    
    
    
}
