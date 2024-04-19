
package tema12ejpracticos02;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
        //Crea una aplicación donde pidamos la ruta de un fichero por teclado y un texto que
        //queramos escribir en el fichero. Deberás mostrar por pantalla el mismo texto pero variando
        //entre mayúsculas y minúsculas, es decir, si escribo “Bienvenido” deberá devolver
        //“bIENVENIDO”. Si se escribe cualquier otro carácter, se quedará tal y como se escribió.
    
        //Deberás crear un método para escribir en el fichero el texto introducido y otro para mostrar
        //el contenido en mayúsculas.
    static Scanner sc = new Scanner(System.in);
    static String ruta = "";
    public static void main(String[] args) {
        PedirRuta();
        EscribirFichero();
        MostrarFichero();
    }
    
    public static void PedirRuta(){
        Boolean pedir = false;
        
        if(pedir){
            System.out.print(">Introduce la ruta del fichero: ");
            ruta = sc.nextLine();
        }else{
            //ruta="/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/fichero1.txt";
            ruta="C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\Tema12EjPracticos\\ficheros\\fichero1.txt";
        }
    }
    
    public static void EscribirFichero(){
        try{
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            String actual="";
            String anterior="";
            do{
                System.out.print(">Introduce el texto (99 para terminar):");
                actual=sc.nextLine();
                if(!actual.equals("99")){
                    anterior=anterior+actual+"\r\n";
                }
            }while(!actual.equals("99"));
            
            //System.out.println(anterior);
            bw.write(anterior);
            bw.close();
            fw.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
    public static void MostrarFichero(){
        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            //System.out.println(br.readLine());
            System.out.println("\n------- Contenido del documento --------");
            int i;
            while((i=br.read())!= -1)
                System.out.print(CambiarMayus(i));
            System.out.println("\n----------------------------------------");
            fr.close();
            br.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
    public static char CambiarMayus(int i){
        char c = ((char)i);
        
        if(Character.isUpperCase(c)){//si es mayuscula
            c=(Character.toLowerCase(c));//hacer minuscula
        }else{
            c=(Character.toUpperCase(c));//hacer mayuscula
        }
        return c;
    }
    
}
