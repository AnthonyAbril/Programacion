
package desdeceroes11;

import java.util.Scanner;

public class DesdeCeroES11 {
    public static void main(String[] args) {
        
        

        Scanner sc = new Scanner(System.in);
        int N;

        System.out.print("Introduzca valor de N: ");
        N = sc.nextInt();
        
        System.out.println("Primera cifra de " + N + " -> " + (N/10000)%10);
        System.out.println("Segunda cifra de " + N + " -> " + (N/1000)%10);
        System.out.println("Tercera cifra de " + N + " -> " + (N/100)%10);
        System.out.println("Cuarta cifra de " + N + " -> " + (N/10)%10);
        System.out.println("Última cifra de " + N + " -> " + (N%10));
    }
    
}
