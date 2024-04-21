
package tema8ejpropuesto06;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo o
        //no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas). Supondremos que
        //el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni acentos, etc.). Un
        //palíndromo es un texto que se lee igual de izquierda a derecha que de derecha a izquierda.
        //  Por ejemplo: Amigo no gima
        //               Dábale arroz a la zorra el abad
        //               Amo la pacífica paloma
        //               A man a plan a canal Panama
        
        //ELIMINAR ESPACIOS
        Scanner sc = new Scanner(System.in);
        String s1;
        System.out.print("Introduce una frase: ");
        s1=(sc.nextLine()).toUpperCase();
        String[] m = s1.split(""); 
        String[] m2 = new String[m.length];
        
        if(comprobador(m,m2)){
            System.out.println("La frase ("+s1+") es un palíndromo");
        }
        else{
            System.out.println("La frase ("+s1+") no es un palíndromo");
        }
        
        
        //darvalor(m,m2);
        
        
    }
    
    public static void darvalor(String[] m, String[] m2){
        
        int c = m.length-1;
        
        for(int a=0;a<m.length;a++){
            for(int b=0;b<m.length;b++){
                if(c==b){
                    m2[m.length-b-1] = m[c];
                    c--;
                }
            }
        }
    }
    
    public static boolean comprobador(String[] m, String[] m2){
        
        for(int a=0;a<m.length;a++){
            if((m[m.length-a-1].compareTo(m[a]))!=0){
                return false;
            }
        }
        
        return true;
    }
    
}
