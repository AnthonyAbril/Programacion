
package ejercicio06;

import java.util.Scanner;

public class Ejercicio06 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float GRAVEDAD, VELOCIDAD, TIEMPO;
        GRAVEDAD = 9.8f;
        
        System.out.println("Introduce un valor de tiempo: ");
        TIEMPO = sc.nextInt();
        
        if(TIEMPO == 0){
            System.out.println("Tiempo incorrecto");
        }
        else{
            System.out.println(GRAVEDAD*TIEMPO);
        }
    }
    
}
