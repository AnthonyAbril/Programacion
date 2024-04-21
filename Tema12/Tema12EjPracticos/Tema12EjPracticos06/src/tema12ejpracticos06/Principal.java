
package tema12ejpracticos06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private static final ArrayList<Coche> Coches = new ArrayList<>();
    private static String ruta = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/listacoches.bin"; 
    
    public static void main(String[] args) {
        
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
            FileOutputStream fos = new FileOutputStream(r);
            DataOutputStream dos = new DataOutputStream(fos);
            
            if(Coches.size()>0){
                for(int b=0;b<Coches.size();b++){
                    dos.writeUTF(Coches.get(b).getMatricula());
                    dos.writeUTF(Coches.get(b).getMarca());
                    dos.writeUTF(Coches.get(b).getModelo());
                    dos.writeUTF(""+Coches.get(b).getTamañoDeDeposito());
                }
            }
            
            fos.close();
            dos.close();
            System.out.println("Lista guardada");
        }catch(IOException ex){
            System.out.println("Error al guardar lista");
        }
    }    
    
    public static void CargarLista(String r){
        try{
            FileInputStream fis = new FileInputStream(r);
            DataInputStream dis = new DataInputStream(fis);
            
                while(true){
                    String matricula = dis.readUTF();
                    String marca = dis.readUTF();
                    String modelo =  dis.readUTF();
                    double tamaño =  Double.parseDouble(dis.readUTF());

                    Coches.add(new Coche(matricula,marca,modelo,tamaño));
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
        
        Coches.add(new Coche(matricula,marca,modelo,tamaño));
    }
    
    public static void MostrarCoches(){
        System.out.println("");
        for(int a=0;a<Coches.size();a++){
            System.out.println(Coches.get(a).toString());
        }
        System.out.println("");
    }
}
