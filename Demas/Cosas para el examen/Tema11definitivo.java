
package tema11definitivo;

import java.util.Scanner;

public class Tema11definitivo {
	
	public static void main(String[] args) {
        double i,num1,num2;
        double rango;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número");
        num1 = sc.nextInt();
        System.out.println("Introduce otro número");
        num2 = sc.nextInt();
        System.out.println("");
        
        do{
            rango = (Math.random()*(num2-2) + num1);   // Esto da valores del num1 al num2 excluido el num2 y el num1
            System.out.println(rango);
        }while((rango<num2)&&(rango>num1));
    }
		
}
