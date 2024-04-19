
package tema8ejpropuesto01;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Matriz m1;
        int filas, columnas;
        
        System.out.print("Filas de la matriz 1: ");
        filas = sc.nextInt();
        System.out.print("Columnas de la matriz 1: ");
        columnas = sc.nextInt();
        m1 = new Matriz();
        m1.solicitarTamanyo(filas, columnas);
        
        
        m1.mostrarMatriz();
        
        m1.asignarDatos();
        m1.mostrarMatriz();
        
        System.out.println("El numero mas grande de esta matriz es: " + m1.maximo());
        System.out.println("El numero mas pequeño de esta matriz es: " + m1.minimo());
        
        Matriz m2;
        System.out.print("Filas de la matriz 2: ");
        filas = sc.nextInt();
        System.out.print("Columnas de la matriz 2: ");
        columnas = sc.nextInt();
        m2 = new Matriz();
        m2.solicitarTamanyo(filas, columnas);
        
        m2.mostrarMatriz();
        
        m2.asignarDatos();
        m2.mostrarMatriz();
        
        if(m1.numFilas==m2.numFilas&&m1.numColumnas==m2.numColumnas){
            System.out.println("La suma de las matrices 1 y 2 es:");
            m1.suma(m2);
            m1.mostrarMatriz();
        }
        else{
            System.out.println("Las matrices no son del mismo tamaño");
        }
        
        if(m1.isCuadrada()&&m2.isCuadrada()&&m1.numFilas==m2.numFilas&&m1.numColumnas==m2.numColumnas){
            System.out.println("El producto de las matrices 1 y 2 es: ");
            m1.producto(m2);
            m1.mostrarMatriz();
        }
        else{
            System.out.println("Las matrices no son cuadradas o no son del mismo tamaño");
        }
        
        if(m1.isCuadrada()&&m2.isCuadrada()){
            System.out.println("La traspuesta de la matriz 2 es: ");
            m2.traspuesta();
            m2.mostrarMatriz();
        }
        else{
            System.out.println("La matriz no es cuadrada");
        }
    }
    
}
