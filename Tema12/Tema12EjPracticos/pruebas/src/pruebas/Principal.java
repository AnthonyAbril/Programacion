
package pruebas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    //Crea una aplicación que pida por teclado una cantidad de números aleatorios enteros
    //positivos y la ruta de un fichero. Este fichero contendrá el conjunto de números aleatorios
    //enteros positivos generados, tantos como la cantidad solicitada por teclado.
    //Escribe los números usando un DataOutputStream y muestra por pantalla estos números
    //leyéndolos con un DataInputStream.
    
    //El rango de los números aleatorios estará entre 0 y 100, incluyendo el 100.
    //Cada vez que ejecutemos la aplicación añadiremos números al fichero sin borrar los
    //anteriores, es decir, si cuando creo el fichero añado 10 números y después añado otros 10
    //al mismo, en el fichero habrá 20 números que serán mostrados por pantalla.
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print(">Introduce una cantidad de números aleatorios enteros positivos: ");
        int cantidadnum = sc.nextInt();
        sc.nextLine();
        System.out.print(">Introduce la ruta del fichero: ");
        //String ruta=sc.nextLine();
        //String ruta = "C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\Tema12EjPracticos\\ficheros\\fichero5.bin";
        String ruta = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/fichero5.bin";
        escribirfichero(ruta, cantidadnum);
        leerfichero(ruta);
    }
    
    public static void escribirfichero(String r, int cantidad){
        try{
            FileOutputStream fos = new FileOutputStream(r,true);
            DataOutputStream dos = new DataOutputStream(fos);
                
            for (int i=0;i<cantidad;i++){
                int numero=(int)(Math.random()*101 + 0);
                dos.writeInt(numero);
            }
            
            dos.flush();
            fos.close();
            dos.close();
            
        }catch(IOException ex){
            System.out.println(">Error al escribir en el fichero");
        }
    }
    
    public static void leerfichero(String r){
        try{
            FileInputStream fis = new FileInputStream(r);
            DataInputStream dis = new DataInputStream(fis);
            
            int tamaño=dis.available()/4;
            System.out.println("\n------- Contenido del documento --------");
            for(int a=0;a<tamaño;a++){
                int entero = dis.readInt();
                System.out.print("| "+entero+" |");
            }
            
            System.out.println("\n----------------------------------------");
            
        }catch(IOException ex){
            System.out.println(">Error al leer el contenido del fichero");
        }
        
    }
}
