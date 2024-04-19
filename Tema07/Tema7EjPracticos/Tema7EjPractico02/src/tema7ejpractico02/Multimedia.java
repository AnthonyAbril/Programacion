
package tema7ejpractico02;

public class Multimedia {
    private String titulo;
    private String autor;
    private Formato formato;
    private int duracion;
    
    public Multimedia (String t, String a, Formato f, int d){
        titulo=t;
        autor=a;
        formato=f;
        duracion=d;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String a) {
        autor = a;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public void setDuracion(int d) {
        duracion = d;
    }
    
    public String toString(){
        return ("Titulo: " + titulo
                + "\nAutor: " + autor
                + "\nFormato: " + formato
                + "\nDuracion: " + duracion);
    }
    
    public boolean equals(Multimedia m){
        if (titulo.equals(m.getTitulo()) && autor.equals(m.getAutor()))
            return true;
        return false;
    }
}
