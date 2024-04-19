
package tema4ejpropuestos11;

import java.util.Scanner;

public class Tema4EjPropuestos11 {
    public static void main(String[] args) {
        int euros_imp,quinientos,doscientos,cien,cincuenta,veinte,diez,cinco,dos,uno;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca el importe: ");
        euros_imp = sc.nextInt();
        
        quinientos=euros_imp/500;
        doscientos=((euros_imp%500)/200);
        cien=(((euros_imp%500)%200)/100);
        cincuenta=((((euros_imp%500)%200)%100)/50);
        veinte=(((((euros_imp%500)%200)%100)%50)/20);
        diez=((((((euros_imp%500)%200)%100)%50)%20)/10);
        cinco=(((((((euros_imp%500)%200)%100)%50)%20)%10)/5);
        dos=((((((((euros_imp%500)%200)%100)%50)%20)%10)%5)/2);
        uno=((((((((euros_imp%500)%200)%100)%50)%20)%10)%5)%2);
        
        System.out.println("El importe es de");
        
        if(quinientos>0)
        {
            System.out.print(quinientos + " billete" + ((quinientos>1)?"s":"") + " de quinientos");
        }
        if(doscientos>0)
        {
            System.out.print(" "+ doscientos + " billete" + ((doscientos>1)?"s":"") + " de doscientos");
        }
        if(cien>0)
        {
            System.out.print(" "+ cien + " billete" + ((cien>1)?"s":"") + " de cien");
        }
        if(cincuenta>0)
        {
            System.out.print(" "+ cincuenta + " billete" + ((cincuenta>1)?"s":"") + " de cincuenta");
        }
        if(veinte>0)
        {
            System.out.print(" "+ veinte + " billete" + ((veinte>1)?"s":"") + " de veinte"); 
        }
        if(diez>0)
        {
            System.out.print(" "+ diez + " billete" + ((diez>1)?"s":"") + " de diez");
        }
        if(cinco>0)
        {
            System.out.print(" "+ cinco + " billete" + ((cinco>1)?"s":"") + " de cinco");
        }
        if(dos>0)
        {
            System.out.print(" "+ dos + " moneda" + ((dos>1)?"s":"") + " de dos");
        }
        if(uno>0)
        {
            System.out.print(" "+ uno + " moneda" + ((uno>1)?"s":"") + " de uno");
        }
        System.out.print(".");
    }
    
}
