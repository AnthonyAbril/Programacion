
package ejerciciosarraylist03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Programa que guarde en un ArrayList los nombres y su nota en el examen de Programación
        //de los alumnos de 1DAM. Estos datos se introducirán por teclado, para luego mostrarlos
        //ordenados alfabéticamente y, posteriormente, por nota.
        
        ArrayList<Alumno> Programacion1DAM = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        int opcion=1;
        do{
            System.out.print("Quieres introducir un alumno nuevo?\n  1-si\n  2-no\n>Elige una opcion: ");
            opcion=sc.nextInt();
            sc.nextLine();
            if(opcion==1){
                System.out.print("Introduce el nombre del alumno: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce la nota del alumno: ");
                int nota = sc.nextInt();
                Programacion1DAM.add(new Alumno(nombre,nota));
            }
        }while(opcion!=2);
        
        ListaAlfabetica(Programacion1DAM);
        
        MostrarLista(Programacion1DAM,"Lista ordenada alfabeticamente");
        
        ListaNota(Programacion1DAM);
        
        MostrarLista(Programacion1DAM, "Lista ordenada por nota");
    }
    
    public int compare(Alumno p1, Alumno p2) {
        return p1.getNombre().compareTo(p2.getNombre() );
    }
    
    public static void ListaAlfabetica(ArrayList<Alumno> a){
        Collections.sort(a, new Comparator<Alumno>(){
            @Override
            public int compare(Alumno p1, Alumno p2) {
                return p1.getNombre().compareTo(p2.getNombre() );
            }
        });
    }
    public static void ListaNota(ArrayList<Alumno> a){
        Collections.sort(a, new Comparator<Alumno>(){
            @Override
            public int compare(Alumno p1, Alumno p2) {
                if((p1.getNota()>p2.getNota())){
                    return -1;
                }
                return 1;
            }
        });
    }
    
    public static void MostrarLista(ArrayList<Alumno> a, String Lista){
        if(a.isEmpty()){
            System.out.println("\n>Esta lista esta vacia\n");
        }else{
            Iterator<Alumno> iterador = a.iterator();
            System.out.println("\n"+Lista);
            while (iterador.hasNext()) {
                Alumno alu = iterador.next();
                System.out.println(alu.getNombre()+"\t"+alu.getNota());
            }
            System.out.println("");
        }
    }
}
