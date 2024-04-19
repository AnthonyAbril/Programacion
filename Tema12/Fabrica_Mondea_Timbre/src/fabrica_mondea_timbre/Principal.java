
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
    private static String RutaPorDefecto = "/home/alumnot/NetBeansProjects/Tema12/fabrica_mondea_timbre_ficheros/ficherodinero.ddr";
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
    
    public static void PreguntarRuta(){
        int opcion=0;
        do{
            System.out.print("Elige una ruta"
                    + "\n\t1-ruta por defecto"
                    + "\n\t2-escribir una ruta"
                    + "\n>Elige una opcion: ");
            opcion = sc.nextInt();
        }while(opcion!=1&&opcion!=2);
        
        if(opcion==1){//ruta por defecto
            ficherodinero = new File(RutaPorDefecto);
        }else{//ruta del usuario
            System.out.print("Introduce la ruta: ");
            ficherodinero = new File(sc.nextLine()+"/ficherodinero.ddr");
        }
        
        //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
    }
    
    public static void titulo(String texto){
        System.out.println("\n"+texto);
        for(int a=1;a<=texto.length();a++){
            System.out.print("*");
        }
        System.out.println("");
    }
    
    public static void Menu(){
        int op=0;
        do{
            try{
                System.out.print("----- OPCIONES --------------"
                        + "\n\t1-Crear objetos"//hecho
                        + "\n\t2-Crear copias de objetos"//hecho
                        + "\n\t3-Mostrar todos los objetos"//hecho
                        + "\n\t4-Comprobar si hay dos objetos iguales, y mostrar un mensaje que lo indique"//hecho
                        + "\n\t5-Ordenar el ArrayList"//hecho
                        + "\n\t6-Buscar objetos"//hecho
                        + "\n\t7-Modificar los atributos de dimensión de un objeto"//hecho
                        + "\n\t8-Eliminar objetos"//hecho
                        + "\n\t9-Salir"
                        + "\n>Elige opcion: ");
                op=sc.nextInt();
                sc.nextLine();

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
                        if(ListaDinero.size()>0){
                            System.out.println(BuscarObjeto().toString()+"\n");
                        }else{
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
            }catch(java.util.InputMismatchException ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
                sc.nextLine();
            }
        }while(op!=9);
    }
    
    public static void CargarListaEmpleados(File archivo)throws ClassNotFoundException, EOFException{
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            while(true){
                ListaDinero=(ArrayList <Dinero>)ois.readObject();
            }
        }catch(IOException ex){
            System.out.println(" - - Datos cargados - - ");
        }
    }
    
    public static void GuardarListaEmpleados(File archivo){
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
        }catch(IOException ex){
            System.out.println("Error al guardar los datos");
        }
    }
    
    public static void CrearObjetos(){
        titulo("CREACIÓN DE UN OBJETO");
        int opcion = 0;
        do{
            System.out.print("Elige que quieres crear"
                    + "\n\t1-crear una moneda"
                    + "\n\t2-crear un billete"
                    + "\n>Introduce que quieres crear: ");
            
            opcion = sc.nextInt();
        }while(opcion!=1&&opcion!=2);
        
        //valores comunes
        sc.nextLine();
        System.out.print(">Introduce el valor: ");
        Double valor = sc.nextDouble();
        System.out.print(">Introduce el año de emision: ");
        int año = sc.nextInt();
        
        if(opcion==1){//valores de moneda
            System.out.print(">Introduce el diametro: ");
            Double diametro = sc.nextDouble();
            System.out.print(">Introduce el peso: ");
            Double peso = sc.nextDouble();
        
            ListaDinero.add(new Moneda(valor,año,diametro,peso));
        }else if(opcion==2){//valores de billete
            System.out.print(">Introduce la altura: ");
            Double altura = sc.nextDouble();
            System.out.print(">Introduce la anchura: ");
            Double anchura = sc.nextDouble();
            
            ListaDinero.add(new Billete(valor,año,altura,anchura));
        }
    }
    
    public static Dinero BuscarObjeto(){//Pregunta la posicion del objeto en la lista, lo busca y lo devuelve
        int posicion;
        boolean v=true;
        do{
            if(v==false)
                System.out.println(" [ POSICION FUERA DE LA LISTA ] ");
            System.out.print(">Pon la posicion del objeto en la lista: ");
            v=false;
            posicion = sc.nextInt()-1;
        }while(posicion<0||posicion>ListaDinero.size()-1);
        return ListaDinero.get(posicion);
    }
    
    public static void CopiarObjetos(){
        
        if(ListaDinero.size()>0){
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
        if(ListaDinero.size()>0){
            titulo("LISTA DE TODOS LOS OBJETOS");
            for(int a=0;a<ListaDinero.size();a++){
                System.out.println("["+(a+1)+"] "+ListaDinero.get(a)+"\n");
            }
        }else{
            System.out.println("No hay objetos en la lista\n");
        }
    }
    
    public static void ComprobarIguales(){
        if(ListaDinero.size()>0){

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
        if(ListaDinero.size()>0){
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
    
    public static double DoblePositivo(String texto){
        Double valor=0d;
        do{
            System.out.print(texto);
            valor = sc.nextDouble();
            if(valor<=0){
                System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
            }
        }while(valor<=0);
        
        return valor;
    }
    
    public static void ModificarDimension(){
        if(ListaDinero.size()>0){
            Dinero D = BuscarObjeto();

            if(D instanceof Moneda){//si es una moneda
                double Diametro = DoblePositivo(">Introduce el nuevo valor de su diametro: ");
                ((Moneda) D).setDiametro(Diametro);
            }
            else if(D instanceof Billete){//si es un billete
                double Altura = DoblePositivo(">Introduce el nuevo valor de su altura");
                ((Billete) D).setAltura(Altura);
                double Anchura = DoblePositivo(">Introduce el nuevo valor de su anchura");
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
