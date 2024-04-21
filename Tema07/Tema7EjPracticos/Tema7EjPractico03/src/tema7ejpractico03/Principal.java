
package tema7ejpractico03;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int num=123;
        Scanner sc = new Scanner(System.in);
        
        Libros L1;
        Revistas R1;
        
        L1 = new Libros("A1B2C3","libro1","2004");
        R1 = new Revistas("D5E6F7","revista1","2003",num);
        System.out.println("El libro "+L1.getTitulo()+" se encuentra actualmente prestado: "+L1.prestado+"\n");
        
        System.out.println(L1.toString()+"\n");
        System.out.println(R1.toString()+"\n");
        
        L1.Prestar();
        
        System.out.println(L1.toString()+"\n");
        System.out.println(R1.toString()+"\n");
        System.out.println("El libro "+L1.getTitulo()+" se encuentra actualmente prestado: "+L1.prestado+"\n");
    }
    
}
