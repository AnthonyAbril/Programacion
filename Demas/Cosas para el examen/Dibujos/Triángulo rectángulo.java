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
        int i, j;
        System.out.println("Introduce el número de columnas");
        int col = sc.nextInt();
        for (i = 1; i <= col; i++) {
            for (j = 1; j <= 1 * (i - 1) + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
