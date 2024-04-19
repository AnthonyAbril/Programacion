
package pruebacomparacionfiguras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal {

    private static ArrayList <Figura> Figuras= new ArrayList<>();
    
    public static void main(String[] args) {//prueba para contar cuantas veces se repite un objeto de mismo contenido
        
        if(true){
            Figuras.add(new Figura(3,2.4));
            Figuras.add(new Figura(0,0));
            Figuras.add(new Figura(1,4.6));
            Figuras.add(new Figura(3,2.4));
            Figuras.add(new Figura(3,2.4));
            Figuras.add(new Figura(1,4.6));
            Figuras.add(new Figura(1,4.6));
            Figuras.add(new Figura(0,0));
        }

        System.out.println("LISTA DE FIGURAS");
        for(int a=0;a<Figuras.size();a++){//recorre la lista normalmente
            System.out.println(Figuras.get(a).getDatos());
        }
        
        /* da la lista de los repetidos, falta guardarla
        System.out.println("\nLISTA DE REPETIDOS");
        for(int a=0;a<Figuras.size();a++){
            int repeticiones=0;
            for(int b=a+1;b<Figuras.size();b++){
                if(Figuras.get(a).equals(Figuras.get(b))){//ambos son iguales
                    repeticiones++;
                    System.out.println("["+repeticiones+"] "+Figuras.get(a).getDatos());
                    if(repetidos.containsKey(Figuras.get(b).getDatos())){//si ya hay uno dentro
                        if(repeticionmayor(repetidos,Figuras.get(b).getDatos(),repeticiones)==false){//buscamos que el que ya este dentro tenga un valor menor a repeticiones
                            repetidos.replace(Figuras.get(b).getDatos(), repeticiones);//cambiar getdatos por tostring
                            System.out.println(repeticiones + "repetido" + repetidos.replace(Figuras.get(b).getDatos(), repeticiones-1, repeticiones));
                        }
                    }else{
                            repetidos.put(Figuras.get(b).getDatos(), 1);//cambiar getdatos por tostring
                            System.out.println(1 + "primero");
                            repeticiones=1;
                    }
                }
            }
        
        }
        */
        
        //rellenar hashmap
        HashMap<String, Integer> repetidos = new HashMap<>();
        System.out.println("\nLISTA DE REPETIDOS");
        for(int a=0;a<Figuras.size();a++){//recorre la lista una sola vez
            if(repetidos.containsKey(Figuras.get(a).getDatos())){//si esta en el hashmap
                System.out.println(repetidos.replace(Figuras.get(a).getDatos(), repetidos.get(Figuras.get(a).getDatos()), repetidos.get(Figuras.get(a).getDatos())+1));//sacamos el valor de el que esta en el hashmap y le sumamos uno
            }else{//si no esta en el hashmap
                repetidos.put(Figuras.get(a).getDatos(), 1);//metemos el primero con un valor de repetidos 1
                System.out.println(repetidos.get(Figuras.get(a).getDatos()) + "]");
            }
        }
        
        System.out.println(repetidos.values());
        //mostrar valores con las veces que se repite
        for (Map.Entry<String, Integer> entry : repetidos.entrySet()) {
            Integer valor = entry.getValue();
            System.out.println(entry.getKey()+" se ha repetido " + valor);
        }
    }
    
    
    
    public static boolean repeticionmayor(HashMap<String, Integer> repetidos,String datos,int repeticiones){
        for (Map.Entry<String, Integer> entry : repetidos.entrySet()) {
            Integer valor = entry.getValue();
            //antes de introducir uno tenemos que repasar el hashmap para ver si ya tiene uno introducido igual a nuestro elemento.
            if(entry.getKey().equals(datos)){
                if(valor>repeticiones)
                    return true;//hay uno igual dentro y tiene valor mayoe
            }
        }
        return false;
    }
}
