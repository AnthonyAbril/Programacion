
package ejerciciosarraylist02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> NumReales=new ArrayList<>();

    public static void main(String[] args) {
        //Crear un programa que use un ArrayList de números reales. El programa muestra un menú
        //donde el usuario elige la acción a realizar sobre el ArrayList, de entre las siguientes:
            //1. Agregar un número
            //2. Buscar un número
            //3. Modificar un número
            //4. Eliminar un número
            //5. Insertar un número en una posición dada
            //6. Mostrar los elementos
            //7. Ordenar ascendentemente los elementos
            //8. Ordenar descendentemente los elementos
            //9. Salir
        //El programa no terminará hasta que se escoja la opción 9.
        
        int opcion=0;
        do{
                System.out.print("\nACCIONES\n"
                        + "\n[1] Agregar elemento\t[2] Buscar elemento"
                        + "\n[3] Modificar elemento\t[4] Eliminar elemento"
                        + "\n[5] Insertar elemento\t[6] Mostrar elementos"
                        + "\n[7] Orden ascendente\t[8] Orden descendente"
                        + "\n[9] Salir"
                        + "\n>Introduzca acción (1-9): ");
            opcion=sc.nextInt();
            sc.nextLine();
            
            if(opcion==1){
                //Solicitará al usuario el elemento a insertar al final de la lista.
                System.out.print("\nIntroduzca el elemento a insertar al final de la lista: ");
                int elemento=sc.nextInt();
                System.out.println("");
                NumReales.add( elemento);
                
            }else if(opcion==2){
                //Solicitará al usuario el elemento a buscar en la lista. Si lo encuentra, mostrará por
                //pantalla la posición en la que se encuentra.
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    System.out.print(">Introduzca elemento que quieres encontrar: ");
                    int elemento=sc.nextInt();
                    if(NumReales.indexOf(elemento)==-1)
                        System.out.print("\n>No se ha encontrado el elemento en la lista");
                    else
                        System.out.print("\n>El elemento se encuentra en la posicion: "+(NumReales.indexOf(elemento)+1));
                }
            }else if(opcion==3){
                //Solicitará al usuario el elemento a modificar en la lista. Si lo encuentra, solicitará al
                //usuario el nuevo valor del elemento de la lista.
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    System.out.print(">Introduzca el elemento que quieres modificar: ");
                    int elemento=sc.nextInt();
                    if(NumReales.indexOf(elemento)==-1){
                        System.out.println(">No se ha encontrado el elemento en la lista");
                    }else{
                        System.out.print("\n>Introduce el nuevo valor del elemento de la lista: ");
                        int elementonuevo=sc.nextInt();
                        NumReales.set(NumReales.indexOf(elemento), elementonuevo);
                    }
                }
            }else if(opcion==4){
                //Solicitará al usuario el elemento a eliminar de la lista.
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    System.out.print(">Introduzca el elemento que quieres eliminar: ");
                    int elemento=sc.nextInt();
                    if(NumReales.indexOf(elemento)==-1){
                        System.out.println(">No se ha encontrado el elemento en la lista");
                    }else{
                        System.out.print("\n>El elemento " + NumReales.remove(NumReales.indexOf(elemento)) + " ha sido eliminado");
                    }
                }
            }else if(opcion==5){
                //Solicitará al usuario el elemento a insertar y la posición en la que se insertará. Se
                //debe comprobar si la posición es correcta, o dará un error.
                System.out.print("\n>Introduzca el elemento a insertar en la lista: ");
                int elemento=sc.nextInt();
                System.out.print(">Introduzca la posicion en la que se insertara el elemento: ");
                int posicion=sc.nextInt()-1;
                if((posicion>=0)&&(posicion-1>NumReales.size())){
                    System.out.println("\n>Esta posicion no esta disponible\n");
                }else{
                    NumReales.add(posicion, elemento);
                }
                
            }else if(opcion==6){
                //Utiliza el método que prefieras para recorrer la lista. Deberá mostrar si la lista está vacia.
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    Iterator<Integer> iterador = NumReales.iterator();
                    System.out.println("\nLista");
                    while (iterador.hasNext()) {
                        System.out.println(iterador.next());
                    }
                    System.out.println("");
                }
            }else if(opcion==7){
                //Ordenar ascendentemente los elementos
                Comparator<Integer> comparador = Collections.reverseOrder();
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    Collections.sort(NumReales, comparador);
                }
            }else if(opcion==8){
                //Ordenar descendentemente los elementos
                if(NumReales.isEmpty()){
                    System.out.println("\n>Esta lista esta vacia\n");
                }else{
                    Collections.sort(NumReales);
                }
            }
            
        }while(opcion!=9);
        
        if(opcion==9){
            System.out.println("fin");
        }
    }
    
}
