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
        System.out.println("Introduce un número dentre el 1 y el 12");
        int mes = sc.nextInt();
        switch(mes) {
            case 1:
                System.out.println("El número " + mes + " corresponde a Enero");
                break;
            case 2:
                System.out.println("El número " + mes + " corresponde a Febrero");
                break;
            case 3:
                System.out.println("El número " + mes + " corresponde a Marzo");
                break;
            case 4:
                System.out.println("El número " + mes + " corresponde a Abril");
                break;
            case 5:
                System.out.println("El número " + mes + " corresponde a Mayo");
                break;
            case 6:
                System.out.println("El número " + mes + " corresponde a Junio");
                break;
            case 7:
                System.out.println("El número " + mes + " corresponde a Julio");
                break;
            case 8:
                System.out.println("El número " + mes + " corresponde a Agosto");
                break;
            case 9:
                System.out.println("El número " + mes + " corresponde a Septiembre");
                break;
            case 10:
                System.out.println("El número " + mes + " corresponde a Octubre");
                break;
            case 11:
                System.out.println("El número " + mes + " corresponde a Noviembre");
                break;
            case 12:
                System.out.println("El número " + mes + " corresponde a Diciembre");
                break;
        }
    }
    
}
