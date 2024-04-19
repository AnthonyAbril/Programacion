
package tema5ejpropuestos07;

import java.util.Scanner;

public class Tema5EjPropuestos07 {

    public static void main(String[] args) {
        int ninicial, c1,c2,c3,c4;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca un numero: ");
        ninicial = sc.nextInt();
        
        c1 = ninicial/1000;                 //cuarta cifra
        c2 = (ninicial%1000)/100;           //tercera cifra
        c3 = ((ninicial%1000)%100)/10;      //segunda cifra
        c4 = (((ninicial%1000)%100)%10);    //primera cifra
        
        switch (c1) 
        {
            case 1: System.out.print("M");
            break;
            case 2: System.out.print("MM");
            break;
            case 3: System.out.print("MMM");
            break;
            
            default: System.out.print("");
            break;
        }
        
        switch (c2) 
        {
            case 1: System.out.print("C");
            break;
            case 2: System.out.print("CC");
            break;
            case 3: System.out.print("CCC");
            break;
            case 4: System.out.print("CD");
            break;
            case 5: System.out.print("D");
            break;
            case 6: System.out.print("DC");
            break;
            case 7: System.out.print("DCC");
            break;
            case 8: System.out.print("DCCC");
            break;
            case 9: System.out.print("CM");
            break;
            
            default: System.out.print("");
            break;
        }
        
        switch (c3) 
        {
            case 1: System.out.print("X");
            break;
            case 2: System.out.print("XX");
            break;
            case 3: System.out.print("XXX");
            break;
            case 4: System.out.print("XL");
            break;
            case 5: System.out.print("L");
            break;
            case 6: System.out.print("LX");
            break;
            case 7: System.out.print("LXX");
            break;
            case 8: System.out.print("LXXX");
            break;
            case 9: System.out.print("XC");
            break;
            
            default: System.out.print("");
            break;
        }
        
        switch (c4) 
        {
            case 1: System.out.println("I");
            break;
            case 2: System.out.println("II");
            break;
            case 3: System.out.println("III");
            break;
            case 4: System.out.println("IV");
            break;
            case 5: System.out.println("V");
            break;
            case 6: System.out.println("VI");
            break;
            case 7: System.out.println("VII");
            break;
            case 8: System.out.println("VIII");
            break;
            case 9: System.out.println("IX");
            break;
            
            default: System.out.println("");
            break;
        }
    }
    
}
