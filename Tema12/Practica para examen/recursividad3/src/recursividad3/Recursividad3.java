
package recursividad3;

public class Recursividad3 {

    public static void main(String[] args) {
        int ancho=5;
        int alto=5;
        for(int x=1;x<ancho;x++){
            for(int y=1;y<alto;y++)
                System.out.print(matriz(x,y));
            System.out.println("");
        }
    }
    
    public static int matriz(int x, int y){
        if(x<=1||y<=1)
            return 1;
        else
            return matriz(x-1,y)+matriz(x,y-1);
    }
}
