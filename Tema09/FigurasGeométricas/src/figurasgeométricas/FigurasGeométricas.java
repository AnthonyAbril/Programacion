
package figurasgeométricas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FigurasGeométricas {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Figura> figuras = new ArrayList <>();
    public static void main(String[] args) {        
        Figura.RellenarTabla();
        Menu();
    }
    
    public static void Menu(){
        try{
            
            int opcion=0;
            do{
                System.out.print("OPCIONES"
                        + "\n\t1. Agregar una figura"
                        + "\n\t2. Consultar el número de figuras creadas"
                        + "\n\t3. Mostrar todas las figuras"
                        + "\n\t4. Mostrar la figura de la posición seleccionada"
                        + "\n\t5. Modificar los datos de la figura de la posición seleccionada y mostrar los cambios:"
                        + "\n\t6. Eliminar la figura de la posición seleccionada y mostrar un mensaje indicando el tipo de figura"
                        + "\n\t7. Vaciar la colección, previa confirmación por parte del usuario de dicha operación"
                        + "\n\t8. Salir"
                        + "\n>Elige una opcion: ");
                opcion=sc.nextInt();
                
                switch (opcion) {
                    case 1:
                        AgregarFigura();
                        break;
                    case 2:
                        System.out.println("Hay "+figuras.size()+" figuras actualmente");
                        break;
                    case 3:
                        MostrarFiguras();
                        break;
                    case 4:
                        if(figuras.size()==0){
                            System.out.println(">La lista esta vacia");
                        }else{
                            System.out.print(">Introducir la posicion de la figura a mostrar:");
                            MostrarFigura(sc.nextInt()-1);
                        }
                        break;
                    case 5:
                        ModificarDatos();
                        break;
                    case 6:
                        EliminarFigura();
                        break;
                    case 7:
                        VaciarColeccion();
                        break;
                    default:
                        break;
                }
            }while(opcion!=8);
            
        }catch(java.util.InputMismatchException ex){
            System.out.println(">El valor debe ser un numero entero");
            sc.nextLine();  //limpiar el buffera
            
            Menu();
        }
    }
    
    public static void AgregarFigura(){
        
        System.out.print("Que figura quieres agregar?"
                + "\n\t1-triangulo"
                + "\n\t2-rectangulo"
                + "\n\t3-trapecio"
                + "\n\t4-hexagono"
                + "\n>Elige una opcion: ");
        int op = sc.nextInt();
        int b=NumPosit("Indica la base: ");
        int a=NumPosit("Indica la altura: ");
        if(op==1){//triangulo
            figuras.add(new Triangulo(b,a));
        }else if(op==2){//rectangulo
            figuras.add(new Rectangulo(b,a));
        }else if(op==3){//trapecio
            int B=NumPosit("Indica la base mayor: ");
            figuras.add(new Trapecio(B,b,a));
        }else if(op==4){//hexagono
            figuras.add(new Hexagono(b,a));
        }
    }
    
    public static int NumPosit(String texto){
        int numero=-1;
        do{
            System.out.print(texto);
            numero=sc.nextInt();
        }while(numero<=0);
        return numero;
    }
    
    public static void MostrarFiguras(){
        //a. Tipo de figura: triángulo, rectángulo, trapecio o hexágono
        //b. Datos: base, altura, Base (si es trapecio)
        //c. Área
        //d. Perímetro
        //e. Posición que ocupa en la colección
        int contador=0;
        for (Figura elemento:figuras){
            contador++;
            System.out.println("\n\tFIGURA N"+contador+elemento.toString());
        }
    }
    
    public static void MostrarFigura(int posicion){
        //for(int a=0;a<figuras.size();a++){
        //    System.out.println();
        //}
        
        if(posicion<figuras.size()&&posicion>=0){
            System.out.println("\tDATOS"+figuras.get(posicion).toString());

            figuras.get(posicion).Dibujar();
        }else{
            System.out.println(">Esta posicion se encuentra fuera de la lista");
        }
    }
    
    public static void ModificarDatos(){
        
        if(figuras.size()==0){
            System.out.println(">La lista esta vacia");
        }
        else{
            System.out.print(">Introduce la posicion de la figura a modificar: ");
            int posicion = sc.nextInt()-1;

            if(posicion<figuras.size()&&posicion>=0){
                int op = 0;
                do{
                    System.out.print("Que tipo de figura?"
                        + "\n\t1-triangulo"
                        + "\n\t2-rectangulo"
                        + "\n\t3-trapecio"
                        + "\n\t4-hexagono"
                        + "\n>Elige una opcion: ");
                    op = sc.nextInt();
                }while(op>4||op<1);
                
                int b=NumPosit("Indica la base: ");
                int a=NumPosit("Indica la altura: ");
                if(op==1){//triangulo
                    figuras.set(posicion, new Triangulo(b,a));
                }else if(op==2){//rectangulo
                    figuras.set(posicion, new Rectangulo(b,a));
                }else if(op==3){//trapecio
                    int B=NumPosit("Indica la base mayor: ");
                    figuras.set(posicion, new Trapecio(B,b,a));
                }else if(op==4){//hexagono
                    figuras.set(posicion, new Hexagono(b,a));
                }

                MostrarFigura(posicion);
            }
            else{
                System.out.println(">Esta posicion se encuentra fuera de la lista");
            }
        }
    }
    
    public static void EliminarFigura(){
        if(figuras.size()==0){
            System.out.println(">La lista esta vacia");
        }
        else{
            int posicion=sc.nextInt()-1;
            figuras.remove(posicion).toString();
        }
    }
    
    public static void VaciarColeccion(){
        System.out.println("Desea vaciar la coleccion?"
                + "\n1-Si\n2-No");
        int op = sc.nextInt();
        if(op==1){
            figuras.clear();
            System.out.println("Se h vaciado la coleecion");
        }else if(op==2){
            System.out.println("No se h vaciado la coleecion");
        }
    }
}