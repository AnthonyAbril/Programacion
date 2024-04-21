
package pkg8.pkg3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //A continuacion, implementa los metodos necesarios para eliminar a un alumno del array a partir de su nombre,
        //para añadir un alumno nuevo al array de alumnos y para ordenar el listado de almnos
        
        int alumnos;
        Scanner sc = new Scanner(System.in);
        String [] A;
                
        //Desarrolla un programa que pida por consola el numero de alumnos de una clase
        System.out.print("Numero de alumnos de la clase: ");
        alumnos = sc.nextInt();
        sc.nextLine();//nextLine para que no de errores con los proximos nextLine
        A=new String[alumnos];
        
        //y que a continuacion solicite los N nombres para almacenarlos en un array.
        for(int N=0;N<alumnos;N++){
            System.out.print("Introduce el nombre del "+(N+1)+"º alumno: ");
            A[N]=sc.nextLine();
        }
        
        int opciones=0;
        do{
            System.out.println("Elige una opcion: \n1-Mostrar lista\n2-Insertar un alumno\n3-Eliminar alumno\n4-Buscar un alumno\n");
            opciones=sc.nextInt();
            
            if(opciones==1){
                decir(A);
                System.out.println("");
            }
            else if(opciones==2){
                sc.nextLine();//nextLine para que no de errores con los proximos nextLine
                System.out.print("Introduce el nombre del alumno: ");
                String nomalum = sc.nextLine();
                System.out.print("Introduce la posicion donde añadir al alumno: ");
                int posicion = sc.nextInt();
                A=insertar(A,nomalum,posicion);
                System.out.println("");
            }
            else if(opciones==3){
                sc.nextLine();//nextLine para que no de errores con los proximos nextLine
                System.out.print("Introduce el nombre del alumno: ");
                String nomalum = sc.nextLine();
                A=eliminar(A,nomalum,buscarPosicion(A,nomalum));
            }
            else if(opciones==4){
                sc.nextLine();//nextLine para que no de errores con los proximos nextLine
                System.out.print("Introduce el nombre del alumno: ");
                String nomalum = sc.nextLine();
                System.out.println("Su posicion es: "+buscarPosicion(A,nomalum+"\n"));
            }
        }while(opciones<5&&opciones>0);
        
    }
    
    public static void decir (String[] a){
        for(int t=0;t<a.length;t++)
            System.out.println(a[t]);
    } 
    
    public static String [] insertar (String[] a, String n, int p){//perfect
        
        if(p<0)
            return a;
        
        String [] nuevo = new String[a.length+1];
        
        for(int c=0;c<p;c++){
            nuevo[c]=a[c];
        }
        nuevo[p-1]=n;
        for(int b=p;b<nuevo.length;b++){
            nuevo[b]=a[b-1];
        }
        
        return nuevo;
    }
    
    public static int buscarPosicion (String a[], String n){//perfect
        for(int i=0;i<a.length;i++){
            if(a[i].equals(n))
                return i+1;
        }
        return -a.length;
    }
    
    public static String [] eliminar (String[] a, String n, int p){//perfect
        if(p<0)
            return a;
        
        String [] nuevo = new String[a.length-1];
        
        for(int c=0;c<p-1;c++){
            nuevo[c]=a[c];
        }
        for(int b=p-1;b<nuevo.length;b++){
            nuevo[b]=a[b+1];
        }
        
        return nuevo;
    }
    
}
