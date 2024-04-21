
package ejercicioshashmap01;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;

public class Principal {

    static Scanner sc = new Scanner(System.in); 
    static HashMap<String, Integer> agenda = new HashMap<>();
    
    public static void main(String[] args) {
        //Crea un programa en el que se genere una agenda con los teléfonos de tus amigos. La
        //agenda almacenará el nombre de un amigo junto a su teléfono. Los datos a guardar en la
        //agenda deben solicitarse por teclado.
        //El programa mostrará un menú con las acciones a realizar sobre la agenda:
        //1. Agendar a un amigo (controlando la reacción ante los duplicados).
        //2. Consultar el número de amigos que hay agendados.
        //3. Consultar el teléfono de un amigo.
        //4. Modificar el teléfono de un amigo.
        //5. Consultar a quién pertenece un número de teléfono.
        //6. Borrar a un ex-amigo de la agenda.
        //7. Mostrar el contenido de la agenda.
        //8. Listar únicamente los nombres de los amigos.
        //9. Ordenar agenda por nombres
        //10. Ordenar agenda por teléfonos
        //11. SALIR        
        //agenda=(nombre,telefono),(nombre,telefono),...
        
        {
            agenda.put("Juan",602339304);
            agenda.put("Abel",631628223);
            agenda.put("Ana",658660278);
            agenda.put("Luis",632995111);
        }
        
        int opcion=0;
        do{
            System.out.print("\nOPCIONES"
                    + "\n\t 1. Agendar a un amigo."
                    + "\n\t 2. Consultar el número de amigos que hay agendados."
                    + "\n\t 3. Consultar el teléfono de un amigo."
                    + "\n\t 4. Modificar el teléfono de un amigo."
                    + "\n\t 5. Consultar a quién pertenece un número de teléfono."
                    + "\n\t 6. Borrar a un ex-amigo de la agenda."
                    + "\n\t 7. Mostrar el contenido de la agenda."
                    + "\n\t 8. Listar únicamente los nombres de los amigos."
                    + "\n\t 9. Ordenar agenda por nombres"
                    + "\n\t10. Ordenar agenda por teléfonos"
                    + "\n\t11. SALIR   "
                    + "\n>Elige una opcion: ");
            opcion=sc.nextInt();
            
            sc.nextLine();
            
            if(opcion==1){//Agendar a un amigo (controlando la reacción ante los duplicados).    HECHO
                System.out.print(">Introduzca el nombre del nuevo amigo: ");
                String nombre = sc.nextLine();
                System.out.print(">Introduzca el numero de telefono de este: ");
                Integer num = sc.nextInt();
                
                if(ConsultaNombre(nombre)!=-1){
                    System.out.println("Este contacto ya esta registrado");
                }else{
                    agenda.put(nombre,num);
                }
                
            }else if(opcion==2){//Consultar el número de amigos que hay agendados.    HECHO
                System.out.println(">Hay "+agenda.size()+" amigos registrados actualmente en esta agenda.");
                
            }else if(opcion==3){//Consultar el teléfono de un amigo.    HECHO
                System.out.print(">Introduce el nombre del contacto: ");
                String nombre = sc.nextLine();
                
                if(ConsultaNombre(nombre)!=-1)
                    System.out.println(ConsultaNombre(nombre));
                else
                    System.out.println("No ha sido encontrado");
                
            }else if(opcion==4){//Modificar el teléfono de un amigo.    HECHO
                System.out.print(">Introduce su nombre: ");
                String nombre = sc.nextLine();
                
                if(ConsultaNombre(nombre)==-1){
                    System.out.println("No se ha encontrado este contacto");
                }else{
                    System.out.print(">Introduce el nuevo numero de este contacto: ");
                    int nuevo = sc.nextInt();
                    System.out.println(agenda.put(nombre, nuevo));
                }
                
            }else if(opcion==5){//Consultar a quién pertenece un número de teléfono.    HECHO
                System.out.print(">Introduce el telefono: ");
                int telefono = sc.nextInt();
                System.out.println(ConsultaTelefono(telefono));
                
            }else if(opcion==6){//Borrar a un ex-amigo de la agenda.    HECHO
                System.out.print(">Introduce el telefono: ");
                int telefono = sc.nextInt();
                String nombre = ConsultaTelefono(telefono);
                if(agenda.remove(ConsultaTelefono(telefono),telefono))
                    System.out.println("Se ha eliminado a "+nombre+" de tu lista de amigos");
                else
                    System.out.println("No se ha encontrado el contacto");
            }else if(opcion==7){//Mostrar el contenido de la agenda.    HECHO
                //System.out.println(agenda.entrySet());
                System.out.println("\nNombre\tnumero");
                
                for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
                    System.out.println(clave.getKey()+"\t"+clave.getValue());
                }
                
            }else if(opcion==8){//Listar únicamente los nombres de los amigos.    HECHO
                for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
                    System.out.println(clave.getKey());
                }
                
            }else if(opcion==9){//Ordenar agenda por nombres    HECHO
                String [] nombres = new String [agenda.size()];
                int contador=0;
                for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
                   nombres[contador] = clave.getKey();
                   contador++;
                }
                java.util.Arrays.sort(nombres);
                for(int a=0;a<nombres.length;a++){
                    System.out.println(nombres[a] + " \t " + agenda.get(nombres[a]));
                }
            }else if(opcion==10){//Ordenar agenda por teléfonos
                String [] nombres = new String [agenda.size()];
                int contador=0;
                for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
                   nombres[contador] = clave.getKey();
                   contador++;
                }
                java.util.Arrays.sort(nombres);
                for(int a=nombres.length-1;a>=0;a--){
                    System.out.println(nombres[a] + " \t " + agenda.get(nombres[a]));
                }
            }
        }while(opcion!=11);
    }
    
    public static String ConsultaTelefono(int t){
        for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
            if(t==clave.getValue()){
                return clave.getKey();
            }
        }
        
        return "no ha sido encontrado";
    }
    
    public static int ConsultaNombre(String n){
        for(HashMap.Entry<String, Integer> clave:agenda.entrySet()){
            if(n.equals(clave.getKey())){
                return clave.getValue();
            }
        }
        return -1;
    }
    
}
