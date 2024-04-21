/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej04;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ej04 {

    /**
     * @param args the command line arguments
     */

//ATENCIÓN: para encontrar un número se suman los dos que tiene encima

    public static void main(String[] args) {
        int filas, i, j, k;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de filas");
        filas = sc.nextInt();
        for (i = 1; i <= filas; i++) {
            for (k = 1; k <= filas-i; k++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print(piramid(i, j)+" ");
            }
            System.out.println(" ");
        }
    }

    private static int piramid(int i, int j) {
        if (j == 1) {
            return 1;
        } else if (i == 1) {
            return 0;
        } else {
            return piramid(i - 1, j) + piramid(i - 1, j - 1);
        }
    }
}
