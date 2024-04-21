
package tema7ejpractico03;

public class Libros extends Publicaciones implements Prestable{
    public boolean prestado;
    
    public Libros (String codigo, String titulo, String año){
        super(codigo,titulo, año);
        prestado = false;
    }
    
    public String toString(){
        
        return (super.toString() + "\nPrestado: " + prestado);
    }
    
    @Override
    public void Prestar() {
        prestado = true;
    }

    @Override
    public void Devolver() {
        prestado = false;
    }

    @Override
    public boolean Prestado() {
        return prestado;
    }
}
