
package desdeceroes04;

import java.util.Scanner;

public class DesdeCeroES04 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float C;
        
        System.out.print("Introduzca una cantidad de grados centígrados: ");
        C = sc.nextInt();
        System.out.println("En grados Fahrenheit es: " + (32 + ( 9 * C / 5)));
    }
    
}
