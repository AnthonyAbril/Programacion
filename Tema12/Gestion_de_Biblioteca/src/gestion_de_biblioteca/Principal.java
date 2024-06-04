
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
            libros.add(new Libro("Arsene Lupin","Maurice Leblanc","Anaya","12434567890",3,14.99d));
            libros.add(new Libro("Caballero Ladron","Maurice Leblanc","Anaya","12345657890",3,14.99d));
            libros.add(new Libro("DEMON SLAYER: KIMETSU NO YAIBA, VOLUMEN 2: 2","KOYOHARU GOTOUGE","Shonen Jump Manga","9781974700530",2    ,10.61d));
        }
        
        if(true){
            Usuarios.add(new Usuario("Luis"));
            Usuarios.add(new Usuario("Mauricio"));
            Usuarios.add(new Usuario("Pablo"));
        }
        
        if(true){
            Empleados.add(new Empleado("German"));
            Empleados.add(new Empleado("Fernando"));
            Empleados.add(new Empleado("Enrique"));
        }
        
        Menu();
    }
    
    public static void Menu(){
        int opcion=0;
        
        do{
            System.out.print("------ Menu --------------------------"
                    + "\n\t1- Dar de alta un libro en el sistema"   //base  hecha
                    + "\n\t2- Búsqueda de libros dentro del sistema"   //base  hecha
                    + "\n\t3- Dar de baja un libro en el sistema"   //base  hecha
                    + "\n\t4- Alquiler de un libro por un usuario"
                    + "\n\t5- Devolución de un libro por un usuario"
                    + "\n\t6- Gestión de empleados/as de la biblioteca"
                    + "\n\t7- Gestión de usuarios/as de la biblioteca"
                    + "\n\t8- Salir del sistema.");
            opcion = eligeopcion(1,8,"\n>Elige una opcion: ");
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    AltaLibro();//hecho
                    break;
                case 2:
                    BuscarLibro(false);//hecho
                    break;
                case 3:
                    BajaLibro();
                    break;
                case 4:
                    AlquilarLibro();    //funcional
                    break;
                case 5:
                    DevolverLibro();    //funcional
                    break;
                case 6:
                    GestionEmpleado();    //terminado
                    break;
                case 7:
                    GestionUsuario();    //terminado
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
    
    public static void LeerLista(ArrayList LL){
        if(LL.isEmpty()){
            System.out.println("No coincide con ningun libro");
        }else{
            for(int a=0;a<LL.size();a++)
                System.out.println("\n     [ Libro nº"+(a+1)+" ]\n"+LL.get(a).toString());
        }
    }
    
    public static Libro BuscarLibro(boolean elegir){
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
            ArrayList <Libro> ListaEncontrados = new ArrayList<>();
            
            Libro elegido = null;
            for(int a=0;a<libros.size();a++){
                boolean encontrado=false;
                elegido = libros.get(a);
                
                if(opcion==1)//titulo
                    encontrado=elegido.getTítulo().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==2)//autor
                    encontrado=elegido.getAutor().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==3)//editorial
                    encontrado=elegido.getEditorial().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==4)//ubicacion
                    encontrado=(elegido.getPasillo()+"").toLowerCase().contains(Pista.toLowerCase());
                if(opcion==5)//ISBN
                    encontrado=elegido.getISBN().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==6)//bibliotecario
                    encontrado=elegido.getBibliotecario().toLowerCase().contains(Pista.toLowerCase());
                if(opcion==7)//prestado o no
                    if(p==1)
                        encontrado=!elegido.isPrestado();
                    else
                        encontrado=elegido.isPrestado();
                if(opcion==8)//usuario
                    encontrado=elegido.getUsuario().toLowerCase().contains(Pista.toLowerCase());
                
                if(encontrado){
                    ListaEncontrados.add(elegido);
                }
            }
            
            LeerLista(ListaEncontrados);
            
            if(elegir){//en caso de que se pida elegir un libro
                if(ListaEncontrados.size()==1){//si solo hay un libro
                    return elegido;
                }else{//si hay mas de un libro se pedira elegir uno entre esos
                    if(ListaEncontrados.isEmpty()){
                        return null;
                    }
                    if(opcion!=1){
                        System.out.print(">Escribe el titulo del libro: ");
                        Pista = sc.nextLine();
                        ArrayList <Libro> AEliminar = new ArrayList<>();
                        
                        for(int a=0;a<ListaEncontrados.size();a++){
                            elegido = ListaEncontrados.get(a);
                            
                            if(!elegido.getTítulo().toLowerCase().contains(Pista.toLowerCase())){
                                AEliminar.add(elegido);
                            }
                        }
                        
                        for(int a=0;a<AEliminar.size();a++){
                            ListaEncontrados.remove(AEliminar.get(a));
                        }
                        
                        LeerLista(ListaEncontrados);
                        if(ListaEncontrados.size()==1){//si solo hay un libro
                            return elegido;
                        }
                        
                        if(ListaEncontrados.isEmpty()){
                            return null;
                        }
                    }
                    do{
                        System.out.print(">Escribe el isbn del libro: ");
                        Pista = sc.nextLine();
                        ArrayList <Libro> AEliminar = new ArrayList<>();
                        
                        for(int a=0;a<ListaEncontrados.size();a++){
                            elegido = ListaEncontrados.get(a);
                            
                            if(!elegido.getISBN().toLowerCase().contains(Pista.toLowerCase())){
                                AEliminar.add(elegido);
                            }
                        }
                        
                        for(int a=0;a<AEliminar.size();a++){
                            ListaEncontrados.remove(AEliminar.get(a));
                        }
                        
                        LeerLista(ListaEncontrados);
                        if(ListaEncontrados.size()==1){//si solo hay un libro
                            return elegido;
                        }
                        
                        if(ListaEncontrados.isEmpty()){
                            return null;
                        }
                    }while(ListaEncontrados.size()!=1);
                }
            }
        }
        return null;
    }
    
    public static void BajaLibro(){
        //El sistema pedirá que busques el libro que se quiere dar de baja (mismos criterios de
        //búsqueda que en apartado anterior). Cuando se haya mostrado la búsqueda, preguntará el
        //título del libro de los listados se desea eliminar, si coincide buscar por autor, si coincide por isbn.
        if(libros.isEmpty()){
            System.out.println("No hay objetos en la lista\n");
        }else{
            Libro l = BuscarLibro(true);
            if(l!=null){
                libros.remove(l);
                System.out.println("- - Objeto Eliminado - -\n");
            }
        }
    }
    
    public static void AlquilarLibro(){
        //El sistema mostrará los libros NO alquilados. 
        ArrayList <Libro> ListaEncontrados = new ArrayList<>();
        Libro elegido = null;
        
        for(int a=0;a<libros.size();a++)//buscamos los libros prestados y los guardamos en ListaEncontrados
            if(!libros.get(a).isPrestado())
                ListaEncontrados.add(libros.get(a));
        
        
        do{
            LeerLista(ListaEncontrados);
            System.out.print(">Escribe el titulo del libro que quieres alquilar: ");
            String Pista = sc.nextLine();
            ArrayList <Libro> AEliminar = new ArrayList<>();

            for(int a=0;a<ListaEncontrados.size();a++){
                elegido = ListaEncontrados.get(a);

                if(!elegido.getTítulo().toLowerCase().contains(Pista.toLowerCase())){
                    AEliminar.add(elegido);
                }
            }

            for(int a=0;a<AEliminar.size();a++){
                ListaEncontrados.remove(AEliminar.get(a));
            }

            LeerLista(ListaEncontrados);
            
        }while(ListaEncontrados.isEmpty());
        
        do{
            System.out.print(">Escribe el isbn del libro: ");
            String Pista = sc.nextLine();
            ArrayList <Libro> AEliminar = new ArrayList<>();

            for(int a=0;a<ListaEncontrados.size();a++){
                elegido = ListaEncontrados.get(a);

                if(!elegido.getISBN().toLowerCase().contains(Pista.toLowerCase())){
                    AEliminar.add(elegido);
                }
            }

            for(int a=0;a<AEliminar.size();a++){
                ListaEncontrados.remove(AEliminar.get(a));
            }
        }while(ListaEncontrados.size()!=1);
        
        
        //Cuando se haya mostrado la búsqueda, preguntará el título del libro de los listados.
        String AlqTitulo = elegido.getTítulo();
        
        //Registrará el nombre de usuario que lo alquila (mostrando listado de usuarios y eligiendo sobre este listado) 
        String AlqUserList="";
        for(int a=0;a<Usuarios.size();a++)
            AlqUserList=(AlqUserList+"\n     [ Usuario nº"+(a+1)+" ] - "+Usuarios.get(a).getNombre()+"\n");
        int AlqUser = eligeopcion(1,Usuarios.size(),AlqUserList+">Introduce la posicion del usuario que lo alquila: ")-1;
        
        //y el empleado que lo entrega (mostrando listado de empleados y eligiendo sobre este listado)
        String AlqEmplList="";
        for(int a=0;a<Empleados.size();a++)
            AlqEmplList=(AlqEmplList+"\n     [ Empleado nº"+(a+1)+" ] - "+Empleados.get(a).getNombre()+"\n");
        int AlqEmpl = eligeopcion(1,Empleados.size(),AlqEmplList+">Introduce la posicion del empleado que lo entrega: ")-1;
        
        //y modificará los atributos necesarios de ese libro para el funcionamiento correcto del programa de gestión.
        //PrestarLibro(AlqEmpl,AlqUser);
        
        elegido.PrestarLibro(Empleados.get(AlqEmpl).nombre, Usuarios.get(AlqUser).nombre);
    }

    private static void DevolverLibro() {
        //El sistema mostrará los libros NO alquilados. 
        ArrayList <Libro> ListaEncontrados = new ArrayList<>();
        Libro elegido = null;
        
        for(int a=0;a<libros.size();a++)//buscamos los libros prestados y los guardamos en ListaEncontrados
            if(libros.get(a).isPrestado())
                ListaEncontrados.add(libros.get(a));
        
        
        do{
            LeerLista(ListaEncontrados);
            System.out.print(">Escribe el titulo del libro que quieres devolver: ");
            String Pista = sc.nextLine();
            ArrayList <Libro> AEliminar = new ArrayList<>();

            for(int a=0;a<ListaEncontrados.size();a++){
                elegido = ListaEncontrados.get(a);

                if(!elegido.getTítulo().toLowerCase().contains(Pista.toLowerCase())){
                    AEliminar.add(elegido);
                }
            }

            for(int a=0;a<AEliminar.size();a++){
                ListaEncontrados.remove(AEliminar.get(a));
            }

            LeerLista(ListaEncontrados);
            
        }while(ListaEncontrados.isEmpty());
        
        do{
            System.out.print(">Escribe el isbn del libro: ");
            String Pista = sc.nextLine();
            ArrayList <Libro> AEliminar = new ArrayList<>();

            for(int a=0;a<ListaEncontrados.size();a++){
                elegido = ListaEncontrados.get(a);

                if(!elegido.getISBN().toLowerCase().contains(Pista.toLowerCase())){
                    AEliminar.add(elegido);
                }
            }

            for(int a=0;a<AEliminar.size();a++){
                ListaEncontrados.remove(AEliminar.get(a));
            }
        }while(ListaEncontrados.size()!=1);
        
        elegido.DevolverLibro();
    }

    private static void GestionEmpleado() {
        //a. Listar empleados.
        //b. Dar de alta nuevo empleado.
        //c. Dar de baja un empleado existente.
        //Indicará el empleado eliminado.
        
        int opcion;
        do{
            opcion = eligeopcion(1,4,"\n------ Gestion de empleados --------------------------"
                    + "\n\t1- Listar empleados"   //base  hecha
                    + "\n\t2- Dar de alta nuevo empleado"   //base  hecha
                    + "\n\t3- Dar de baja un empleado existente"   //base  hecha
                    + "\n\t4- Volver al menú."
                    +"\n>Elige una opcion: ");
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    ListaEmpleado();//hecho
                    break;
                case 2:
                    AltaEmpleado();//hecho
                    break;
                case 3:
                    BajaEmpleado();
                    break;
                default:
                    System.out.println("\n [ ELIGE UNA OPCION DEL MENU ]\n");
                    break;
            }
        }while(opcion!=4);
    }
    
    public static void ListaEmpleado(){
        if(!Empleados.isEmpty()){
            for(int a=0;a<Empleados.size();a++){
                System.out.print("\n     [ Empleado nº"+(a+1)+" ] - "+Empleados.get(a).getNombre()+"\n");
            }
        }else{
            System.out.println(" [ NO HAY EMPLEADOS ] ");
        }
    }    
    
    public static void AltaEmpleado(){
        System.out.print(">Introduzca el nombre del empleado: ");
        Empleados.add(new Empleado(sc.nextLine()));
    }    
    
    public static void BajaEmpleado(){
        
        if(!Empleados.isEmpty()){
            ListaEmpleado();
            System.out.println("Se ha eliminado al empleado "+Empleados.remove(eligeopcion(1,Empleados.size(),">Introduzca la posicion del empleado: ")-1).nombre);
        }else{
            System.out.println(" [ NO HAY EMPLEADOS ] ");
        }
    }
    
    private static void GestionUsuario() {
        //a. Listar usuarios.
        //b. Dar de alta nuevo usuario.
        //c. Dar de baja un usuario existente.
        //Indicará el usuario eliminado.
        
        int opcion;
        do{
            opcion = eligeopcion(1,4,"\n------ Gestion de usuario --------------------------"
                    + "\n\t1- Listar usuario"   //base  hecha
                    + "\n\t2- Dar de alta nuevo usuario"   //base  hecha
                    + "\n\t3- Dar de baja un usuario existente"   //base  hecha
                    + "\n\t4- Volver al menú."
                    +"\n>Elige una opcion: ");
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    ListaUsuario();//hecho
                    break;
                case 2:
                    AltaUsuario();//hecho
                    break;
                case 3:
                    BajaUsuario();
                    break;
                default:
                    System.out.println("\n [ ELIGE UNA OPCION DEL MENU ]\n");
                    break;
            }
        }while(opcion!=4);
    }
    
    public static void ListaUsuario(){
        if(!Usuarios.isEmpty()){
            for(int a=0;a<Usuarios.size();a++){
                System.out.print("\n     [ Usuario nº"+(a+1)+" ] - "+Usuarios.get(a).getNombre()+"\n");
            }
        }else{
            System.out.println(" [ NO HAY USUARIOS ] ");
        }
    }    
    
    public static void AltaUsuario(){
        System.out.print(">Introduzca el nombre del usuario: ");
        Usuarios.add(new Usuario(sc.nextLine()));
    }    
    
    public static void BajaUsuario(){
        
        if(!Usuarios.isEmpty()){
            ListaUsuario();
            System.out.println("\nSe ha eliminado al usuario "+Usuarios.remove(eligeopcion(1,Usuarios.size(),">Introduzca la posicion del usuario: ")-1).nombre);
        }else{
            System.out.println(" [ NO HAY USUARIOS ] ");
        }
    }
}