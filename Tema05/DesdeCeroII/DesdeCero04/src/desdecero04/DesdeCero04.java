
package desdecero04;

import java.util.Scanner;

public class DesdeCero04 {

    public static void main(String[] args) {
        char A,B;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un caracter: ");
        A = sc.next().charAt(0);
        System.out.print("Introduzca otro caracter: ");       
        B = sc.next().charAt(0);
        if(A==B)
        {
            System.out.println("Son iguales");
        }
        else
        {
            System.out.println("No son iguales");
        }
    }
    
}
