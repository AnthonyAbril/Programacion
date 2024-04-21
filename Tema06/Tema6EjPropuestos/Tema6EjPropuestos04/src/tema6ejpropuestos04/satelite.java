
package tema6ejpropuestos04;

import java.util.Scanner;

public class satelite {
    private double meridiano;
    private double paralelo;
    private double distancia_tierra;

    satelite ( double m, double p, double d ) {
        meridiano = m;
        paralelo = p;
        distancia_tierra = d;
    }
    
    satelite() {
        meridiano = paralelo = distancia_tierra = 0;
    }
    
    public void setPosicion(double m, double p, double d ) {
        meridiano = m;
        paralelo = p;
        distancia_tierra = d;
    }
    public void printPosicion( ) {
        System.out.println ("\nEl satellite se encuentra en el paralelo "+paralelo+
        " meridiano "+ meridiano+ " a una distancia de la tierra de " +
        distancia_tierra+ " kilómetros" );
    }
    
    
    public void variaAltura(double desplazamiento){
        //Este método acepta un parámetro que será positivo o negativo dependiendo de si el satélite tiene que acercarse o alejarse a la Tierra.
        distancia_tierra =distancia_tierra + desplazamiento;
        
        if(distancia_tierra<0)
        {
            distancia_tierra =0;
        }
    }
    
    public boolean enOrbita( ){
        //Este método devolverá false si el satélite está en tierra y trae en caso contrario.
        if(distancia_tierra==0){
            return false;//esta en tierra
        }
        return true;//esta en orbita
    }
    
    public void variaPosicion(double variap, double variam){
        //Este método permite modificar los atributos de posición (meridiano y paralelo) mediante los parámetros variap y variam. Estos parámetros serán valores positivos o negativos relativos que harán al satélite modificar su posición.
        meridiano = meridiano + variam;
        paralelo = paralelo + variap;
    }    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        satelite s=new satelite();
        
        System.out.println("Desea poner los datos del satelite?\n1-Si\n2-No");
        int a = 0;
        do{
            a=sc.nextInt();
            if(a==1){
                System.out.println("Introduzca el meridiano");
                int m=sc.nextInt();
                System.out.println("Introduzca el paralelo");
                int p=sc.nextInt();
                System.out.println("Introduzca la distancia a la tierra");
                int d=sc.nextInt();
                s.setPosicion(m, p, d);
            }
        }while(a<1||a>2);
        
        
        int opcion=1;
        do{
            
            System.out.println("\nQue quieres hacer?\n1-Establecer posicion\n2-Mostrar posicion\n3-Variar altura\n4-Mostrar si esta en orbita\n5-Variar posicion\n6-Salir");
            opcion=sc.nextInt();
            
            if(opcion==1){
                System.out.println("Introduzca el nuevo meridiano");
                int m=sc.nextInt();
                System.out.println("Introduzca el nuevo paralelo");
                int p=sc.nextInt();
                System.out.println("Introduzca la nueva distancia a la tierra");
                int d=sc.nextInt();
                s.setPosicion(m, p, d);
            }
            else if(opcion==2){
                s.printPosicion();
            }
            else if(opcion==3){
                System.out.println("Introduzca el valor que quiere añadir a la distancia");
                int d=sc.nextInt();
                s.variaAltura(d);
            }
            else if(opcion==4){
                if(s.enOrbita())
                    System.out.println("\nesta en orbita");
                else
                    System.out.println("\nesta en tierra");
            }
            else if(opcion==5){
                System.out.println("Introduzca el nuevo meridiano");
                int m=sc.nextInt();
                System.out.println("Introduzca el nuevo paralelo");
                int p=sc.nextInt();
                s.variaPosicion(p, m);
            }
        }while(opcion!=6);
    }
    
}
