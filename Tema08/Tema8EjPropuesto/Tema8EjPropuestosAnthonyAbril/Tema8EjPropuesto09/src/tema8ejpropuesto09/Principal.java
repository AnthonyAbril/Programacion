
package tema8ejpropuesto09;

public class Principal {

    public static void main(String[] args) {
        //Realiza un programa que cree un vector de 100 posiciones con números aleatorios entre 1 y
        //100. Una vez creado el vector el programa deberá ordenar el vector y mostrar los números
        //entre 1 y 100 que no han sido almacenados.
        
        int [] m = new int[100];
        
        for(int a=0;a<m.length;a++){
            m[a]=(int) (Math.random()*100+1);
        }
        
        java.util.Arrays.sort(m);
        
        System.out.println("Los numeros que no han sido almacenados son: ");
        for(int a=1;a<=100;a++){//recorremos numeros del 1 al 100
            boolean encontrado=false;
            for(int b=0;b<m.length;b++){//recorremos el array
                if(a==m[b]){
                    encontrado=true;
                }
            }
            if(encontrado==false){
                System.out.print(a+" ");
            }
        }
    }
    
}
