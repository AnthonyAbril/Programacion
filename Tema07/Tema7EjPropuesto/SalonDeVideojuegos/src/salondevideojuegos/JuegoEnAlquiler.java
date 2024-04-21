
package salondevideojuegos;

public class JuegoEnAlquiler extends Juego implements Alquilable{
    int ndiasalquila;//Número de días que se alquila (1 día, 2 días, ...):
    
    //Constructor por defecto
    public JuegoEnAlquiler(){
        super();
    }
    //Constructor con todos los parámetros
    public JuegoEnAlquiler(String t, String f, int a, double p, int nc, int ndias){
        super(t, f, a, p, nc);
        ndiasalquila=ndias;
    }
    
    //Constructor de copia
    public JuegoEnAlquiler(JuegoEnAlquiler JeA){
        super(JeA.titulo, JeA.fabricante, JeA.anyo, JeA.precio, JeA.ncopiasdisp);
        this.ndiasalquila=JeA.ndiasalquila;
    }
    
    @Override
    public void alquilar() {
        //decrementa el número de copias disponibles
        super.ncopiasdisp=super.ncopiasdisp-1;
    }
    
    @Override
    public void devolver() {
        //incrementa el número de copias disponibles
        super.ncopiasdisp=super.ncopiasdisp+1;
    }
    
    @Override
    public double precioFinal(){
        //devuelve el precio final del alquiler, dependiendo del número de días que se alquile el juego.
        
        return  ndiasalquila*super.precio;
    }
    
    @Override
    public String toString() {
    //devuelve los datos del JuegoEnAlquiler
    
         return super.toString() 
                 + "\nndiasalquila=" + ndiasalquila;
    }
    
}
