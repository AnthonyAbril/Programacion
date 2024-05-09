
package gestion_de_biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    
    public static double solodouble(String texto){
        boolean isnumeric=false;
        double numero=0;
        do{
            try{
                System.out.print(texto);
                numero = sc.nextDouble();
                if(numero<=0){
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                }else{
                    isnumeric=true;
                }
                
            }catch(java.util.InputMismatchException  ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO DECIMAL ] ");
                sc.nextLine();
            }
        }while(isnumeric==false);
        return numero;
    }
    
    public static int solonumero(String texto){
        boolean isnumeric=false;
        int numero=0;
        do{
            try{
                System.out.print(texto);
                numero = sc.nextInt();
                if(numero<=0){
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                }else{
                    isnumeric=true;
                }
            }catch(java.util.InputMismatchException  ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] ");
                sc.nextLine();
            }
        }while(isnumeric==false);
        return numero;
    }
    
    public static int eligeopcion(int min, int max, String texto){
        int opcion = 0;
        do{
            opcion = solonumero(texto);
            if(opcion<min || opcion >max){
                System.out.println(" [ OPCION NO DISPONIBLE ] ");
            }
        }while(opcion<min || opcion >max);
        return opcion;
    }

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
            libros.add(new Libro("Arsene Lupin","Maurice Leblanc","Anaya","1234567890",3,14.99d));
            libros.add(new Libro("DEMON SLAYER: KIMETSU NO YAIBA, VOLUMEN 2: 2","KOYOHARU GOTOUGE","Shonen Jump Manga","9781974700530",2    ,10.61d));
        }
        
        if(true){
            Empleados.add(new Empleado());
        }
        
        Menu();
    }
    
    public static void Menu(){
        int opcion=0;
        
        do{
            System.out.print("------ Menu --------------------------"
                    + "\n\t1- Dar de alta un libro en el sistema"   //base  hecha
                    + "\n\t2- Búsqueda de libros dentro del sistema"
                    + "\n\t3- Dar de baja un libro en el sistema"
                    + "\n\t4- Alquiler de un libro por un usuario"
                    + "\n\t5- Devolución de un libro por un usuario"
                    + "\n\t6- Gestión de empleados/as de la biblioteca"
                    + "\n\t7- Gestión de usuarios/as de la biblioteca"
                    + "\n\t8- Salir del sistema."
                    + "\n>Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    AltaLibro();//hecho
                    break;
                case 2:
                    BuscarLibro();//hecho
                    break;
                case 3:
                    BajaLibro();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n [ ELIGE UNA OPCION DEL MENU ]\n");
                    break;
            }
        }while(opcion!=8);
    }
    
    public static Libro BuscarObjeto(){
        int posicion;
        boolean v=true;
        do{
            if(v==false)
                System.out.println(" [ POSICION FUERA DE LA LISTA ] ");
            v=false;
            posicion = solonumero(">Pon la posicion del objeto en la lista: ")-1;
        }while(posicion<0||posicion>libros.size()-1);
        return libros.get(posicion);
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
        int pasillo = solonumero(">Introduce la ubicación del libro (numero del pasillo): ");
        Double precio = solodouble(">Introduce el precio del libro: ");
        
        libros.add(new Libro(titulo,autor,editorial,ISBN,pasillo,precio));
    }
    
    public static void BuscarLibro(){
        if(!libros.isEmpty()){
            System.out.println("Busqueda de libros"
                    + "\n\t1-Titulo"
                    + "\n\t2-Autor"
                    + "\n\t3-Editorial"
                    + "\n\t4-Ubicacion"
                    + "\n\t5-ISBN"
                    + "\n\t6-Nombre del bibliotecario que lo ha prestado"
                    + "\n\t7-Estado préstamos (búsqueda de libros prestados y no prestados)"
                    + "\n\t8-Nombre del usuario que lo ha alquilado");
            int opcion=eligeopcion(1,8,">Elige un metodo de busqueda: ");
            sc.nextLine();
            String Pista="";
            int p=0;
            if(opcion==7)
                p=eligeopcion(1,2,"\nQue quieres buscar"
                        + "\n\t1-prestados"
                        + "\n\t2-no prestados"
                        + "\n>Elige una opcion: ");
            else{
                System.out.print(">Palabra que se busca: ");
                Pista = sc.nextLine();
            }
            
            for(int a=0;a<libros.size();a++){
                boolean encontrado=false;
                
                if(opcion==1)//titulo
                    encontrado=libros.get(a).getTítulo().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==2)//autor
                    encontrado=libros.get(a).getAutor().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==3)//editorial
                    encontrado=libros.get(a).getEditorial().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==4)//ubicacion
                    encontrado=(libros.get(a).getPasillo()+"").toLowerCase().contains(Pista.toLowerCase());
                if(opcion==5)//ISBN
                    encontrado=libros.get(a).getISBN().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==6)//bibliotecario
                    encontrado=libros.get(a).getBibliotecario().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==7)//prestado o no
                    if(p==1)
                        encontrado=!libros.get(a).isPrestado();
                    else
                        encontrado=libros.get(a).isPrestado();
                if(opcion==8)//usuario
                    encontrado=libros.get(a).getUsuario().toLowerCase().contains(Pista.toLowerCase());
                
                if(encontrado){
                    System.out.println("\n     [ Libro nº"+(a+1)+" ]\n"+libros.get(a).toString());
                }
            }
        }
    }
    
    public static void BajaLibro(){
        if(libros.isEmpty()){
            System.out.println("No hay objetos en la lista\n");
        }else{
            Libro l = BuscarObjeto();
            System.out.println("\n"+l.toString());
            libros.remove(l);
            System.out.println("- - Objeto Eliminado - -\n");
        }
    }
    
    
}
