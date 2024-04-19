
package tema8ejpracticos02;

public class Tema8EjPracticos02 {

    public static void main(String[] args) {
        //Realiza un programa que cree un vector de 100 posiciones con números aleatorios entre 10
        //y 80. Una vez creado el vector el programa deberá mostrar el mayor, el menor y la media
        
        
        //Realiza un programa que cree un vector de 100 posiciones
        int [] a = new int[100];
        
        //con números aleatorios entre 10 al 80
        for(int cont=0;cont<=a.length-1;cont++){
            a[cont]=(int) (Math.random()*80+10);
            System.out.println(a[cont]);
        }
    }
    
}
