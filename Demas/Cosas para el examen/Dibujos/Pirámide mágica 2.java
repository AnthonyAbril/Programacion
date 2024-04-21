/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej05;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */

//ATENCIÓN: para encontrar un número se suman tres números: arriba, arriba a la izquierda y arriba a la derecha

    public static void main(String[] args) {
        int filas, i, j, k, h;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de filas");
        filas = sc.nextInt();
        for (i = 1; i <= filas; i++) {
            for (k = 1; k <= filas-i; k++) {
                System.out.print("  ");
            }
            for (j = 1; j <= 2*i-1; j++) {
                System.out.print(piramid(i, j)+" ");
                
            }
            System.out.println(" ");
        }
    }

    private static int piramid(int i, int j) {
        if (i <= 0) {
            return 0;
        } else if (j == 1 && i == 1) {
            return 1;
        } else {
            return piramid(i - 1, j) + piramid(i-1,j-2)+ piramid(i - 1, j - 1);
        }
    }
}
