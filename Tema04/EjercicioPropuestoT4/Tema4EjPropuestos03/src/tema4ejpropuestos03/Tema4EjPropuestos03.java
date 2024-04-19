
package tema4ejpropuestos03;

public class Tema4EjPropuestos03 {

    public static void main(String[] args) {
        int numero = 2;
        int cuad = numero * numero;
        System.out.println("EL CUADRADO DE " +numero+ " ES: "  +
        cuad);
        //La linea que declaraba la variable numero no cerraba con ;
        //Se usa la variable cuad sin haber sido declarada previamente y llama a la variable numero como "número"
        //Al imprimir el resultado las comillas estaban mal colocadas y se llama a la variable numero como "NUMERO"
        //La variable numero al ser declarada estaba mal escrita como "nunero"
    }
    
}
