/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package suppracticost4;


public class Principal {
    
    //Ampliación 1
    static final int CONSTANTE_NUMERICA = 9;
    static final String CONSTANTE_CADENA = "hola";
    
    public static void main(String[] args) {
        final int NUMERO = 1008;
        final String CADENA = "Saludos";
        
        Integer n1 = NUMERO;
        Integer n2 = n1;
        
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
        System.out.println("CADENA = " + CADENA);
        
        //Ampliación 1
        
        System.out.println("\nAmpliación 1");
        System.out.println("Constante numérica = " + CONSTANTE_NUMERICA);
        System.out.println("Constante cadena = " + CONSTANTE_CADENA);
        
        //Ampliacion 2
        int b = 9 << 2;     // 5<<2 = 101+00 = 10100
        System.out.println("\nAmpliacion 2");
        System.out.println("b = " + b);
        
        //Ampliación 3
        b = 16 & 8;
        System.out.println("\nAmpliación 3");
        System.out.println("b = " + b);
        
        //Ampliación 4
        int a = b++ + 13;
        System.out.println("\nAmpliación 4");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        //Ampliación 5
        int $hora;
        int Loveyou;    //no 1loveyou pq no puede empezar por un numero
        int iva;        // no iva% pq no puede contener un %
    }
    
}
