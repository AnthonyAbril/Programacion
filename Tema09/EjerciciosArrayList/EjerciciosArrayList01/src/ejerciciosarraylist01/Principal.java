
package ejerciciosarraylist01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> arrayEnteros = new ArrayList<>();
        
        arrayEnteros = leerValores(arrayEnteros);
        
        if(arrayEnteros.size()>0){
            mostrarResultados(arrayEnteros,calcularSuma(arrayEnteros),(calcularSuma(arrayEnteros))/arrayEnteros.size());
        }
    }
    
    public static ArrayList<Integer> leerValores(ArrayList<Integer> a){
        //La lectura de números termina cuando se introduzca el valor -99
        boolean entrada=true;
        do{
            System.out.print("Introduce un numero: ");
            int añadir=sc.nextInt();
            if(añadir==-99){
                return a;
            }else{
                a.add(añadir);
            }
            int opcion;
            do{
                System.out.println("Quieres introducir otro numero mas?\n 1-Si\n 2-No");
                opcion=sc.nextInt();
                if(opcion==2)
                    entrada=false;
            }while(opcion>2||opcion<1);
        }while(entrada==true);
        
        return a;
    }
    
    public static int calcularSuma(ArrayList<Integer> a){
        int suma=0;
        
        Iterator<Integer> iterador = a.iterator();
        while (iterador.hasNext()){
            suma+=iterador.next(); 
       }
            
        return suma;
    }

    public static void mostrarResultados(ArrayList<Integer> a, int s, float m){
        
        
        System.out.println("\nEl numero de valores que se han leido es de " + a.size());
        
        System.out.println("La suma de los valores es "+s);
        
        System.out.printf("La media de los valores es %.2f%n",m);
        
        System.out.println("Los valores son: ");
        for(int e:a){
            System.out.println(e+(e>m ? " (mayor a la media)" : ""));
        }
    }
}
