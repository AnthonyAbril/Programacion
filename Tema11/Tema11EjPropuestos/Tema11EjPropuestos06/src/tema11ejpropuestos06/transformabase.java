
package tema11ejpropuestos06;

import java.util.Scanner;

public class transformabase {
    
    public static void main(String[] args) {
        int a,b;
        
        Scanner sc= new Scanner(System.in);
        
        System.out.print("Introduzca un decimal: ");
        
        b=sc.nextInt();
        
        System.out.print("Introduzca una base: ");
        
        a=sc.nextInt();
        
        switch(a){
            case 2 -> System.out.print(binario(b));
            case 8 -> System.out.print(octal(b));
            case 16 -> System.out.print(hexadecimal(b));
        }
    }
    
    public static int binario(int n){
        if(n>1)
        {
            System.out.print(binario(n/2));
        }
        return n%2;
    }
    
    public static int octal(int n){
        if(n>=8)
        {
            System.out.print(octal(n/8));
        }
        return n%8;
    }
    
    public static int hexadecimal(int n){
        if(n>16){
            
            int prov=hexadecimal(n/16);
            if(prov%16>9)
            {
            switch(prov){
                case 10 -> System.out.print("A");
                case 11 -> System.out.print("B");
                case 12 -> System.out.print("C");
                case 13 -> System.out.print("D");
                case 14 -> System.out.print("E");
                case 15 -> System.out.print("F");     
                }
            }
            else
            {
                System.out.print(prov);
            }
            
        }
        return (n%16);
    }
    
}
