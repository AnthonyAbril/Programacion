/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaarrays;

import java.util.ArrayList;

/**
 *
 * @author alumnot
 */
public class PruebaArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //array q contiene arraylists
        ArrayList<Integer>[] arrayDeArrayLists = new ArrayList[3];

        // Crear los ArrayLists y agregarlos al array
        arrayDeArrayLists[0] = new ArrayList<>(); //
        arrayDeArrayLists[1] = new ArrayList<>();
        arrayDeArrayLists[2] = new ArrayList<>();

        // Agregar elementos a los ArrayLists
        arrayDeArrayLists[0].add(1);
        arrayDeArrayLists[0].add(2);
        arrayDeArrayLists[1].add(3);
        arrayDeArrayLists[2].add(4);
        arrayDeArrayLists[2].add(5);

        // Imprimir el contenido de los ArrayLists en el array
        for (int i = 0; i < arrayDeArrayLists.length; i++) {
            System.out.println("ArrayList " + i + ": " + arrayDeArrayLists[i]);
        }
        
        //arraylist q contiene arrays
        ArrayList<String[]> arrayList = new ArrayList<>();
        
        String[] array1 = {"hello", "world"};
        String[] array2 = {"foo", "bar"};
        
        arrayList.add(array1);
        arrayList.add(array2);
        
        System.out.println(arrayList);
    }
    
}
