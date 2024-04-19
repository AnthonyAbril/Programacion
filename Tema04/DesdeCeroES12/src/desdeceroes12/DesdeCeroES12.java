/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desdeceroes12;

import java.util.Scanner;

public class DesdeCeroES12 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N;

        System.out.print("Introduzca valor de N: ");
        N = sc.nextInt();
        
        System.out.println("Primera cifra de " + N + " -> " + (N%10));
        System.out.println("Segunda cifra de " + N + " -> " + (N/10)%10);
        System.out.println("Tercera cifra de " + N + " -> " + (N/100)%10);
        System.out.println("Cuarta cifra de " + N + " -> " + (N/1000)%10);
        System.out.println("Ultima cifra de " + N + " -> " + (N/10000)%10);
    }
    
}
