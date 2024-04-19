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
    public static void main(String[] args) {
        int i,num1,num2,rango;
    Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        num1 = sc.nextInt();
        System.out.println("Introduce otro número");
        num2 = sc.nextInt();
        System.out.println("");
        
        for (i = 1; i < 11 ; i++){
            rango = (int)(Math.random()* (num2 - num1+1) + num1);
            System.out.println(+rango);

        }
    }
    
}
