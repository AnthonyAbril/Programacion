
package tema5ejpropuestos05;

public class Tema5EjPropuestos05 {

    public static void main(String[] args) {
        int tabla=1,j=1,num;
        
        
        for (tabla = 1; tabla <= 10; tabla++)
        {
            System.out.println("");
            System.out.println("Tabla del " + tabla);
            for (j = 1; j < 13; j++) {
            System.out.print( "*");
            }
            System.out.println("");
            
            num=0;
            for (num=1;num<11;num++)
            {
                System.out.println(tabla+" x "+num+ " = " + (tabla*num));
            }
        }
    }
    
}
