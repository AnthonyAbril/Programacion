/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej02;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, i;
        System.out.println("Introduce cuantos números de la serie de Fibonacci quieres");
        num = sc.nextInt();
        fibonacciiterativo(num);
        System.out.println("\n");
        for (i = 0; i < num; i++) {
           System.out.print(fibonaccirecursivo(i));
        }
    }

    private static int fibonacciiterativo(int num) {
        int res = 0, i, num1 = 0, num2 = 1;
        System.out.print("0 ");
        System.out.print("1 ");
        for (i = 0; i < num - 2; i++) {
            res = num1 + num2;
            num1 = num2;
            num2 = res;
            System.out.print(res + " ");
        }
        return res;
    }

    private static int fibonaccirecursivo(int num) {
        if (num == 1 || num == 0) {
       return num;
        } else {
            return fibonaccirecursivo(num - 1) + fibonaccirecursivo(num - 2);
        }
    }
}
