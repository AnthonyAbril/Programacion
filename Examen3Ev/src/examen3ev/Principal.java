
package examen3ev;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList <Numero> ListaNumeros = new ArrayList<>();
    private static ArrayList <Integer> VariablesStatic = new ArrayList<>();
    private static File ficheronumero;
    private static String ruta = "ficheros";

    public static void main(String[] args) {
        
        try{
            PrepararRuta();
            
            CargarListaEmpleados(ficheronumero);
            
            Menu();
            
            GuardarListaEmpleados(ficheronumero);
        }catch(ClassNotFoundException ex){
            System.out.println(" [ NO SE HA ENCONTRADO LA CLASE ] ");
        }catch(EOFException ex){
            System.out.println("");
        }
    }
    
    public static void PrepararRuta(){
        ficheronumero = new File(ruta);
        ficheronumero.mkdirs();
        ficheronumero = new File(ruta+"/ficheroNumero.ddr");
    }
    
    public static void CargarListaEmpleados(File archivo)throws ClassNotFoundException, EOFException{
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
            if(ficheronumero.exists()&&ficheronumero.length()>0){//si ya existe un fichero ahi y tiene contenido

                System.out.print("ya hay un fichero con contenido en la ruta indicada"
                        + "\n\t1-usar la informacion fichero"
                        + "\n\t2-crear un nuevo fichero");
                int opcion = eligeopcion(1,2,"\n>Elige una opcion: ");

                if(opcion==1){//lee la informacion fichero
                    while(true){
                        ListaNumeros=(ArrayList <Numero>)ois.readObject();
                        VariablesStatic=(ArrayList <Integer>)ois.readObject();
                    }
                }
            }
            
        }catch(IOException ex){
            System.out.println(" - - Datos cargados - - ");
        }
        if(!VariablesStatic.isEmpty()){
            Numero.setTotalN(VariablesStatic.get(0));
            Entero.setTotalE(VariablesStatic.get(1));
            Racional.setTotalR(VariablesStatic.get(2));
        }
    }
    
    public static void GuardarListaEmpleados(File archivo){
        System.out.println("Quieres guardar?"
                + "\n\t1-Si"
                + "\n\t2-No");
        if(eligeopcion(1,2,">Elige una opcion: ")==1){
            try{
                VariablesStatic.add(Numero.getTotalN());
                VariablesStatic.add(Entero.getTotalE());
                VariablesStatic.add(Racional.getTotalR());
                if(archivo.exists()){
                    FileOutputStream fos = new FileOutputStream(archivo,true);
                    MiObjectOutputStream moos = new MiObjectOutputStream(fos);

                    moos.writeObject(ListaNumeros);
                    moos.writeObject(VariablesStatic);

                    fos.close();
                    moos.close();
                }else{
                    FileOutputStream fos = new FileOutputStream(archivo);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(ListaNumeros);
                    oos.writeObject(VariablesStatic);

                    fos.close();
                    oos.close();
                }

                System.out.println("\n - - Datos guardados - - ");
                System.out.println("Se han guardado en: "+archivo);

            }catch(IOException ex){
                System.out.println("Error al guardar los datos");
            }
        }else{
            System.out.println("Programa finalizado sin guardar");
        }
    }
    
    public static void titulo(String texto){
        System.out.println("\n"+texto);
        for(int a=1;a<=texto.length();a++){
            System.out.print("*");
        }
        System.out.println("");
    }
    
    public static int solonumero(String texto){
        boolean isnumeric=false;
        int numero=0;
        do{
            try{
                System.out.print(texto);
                numero = sc.nextInt();
                if(numero<=0){
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                }else{
                    isnumeric=true;
                }
            }catch(java.util.InputMismatchException  ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] ");
                sc.nextLine();
            }
        }while(isnumeric==false);
        return numero;
    }
    
    public static int eligeopcion(int min, int max, String texto){
        int opcion = 0;
        do{
            opcion = solonumero(texto);
            if(opcion<min || opcion >max){
                System.out.println(" [ OPCION NO DISPONIBLE ] ");
            }
        }while(opcion<min || opcion >max);
        return opcion;
    }
    
    public static double solodouble(String texto){
        boolean isnumeric=false;
        double numero=0;
        do{
            try{
                System.out.print(texto);
                numero = sc.nextDouble();
                if(numero<=0){
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                }else{
                    isnumeric=true;
                }
                
            }catch(java.util.InputMismatchException  ex){
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO DECIMAL ] ");
                sc.nextLine();
            }
        }while(isnumeric==false);
        return numero;
    }
    
    public static void Menu(){
        try {
            int op = 0;
            do {
                System.out.print("\n----- OPCIONES --------------"
                        + "\n\t1-Introducir número"
                        + "\n\t2-Eliminar número"
                        + "\n\t3-Numeros almacenados"
                        + "\n\t4-Numeros introducidos"
                        + "\n\t5-Mostrar todo"
                        + "\n\t6-Buscar duplicados"
                        + "\n\t7-Calcular sumas"
                        + "\n\t8-Trabajar con ENTEROS"
                        + "\n\t9-Trabajar con RACIONALES"
                        + "\n\t10-Salir");
                op = eligeopcion(1, 10, "\n>Elige opcion: ");

                switch (op) {
                    case 1:
                        CrearNumero();//terminado
                        break;
                    case 2:
                        EliminarNumero();//terminado
                        break;
                    case 3:
                        MostrarNumeros();//terminado
                        break;
                    case 4:
                        MostrarIntroducidos();//terminado
                        break;
                    case 5:
                        MostrarTodo();//terminado
                        break;
                    case 6:
                        BuscarDuplicados();//terminado
                        break;
                    case 7:
                        CalcularSumas();//terminado
                        break;
                    case 8:
                        TrabajarConEnteros();
                        break;
                    case 9:
                        TrabajarConRacionales();
                        break;
                    default:
                        break;
                }
            } while (op != 10);
        } catch (java.util.InputMismatchException ex) {
            System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
            sc.nextLine();
        }
    }
    
    public static void CrearNumero(){
        titulo("INTRODUCIR UN NUMERO");
        int opcion = 0;

        opcion = eligeopcion(1,2,
                "Elige que tipo de numero vas a introducir"
                + "\n\t1-Numero Entero"
                + "\n\t2-Numero Racional"
                +"\n>Introduce una opcion: ");
        
        //valores comunes
        sc.nextLine();
        String signo;
        do {
            System.out.print("Elige un signo (+ o -): ");
            signo = sc.nextLine();
        } while (!"-".equals(signo)&&!"+".equals(signo));
        
        int entera = solonumero(">Introduce la parte entera: ");
        
        if(opcion==1){//entero
            ListaNumeros.add(new Entero(entera,signo));
        }else if(opcion==2){//decimal
            Double decimal=0d;
            do{
                decimal = solodouble(">Introduce la parte decimal (Ej: 0,2): ");
            }while(decimal>=1||decimal<0);
            
            ListaNumeros.add(new Racional(entera,signo,decimal));
        }
    }
    
    public static void EliminarNumero(){
        if(ListaNumeros.isEmpty()){
            System.out.println("No hay numeros en la lista");
        }else{
            MostrarTodo();
            ListaNumeros.remove(eligeopcion(1,ListaNumeros.size(),"Elige la posicion del numero a eliminar: ")-1);
        }
    }

    private static void MostrarNumeros() {
        if(!ListaNumeros.isEmpty()){
            titulo("NUMEROS ALMACENADOS");
            int nenteros=0;
            int nracionales=0;
            for(int a=0;a<ListaNumeros.size();a++)
                if(ListaNumeros.get(a) instanceof Entero)
                    nenteros++;
                else if(ListaNumeros.get(a) instanceof Racional)
                    nracionales++;

            System.out.println("Hay "+ListaNumeros.size()+" numeros almacenados"
                    + "\nde los cuales "+nenteros+" son enteros y "+nracionales+" son racionales.");
        }else{
            System.out.println("No hay numeros en la lista");
        }
    }
    
    private static void MostrarTodo() {
        if(ListaNumeros.isEmpty()){
            System.out.println("No hay numeros en la lista");
        }else{
            titulo("NUMEROS ALMACENADOS");
            for(int a=0;a<ListaNumeros.size();a++){
                System.out.println("["+(a+1)+"] "+ListaNumeros.get(a).toString());
            }
        }
    }
    
    public static void BuscarDuplicados(){
        if(!ListaNumeros.isEmpty()){

            titulo("LISTA DE OBJETOS REPETIDOS");    //usar arraylist en la que se guarden los numeros de la posicion en la que se encuentran las repetidas y se repase despues para no repetirse

            HashMap<String, Integer> repetidos = new HashMap<>();   //hacemos una lista que tenga los datos y las veces q han salido
            for(int a=0;a<ListaNumeros.size();a++){//recorre la lista una sola vez

                if(repetidos.containsKey(ListaNumeros.get(a).getTexto())){   //si esta en el hashmap
                    repetidos.replace(ListaNumeros.get(a).getTexto(), repetidos.get(ListaNumeros.get(a).getTexto()), repetidos.get(ListaNumeros.get(a).getTexto())+1);

                }else{//si no esta en el hashmap
                    repetidos.put(ListaNumeros.get(a).getTexto(), 1);    //metemos el primero con un valor de repetidos 1

                }
            }

            //recorremos el hashmap
            boolean hayRepetidos = false;
            for (Map.Entry<String, Integer> entry : repetidos.entrySet()) {
                Integer valor = entry.getValue();
                // Hacer algo con cada valor
                if(valor>1){
                    System.out.print("El numero ("+entry.getKey()+") se ha repetido " + valor + " veces\n");
                    hayRepetidos = true;
                }
            }
            if(hayRepetidos == false){
                System.out.println("No se repite ningun objeto");
            }
        }else{
            System.out.println("No hay numeros en la lista\n");
        }
    }
    
    public static void CalcularSumas(){
        if(!ListaNumeros.isEmpty()){
            titulo("CALCULO DE SUMAS");
            int enteros=0;
            double racionales=0;
            double todos=0;
            for(int a=0;a<ListaNumeros.size();a++){
                todos+=ListaNumeros.get(a).getValor();
                if(ListaNumeros.get(a) instanceof Entero)
                    enteros+=ListaNumeros.get(a).getValor();
                else if(ListaNumeros.get(a) instanceof Racional)
                    racionales+=ListaNumeros.get(a).getValor();
            }

            System.out.println("Suma total de todos los numeros almacenados: "+todos);
            System.out.println("Suma total de todos los numeros enteros almacenados: "+enteros);
            System.out.println("Suma total de todos los numeros racionales almacenados: "+racionales);

        }else{
            System.out.println("No hay numeros en la lista");
        }
    }
    
    public static void TrabajarConEnteros(){
        boolean noEnteros=true;
        boolean solouno=true;
        for(int a=0;a<ListaNumeros.size();a++){
            if(ListaNumeros.get(a) instanceof Entero){
                if(noEnteros)
                    noEnteros=false;
                else
                    solouno=false;
            }
        }
        if(!noEnteros){
            try {
                int op = 0;
                do {
                    op = eligeopcion(1, 3, "\n----- Trabajar con ENTEROS --------------"
                            + "\n\t1-Mostrar divisores propios de todos los enteros"
                            + "\n\t2-Comprobar si dos enteros son amigos"
                            + "\n\t3-Salir"
                            + "\n>Elige opcion: ");

                    switch (op) {
                        case 1:
                            MostrarDivisores();
                            break;
                        case 2:
                            if(!solouno)
                                ComprobarAmigos();
                            else
                                System.out.println(" [ SE NECESITA MAS DE UN ENTERO ]");
                            break;
                        default:
                            break;
                    }
                } while (op != 3);
            } catch (java.util.InputMismatchException ex) {
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
                sc.nextLine();
            }
        }else{
            System.out.println("No hay numeros enteros");
        }
    }

    private static void MostrarDivisores() {
        for(int a=0;a<ListaNumeros.size();a++){
            if(ListaNumeros.get(a) instanceof Entero e){
                System.out.println("Posición: "+a+" Entero: "+Math.abs((int)e.getValor())+" -> "+e.getDivisoresPropios()+" = "+e.getSumDivPropios());
            }
        }
    }

    private static void ComprobarAmigos() {
        int entero1 = 0;
        int entero2 = 0;
        
        do{
            MostrarTodo();
            entero1 = eligeopcion(1,ListaNumeros.size(),">Introduce la posición del entero: ")-1;
            sc.nextLine();
            if(!(ListaNumeros.get(entero1) instanceof Entero))
                System.out.println(" [ DEBE SER UN NUMERO ENTERO ] ");
        }while(!(ListaNumeros.get(entero1) instanceof Entero));
        
        do{
            MostrarTodo();
            entero2 = eligeopcion(1,ListaNumeros.size(),">Introduce la posición del otro entero: ")-1;
            sc.nextLine();
            if(!(ListaNumeros.get(entero2) instanceof Entero))
                System.out.println(" [ DEBE SER UN NUMERO ENTERO ] ");
            else if(entero2==entero1)
                System.out.println(" [ DEBEN SER DISTINTOS ]");
        }while((entero2==entero1)||!(ListaNumeros.get(entero2) instanceof Entero));
        
        Entero e1=(Entero)ListaNumeros.get(entero1);
        Entero e2=(Entero)ListaNumeros.get(entero2);
        
        int v1=Math.abs((int) e1.getValor());
        int v2=Math.abs((int) e2.getValor());
        int d1=Math.abs((int) e1.getSumDivPropios());
        int d2=Math.abs((int) e2.getSumDivPropios());
        
        System.out.println("\nDivisores propios ("+v1+"): "+e1.getDivisoresPropios()+" = "+d1);
        System.out.println("Divisores propios ("+v2+"): "+e2.getDivisoresPropios()+" = "+d2);
        
        if((v1 == d2)&&(v2 == d1)){
            System.out.println("\nLos números "+v1+" y "+v2+" son amigos");
        }else{
            System.out.println("Los números "+v1+" y "+v2+" NO son amigos");
        }
    }
    
    private static void TrabajarConRacionales(){
        boolean noRacionales=true;
        for(int a=0;a<ListaNumeros.size();a++){
            if(ListaNumeros.get(a) instanceof Racional)
                noRacionales=false;
        }
        
        if(!noRacionales){
            try {
                int op = 0;
                do {
                    op = eligeopcion(1, 3, "\n----- Trabajar con RACIONALES --------------"
                            + "\n\t1-Mostrar todos los racionales"
                            + "\n\t2-Averiguar la fraccion de un racional"
                            + "\n\t3-Salir"
                            + "\n>Elige opcion: ");

                    switch (op) {
                        case 1:
                            MostrarRacionales();
                            break;
                        case 2:
                            FraccionRacional();
                            break;
                        default:
                            break;
                    }
                } while (op != 3);
            } catch (java.util.InputMismatchException ex) {
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
                sc.nextLine();
            }
        }else{
            System.out.println("No hay numeros racionales");
        }
    }

    private static void MostrarRacionales() {
        titulo("NUMEROS RACIONALES");
        for(int a=0;a<ListaNumeros.size();a++){
            if(ListaNumeros.get(a) instanceof Racional)
                System.out.println("["+(a+1)+"] "+ListaNumeros.get(a).toString());
        }
    }

    private static void FraccionRacional() {
        int r = 0;
        
        do{
            MostrarTodo();
            r = eligeopcion(1,ListaNumeros.size(),">Introduce la posición del racional: ")-1;
            sc.nextLine();
            if(!(ListaNumeros.get(r) instanceof Racional))
                System.out.println(" [ DEBE SER UN NUMERO RACIONAL ] ");
        }while(!(ListaNumeros.get(r) instanceof Racional));
        String svalor = ""+ListaNumeros.get(r).getValor();
        int ndecimales = (svalor.substring(svalor.indexOf("."))).length()-1;
        double divisor = Math.pow(10, ndecimales);
        int valor =(int)ListaNumeros.get(r).getValor();
        int dividendo = (int)(Math.abs(valor)*divisor)+Integer.parseInt(svalor.substring(svalor.indexOf(".")+1));
        int MCD=euclides(dividendo,(int)divisor);
            
        System.out.println("\nFracción: "+dividendo+" / "+divisor);
        System.out.println("MCD: "+MCD);
        System.out.println("Fracción simplificada: "+(dividendo/MCD)+" / "+(divisor/MCD));
        
    }

    public static int euclides(int e1, int e2){
        if(e1==e2){
            return e1;
        }else{
            if(e1>e2){
                return euclides((e1-e2),e2);
            }else{
                return euclides(e1,(e2-e1));
            }
        }
    }
    
    private static void MostrarIntroducidos() {
        
        System.out.println("Se han creado "+Numero.getTotalN()+" numeros a lo largo del programa"
                + "\nde los cuales hay "+Entero.getTotalE()+" enteros y "+Racional.getTotalR()+" racionales.");
    }
}
