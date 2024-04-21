
package tema7ejpractico03;

public class Revistas extends Publicaciones {
    public int numero;
    
    public Revistas(String codigo, String titulo, String año , int n){
        super(codigo,titulo, año);
        
        numero = n;
    }
    
    public String toString(){
        
        return (super.toString() + "\nNumero: " + numero);
    }
}
