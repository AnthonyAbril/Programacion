
package tienda_de_electrodomésticos;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda_de_electrodomésticos {

    static Scanner sc = new Scanner(System.in);

    //Implementa una clase Tienda que almacene en un ArrayList las lavadoras de la tienda de electrodomésticos. 
    static ArrayList<Lavadora> Lavadoras = new ArrayList<>();
    
    public static void main(String[] args) {
        Electrodoméstico.LetraPrecio.put('A',100);
        Electrodoméstico.LetraPrecio.put('B',80);
        Electrodoméstico.LetraPrecio.put('C',60);
        Electrodoméstico.LetraPrecio.put('D',50);
        Electrodoméstico.LetraPrecio.put('E',30);
        Electrodoméstico.LetraPrecio.put('F',10);
        
        //Al usuario se le debe mostrar un menú donde elegir la acción a realizar
        //sobre el ArrayList, de entre las siguientes:
            //1. Agregar una lavadora.
            //2. Buscar una lavadora determinada por el modelo, si existe, y mostrarla.
            //3. Modificar el precio base de una lavadora determinada por el modelo, si existe, y mostrarla.
            //4. Eliminar una lavadora determinada por el modelo, si existe, y mostrarla.
            //5. Mostrar todas las lavadoras de la tienda.
            //6. Salir
        
        int opcion=0;
        do{
            System.out.print("QUE QUIERES HACER?"
                    + "\n\t1. Agregar una lavadora."
                    + "\n\t2. Buscar una lavadora determinada por el modelo, si existe, y mostrarla."
                    + "\n\t3. Modificar el precio base de una lavadora determinada por el modelo, si existe, y mostrarla."
                    + "\n\t4. Eliminar una lavadora determinada por el modelo, si existe, y mostrarla."
                    + "\n\t5. Mostrar todas las lavadoras de la tienda."
                    + "\n\t6. Salir"
                    + "\n\t7. Mostrar el numero de lavadoras que hay en la tienda"
                    + "\n>Elige que quieres hacer: ");
            opcion=sc.nextInt();
            
            switch (opcion) {
                case 1:
                    //Agregar una lavadora
                    AgregarLavadora();
                    break;
                case 2:
                    //Buscar una lavadora determinada por el modelo, si existe, y mostrarla.
                    System.out.println(BuscarLavadora());
                    break;
                case 3:
                    //Modificar el precio base de una lavadora determinada por el modelo, si existe, y mostrarla.
                    ModificarPrecio();
                    break;
                case 4:
                    //Eliminar una lavadora determinada por el modelo, si existe, y mostrarla.
                    System.out.println(EliminarLavadora());
                    break;
                case 5:
                    //Mostrar todas las lavadoras de la tienda.
                    MostrarTodas();
                    break;
                case 7:
                    //Mostrar el numero de lavadoras que hay en la tienda
                    MostrarTotal();
                    break;
                default:
                    break;
            }
        }while(opcion!=6);
            
        //A tener en cuenta:
            //● Todos los datos se tienen que solicitar al usuario.
            //● Siempre que sea posible, se debe de extraer el código repetido en varios métodos a otro método común.
            //● No te olvides de rellenar el HashMap con su contenido.
    }
    
    public static void AgregarLavadora(){
        System.out.print(">Quieres introducir los parametros o dejarlos por defecto?\n\t1-Introducir parametros\n\t2-Parametros por defecto\n>Elige una opcion: ");
        int op=sc.nextInt();
        if(op==1){
            System.out.print(">Introduce el modelo de la lavadora: ");
            String Modelo = sc.next();
            if(BuscarModelo(Modelo)){
                System.out.println(">Este modelo ya ha sido introducido");
            }else{
                System.out.print(">Introduce el precio base de la lavadora: ");
                int base = sc.nextInt();
                sc.nextLine();
                System.out.print(">Introduce el peso de la lavadora: ");
                int peso = sc.nextInt();
                sc.nextLine();
                System.out.print(">Introduce la carga: ");
                int carga = sc.nextInt();
                System.out.print(">Elige su consumo energetico: ");
                char CE = sc.next().charAt(0);
                sc.nextLine();

                Lavadoras.add(new Lavadora(Modelo, base, CE, peso, carga));
            }
            
        }else if(op==2){
            Lavadoras.add(new Lavadora());
        }
    }
    
    public static String BuscarLavadora(){
        System.out.print(">Introduce el modelo: ");
        String M;
        M = sc.next().toLowerCase();
        
        for(int a=0;a<Lavadoras.size();a++){
            if(M.equals(Lavadoras.get(a).getModelo().toLowerCase())){
                return ("\n"+Lavadoras.get(a).toString()+"\n");
            }
        }
        return ("\n>No se ha encontrado\n");
    }
    
    public static boolean BuscarModelo(String M){
        for(int a=0;a<Lavadoras.size();a++){
            if(M.equals(Lavadoras.get(a).getModelo().toLowerCase())){
                return (true);
            }
        }
        return (false);
    }
    
    public static void ModificarPrecio(){
    //Modificar el precio base de una lavadora determinada por el modelo, si existe, y mostrarla.
        System.out.print(">Introduce el modelo: ");
        String M = sc.next().toLowerCase();
        System.out.print(">Introduce el nuevo precio: ");
        int P = sc.nextInt();
        
        for(int a=0;a<Lavadoras.size();a++){
            if(M.equals(Lavadoras.get(a).getModelo().toLowerCase())){
                Lavadoras.get(a).setBase(P);
                break;
            }
        }
    }
    
    public static String EliminarLavadora(){
    //Eliminar una lavadora determinada por el modelo, si existe, y mostrarla.
        System.out.print(">Introduce el modelo: ");
        String M = sc.next().toLowerCase();
        int posicion=0;
        
        for(int a=0;a<Lavadoras.size();a++){
            if(M.equals(Lavadoras.get(a).getModelo().toLowerCase())){
                return "\n"+Lavadoras.remove(a).toString()+"\n";
            }
        }
        return ("\n>No se ha encontrado\n");
    }
    
    public static void MostrarTodas(){
    
        if(!Lavadoras.isEmpty()){
            for(Lavadora elemento:Lavadoras){
                System.out.println("\n"+elemento.toString()+"\n");
            }
        }else{
            System.out.println("No hay lavadoras en la tienda");
        }
    }
    
    public static void MostrarTotal(){
        System.out.println("Hay en total "+Lavadora.getNtotal()+" lavadoras.");
    }
}
