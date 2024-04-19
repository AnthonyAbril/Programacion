
package desdecero03;

import java.util.Scanner;

public class DesdeCero03 {

    public static void main(String[] args) {
        char caracter;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un caracter: ");
        caracter = sc.next().charAt(0);
        if(Character.isUpperCase(caracter))
        {         
          System.out.println("Mayuscula");             
        }
        else
        {                  
          System.out.println("Minuscula");  
        }
    }
    
}
