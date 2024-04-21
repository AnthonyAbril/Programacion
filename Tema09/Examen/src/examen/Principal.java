
package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Empleado> Empleados = new ArrayList<>();
    
    public static void main(String[] args) {
        Empleado.LlenarTablas();
        
        {//metemos empleados de prueba
            Empleados.add(new Medico(5,"A","Juan Franco","Cirugia",true));
            Empleados.add(new AuxiliarDeEnfermeria("C","Felipe Gerard","dermatologo",true,true));
            Empleados.add(new Enfermero("B","Maria Castaño","quemados",false));
        }
        
        Menu();
    }
    
    public static void Menu(){
        
        try{
        int opcion = 0;
            do{

                System.out.println("\nOPCIONES");
                System.out.println("\t1. Dar de alta a un empleado");
                System.out.println("\t2. Mostrar a todos los empleados");
                System.out.println("\t3. Consultar el numero de empleados en activo");
                System.out.println("\t4. Consultar el numero de empleados por categoria");
                System.out.println("\t5. Mostrar la informacion del empleado con un codigo determinado");
                System.out.println("\t6. Eliminar al empleado");
                System.out.println("\t7. Ordenar la lista de empleados");
                System.out.println("\t8. Modificar las guardias del medico de la posicion seleccionada y mostrar sus datos");
                System.out.println("\t9. Salir");
                System.out.print(">Elige una opcion: ");

                opcion=sc.nextInt();

                switch (opcion) {
                    case 1:
                        CrearEmpleado();
                        break;
                    case 2:
                        MostrarEmpleados();
                        break;
                    case 3:
                        System.out.println(">Actualmente hay "+Empleados.size()+" empleados activos\n");
                        break;
                    case 4:
                        ListaCategoria();
                        break;
                    case 5:
                        System.out.println(MostrarEmpleado());
                        break;
                    case 6:
                        EliminarEmpleado();
                        break;
                    case 7:
                        OrdenarLista();
                        break;
                    case 8:
                        ModificarGuardias();
                        break;
                    default:
                        break;
                }
            }while(opcion!=9);
        }catch(java.util.InputMismatchException ex){
            System.out.println(">El valor debe ser un numero entero");
            sc.nextLine();  //limpiar el buffera
            
            Menu();
        }
    }
    
    public static void CrearEmpleado(){
        String c="g";
        do{
            System.out.print(">Indica la categoria del empleado: ");
            c=sc.next().toUpperCase();
        }while(("A".equals(c)||"B".equals(c)||"C".equals(c))==false);
        
        System.out.print(">Nombre del empleado: ");//que no se pueda introducir un numero
        String N= ComprobarTexto();
        System.out.print(">Servicio del empleado: ");//que no se pueda introducir un numero
        String S=ComprobarTexto();
        int op=0;
        do{
            System.out.print(">Tiene turnicidad?\n\t1-Si\n\t2-No\n>Elige una opcion: ");
            op = sc.nextInt();
        }while(op>2||op<1);
        boolean T = (op==1);
        
        if("A".equals(c)){//medico
            System.out.print(">Numero de guardias del empleado: ");
            int G=ComprobarGuardias(sc.nextInt());
            
            Empleados.add(new Medico(G,c,N,S,T));
        }else if("B".equals(c)){//Enfermero
            
            Empleados.add(new Enfermero(c,N,S,T));
            
        }else if("C".equals(c)){//Auxiliar
            
            int o=0;
            do{
                System.out.print(">Tiene alguna discapacidad?\n\t1-Si\n\t2-No\n>Elige una opcion: ");
                o = sc.nextInt();
            }while(o>2||o<1);
            boolean D = (op==1);
            
            Empleados.add(new AuxiliarDeEnfermeria(c,N,S,T,D));
        }
    }
    
    public static void MostrarEmpleados(){
        System.out.println("\tLISTA DE EMPLEADOS");
        for(int a=0;a<Empleados.size();a++){
            System.out.println("NUMERO: "+(a+1)+"\t"+Empleados.get(a).getCodigo()+"\t\t"+Empleados.get(a).getNombre()+"\n");
        }
    }
    
    public static String ComprobarTexto() {
        String c = "a";
        boolean esNumerico = false;
        do {
            c = sc.next();
            for (int a = 0; a < c.length(); a++) {
                try {
                    String b = Character.toString(c.charAt(a));
                    Integer.parseInt(b);    //si no es letra continuara
                    esNumerico = false;
                    System.out.print(">Por favor, introduce solo letras: ");
                    break;
                } catch (NumberFormatException excepcion) {
                    esNumerico = true;
                }
            }
        } while (esNumerico == false);
        return c;
    }
    
    public static void ListaCategoria(){
        int M=0;
        int E=0;
        int A=0;
        
        for(int c=0;c<Empleados.size();c++){
            if(Empleados.get(c) instanceof Medico){
                M++;
            }else if(Empleados.get(c) instanceof Enfermero){
                E++;
            }else if(Empleados.get(c) instanceof AuxiliarDeEnfermeria){
                A++;
            }
        }
        
        System.out.println("Hay "+M+" medicos");
        System.out.println("Hay "+E+" enfermeros");
        System.out.println("Hay "+A+" auxiliares");
    }
    
    public static String MostrarEmpleado(){
        System.out.print(">Introduce el codigo del empleado a buscar: ");
        String codigo = sc.next();
        for(int c=0;c<Empleados.size();c++){
            if(Empleados.get(c).getCodigo().equals(codigo)){
                return "\n\tPosicion:"+(c+1)+" - "+Empleados.get(c).toString();
            }
        }
        
        return ">No se ha encontrado ningun empleado con este codigo";
    }
    
    public static void EliminarEmpleado(){
        System.out.print(">Introduce la posicon del empleado a eliminar: ");
        int posicion = sc.nextInt();
        if(posicion>Empleados.size()||posicion<1){
            System.out.println(">Se ha eliminado el empleado de categoria "+Empleados.remove(posicion-1).getCodigo().charAt(0));
        }else{
            System.out.println(">No se ha encontrado ningun empleado en esta posicion");
        }
    }
    
    public static void OrdenarLista(){
        Collections.sort(Empleados, new Comparator<Empleado>(){
            @Override
            public int compare(Empleado e1, Empleado e2) {
                return e1.getCodigo().compareTo(e2.getCodigo() );
                }
            }
        );
    }
    
    public static int ComprobarGuardias(int g){
        if(g>Medico.getGuardiasMaximas())
            return Medico.getGuardiasMaximas();
        else if(g<0)
            return 0;
        else
            return g;
    }
    
    public static void ModificarGuardias(){
        int posicion = 0;
        System.out.print(">Indica la posicion del medico: ");
        posicion = sc.nextInt();
        if(posicion<1||(posicion>Empleados.size())){
            System.out.println("La posicion no pertenece a la lista");
        }else{
            if((Empleados.get(posicion-1) instanceof Medico)==false){
                System.out.println(">La posicion no pertenece a ningun empleado en la lista");
            }else{
                System.out.print(">Introduce el nuevo numero de guardias de este medico: ");
                int G = ComprobarGuardias(sc.nextInt());

                Medico p = (Medico)Empleados.get(posicion-1);
                p.setNguardias(G);

                System.out.println(p.toString());
            }
        }
    }
}
