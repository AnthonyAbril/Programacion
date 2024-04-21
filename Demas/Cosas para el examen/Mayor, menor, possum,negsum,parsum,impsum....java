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
    int num,mayor=0,menor=0,pos=0,cantpos=0,neg=0,cantneg=0,par=0,cantpar=0,impar=0,cantimpar=0,i=0;
    double media,sum=0,j=0;
    String res;
        
        do {//Guardar número en una variable
            System.out.println("Introduce un número");
            num = sc.nextInt();
            //Iniciar mayor y menor con el mismo valor de num
            if (i==0) {mayor=num; menor=num;i=1;}//Esto último para hacerlo solo la primera vez
            //Comprobar si el número es el mayor
            if (num > mayor){mayor = num;}
            //Comprobar si el número es el menor
            if (num < menor){menor = num;}
            //Comprobar si es positivo y sumarlo, y si no, hacer lo mismo en negativo
            if (num >= 0){pos = pos+num; cantpos++;} else {neg = neg+num; cantneg++;}
            //Comprobar si es par y sumarlo, y si no, hacer lo mismo en impar
            if (num%2  == 0){par = par+num; cantpar++;} else {impar = impar+num; cantimpar++;}
            //La suma de todos los números para hacer posteriormente la media
            sum = sum+num;
            //A partir de aqui proceso para determinar si poner mas números o no
            System.out.println("¿Quieres continuar introduciendo números?(S/N)");
            res = sc.next();
            if (res.equalsIgnoreCase("N")) {i = 2;}
            j++;
        }
        while (i<=1);//1 para que se pueda almacenar en mayor y menor la primera vez que se ejecuta
            media = sum/j;
            System.out.println("El número mayor es "+mayor);
            System.out.println("\nEl número menor es "+menor);
            System.out.println("\nLa suma de todos los números es "+sum);
            System.out.println("\nLa suma de todos los números positivos es "+pos);
            System.out.println("\nHay un total de "+cantpos+" números positivos");
            System.out.println("\nLa suma de todos los números negativos es "+neg);
            System.out.println("\nHay un total de "+cantneg+" números negativos");
            System.out.println("\nLa suma de todos los números pares es "+par);
            System.out.println("\nHay un total de "+cantpar+" números paress");
            System.out.println("\nLa suma de todos los números impares es "+impar);
            System.out.println("\nHay un total de "+cantimpar+" números impares");
            System.out.println("\nLa media de todos los números es "+media);
            
        
        
        
    }
    
}
