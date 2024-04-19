/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej03;

import java.util.Scanner;

public class Ej03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean numeroCorrecto = false;
        int row; 
        do {
            System.out.print("Introduce un número natural e impar: ");
            row = sc.nextInt();
            if(row>0 && row%2!=0){
                numeroCorrecto = true;
            }
        } while (!numeroCorrecto);
         
        int numrow = row/2 + 1;
                 
        for(int alto=1;alto<=numrow;alto++){
            for(int espacio=1;espacio<=numrow-alto;espacio++){
                System.out.print(" ");
            }
            for(int asterisco=1;asterisco<=(2*alto)-1;asterisco++){
                System.out.print("*");
            }
            System.out.println("");         
        }
         

	//Parte del triángulo invertido
        numrow--;
         
        for(int alto=1;alto<=numrow;alto++){
            for(int espacio=1;espacio<=alto;espacio++){
                System.out.print(" ");
            }
            for(int asterisco=1;asterisco<=(numrow-alto)*2 +1;asterisco++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}