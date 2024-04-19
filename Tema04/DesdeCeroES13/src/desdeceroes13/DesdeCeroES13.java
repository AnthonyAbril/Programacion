
package desdeceroes13;

import java.util.Scanner;

public class DesdeCeroES13 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia,mes,año;
        
        System.out.print("Introduce tu dia de nacimiento: ");
        dia = sc.nextInt();
        System.out.print("Introduce tu mes de nacimiento: ");
        mes = sc.nextInt();
        System.out.print("Introduce tu año de nacimiento: ");
        año = sc.nextInt();
        System.out.println("Tu numero de la suerte es " + (((((((dia/10)%10) + (dia%10)) + (((mes/10)%10) + (mes%10)) + (((año/10)%10) + (año%10) + ((año/100)%10) + ((año/1000)%10)))/10)%10) + (((((dia/10)%10) + (dia%10)) + (((mes/10)%10) + (mes%10)) + (((año/10)%10) + (año%10) + ((año/100)%10) + ((año/1000)%10)))%10)));
    }
}
