
package gestion_de_parking;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Principal {

    //Acabas de inaugurar una consultoría informática y tu primer cliente es el dueño de un bajo
    //muy grande que quiere convertir en un parking, dada la dificultad para aparcar en la zona en
    //la que está situado. Ya ha obtenido todos los permisos necesarios y el último paso es el
    //programa informático que le gestione el negocio
    
    
    static Scanner sc = new Scanner(System.in);
    private static ArrayList <ArrayList <Plaza>> plazas = new ArrayList<>();
    private static File ficheroparking;
    private static final String RutaPorDefecto = "/home/alumnot/NetBeansProjects/Programacion/Tema12/fabrica_mondea_timbre_ficheros";
    private static String ruta;
    
    public static void main(String[] args) {
        
    //El número de plazas de alquiler del parking es 50, distribuidas en dos plantas: 30 en la
    //primera planta y 20 en la segunda. Cada vez que llega un coche al parking, se debe
    //comprobar si quedan plazas libres en la planta superior. Si no queda ninguna libre en la
    //planta superior, se comprueba la disponibilidad de la planta inferior. Se intentará, siempre
    //que sea posible, asignar la plaza más cercana a la salida, en la primera planta, o a la rampa
    //de subida, en la planta inferior.

    ArrayList <Plaza> plazaPlantSup = new ArrayList<>(); //20 plazas
    ArrayList <Plaza> plazaPlantInf = new ArrayList<>(); //20 plazas
    
    //Para los dueños de los negocios cercanos, se han reservado 10 plazas de aparcamiento en
    //la planta inferior, las más alejadas de la rampa de subida. Cada una de estas plazas estará
    //asignada a uno de esos dueños, y se deberán guardar sus datos de identificación: dni,
    //nombre, apellidos, dirección, teléfono y cuenta bancaria, así como su coche, del que se
    //guardarán los mismos datos que para las plazas de alquiler.
    
    ArrayList <Plaza> plazareservada = new ArrayList<>(); //10 plazas
    
    plazas.add(plazaPlantSup);
    plazas.add(plazaPlantInf);
    plazas.add(plazareservada);
    
        if(true){//rellenar arraylist con objeto parking
            for(int a=0;a<=20;a++)
                plazaPlantSup.add(new Plaza());
            
            for(int a=0;a<=20;a++)
                plazaPlantInf.add(new Plaza());
            
            for(int a=0;a<=10;a++)
                plazareservada.add(new Plaza());
        }

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
        
        ficheroparking = new File(ruta);
        ficheroparking.mkdirs();
        ficheroparking = new File(ruta+"/ficherodinero.ddr");
    }
    
    public static void CargarListaEmpleados(File archivo)throws ClassNotFoundException, EOFException{
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
            if(ficheroparking.exists()&&ficheroparking.length()>0){//si ya existe un fichero ahi y tiene contenido

                System.out.print("ya hay un fichero con contenido en la ruta indicada"
                        + "\n\t1-usar la informacion fichero"
                        + "\n\t2-crear un nuevo fichero");
                int opcion = eligeopcion(1,2,"\n>Elige una opcion: ");;

                if(opcion==1){//lee la informacion fichero
                    while(true){
                        plazas=(ArrayList <ArrayList <Plaza>>)ois.readObject();
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
    
    public static void Menu(){
        int op=0;
        do{
            try{
                
                System.out.println("-- Opciones --"
                    + "\n\t1-Salir"
                    + "\n\t2-Aparcar coche"
                    + "\n\t3-Sacar coche"
                    + "\n\t4-Buscar coche"
                    + "\n\t5-Plazas de alquiler libres"
                    + "\n\t6-Otras consultas posibles");
                op=eligeopcion(1,6,"\n>Elige opcion: ");

                switch (op) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        break;
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
                sc.nextLine();
            }
        }while(op!=1);
    }
}
