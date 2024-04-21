
package tema5ejpropuestos08;

import java.util.Scanner;

public class minumeroEsOmirp {

     
    private static Scanner sc;
 
    public static void main(String[] args) {
        int num;
        sc = new Scanner(System.in);
        
        System.out.print("Introduce un número para invertir: ");
        num = sc.nextInt();
        
        if((EsPrimo(num))&&(EsPrimo(invertirNumero(num))))
        {
            System.out.println(num + " es omirp");
        }
        else
        {
            System.out.println(num + " no es omirp");
        }
        
    }
     
    private static int invertirNumero(int numero){
        int cifra, inverso = 0;
        while(numero!=0){
            cifra = numero%10;
            inverso = (inverso * 10) + cifra;
            numero/=10;
        }
        return inverso;
    }
    
    private static boolean EsPrimo(int numero){
        int contador;
        for(contador=2; contador<numero;contador++){
            if(numero%contador==0)
            {
                return false;
            }
        }
        return true;
    }
    
}
