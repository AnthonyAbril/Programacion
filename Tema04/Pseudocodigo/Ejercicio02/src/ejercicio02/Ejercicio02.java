/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio02;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;

        do {
            System.out.print("Introduzca primer numero: ");
            n1 = sc.nextInt();

            System.out.print("Introduzca segundo numero: ");
            n2 = sc.nextInt();
            
            System.out.println("");
        } while (n1 != n2);
    }

}
