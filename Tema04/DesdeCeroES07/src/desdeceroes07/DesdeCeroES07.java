
package desdeceroes07;

import java.util.Scanner;

public class DesdeCeroES07 {
    
    public static void main(String[] args) {
        float cateto1,cateto2;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la longitud del primer cateto: ");
        cateto1 = sc.nextFloat();
        System.out.print("Introduce la longitud del segundo cateto: ");
        cateto2 = sc.nextFloat();
        System.out.println("La hipotenusa es: " + Math.sqrt((((Math.pow(cateto1, 2)))+(Math.pow(cateto2, 2)))));
    }
}
