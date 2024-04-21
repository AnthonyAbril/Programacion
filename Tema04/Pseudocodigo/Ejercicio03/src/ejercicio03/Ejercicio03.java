/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n, sum = 0;
        Scanner sc = new Scanner(System.in);    
        
            int i;  
        for (i=1; i<=10; i++){
            System.out.println("Introduzca numero " + i + ": " );
            n = sc.nextInt();
            
            sum = sum + n;
        }
        
        System.out.println("\nSumatorio: " + sum);
            
    }
    
}
