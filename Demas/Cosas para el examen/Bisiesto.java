/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej03;
/**
 *
 * @author alumnot
 */
public class Ej03 {
    public static boolean bisiesto (int year) {
    if (year%4 == 0)
        if (year%100 == 0 && year%400 != 0) {
            return false;
            } else {
        return true;
        } else {
    return false;
}
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] arg) {
        int year = Integer.parseInt(arg[0]);
        if (bisiesto(year) == true) {
            System.out.println(year + " es bisiesto");
        } else {
            System.out.println(year + " no es bisiesto");
        }

    }
}
