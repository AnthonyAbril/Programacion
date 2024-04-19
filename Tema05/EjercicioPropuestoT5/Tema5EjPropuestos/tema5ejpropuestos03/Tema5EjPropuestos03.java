
package tema5ejpropuestos03;

public class Tema5EjPropuestos03 {
    
    public static void main(String[] args) {
        int i, j, k, max=4;
        
        
        for (i = 1; i <= max; i++) { //bucle que cuenta hasta 10
            for (k = 1; k <= max-i; k++) {
            System.out.print( " ");
            }
            
            for (j = 1; j <= 2 * (i-1)+ 1; j++) {
            System.out.print( "*");
            }
            
            System.out.println( "");
        }
        
        for (i = max-1; i >= 1; i--) { //bucle que cuenta hasta 10
            for (k = 1; k <= max-i; k++) {
            System.out.print( " ");
            }
            
            for (j = 1; j <= 2 * (i-1)+ 1; j++) {
            System.out.print( "*");
            }
            
            System.out.println( "");
        }
    }
}
