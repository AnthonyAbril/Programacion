
package gestion_de_biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);

    //- Colección empleados/as de la biblioteca: esta colección estará precargada por programa e
    //incluirá las siguientes personas: Alberto, Encarna, Estela, Manolo, Agustín. En la opción
    //correspondiente del menú se podrá gestionar el alta y baja de empleados.
    private static ArrayList <Empleado> Empleados = new ArrayList<>();
    
    //- Colección usuarios/as biblioteca: esta colección estará precargada por programa e incluirá las
    //siguientes personas: usu1, usu2, usu3, usu4, usu5. En la opción correspondiente del menú se
    //podrá gestionar el alta y baja de usuarios.
    private static ArrayList <Usuario> Usuarios = new ArrayList<>();
    
    //- Colección libros: implementará una colección de objetos de tipo Libro con todos los campos
    //indicados anteriormente.
    private static ArrayList <Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        if(true){
            Empleados.add(new Empleado());
        }
        
        Menu();
    }
    
    public static void Menu(){
        int opcion=0;
        
        do{
            System.out.print("------ Menu --------------------------"
                    + "\n\t1- Dar de alta un libro en el sistema"
                    + "\n\t2- Búsqueda de libros dentro del sistema"
                    + "\n\t3- Dar de baja un libro en el sistema"
                    + "\n\t4- Alquiler de un libro por un usuario"
                    + "\n\t5- Devolución de un libro por un usuario"
                    + "\n\t6- Gestión de empleados/as de la biblioteca"
                    + "\n\t7- Gestión de usuarios/as de la biblioteca"
                    + "\n\t8- Salir del sistema."
                    + ">Elige una opcion: ");
            
            switch (opcion) {
                case 1:
                    AltaLibro();
                    break;
                case 2:
                    BuscarLibro();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(opcion!=8);
    }
    
    public static void AltaLibro(){
        //El sistema pedirá: título, autor, editorial, ubicación, ISBN, precio.
        //El sistema añadirá este libro en el conjunto de libros de la biblioteca.
        
        System.out.print(">Introduce el titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.print(">Introduce el autor del libro: ");
        String autor = sc.nextLine();
        System.out.print(">Introduce la editorial del libro: ");
        String editorial = sc.nextLine();
        System.out.print(">Introduce el ISBN del libro: ");
        String ISBN = sc.nextLine();
        System.out.print(">Introduce la ubicación del libro (numero del pasillo): ");
        int pasillo = sc.nextInt();
        System.out.print(">Introduce el precio del libro: ");
        Double precio = sc.nextDouble();
        
        libros.add(new Libro(titulo,autor,editorial,ISBN,pasillo,precio));
    }
    
    public static void BuscarLibro(){
        
    }
}
