
package tienda_de_electrodomésticos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda_de_electrodomésticos {

    static Scanner sc = new Scanner(System.in);

    //Implementa una clase Tienda que almacene en un ArrayList los electrodomesticos de la tienda de electrodomésticos. 
    static ArrayList<Electrodoméstico> Electrodomésticos = new ArrayList<>();
    private static final File lavadoras = new File("/home/alumnot/NetBeansProjects/Tema12/Tienda_de_electrodomesticos_ficheros/lavadoras.ddr");
    
    public static void main(String[] args) {
        Electrodoméstico.rellenarLetras();
        
        try{
            CargarListaEmpleados(lavadoras);
            
            Menu();
            
            GuardarListaEmpleados(lavadoras);
        
        }catch(ClassNotFoundException ex){
            System.out.println(">No se ha encontrado la clase");
            sc.nextLine();  //limpiar el buffera
            Menu();
        }catch(EOFException ex){
            System.out.println("FIN");
        }
    }
    
    public static void Menu(){
            int opcion=0;
            do{
                try{
                    
                    System.out.print("QUE QUIERES HACER?"
                            + "\n\t1. Agregar una electrodoméstico."
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
                            //Agregar un electrodomestico
                            AgregarElectrodomestico();
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
                }catch(java.util.InputMismatchException ex){
                    System.out.println(">El valor debe ser un numero entero");
                    sc.nextLine();  //limpiar el buffer
                }
            }while(opcion!=6);

            //A tener en cuenta:
                //● Todos los datos se tienen que solicitar al usuario.
                //● Siempre que sea posible, se debe de extraer el código repetido en varios métodos a otro método común.
                //● No te olvides de rellenar el HashMap con su contenido.
    }
    
    public static void CargarListaEmpleados(File archivo)  throws ClassNotFoundException, EOFException {
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
                while(true){
                    Electrodomésticos = (ArrayList<Electrodoméstico>) ois.readObject();
                }
            
        }catch(IOException ex){
            System.out.println(" - - Datos cargados - - ");
        }
    }
    
    public static void GuardarListaEmpleados(File archivo){
        try{
            if(archivo.exists()){
                FileOutputStream fos = new FileOutputStream(archivo,true);
                MiObjectOutputStream moos = new MiObjectOutputStream(fos);
                
                moos.writeObject(Electrodomésticos);
            
                fos.close();
                moos.close();
            }else{
                FileOutputStream fos = new FileOutputStream(archivo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                
                oos.writeObject(Electrodomésticos);
            
                fos.close();
                oos.close();
            }
            
            System.out.println("\n - - Datos guardados - - ");
        }catch(IOException ex){
            System.out.println("Error al guardar los datos");
        }
    }
    
    
    public static void AgregarElectrodomestico(){
        
        System.out.print(">Quieres tipo de electrodoméstico quieres crear?\n\t1-Lavadora\n\t2-Televisión\n>Elige una opcion: ");
        int tipo=sc.nextInt();
        System.out.print(">Quieres introducir los parametros o dejarlos por defecto?\n\t1-Introducir parametros\n\t2-Parametros por defecto\n>Elige una opcion: ");
        int op=sc.nextInt();
        if(op==1){
            System.out.print(">Introduce el modelo del electrodomestico: ");
            String Modelo = sc.next();
            if(BuscarModelo(Modelo)){
                System.out.println(">Este modelo ya ha sido introducido");
            }else{
                System.out.print(">Introduce el precio base del electrodomestico: ");
                int base = sc.nextInt();
                sc.nextLine();
                System.out.print(">Introduce el color del electrodomestico: ");
                String color = sc.nextLine();
                System.out.print(">Introduce el peso del electrodomestico: ");
                int peso = sc.nextInt();
                sc.nextLine();
                System.out.print(">Elige su consumo energetico: ");
                char CE = sc.next().charAt(0);
                sc.nextLine();
                Electrodoméstico elec;
                if(tipo==1){
                    System.out.print(">Introduce la carga: ");
                    int carga = sc.nextInt();
                    sc.nextLine();
                    
                    elec = new Lavadora(Modelo, base, color ,CE, peso, carga);
                }else{
                    
                    System.out.print(">Introduce la resolucion: ");
                    int resolucion = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print(">Tiene sintetizador incorporado?\n\t1-Si\n\t2-No\n>Elige una opcion: ");
                    int sintetizador=sc.nextInt();
                    if(sintetizador==1)
                        elec = new Televisión(resolucion,true,Modelo, base, color ,CE, peso);
                    else
                        elec = new Televisión(resolucion,false,Modelo, base, color ,CE, peso);
                }
                //Si ya está en la lista, no volver a insertarlo.
                //antes de meterlo en el array, lo recorremos comparando si ya hay uno asi
                
                if(ComprobarIguales(elec)){
                    System.out.println("Ya hay un electrodomestico igual en la lista");
                }else{
                    Electrodomésticos.add(elec);
                }
            }
            
        }else if(op==2){
                if(tipo==1){
                    Electrodomésticos.add(new Lavadora());
                }else if(tipo==2){
                    Electrodomésticos.add(new Televisión());
                }
        }
    }
    
    public static boolean ComprobarIguales(Electrodoméstico elec){
        for(int a=0;a<Electrodomésticos.size();a++){
            if(elec.getModelo().toLowerCase().equals(Electrodomésticos.get(a).getModelo().toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
    public static String BuscarLavadora(){
        System.out.print(">Introduce el modelo: ");
        String M;
        M = sc.next().toLowerCase();
        
        for(int a=0;a<Electrodomésticos.size();a++){
            if(M.equals(Electrodomésticos.get(a).getModelo().toLowerCase())){
                return ("\n"+Electrodomésticos.get(a).toString()+"\n");
            }
        }
        return ("\n>No se ha encontrado\n");
    }
    
    public static boolean BuscarModelo(String M){
        for(int a=0;a<Electrodomésticos.size();a++){
            if(M.equals(Electrodomésticos.get(a).getModelo().toLowerCase())){
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
        
        for(int a=0;a<Electrodomésticos.size();a++){
            if(M.equals(Electrodomésticos.get(a).getModelo().toLowerCase())){
                Electrodomésticos.get(a).setBase(P);
                break;
            }
        }
    }
    
    public static String EliminarLavadora(){
    //Eliminar una lavadora determinada por el modelo, si existe, y mostrarla.
        System.out.print(">Introduce el modelo: ");
        String M = sc.next().toLowerCase();
        int posicion=0;
        
        for(int a=0;a<Electrodomésticos.size();a++){
            if(M.equals(Electrodomésticos.get(a).getModelo().toLowerCase())){
                return "\n"+Electrodomésticos.remove(a).toString()+"\n";
            }
        }
        return ("\n>No se ha encontrado\n");
    }
    
    public static void MostrarTodas(){
    
        if(!Electrodomésticos.isEmpty()){
            for(Electrodoméstico elemento:Electrodomésticos){
                if(elemento instanceof Lavadora)
                    System.out.println("\n"+elemento.toString()+"\n");
            }
            
            for(Electrodoméstico elemento:Electrodomésticos){
                if(elemento instanceof Televisión)
                    System.out.println("\n"+elemento.toString()+"\n");
            }
        }else{
            System.out.println("No hay electrodomésticos en la tienda");
        }
    }
    
    public static void MostrarTotal(){
        System.out.print("Hay en total "+Electrodomésticos.size()+" electrodomésticos");
        System.out.println(" y se han creado en total "+Electrodoméstico.Ntotal+" electrodomésticos.");
    }
}
