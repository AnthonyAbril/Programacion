
package tema4ejpropuestos10;

import java.util.Scanner;

public class Tema4EjPropuestos10 {
    public static void main(String[] args) {
        int t,minutos,horas;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca una cantidad de tiempo en segundos: ");
        t = sc.nextInt();
        if(t>3600)
        {
            horas=t/3600;
            minutos=((t%3600)/60);
            System.out.println("Son " + horas + " horas con " + minutos + " minutos y " + (((t%3600)%60)) + " segundos");
        }
        else if(t>60)
        {
            minutos=((t%3600)/60);
            System.out.println("Son " + minutos + " minutos y " + (((t%3600)%60)) + " segundos");
        }
        else
        {
            System.out.println("Son " + (((t%3600)%60)) + " segundos");
        }
    }
    
}
