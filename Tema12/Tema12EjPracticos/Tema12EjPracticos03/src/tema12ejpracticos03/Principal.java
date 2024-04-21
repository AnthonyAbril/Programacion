/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema12ejpracticos03;

import java.io.*;
import java.util.Scanner;

public class Principal {

    //Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (sólo
    //la ruta, sin fichero al final). Debes copiar el contenido de los dos ficheros en uno, éste tendrá
    //el nombre de los dos ficheros separados por un guión bajo, y se guardará en la ruta donde
    //le hayamos indicado por teclado.
    
    //Para unir los ficheros en uno, crea un método donde le pases como parámetro todas las
    //rutas. En este método, aparte de copiar debe comprobar que si existe el fichero de destino,
    //nos muestre un mensaje informándonos de si queremos sobrescribir el fichero. Te
    //recomiendo usar la clase File.
    
    //Por ejemplo, si tengo un fichero A.txt con “ABC” como contenido, un fichero B.txt con
    //“DEF”, y una ruta de destino D:\, el resultado será un fichero llamado A_B.txt en la ruta D:\
    //con el contenido “ABCDEF”.
    
    //Puedes crear submétodos para realizar la copia de ficheros, piensa también cómo podrías
    //optimizar esta copia, si los ficheros tuvieran mucho contenido.
    //Recuerda que debes controlar las excepciones que puedan aparecer. En caso de error,
    //mostrar la información del error
    
    static String ruta1,ruta2,destino;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        PedirRuta();
        System.out.println(destino);
        EscribirFichero(destino,LeerFichero(ruta1),LeerFichero(ruta2));
    }
    
    public static String ObtenerNombre(String ruta){
        File fichero = new File(ruta);
               
        String a = fichero.getName();
        //return a.replaceAll(".txt", "");
        return a.substring(0, a.lastIndexOf("."));

    }
    
    public static void EscribirFichero(String ruta, String texto1, String texto2){
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(texto1+texto2);
            bw.write(texto1+texto2);
            bw.close();
            fw.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    
    public static void PedirRuta() {
        Boolean pedir = true;

        if (pedir) {
            System.out.print(">Introduce la ruta del fichero A: ");
            ruta1 = sc.nextLine();
            System.out.print(">Introduce la ruta del fichero B: ");
            ruta2 = sc.nextLine();
            System.out.print(">Introduce la ruta de destino: ");
            destino = sc.nextLine()+ObtenerNombre(ruta1)+"_"+ObtenerNombre(ruta2)+".txt";
        } else {
            ruta1 = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/A.txt";
            ruta2 = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/B.txt";
            destino = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/"+ObtenerNombre(ruta1)+"_"+ObtenerNombre(ruta2)+".txt";
            //ruta="C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\Tema12EjPracticos\\ficheros\\fichero1.txt";
        }
    }
    
     public static String LeerFichero(String ruta){
        String texto="";
        try{
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            int i;
            while((i=br.read())!= -1){
                texto += (""+(char)i);
            }
            fr.close();
            br.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
        return texto.substring(0, texto.length()-1);
    }
}
