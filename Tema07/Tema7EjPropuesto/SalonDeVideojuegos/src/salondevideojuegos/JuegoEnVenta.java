
package salondevideojuegos;

public class JuegoEnVenta extends Juego {

    public JuegoEnVenta() {
        super();
    }

    public JuegoEnVenta(String t, String f, int a, double p, int nc) {
        super(t, f, a, p, nc);
    }
    
    public void vender(){
        //decrementa el número de copias disponibles
        super.ncopiasdisp=super.ncopiasdisp-1;
    }
}
