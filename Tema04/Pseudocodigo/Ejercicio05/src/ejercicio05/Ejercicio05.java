
package ejercicio05;

import java.util.Scanner;


public class Ejercicio05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
            
        System.out.print("Introduzca primer numero: ");
        n = sc.nextInt();
        
        if(n==1){
            System.out.print("Lunes");
        }
        else if (n==2){
            System.out.print("Martes");
        }
        else if (n==3){
            System.out.print("Miercoles");
        }
        else if (n==4){
            System.out.print("Jueves");
        }
        else if (n==5){
            System.out.print("Viernes");
        }
        else {
        System.out.println("No valido");
        }
    }

}