
package arbol;

public class Arbol {

    public static void main(String[] args) {
        int lineas = 5;
        int contador = 1;
        for (int i = 1; i <= lineas; i++) {
            contador++;
            for (int j = 1; j <= contador; j++) {
                for(int e=contador-j;e>0;e--)//espacios
                {
                    System.out.print(" ");
                }
                
                for(int g=lineas-contador;g>=0;g--)
                {
                    System.out.print(" ");
                }
                
                for (int k = (j+(j-1)); k > 0; k--) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }
        for(int c=2;c>0;c--)
        {
            for(int a=lineas;a>1;a--)
            {
                   System.out.print(" ");
            }
            for(int b=3;b>0;b--)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
