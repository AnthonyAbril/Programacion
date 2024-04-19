
package ejerciciosarraylist04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Esta información se tiene que registrar en un ArrayList, buscar una persona dado el dni,
        //eliminar una persona dado el dni, ordenar por apellidos y mostrar todas las personas. Hacer
        //un menú para realizar lo que se pide.     
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Persona> p = new ArrayList<>();
        
        p.add(new Persona("44530704J","Gomez","Juan","Hombre",25,83));
        p.add(new Persona("50293451T","Espinosa","Carla","Mujer",18,72));
        p.add(new Persona("44325674Y","Ortiz","Paula","Mujer",22,74));
        p.add(new Persona("21353647M","Carrasco","Abel","Hombre",19,76));
        
        int opcion=0;
        do{
            System.out.print("Opciones\n 1-Registrar a una persona\n 2-Buscar una persona dado el dni\n 3-Eliminar una persona dado el dni\n 4-Ordenar por apellidos\n 5-Mostrar todas las personas\n 6-Salir\nElige una opcion: ");
            
            opcion=sc.nextInt();
            sc.nextLine();
            
            if(opcion==1){
                System.out.print("Introduce su nombre: ");
                String nombre=sc.nextLine();
                System.out.print("Introduce su apellido: ");
                String apellido=sc.nextLine();
                System.out.print("Introduce su DNI: ");
                String DNI=sc.nextLine();
                System.out.print("Introduce su sexo: ");
                String sexo=sc.nextLine();
                System.out.print("Introduce su edad: ");
                int edad=sc.nextInt();
                System.out.print("Introduce su peso: ");
                int peso=sc.nextInt();
                p.add(new Persona(DNI,apellido,nombre,sexo,edad,peso));

            }else if(opcion==2){//Buscar una persona dado el dni
                System.out.print("Introduce el DNI de la persona buscada: ");
                String DNI=sc.nextLine();
                Iterator<Persona> it = p.iterator();
                while(it.hasNext()){
                    Persona actual = it.next();
                    if(actual.GetDni().equals(DNI)){
                        System.out.print("Los datos que coinciden con este dni:");
                        System.out.println(" "+MostrarInformacion(actual)+"\n");
                    }
                }
                
            }else if(opcion==3){//Eliminar una persona dado el dni
                System.out.print("Introduce el DNI de la persona a eliminar: ");
                String DNI=sc.nextLine();
                for(int a=0;a<p.size();a++){
                    if(p.get(a).GetDni().equals(DNI)){
                        p.remove(p.get(a));
                    }
                }
                
            }else if(opcion==4){//Ordenar por apellidos
                Collections.sort(p, new Comparator<Persona>(){
                @Override
                public int compare(Persona p1, Persona p2) {
                    return p1.GetApellido().compareTo(p2.GetApellido() );
                }
            });
                
            }else if(opcion==5){//Mostrar todas las personas
                
                System.out.println("");
                for(Persona actual:p){
                    System.out.println(MostrarInformacion(actual));
                }
                System.out.println("");
            }
        }while(opcion!=6);
    }
    
    public static String MostrarInformacion(Persona per){
        return (per.getNombre()+" "+per.GetApellido()+"\t("+per.GetDni()+")");
    }
    
}
