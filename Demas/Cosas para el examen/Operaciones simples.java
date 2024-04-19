/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej07;
import java.util.Scanner;
/**
 *
 * @author alumnot
 */
public class Ej07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1,n2;
    String op;
        System.out.println("Introduce un número");
        n1=sc.nextInt();
        System.out.println("Introduce otro número");
        n2=sc.nextInt();
        System.out.println("Introduce la operación (+,-,*,/,^,%)");
        op=sc.next();
        if (op.equals("+")){System.out.println("La suma de "+n1+" y "+n2+" es "+(n1+n2));}
        if (op.equals("-")){System.out.println("La resta de "+n1+" y "+n2+" es "+(n1-n2));}
        if (op.equals("*")){System.out.println("La multiplicación de "+n1+" y "+n2+" es "+(n1*n2));}
        if (op.equals("/")){System.out.println("La división de "+n1+" y "+n2+" es "+(n1/n2));}
        if (op.equals("%")){System.out.println("El resto de dividir "+n1+" y "+n2+" es "+(n1%n2));}
        if (op.equals("^")){System.out.println("La potencia de "+n1+" a "+n2+" es "+((int)Math.pow(n1,n2)));}
    }
    
}
