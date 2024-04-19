
package tema8ejpropuesto03;

import java.util.Scanner;

public class Tema8EjPropuesto03 {

    public static void main(String[] args) {
        //Crea un programa que pida dos cadenas de texto por teclado y luego indique si son iguales,
        //además de si son iguales sin diferenciar entre mayúsculas y minúsculas.
        
        Scanner sc = new Scanner(System.in);
        String s1,s2;
        
        System.out.print("Introduce el texto1: ");
        s1=sc.nextLine();
        System.out.print("Introduce el texto2: ");
        s2=sc.nextLine();
        
        System.out.print("Tomando en cuenta las mayusculas, ambos textos ");
        System.out.println((s1.compareTo(s2)==0) ? "son iguales" : "no son iguales");
        
        System.out.print("Sin tomar en cuenta las mayusculas, ambos textos ");
        System.out.println((s1.compareToIgnoreCase(s2)==0) ? "son iguales" : "no son iguales");
    }
    
}
