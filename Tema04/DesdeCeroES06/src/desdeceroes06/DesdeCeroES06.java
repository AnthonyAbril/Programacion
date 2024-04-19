
package desdeceroes06;

import java.util.Scanner;

public class DesdeCeroES06 {
    
    public static void main(String[] args) {
        float n;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca una velocidad en kilometros por hora: ");
        n = sc.nextFloat();
        System.out.println("En metros por segundos es: " + (n*1000)/3600);
    }
    
}
