
package tema6ejpropuestos01;

import java.util.Scanner;

public class Viajero {

    private String dni, nombre, apellidos, nacionalidad, direccion;
    
    private static int numViajeros;
    
    //constructor con valores por defecto ej5
    public Viajero(){
        dni = "12345678A";
        nombre = "Desconocido";
        apellidos = "Desconocido";
        nacionalidad = "Desconocida";
        direccion = "Desconocida";
        numViajeros++;
    }
    
    
    //constructor con valores definidos ej5
    public Viajero(String a, String b, String c, String d, String e){
        dni = a;
        nombre = b;
        apellidos = c;
        nacionalidad = d;
        direccion = e;
        numViajeros++;
    }
    
    public static int getNumViajeros(){
        return numViajeros;
    }
    
    //ej2
    public String getDni (){
        return dni;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setDni(String dni){
        this.dni = dni;
    }
    
    public void setNombre(String a){
        nombre = a;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }
    
    public void setDireccion(String nacionalidad){
        this.nacionalidad=nacionalidad;//this.nacionalidad se refiere a la nacionalidad creada en esta clase mientras que nacionalidad a secas se refiere al creado en el parametro de setDireccion
    }
    
    public void getInfo(String formato){
        Scanner sc = new Scanner(System.in);
        if(formato.equals("normal")){
            System.out.println("DNI: "+ dni);
            System.out.println("Nombre: "+ nombre);
            System.out.println("Apellidos: "+ apellidos);
            System.out.println("Nacionalidad: "+ nacionalidad);
            System.out.println("Direccion: "+ direccion);
        }
        else if(formato.equals("pausado")){//el sc.nextLine hace q espere a q des intro para pasar a la siguiente linea
            System.out.println("DNI: "+ dni);
            sc.nextLine();
            System.out.println("Nombre: "+ nombre);
            sc.nextLine();
            System.out.println("Apellidos: "+ apellidos);
            sc.nextLine();
            System.out.println("Nacionalidad: "+ nacionalidad);
            sc.nextLine();
            System.out.println("Direccion: "+ direccion);
            sc.nextLine();
        }
        else{
            System.out.println("La forma de mostrar la informacion no es correcta");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Viajero v1 = new Viajero();
        
        Viajero v2 = new Viajero("98765432A","tony","abril rueda","Española", "Av circuncision");
        
        v1.setNombre("Rodrigo");
        
        v1.getInfo("pausado");
        System.out.println("**************");
        v2.getInfo("normal");
        System.out.println("**************");
        System.out.println("Numero de viajeros:" + Viajero.getNumViajeros());
    }
    
}
