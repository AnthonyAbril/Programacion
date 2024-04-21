
package tema6ejpropuestos08;

import java.util.Scanner;

/**
 *
 * @author abril
 */
public class Restaurante {
    
    int papas;
    int chocos;
    
    public Restaurante(int p, int c){
        papas=p;
        chocos=c;
    }

    public void addChocos(int x){ //Añade x kilos de chocos a los ya existentes.
        chocos=chocos+x;
    }
    public void addPapas(int x){ //Añade x kilos de papas a los ya existentes.
        papas=papas+x;
    }
    public int getComensales(){ //Devuelve el nº de comensales que puede atender.
        //cada tres personas, utiliza 1 kilo de papas y medio de chocos
        if(papas>(chocos*2)){
            return chocos*2*3;
        }
        return papas*3;
    }
    public void showChocos(){ //Muestra en pantalla los kilos de chocos del almacén.
        System.out.println("Hay actualmente " + chocos + " chocos.");
    }
    public void showPapas(){ //Muestra en pantalla los kilos de papas del almacén. 
        System.out.println("Hay actualmente " + papas + " papas.");
    }
    
    public static void main(String[] args) {
        int p;
        int c;
        
        Restaurante r;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduzca la cantidad en kilos que hay de papas: ");
        p = sc.nextInt();
        System.out.print("Introduzca la cantidad en kilos que hay de chocos: ");
        c = sc.nextInt();
        
        r = new Restaurante(p,c);
        int opcion;
        
        do{
            System.out.println("\nQue quieres hacer?\n1-Añadir x kilos de chocos a los ya existentes\n2-Añade x kilos de papas a los ya existentes\n3-Mostrar a cuantos comensales que puede atender\n4-Mostrar en pantalla los kilos de chocos del almacen\n5-Mostrar en pantalla los kilos de papas del almacen");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            
            if(opcion==1){
                r.addChocos(sc.nextInt());
            }
            if(opcion==2){
                r.addPapas(sc.nextInt());
            }
            if(opcion==3){
                System.out.println("\nCon la cantidad de papas y chocos que hay se pueden atender a " + r.getComensales());
            }
            if(opcion==4){
                System.out.println("\nActualmente hay "+r.chocos+" kilos de chocos en el almacen");
            }
            if(opcion==5){
                System.out.println("\nActualmente hay "+r.papas+" kilos de papas en el almacen");
            }
        }while(opcion>0&&opcion<6);
        
    }
    
}
