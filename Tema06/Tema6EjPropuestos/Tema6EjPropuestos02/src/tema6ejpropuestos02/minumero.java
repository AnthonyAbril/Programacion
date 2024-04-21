
package tema6ejpropuestos02;

/**
 *
 * @author abril
 */
import java.util.Scanner;

public class minumero {
    int num;
    
    public minumero(int a){
        num=a;
    }
    
    public int doble(){
        return num*2;
    }
    
    public int triple(){
        return num*3;
    }
    
    public int cuadruple(){
        return num*4;
    }
    
    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        minumero n;
        
        System.out.print("Introduce un numero: ");
        numero = sc.nextInt();
        n = new minumero(numero);
        
        System.out.println(n.doble());
        System.out.println(n.triple());
        System.out.println(n.cuadruple());
    }
    
}
