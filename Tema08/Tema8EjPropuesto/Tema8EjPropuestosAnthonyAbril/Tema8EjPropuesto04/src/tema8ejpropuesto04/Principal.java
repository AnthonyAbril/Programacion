
package tema8ejpropuesto04;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos.
        //Luego mostrará un código de usuario (en mayúsculas) formado por la concatenación de las
        //tres primeras letras de cada uno de ellos. Por ejemplo si se introduce “Lionel”, “Tarazón” y
        //“Alcocer” mostrará “LIOTARALC”.
        
        Scanner sc = new Scanner(System.in);
        String s1,s2,s3;
        System.out.print("Introduce el nombre: ");
        s1=sc.nextLine();
        System.out.print("Introduce el primer apellido: ");
        s2=sc.nextLine();
        System.out.print("Introduce el segundo apellido: ");
        s3=sc.nextLine();
        
        System.out.println("Tu codigo es " + (s1.substring(0, 3) + s2.substring(0, 3) + s3.substring(0, 3)).toUpperCase());
    }
    
}
