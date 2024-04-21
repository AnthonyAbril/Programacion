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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, num2 = 0;
        System.out.println("Introduce tu dia de nacimiento");
        int dia = sc.nextInt();
        System.out.println("Introduce tu mes de nacimiento");
        int mes = sc.nextInt();
        System.out.println("Introduce tu año de nacimiento");
        int año = sc.nextInt();
        System.out.println("Tu fecha de nacimiento es " + dia + "/" + mes + "/" + año);
        num = dia + mes + año;

        while (num > 0) {

            num2 += num % 10;

            num = num / 10;

        }
        System.out.println("Tu numero de la suerte segun tu fecha de nacimiento es " + num2);
    }

}
