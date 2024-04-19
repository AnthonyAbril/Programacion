
package tema7ejpractico03;

public class Publicaciones {
    private String codigo;
    private String titulo;
    private String año;
    
    public Publicaciones(String c, String t, String a){
        codigo = c;
        titulo = t;
        año = a;
    }
    
    public String toString(){
        return ("Codigo: " + codigo
                + "\nTitulo: " + titulo
                + "\nAño: " + año);
    }
    
    public String añoycodigo(){
        return ("El año de publicacion es " + año + " y tiene el codigo: " + codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAño() {
        return año;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    
}
