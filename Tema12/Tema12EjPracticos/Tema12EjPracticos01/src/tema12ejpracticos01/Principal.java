package tema12ejpracticos01;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora crea una
//aplicación que lea este fichero de texto carácter a carácter y muestre su contenido por
//pantalla sin espacios. Por ejemplo, si un fichero tiene el siguiente texto “Esto es una
//prueba”, deberá mostrar “Estoesunaprueba”. Captura las excepciones que veas necesario.
//Ampliación: Haz que el programa almacene en el fichero de texto las frases que escriba el
//usuario por pantalla (hasta que introduzca “99”), sin descartar el contenido almacenado en
//ejecuciones anteriores, a no ser que el usuario decida lo contrario.
public class Principal {

    static Scanner sc = new Scanner(System.in);
    static String fichero1 = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/fichero1.txt";
    static String anterior = "";
    public static void main(String[] args) {
        Parte1();
        Parte2();
    }

    public static void Parte1() {
        try {
            FileInputStream fis = new FileInputStream(fichero1);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;
            System.out.println("Contenido del fichero:");
            while ((i = bis.read()) != -1) {
                char a = (char) i;
                if (!Character.toString(a).equals(" ")) {
                    anterior = anterior+a;
                }
            }
            System.out.println(anterior);
            bis.close();
            fis.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void Parte2() {
        int op = 0;
        do {
            System.out.print("\nOPCIONES\n\t1-Usar el contenido almacenado anteriormente\n\t2-Descartar el contenido almacenado anteriormente\n>Elige una opcion: ");
            op = sc.nextInt();
        } while (op < 1 || op > 2);

        if (op == 1) {
            try {
                System.out.println("Primera opcion");
                sc.nextLine();
                FileWriter fw = new FileWriter(fichero1);
                BufferedWriter bw = new BufferedWriter(fw);
                String a = "";
                do{
                    System.out.print(">Introduce el texto: ");
                    a = sc.nextLine();
                    if(!a.equals("99")){
                        anterior = anterior+a+" \r\n";
                        System.out.println(a);
                    }
                }while(!a.equals("99"));
                bw.write(anterior);
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else if (op == 2) {
            try {
                sc.nextLine();
                FileWriter fw = new FileWriter(fichero1);
                BufferedWriter bw = new BufferedWriter(fw);
                anterior = "";
                String a = "";
                do{
                    System.out.print(">Introduce el texto: ");
                    a = sc.nextLine();
                    if(!a.equals("99")){
                        anterior = anterior+a;
                        System.out.println(a);
                        bw.write(a+" \r\n");
                    }
                }while(!a.equals("99"));
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
}
