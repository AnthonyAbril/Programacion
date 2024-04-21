
package tema8ejpropuesto02;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Crea un programa que pida una cadena de texto por teclado y luego muestre cada palabra
        //de la cadena en una línea distinta.
        
        Scanner sc = new Scanner(System.in);
        String m [];
        String s;
        
        System.out.print("Introduce el texto: ");
        s=sc.nextLine();
        
        m = s.split(" ");
        
        for(int b=0;b<m.length;b++){
            System.out.println(m[b]);
        }
    }
    
}
