
package tema11ejpropuestos04;

import java.util.Scanner;

public class Tema11EjPropuestos04 {

    public static void main(String[] args) {
     
        int a,contador;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        
        a = sc.nextInt();
        
        for(int b=1; b<=a; b++)//lineas
        {
            contador=0;
            for(int c=1; c<=a-b; c++)//espacios
            {
                System.out.print(" ");
            }
            
            for(int d=1; d<=b+(b-1); d++)//puntos
            {
                if(d%2==0){
                    System.out.print(" ");
                }
                else{
                    contador++;
                    System.out.print(triangulo(contador,b));
                }
            }
            System.out.println("");
        }
    }
    
    static int triangulo(int x, int y){
        if((x==1)||(x==y))
        {
            return 1;
        }
        else
        {
            return ((triangulo(x-1,y-1))+(triangulo(x,y-1)));
        }
    }
    
}
