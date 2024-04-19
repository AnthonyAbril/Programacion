
package tema8ejpropuesto05;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas ‘a’,
        //cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
        //mayúsculas y minúsculas.
        //  Por ejemplo dada la frase “Mi mama me mima” dirá que hay:
        //  No de A's: 3
        //  No de E's: 1
        //  No de I's: 2
        //  No de O's: 0
        //  No de U's: 0
        
        Scanner sc = new Scanner(System.in);
        String s1;
        System.out.print("Introduce una frase: ");
        s1=(sc.nextLine()).toUpperCase();
        String[] m = s1.split(""); 
        String[] abc = {"A","E","I","O","U"};
        
        for(int c=0;c<5;c++){//cuenta las letras
            int contador=0;
            for(int a=0;a<m.length;a++){
                if(abc[c].compareToIgnoreCase(m[a])==0)
                    contador++;
            }
            System.out.println("No de " + abc[c] + "'s: "+contador);
        }
    }
    
}
