
package tema12ejpracticos07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

        //Crea una aplicación que almacene los datos básicos de un vehículo como la
        //matricula(String), marca (String), modelo (String) y tamaño de depósito (double), en ese
        //orden, y que los lea de uno en uno usando la clase DataInputStream.
        
        //Los datos anteriores se pedirán por teclado y se irán añadiendo al fichero (no se
        //sobrescriben los datos) cada vez que ejecutemos la aplicación.
        
        //El fichero siempre será el mismo, en todos los casos.
        
        //Muestra todos los datos de cada coche en una línea distinta, es decir, si tenemos 3
        //vehículos mostrará 3 líneas con sus respectivos datos. Un ejemplo de salida de información
        //puede ser este:
        
        //El vehículo tiene una matrícula 5599BVC, su marca es Seat, su modelo es Ibiza y el tamaño
        //del depósito es de 50.0 litros.
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Vehiculo> Coches = new ArrayList<>();
    private static String ruta = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/coches.ddr"; 
    private static File fichero =  new File(ruta);
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        CargarLista(ruta);
        
        int op = 0;
        do{
            System.out.print("ELIGE UNA OPCION\n\t1-registrar coche\n\t2-mostrar coches\n\t3-salir\n>Introduce una opcion: ");
            op = sc.nextInt();
            sc.nextLine();
            if(op==1){
                RegistrarCoche();
            }else if(op==2){
                MostrarCoches();
            }
        }while(op!=3);
        GuardarLista(ruta);
    }
    
    public static void GuardarLista(String r){
        try{
            //Si el fichero existe, usamos nuestra clase de Object y si no usamos la original
            if(fichero.exists()){
                MiObjectOutputStream moos=new MiObjectOutputStream(new FileOutputStream(r, true));
                moos.writeObject(Coches);
                moos.close();
            }else{
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(r));
                oos.writeObject(Coches);
                oos.close();
            }
            
            System.out.println("Lista guardada");
        }catch(EOFException e){
            System.out.println("Fin");
        }catch(IOException e){
            System.out.println("Error abriendo los ficheros");
        }
    }    
    
    public static void CargarLista(String r)  throws ClassNotFoundException, EOFException {
        try{
            FileInputStream fis = new FileInputStream(r);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
                while(true){
                    Coches = (ArrayList<Vehiculo>) ois.readObject();
                }
            
        }catch(IOException ex){
            System.out.println("Lista cargada");
        }
    }
    
    public static void RegistrarCoche(){
        System.out.print(">Introduce la matricula: ");
        String matricula = sc.nextLine();
        System.out.print(">Introduce la marca: ");
        String marca = sc.nextLine();
        System.out.print(">Introduce el modelo: ");
        String modelo = sc.nextLine();
        System.out.print(">Introduce el tamaño del depósito: ");
        double tamaño = sc.nextDouble();
        
        Coches.add(new Vehiculo(matricula,marca,modelo,tamaño));
    }
    
    public static void MostrarCoches(){
        System.out.println("");
        for(int a=0;a<Coches.size();a++){
            System.out.println(Coches.get(a).toString());
        }
        System.out.println("");
    }
}
