
package desdecero02;

import java.util.Scanner;

public class DesdeCero02 {

    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        numero = sc.nextInt();
        
        if(numero%10==0 && numero!=0)
        {
            System.out.println("Es multiplo de 10");
        }
        else
        {
            System.out.println("No es multiplo de 10");
        }
    }
    
}
