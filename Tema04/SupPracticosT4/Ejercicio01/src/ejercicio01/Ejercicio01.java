/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio01;

import java.util.Scanner;

public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;

        System.out.print("Introduzca primer numero");
        n1 = sc.nextInt();

        System.out.print("Introduzca segundo numero");
        n2 = sc.nextInt();

        if (n1 > n2) {
            System.out.println("El mayor es " + n1);
        } else if (n2 > n1) {
            System.out.println("El mayor es " + n2);
        } else {
            System.out.println("Son iguales");
        }

    }

}
