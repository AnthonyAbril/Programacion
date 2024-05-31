
package gestordearchivos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {

    static Scanner sc = new Scanner(System.in);
    private static ArrayList <ArrayList> plazas = new ArrayList<>();
    private static File ficheroparking;
    private static final String RutaPorDefecto = "ficheros/";
    private static String ruta;
    
    private static ArrayList <String> plazaPlantSup = new ArrayList<>(); //20 plazas
    private static ArrayList <String> plazaPlantInf = new ArrayList<>(); //20 plazas
    private static ArrayList <String> plazareservada = new ArrayList<>(); //10 plazas
    
    public static void main(String[] args) {
        try{
            PreguntarRuta();
            
            CargarListaEmpleados(ficheroparking);
            
            Menu();
            
            GuardarListaEmpleados(ficheroparking);
        }catch(IOException ex){
            System.out.println(ex);
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
        }
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
            boolean isnumeric=false;
            int numero=0;
            do{
                try{
                    System.out.print(texto);
                    numero = sc.nextInt();
                    isnumeric=true;
                }catch(java.util.InputMismatchException  ex){
                    System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] ");
                    sc.nextLine();
                }
            }while(isnumeric==false);
            opcion = numero;
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
        
        ficheroparking = new File(ruta);
        ficheroparking.mkdirs();
        ficheroparking = new File(ruta+"/ficheroparking.ddr");
    }
    
    public static void CargarListaEmpleados(File archivo)throws ClassNotFoundException, EOFException{
        
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
            if(ficheroparking.exists()){
                if(ficheroparking.length()>0){//si ya existe un fichero ahi y tiene contenido

                    System.out.print("ya hay un fichero con contenido en la ruta indicada"
                            + "\n\t1-usar la informacion fichero"
                            + "\n\t2-crear un nuevo fichero");
                    int opcion = eligeopcion(1,2,"\n>Elige una opcion: ");

                    if(opcion==1){//lee la informacion fichero
                        while(true){
                            plazas=(ArrayList <ArrayList>)ois.readObject();
                            System.out.println(" - - - Leyendo lista - - -");
                        }
                    }
                }
            }

        }catch(IOException ex){
            System.out.println(" - - Datos cargados - - ");
        }
       if(!plazas.isEmpty()){//si el plazas que hemos leido tiene contenido lo leemos
            plazaPlantSup=plazas.get(0);
            plazaPlantInf=plazas.get(1);
            plazareservada=plazas.get(2);
       }else{//si no tiene contenido lo llenamos
           System.out.println("rellenars");
            for(int a=0;plazaPlantSup.size()<20;a++){
                plazaPlantSup.add("VACIO");
            }

            for(int a=0;plazaPlantInf.size()<20;a++)
                plazaPlantInf.add("VACIO");

            for(int a=0;plazareservada.size()<10;a++)
                plazareservada.add("VACIO");
       }
    }
    
    
    public static void Menu(){
        int op=0;
        do{
            try{
                
                System.out.println("-- Opciones --"
                    + "\n\t1-Introducir"
                    + "\n\t2-Mostrar"
                    + "\n\t3-Eliminar"
                    + "\n\t4-Salir");
                op=eligeopcion(1,6,"\n>Elige opcion: ");

                switch (op) {
                    case 1:
                        introducir();
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                        eliminar();
                        break;
                    default:
                        break;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
                sc.nextLine();
            }
        }while(op!=4);
    }
    
    public static void GuardarListaEmpleados(File archivo){
        System.out.println("Quieres guardar?"
                + "\n\t1-Si"
                + "\n\t2-No");
        if(eligeopcion(1,2,">Elige una opcion: ")==1){
            if(true){
                plazas.add(0, plazaPlantSup);
                plazas.add(1, plazaPlantInf);
                plazas.add(2, plazareservada);
            }
            
            try{
                if(archivo.exists()){
                    FileOutputStream fos = new FileOutputStream(archivo,true);
                    MiObjectOutputStream moos = new MiObjectOutputStream(fos);

                    moos.writeObject(plazas);

                    fos.close();
                    moos.close();
                }else{
                    FileOutputStream fos = new FileOutputStream(archivo);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(plazas);

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
    
    public static void introducir(){
        int pos=0;
        int lista=eligeopcion(1,3,"- - - - LISTAS - - - -"
                + "\n\t1-Planta Superior"
                + "\n\t2-Planta Inferior"
                + "\n\t3-Plazas Reservadas"
                + "\n>Elige una opcion: ");
        sc.nextLine();
        System.out.print(">Introduce el texto: ");
        String texto=sc.nextLine();
        if(lista==1){
            pos=eligeopcion(1,plazaPlantSup.size()+1,">Elige la posicion en la que quieres escribir: ");
            plazaPlantSup.add(pos-1, texto);
        }
        else if(lista==2){
            pos=eligeopcion(1,plazaPlantInf.size()+1,">Elige la posicion en la que quieres escribir: ");
            plazaPlantInf.add(pos-1, texto);
        }
        else if(lista==3){
            pos=eligeopcion(1,plazareservada.size()+1,">Elige la posicion en la que quieres escribir: ");
            plazareservada.add(pos-1, texto);
        }
        System.out.println("Se introduce el texto "+texto);
    }

    public static void mostrar(){
        for(int a=0;a<plazaPlantSup.size();a++){
            System.out.println("Planta superior ("+(a+1)+"): "+plazaPlantSup.get(a));
        }
        
        for(int a=0;a<plazaPlantInf.size();a++){
            System.out.println("Planta inferior ("+(a+1)+"): "+plazaPlantInf.get(a));
        }
        
        for(int a=0;a<plazareservada.size();a++){
            System.out.println("Plaza reservada ("+(a+1)+"): "+plazareservada.get(a));
        }
    }

    public static void eliminar(){
               int pos=0;
        int lista=eligeopcion(1,3,"- - - - LISTAS - - - -"
                + "\n\t1-Planta Superior"
                + "\n\t2-Planta Inferior"
                + "\n\t3-Plazas Reservadas"
                + "\n>Elige una opcion: ");
        sc.nextLine();
        if(lista==1){
            pos=eligeopcion(1,plazaPlantSup.size()+1,">Elige la posicion en la que quieres eliminar: ");
            plazaPlantSup.remove(pos-1);
        }
        else if(lista==2){
            pos=eligeopcion(1,plazaPlantInf.size()+1,">Elige la posicion en la que quieres eliminar: ");
            plazaPlantInf.remove(pos-1);
        }
        else if(lista==3){
            pos=eligeopcion(1,plazareservada.size()+1,">Elige la posicion en la que quieres eliminar: ");
            plazareservada.remove(pos-1);
        }
    }
}
