
package tema11ejpropuestos03;

import java.util.Scanner;

public class Tema11EjPropuestos03 {

    static int sx,sy;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce x: ");

        sx = sc.nextInt();

        System.out.print("Introduce y: ");

        sy = sc.nextInt();
        
        for(int i=1; i<=sy; i++)
        {
            for(int j=1; j<=sx; j++)
            {
                System.out.print(cuadro(j,i));
                if((cuadro(j,i))>9)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
    
    static int cuadro (int x, int y){
            
        if((x==1) || (y==1))//primera columna
        {
            return 1;
        }
        
        else{

            return ((cuadro((x-1),y))+(cuadro(x,(y-1))));
        }
        
    }
    
}
