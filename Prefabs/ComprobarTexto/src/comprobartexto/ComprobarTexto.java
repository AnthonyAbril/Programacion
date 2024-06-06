
package comprobartexto;

import java.util.Scanner;

public class ComprobarTexto {

    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(">Introduce algo: ");
        String texto = ComprobarTexto();
        System.out.println(texto);
    }

    public static String ComprobarTexto() {
        String c = "a";
        boolean esNumerico = false;
        do {
            c = sc.next();
            for (int a = 0; a < c.length(); a++) {
                try {
                    String b = Character.toString(c.charAt(a));
                    Integer.parseInt(b);//si no es letra continuara
                    esNumerico = false;
                    System.out.print(">Por favor, introduce solo letras: ");
                    break;
                } catch (NumberFormatException excepcion) {
                    esNumerico = true;
                }
            }
        } while (esNumerico == false);
        return c;
    }
    
    public static String SoloTexto(String texto) {
         String pista;
        do {
        System.out.print(texto);
        pista = sc.nextLine();
        } while (!pista.matches("[A-Za-z]*"));
        return pista;
    }
}
