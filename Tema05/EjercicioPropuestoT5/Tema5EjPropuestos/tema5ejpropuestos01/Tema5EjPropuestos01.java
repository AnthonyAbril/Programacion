
package tema5ejpropuestos01;

public class Tema5EjPropuestos01 {

    public static void main(String[] args) {
        int a=1,b=2,c=3;
        
        if(a>=b&&a>=c)
        {
            System.out.println(a + " es el mayor");
        }
        else if(b>=a&&b>=c)
        {
            System.out.println(b + " es el mayor");
        }
        else if(c>=a&&c>=b)
        {
            System.out.println(c + " es el mayor");
        }
        
        if(a<=b&&a<=c)
        {
            System.out.println(a + " es el menor");
        }
        else if(b<=a&&b<=c)
        {
            System.out.println(b + " es el menor");
        }
        else if(c<=a&&c<=b)
        {
            System.out.println(c + " es el menor");
        }
    }
    
}
