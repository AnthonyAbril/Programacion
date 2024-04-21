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
        int i;
        String pssw, pssw2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nueva contraseña");
        pssw = sc.next();
        for (i = 0; i <= 2; i++) {
            System.out.println("Escribe tu contraseña de nuevo");
            pssw2 = sc.next();
            if (pssw2.equals(pssw)) {
                System.out.println("Las contraseñas coinciden, enhorabuena");
                i = 4;
            } else {
                System.out.println("La contraseña introducida no es correcta");
            }
        }
        if (i == 3){System.out.println("Demasiados intentos fallidos, inténtelo de nuevo más tarde");}
    }

}
