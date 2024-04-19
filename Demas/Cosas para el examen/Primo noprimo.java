/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej06;

/**
 *
 * @author alumnot
 */
public class Ej06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   int i;
   for(i=0;i<101;i++){
   if(Primo(i)){
       System.out.println(i);
   }
   }
    }
    private static boolean Primo(int num) {
        int cont = 2;
        boolean primo = true;
        while ((primo) && (cont != num)) {
            if (num % cont == 0) {
                primo = false;
            }
            cont++;
        }
        return primo;
    }
}
