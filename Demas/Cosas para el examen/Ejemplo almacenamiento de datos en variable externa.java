/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej04;

/**
 *
 * @author alumnot
 */
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int A = 1;
    int B = 2;
    int C = 3;
    int D = 4;
    int aux = 0;
    
        System.out.println("A=" + A + " B=" + B + " C=" + C + " D=" + D);
        aux=B;
        B=C;
        C=A;
        A=D;
        D=aux;
        System.out.println("Los nuevos valores son:");
        System.out.println("A=" + A + " B=" + B + " C=" + C + " D=" + D);
    }
    
}
