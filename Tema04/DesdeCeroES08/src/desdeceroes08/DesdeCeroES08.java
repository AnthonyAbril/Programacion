
package desdeceroes08;

import java.util.Scanner;

public class DesdeCeroES08 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float r;
        System.out.print("Introduzca el radio: ");
        r = sc.nextFloat();
        System.out.println("El volume es " + ((4*Math.PI*(Math.pow(r, 3))))/3);
    }
    
}
