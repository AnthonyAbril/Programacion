/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej06;

import java.util.Scanner;

public class Ej06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número decimal: ");
        int numeroDecimal = scanner.nextInt();

        System.out.print("Ingresa la base a la que deseas convertir (2, 8 o 16): ");
        int base = scanner.nextInt();

        if (base != 2 && base != 8 && base != 16) {
            System.out.println("Base no válida. Debe ser 2, 8 o 16.");
        } else {
            String numeroBase = transformabase(numeroDecimal, base);
            System.out.println("El número en base " + base + " es: " + numeroBase);
        }

    }

    public static String transformabase(int numeroDecimal, int base) {
        if (numeroDecimal == 0) {
            return "";
        } else {
            int residuo = numeroDecimal % base;
            return transformabase(numeroDecimal / base, base) + obtenerCaracterBase(residuo);
        }
    }

    public static char obtenerCaracterBase(int residuo) {
        if (residuo < 10) {
            return (char) ('0' + residuo);
        } else {
            return (char) ('A' + (residuo - 10));
        }
    }
}