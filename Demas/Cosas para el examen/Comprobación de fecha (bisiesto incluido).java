/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej08;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Ej08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int d1, d2, d3, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la fecha en formato xx xx xxxx");
        d1 = sc.nextInt();
        d2 = sc.nextInt();
        d3 = sc.nextInt();
        if (d2 > 0 && d2 <= 12) {
            if (d2 == 1 || (d2 == 3 || (d2 == 5 || (d2 == 7 || (d2 == 8 || (d2 == 10 || d2 == 12)))))) {
                if (d1 > 0 && d1 <= 31) {
                    System.out.println("La fecha es valida");
                } else {
                    System.out.println("La fecha no es valida");
                }
            } else if (d2 == 02) {
                if (Bisiesto(d3)) {
                    i = 29;
                } else {
                    i = 28;
                }
                if (d1 > 0 && d1 <= i) {
                    System.out.println("La fecha es valida");
                } else {
                    System.out.println("La fecha no es valida");
                }

            } else if (d2 == 4 || (d2 == 6 || (d2 == 9 || (d2 == 11)))) {
                if (d1 > 0 && d1 <= 31) {
                    System.out.println("La fecha es valida");
                } else {
                    System.out.println("La fecha no es valida");
                }
            }

        } else {
            System.out.println("Fecha no valida");
        }
    }

    private static boolean Bisiesto(int d3) {
        if (d3 % 4 == 0) {
            if (d3 % 4 == 0 && d3 % 100 != 0) {
                if (d3 % 100 == 0 && d3 % 400 != 0) {
                    if (d3 % 100 == 0 && d3 % 400 == 0) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
