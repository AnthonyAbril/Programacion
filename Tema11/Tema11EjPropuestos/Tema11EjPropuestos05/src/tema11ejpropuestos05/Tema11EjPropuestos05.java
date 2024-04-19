
package tema11ejpropuestos05;

import java.util.Scanner;

public class Tema11EjPropuestos05 {
    
    static int b,d;
    
    public static void main(String[] args) {
        
        int a,contador;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        
        a = sc.nextInt();
        
        for(b=1;b<=a;b++)//lineas
        {
            //System.out.print(b);
            for(int c=1;c<=a-b;c++)//espacios en blanco
            {
                System.out.print("  ");
            }
            for(d=1;d<=b+(b-1);d++)
            {
                System.out.print(" ");
                //System.out.print("("+d+","+b+")");
                System.out.print(piramide(d,b));
            }
            System.out.println("");
        }
        
    }
    
    public static int piramide(int x, int y){
        if((x==1)&&(y==1))
        {
            return 1;
        }
        if((x<=0)||(y<=0))
        {
            return 0;
        }
        else
        {
            return (((piramide(x-2,y-1)))+((piramide(x-1,y-1)))+((piramide(x,y-1))));
        }
    }
    
}
