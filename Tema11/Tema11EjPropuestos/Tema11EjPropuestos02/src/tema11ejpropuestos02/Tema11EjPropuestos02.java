
package tema11ejpropuestos02;

import java.util.Scanner;

public class Tema11EjPropuestos02 {

    public static void main(String[] args) {
        
        int s;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un numero: ");

        s = sc.nextInt();

        for(int i=1;i<s+1;i++)
            System.out.print(f(i) + ", ");
        
    }
    
    static int f (int n){
        
        if(n==1)
            return 0;
        
        if(n==2)
            return 1;
        
        else
            return (f(n-1) + f(n-2));
    }
    
    
}
