/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej03;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ej03 {

    /**
     * @param args the command line arguments
     */


//ATENCIÓN: para encontrar un número, se suman el que tiene justo encima y justo a la izquierda


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lado;
        System.out.println("Introduce cuantos números de lado quieres");
        lado = sc.nextInt();
        for (int i = 1; i <= lado; i++) {
            for (int j = 1; j <= lado; j++) {
                System.out.print(cuadrado(i, j) + "\t");
            }
            System.out.println(" ");
        }
    }

    private static int cuadrado(int i, int j) {
        if (i == 1 || j == 1) {
            return 1;
        } else 
            return cuadrado(i - 1, j) + cuadrado(i, j - 1);
        
    }
}
