
package desdecero05;

import java.util.Scanner;

public class DesdeCero05 {

    public static void main(String[] args) {
        char A,B;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un caracter: ");
        A = sc.next().charAt(0);
        System.out.print("Introduzca otro caracter: ");
        B = sc.next().charAt(0);
        
        if((Character.isLowerCase(A))&&(Character.isLowerCase(B)))
        {
            System.out.println("Los dos caracteres son minusculas");
        }
        else
        {
            System.out.println("Los dos caracteres no son minusculas");
        }
    }
    
}
