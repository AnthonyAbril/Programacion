
package gestion_de_biblioteca;

public class Libro {
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
        
        this.prestado = true;
        this.bibliotecario = bibliotecario;
        this.usuario = usuario;
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
