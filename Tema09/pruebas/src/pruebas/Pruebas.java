
package pruebas;

import java.util.Scanner;

public class Pruebas {

    static Scanner sc = new Scanner( System.in );
    static int a=0;
    
    public static void main(String[] args) {
        System.out.print(">Introduce un texto (sin numeros): ");
        String t = ComprobarTexto();
    }
    
     public static String ComprobarTexto() {
        String c = "a";
        boolean esNumerico = false;
        do {
            c = sc.next();
            for (int a = 0; a < c.length(); a++) {
                if(c.charAt(a)>='0'&&c.charAt(a)>='9'){//es numero
                    
                    esNumerico = true;
                }else{//es letra
                    
                    esNumerico = false;
                }
            }
            System.out.println("Introduzca otro numero");
        } while (esNumerico == false);
        return c;
    }
    }
    
