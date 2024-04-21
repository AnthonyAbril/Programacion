
package tema8ejpractico01;

public class Tema8EjPractico01 {

    //Crea un array de números enteros de 100 posiciones, que contendrá los números del 1 al
    //100. Muestra por pantalla los elementos del vector separados por un espacio, así como la
    //suma de todos ellos y su media aritmética. Pista: sólo necesitarás un bucle para hacer todo
    //lo que te pido.
    
    //1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 .....
    //Suma = 5050
    //Media = 50.5
    
    public static void main(String[] args) {
        //Crea un array de números enteros de 100 posiciones
        int [] a = new int[100];
        int suma = 0;
        
        //que contendrá los números del 1 al 100
        for(int cont=0;cont<=a.length-1;cont++){
            a[cont]=cont+1;
            
            //Muestra por pantalla los elementos del vector separados por un espacio
            System.out.print(a[cont]+" ");
            
            //suma de todos ellos
            suma = a[cont]+suma;
        }
        
        System.out.println("\nSuma = " + suma);
        System.out.println("Media = " + ((float)suma)/100);
    }
    
}
