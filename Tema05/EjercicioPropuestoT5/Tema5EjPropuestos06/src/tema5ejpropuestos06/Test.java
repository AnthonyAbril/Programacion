
package tema5ejpropuestos06;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        
        Random rnd = new Random(); 
        int valor= rnd.nextInt(101) + 100;
        
        if(valor%2==0)
        {
            System.out.println(valor+" es par");
        }
        else
        {
            System.out.println(valor+" es impar");
        }
    }
    
}
