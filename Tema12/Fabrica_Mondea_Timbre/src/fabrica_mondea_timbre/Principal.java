
package fabrica_mondea_timbre;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList <Dinero> ListaDinero = new ArrayList<>();
    private static File ficherodinero;
    private static final String RutaPorDefecto = "/home/alumnot/NetBeansProjects/Programacion/Tema12/fabrica_mondea_timbre_ficheros";
    private static String ruta;
    //private static final File ficherodinero = new File("C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\fabrica_mondea_timbre_ficheros\\ficherodinero.ddr");
    
    public static void main(String[] args) {
        //arreglar que al poner texto no salga de la funcion, sino que siga preguntandolo
        //arreglar que se pueda poner enteros negativos
        
        try{
            PreguntarRuta();
            
            CargarListaEmpleados(ficherodinero);
            
            Menu();
            
            GuardarListaEmpleados(ficherodinero);
        }catch(ClassNotFoundException ex){
            System.out.println(" [ NO SE HA ENCONTRADO LA CLASE ] ");
        }catch(EOFException ex){
            System.out.println("");
        }
    }
    
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
    
    public static void PreguntarRuta(){
        System.out.print("Elige una ruta"
                + "\n\t1-ruta por defecto"
                + "\n\t2-escribir una ruta");
        int opcion = eligeopcion(1,2,"\n>Elige una opcion: ");
        
        sc.nextLine();
        
        if(opcion==1){//ruta por defecto
            ruta = RutaPorDefecto;
        }else{//ruta del usuario
            System.out.print("Introduce la ruta de la carpeta contenedora del fichero: ");
            ruta = sc.nextLine();
        }
        
        ficherodinero = new File(ruta);
        ficherodinero.mkdirs();
        ficherodinero = new File(ruta+"/ficherofiguras.ddr");
    }
    
    public static void titulo(String texto){
        System.out.println("\n"+texto);
        for(int a=1;a<=texto.length();a++){
            System.out.print("*");
        }
        System.out.println("");
    }
    
    public static void Menu(){
        try {
            int op = 0;
            do {
                System.out.print("----- OPCIONES --------------"
                        + "\n\t1-Crear objetos"//hecho
                        + "\n\t2-Crear copias de objetos"//hecho
                        + "\n\t3-Mostrar todos los objetos"//hecho
                        + "\n\t4-Comprobar si hay dos objetos iguales, y mostrar un mensaje que lo indique"//hecho
                        + "\n\t5-Ordenar el ArrayList"//hecho
                        + "\n\t6-Buscar objetos"//hecho
                        + "\n\t7-Modificar los atributos de dimensión de un objeto"//hecho
                        + "\n\t8-Eliminar objetos"//hecho
                        + "\n\t9-Salir");
                op = eligeopcion(1, 9, "\n>Elige opcion: ");

                switch (op) {
                    case 1:
                        CrearObjetos();
                        break;
                    case 2:
                        CopiarObjetos();
                        break;
                    case 3:
                        MostrarObjetos();
                        break;
                    case 4:
                        ComprobarIguales();
                        break;
                    case 5:
                        OrdenarLista();
                        break;
                    case 6:
                        if (ListaDinero.size() > 0) {
                            System.out.println(BuscarObjeto().toString() + "\n");
                        } else {
                            System.out.println("No hay objetos en la lista\n");
                        }

                        break;
                    case 7:
                        ModificarDimension();
                        break;
                    case 8:
                        EliminarObjeto();
                        break;
                    default:
                        break;
                }
            } while (op != 9);
        } catch (java.util.InputMismatchException ex) {
            System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
            sc.nextLine();
        }
    }
    
    public static void CargarListaEmpleados(File archivo)throws ClassNotFoundException, EOFException{
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
            if(ficherodinero.exists()&&ficherodinero.length()>0){//si ya existe un fichero ahi y tiene contenido

                System.out.print("ya hay un fichero con contenido en la ruta indicada"
                        + "\n\t1-usar la informacion fichero"
                        + "\n\t2-crear un nuevo fichero");
                int opcion = eligeopcion(1,2,"\n>Elige una opcion: ");

                if(opcion==1){//lee la informacion fichero
                    while(true){
                        ListaDinero=(ArrayList <Dinero>)ois.readObject();
                    }
                }
            }
            
        }catch(IOException ex){
            System.out.println(" - - Datos cargados - - ");
        }
    }
    
    public static void GuardarListaEmpleados(File archivo){
        System.out.println("Quieres guardar?"
                + "\n\t1-Si"
                + "\n\t2-No");
        if(eligeopcion(1,2,">Elige una opcion: ")==1){
            try{
                if(archivo.exists()){
                    FileOutputStream fos = new FileOutputStream(archivo,true);
                    MiObjectOutputStream moos = new MiObjectOutputStream(fos);

                    moos.writeObject(ListaDinero);

                    fos.close();
                    moos.close();
                }else{
                    FileOutputStream fos = new FileOutputStream(archivo);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(ListaDinero);

                    fos.close();
                    oos.close();
                }

                System.out.println("\n - - Datos guardados - - ");
                System.out.println("Se han guardado en: "+archivo);

            }catch(IOException ex){
                System.out.println("Error al guardar los datos");
            }
        }else{
            System.out.println("Programa finalizado sin guardar");
        }
    }
    
    public static void CrearObjetos(){
        titulo("CREACIÓN DE UN OBJETO");
        int opcion = 0;
        System.out.print("Elige que quieres crear"
                + "\n\t1-crear una moneda"
                + "\n\t2-crear un billete");

        opcion = eligeopcion(1,2,"\n>Introduce que quieres crear: ");
        
        //valores comunes
        sc.nextLine();
        Double valor = solodouble(">Introduce el valor: ");
        int año = solonumero(">Introduce el año de emision: ");
        
        if(opcion==1){//valores de moneda
            Double diametro = solodouble(">Introduce el diametro: ");
            Double peso = solodouble(">Introduce el peso: ");
        
            ListaDinero.add(new Moneda(valor,año,diametro,peso));
        }else if(opcion==2){//valores de billete
            Double altura = solodouble(">Introduce la altura: ");
            Double anchura = solodouble(">Introduce la anchura: ");
            
            ListaDinero.add(new Billete(valor,año,altura,anchura));
        }
    }
    
    public static Dinero BuscarObjeto(){//Pregunta la posicion del objeto en la lista, lo busca y lo devuelve
        int posicion;
        boolean v=true;
        do{
            if(v==false)
                System.out.println(" [ POSICION FUERA DE LA LISTA ] ");
            v=false;
            posicion = solonumero(">Pon la posicion del objeto en la lista: ")-1;
        }while(posicion<0||posicion>ListaDinero.size()-1);
        return ListaDinero.get(posicion);
    }
    
    public static void CopiarObjetos(){
        
        if(!ListaDinero.isEmpty()){
            Dinero D = BuscarObjeto();
            if(D instanceof Moneda){
                ListaDinero.add(new Moneda((Moneda)D));
            }else if(D instanceof Billete){
                ListaDinero.add(new Billete((Billete)D));
            }
        System.out.println("- - Copia Creada - -\n");
        }else{
            System.out.println("No hay objetos en la lista");
        }
    }
    
    public static void MostrarObjetos(){
        if(!ListaDinero.isEmpty()){
            titulo("LISTA DE TODOS LOS OBJETOS");
            for(int a=0;a<ListaDinero.size();a++){
                System.out.println("["+(a+1)+"] "+ListaDinero.get(a)+"\n");
            }
        }else{
            System.out.println("No hay objetos en la lista\n");
        }
    }
    
    public static void ComprobarIguales(){
        if(!ListaDinero.isEmpty()){

            titulo("LISTA DE OBJETOS REPETIDOS");    //usar arraylist en la que se guarden los numeros de la posicion en la que se encuentran las repetidas y se repase despues para no repetirse

            HashMap<String, Integer> repetidos = new HashMap<>();   //hacemos una lista que tenga los datos y las veces q han salido
            for(int a=0;a<ListaDinero.size();a++){//recorre la lista una sola vez

                if(repetidos.containsKey(ListaDinero.get(a).toString())){   //si esta en el hashmap
                    repetidos.replace(ListaDinero.get(a).toString(), repetidos.get(ListaDinero.get(a).toString()), repetidos.get(ListaDinero.get(a).toString())+1);

                }else{//si no esta en el hashmap
                    repetidos.put(ListaDinero.get(a).toString(), 1);    //metemos el primero con un valor de repetidos 1

                }
            }

            //recorremos el hashmap
            boolean hayRepetidos = false;
            for (Map.Entry<String, Integer> entry : repetidos.entrySet()) {
                Integer valor = entry.getValue();
                // Hacer algo con cada valor
                if(valor>1){
                    System.out.print("El objeto "+entry.getKey()+" se ha repetido " + valor + " veces\n");
                    hayRepetidos = true;
                }
            }
            if(hayRepetidos == false){
                System.out.println("No se repite ningun objeto");
            }
        }else{
            System.out.println("No hay objetos en la lista\n");
        }
    }
    
    public static void OrdenarLista(){
        if(!ListaDinero.isEmpty()){
            Collections.sort(ListaDinero, new Comparator<Dinero>(){
            @Override
            public int compare(Dinero e1, Dinero e2) {
                return e1.compareTo(e2 );
                }
            });
            MostrarObjetos();
            System.out.println("Lista Ordenada");
        }else{
            System.out.println("No hay objetos en la lista\n");
        }
    }
    
    public static void ModificarDimension(){
        if(!ListaDinero.isEmpty()){
            Dinero D = BuscarObjeto();

            if(D instanceof Moneda){//si es una moneda
                double Diametro = solodouble(">Introduce el nuevo valor de su diametro: ");
                ((Moneda) D).setDiametro(Diametro);
            }
            else if(D instanceof Billete){//si es un billete
                double Altura = solodouble(">Introduce el nuevo valor de su altura");
                ((Billete) D).setAltura(Altura);
                double Anchura = solodouble(">Introduce el nuevo valor de su anchura");
                ((Billete) D).setAnchura(Anchura);
            }
        }else{
            System.out.println("No hay objetos en la lista\n");
        }
    }
    
    public static void EliminarObjeto(){
        if(ListaDinero.isEmpty()){
            System.out.println("No hay objetos en la lista\n");
        }else{
            Dinero d = BuscarObjeto();
            System.out.println("\n"+d.toString());
            ListaDinero.remove(d);
            System.out.println("- - Objeto Eliminado - -\n");
        }
    }
}
