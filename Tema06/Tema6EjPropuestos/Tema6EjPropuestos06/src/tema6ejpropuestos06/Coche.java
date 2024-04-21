
package tema6ejpropuestos06;

/**
 *
 * @author abril
 */
public class Coche {

    String marca;
    String modelo;
    
    
    Coche(){
        marca="BMW";
        modelo="Serie 1";
    }
    Coche(String ma, String mo){
        marca=ma;
        modelo=mo;
    }
    
    public static void main(String[] args) {
        Coche c1 = new Coche();
        Coche c2 = new Coche("Mercedes-Benz","Clase G");
        
        System.out.println("El primer coche es de marca "+c1.marca+" de modelo "+ c1.modelo);
        System.out.println("El segundo coche es de marca "+c2.marca+" de modelo "+ c2.modelo);

    }
    
}
