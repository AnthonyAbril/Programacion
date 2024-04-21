
package desdeceroes09;

import java.util.Scanner;

public class DesdeCeroES09 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float A,B,C,s;
        
        System.out.print("Introduce la longitud del primer lado: ");
        A = sc.nextFloat();
        System.out.print("Introduce la longitud del segundo lado: ");
        B = sc.nextFloat();
        System.out.print("Introduce la longitud del tercer lado: ");
        C = sc.nextFloat();
        s = ((A+B+C)/2);
        System.out.println("El area del triangulo es " + Math.sqrt(s*(s-A)*(s-B)*(s-C)));
    }
    
}
