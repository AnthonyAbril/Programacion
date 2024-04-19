
package salondevideojuegos;

public interface Alquilable {
    
    public void alquilar(); //decrementa el número de copias disponibles
    
    public void devolver(); //incrementa el número de copias disponibles
    
    public double precioFinal(); //devuelve el precio final del alquiler, dependiendo del número de días que se alquile el juego.
    
    
}
