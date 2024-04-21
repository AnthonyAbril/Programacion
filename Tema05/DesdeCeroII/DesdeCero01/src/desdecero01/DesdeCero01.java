
package desdecero01;

import java.util.Scanner;

public class DesdeCero01 {

    public static void main(String[] args) {
        int numero;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un numero: ");
        numero = sc.nextInt();
        
        if(numero%2==0)
        {
            System.out.println("Es par");
        }
        else
        {
            System.out.println("Es impar");
        }
    }
    
}
