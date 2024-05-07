/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaopciones;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class Pruebaopciones {
public static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(eligeopcion(1,3,"\nElige una opcion: "));
        
    }
    
    public static int eligeopcion(int min, int max, String texto){
        int opcion = 0;
        do{
            try{
                System.out.print(texto);
                opcion = sc.nextInt();
                if(opcion<min || opcion >max){
                    System.out.println(" [ OPCION NO DISPONIBLE ] ");
                }
            }catch(java.util.InputMismatchException ex){
                System.out.println(" [ ESCRIBE UN ENTERO ] ");
                sc.nextLine();
            }
        }while(opcion<min || opcion >max);
        return opcion;
    }
}
