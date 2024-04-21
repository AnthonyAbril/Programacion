
package desdeceroes05;

import java.util.Scanner;

public class DesdeCeroES05 {

    public static void main(String[] args) {
        float radio;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca un numero: ");
        radio = sc.nextFloat();
        System.out.println("Longitud de la circunferencia: " + (2*Math.PI*radio));
        System.out.println("Area de la circunferencia: " +  Math.PI*Math.pow(radio,2));
    }
    
}
