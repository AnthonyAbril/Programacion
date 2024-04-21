
package ejercicioshashmap02;

import java.util.HashMap;

public class Colegio {
    HashMap<String, Integer> Alumnos = new HashMap<>();
    
    //addAlumno(String nacionalidad): añade la nacionalidad de un nuevo alumno.
    public void addAlumno(String nacionalidad){
        Alumnos.put(nacionalidad,buscador(nacionalidad)+1);
        
    }
    
    //showAll(): Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad.      HECHO
    public void showAll(){
        for(HashMap.Entry<String, Integer> clave:Alumnos.entrySet()){
            System.out.println(clave.getKey() +" \t "+ clave.getValue());
        }
    }
    
    //showNacionalidad(String nacionalidad): Muestra la nacionalidad y el número de alumnos de esa nacionalidad.
    public void showNacionalidad(String nacionalidad){
        System.out.println(nacionalidad +" \t "+ Alumnos.get(nacionalidad));
    }
    
    //cuantos(): Muestra cuántas nacionalidades diferentes existen en el colegio.
    public void cuantos(){
        System.out.println(Alumnos.size());
    }
    
    //borrarNacionalidad(String nacionalidad): Borra una nacionalidad.
    public void borrarNacionalidad(String nacionalidad){
        if(Alumnos.remove(nacionalidad, Alumnos.get(nacionalidad))){
            System.out.println("Se ha eliminado "+nacionalidad+" de la lista");
        }else{
            System.out.println("No se ha eliminado "+nacionalidad+" de la lista");
        }
    }
    
    //borrarAll(): Elimina los datos insertados.
    public void borrarAll(){
        Alumnos.clear();
        System.out.println("Se han eliminado todos los datos");
    }
    
    public int buscador(String nacionalidad){
        for(HashMap.Entry<String, Integer> clave:Alumnos.entrySet()){
            if(clave.getKey().equals(nacionalidad)){
                return clave.getValue();
            }
        }
        return 0;
    }
}
