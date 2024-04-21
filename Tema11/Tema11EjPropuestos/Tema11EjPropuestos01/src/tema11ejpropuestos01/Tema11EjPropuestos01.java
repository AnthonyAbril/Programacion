
package tema11ejpropuestos01;

import java.util.Scanner;

public class Tema11EjPropuestos01 {

    public static void main(String[] args) {
        
        int n,resultado;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un numero: ");
        
        n = sc.nextInt();
        
        for(resultado=n;n>1;n--)
        {
            resultado = (resultado * (n-1));
        }
        
        System.out.println(resultado);
        
    }
    
}
