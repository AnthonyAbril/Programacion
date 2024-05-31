
package gestion_de_biblioteca;

import java.io.Serializable;

public class Libro implements Serializable{
    private static final long serialVersionUID = 6L;
    //Tenemos libros (título, autor, editorial, estado préstamos (SI/NO), ubicación en biblioteca (pasillo
    //numérico), ISBN, precio, nombre bibliotecario/a que lo ha prestado, nombre usuario biblioteca que
    //tiene el libro).
    
    private String título;
    private String autor;
    private String editorial;
    private boolean prestado;
    private String ISBN;
    private int pasillo;
    private Double precio;

    //datos si esta prestado
    private String bibliotecario;   //que lo ha prestado
    private String usuario;     //que tiene el libro

    //constructor para un libro prestado
    public Libro(String título, String autor, String editorial, String ISBN, int pasillo, Double precio, String bibliotecario, String usuario) {
        this.título = título;
        this.autor = autor;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.pasillo = pasillo;
        this.precio = precio;
        
        this.prestado = false;
        this.bibliotecario = bibliotecario;
        this.usuario = usuario;
    }

    public void PrestarLibro(String bibliotecario, String usuario) {
        this.bibliotecario = bibliotecario;
        this.usuario = usuario;
        this.prestado = true;
    }
    
        public void PrestarLibro() {
        this.prestado = false;
    }

    @Override
    public String toString() {
        return "\tt\u00edtulo=" + título + "\n\tautor=" + autor + "\n\teditorial=" + editorial + "\n\tprestado=" + prestado + "\n\tISBN=" + ISBN + "\n\tpasillo=" + pasillo + "\n\tprecio=" + precio + "\n\tbibliotecario=" + bibliotecario + "\n\tusuario=" + usuario;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getBibliotecario() {
        return bibliotecario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTítulo() {
        return título;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPasillo() {
        return pasillo;
    }
    
    
    
    //constructor para un libro sin prestar
    public Libro(String título, String autor, String editorial, String ISBN, int pasillo, Double precio) {
        this.título = título;
        this.autor = autor;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.pasillo = pasillo;
        this.precio = precio;
        
        this.prestado = false;
        this.bibliotecario = null;
        this.usuario = null;
    }
    
}
