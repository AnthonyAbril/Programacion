/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej01;
import java.util.Scanner;
/**
 *
 * @author alumnot
 */
public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num,res=1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número para calcular su factorial");
        num = sc.nextInt();
        System.out.println("El factorial de "+num+" es "+factorialiterativo(num));
        System.out.println("El factorial de "+num+" es "+factorialrecursivo(num,res));
    }
    private static int factorialiterativo(int num){
    int res=1,i;
    for (i=num;i>0;i--){
    res = res*i;
    }
        return res;
    }
    private static int factorialrecursivo(int num,int res){
        if (num>0) {
            res = res*num;
            num--;
            return (factorialrecursivo(num,res));
        } else {return res;}
    }
    
}
