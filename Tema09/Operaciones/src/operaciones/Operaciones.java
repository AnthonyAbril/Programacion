/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operaciones;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operaciones {

    Scanner sr = new Scanner( System.in );

    void ejercicio() {
       int primerNumero = recibeNumero( "Introduce el primer numero" );
       int segundoNumero = recibeNumero( "Introduce el segundo numero" );

       int suma = primerNumero + segundoNumero;
       System.out.println( "La suma es: " + suma );

       int multiplicacion = primerNumero * segundoNumero;
       System.out.println( "La multiplicacion es: " + multiplicacion );

       int resta = primerNumero - segundoNumero;
       System.out.println( "La resta es: " + resta );  

       try {
          int division = primerNumero / segundoNumero;
          System.out.println( "La division es: " + division );
       }
       catch( ArithmeticException e ) {
          System.err.println( "No se puede dividir entre cero." );
       }  
       finaliza();             
    }

    void finaliza() {
       int terminar = recibeNumero( "Si desea continuar, ingrese \"1\", sino, ingrese \"0\"" );
       if( terminar == 0 ) {
          return;
       }
       else if( terminar == 1 ) {
          ejercicio();
       }
       else {
          finaliza();
       }      
    }

    int recibeNumero( String msg ) {
       System.out.println( msg );
       try {
          return sr.nextInt();
       }
       catch( InputMismatchException e ) {
          System.err.println( "El valor debe ser un numero entero" );
          sr.nextLine();  //limpiar el buffer
          recibeNumero( msg );
       }
       return 0;
    } 

    public static void main( String[] args ) {
       Operaciones ope = new Operaciones();
       ope.ejercicio();
    }
}