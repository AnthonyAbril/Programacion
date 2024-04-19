/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej05;

/**
 *
 * @author alumnot
 */
public class Ej05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int i, n;

        for (i = 1; i <= 10; i++) {
            System.out.println(" ");
            System.out.println("Tabla de multiplicar del " + i);
            System.out.println("***************************");
            for (n = 0; n <= 10; n++) {
                System.out.println(i + " * " + n + " = " + n * i);

            }
        }
    }
    
}
