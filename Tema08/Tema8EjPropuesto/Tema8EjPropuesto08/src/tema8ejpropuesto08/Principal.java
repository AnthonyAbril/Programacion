
package tema8ejpropuesto08;

public class Principal {

    public static void main(String[] args) {
        //Realiza un programa que cree un vector de 100 posiciones con números aleatorios entre 10
        //y 80. Una vez creado el vector el programa deberá mostrar el valor que más se repite.
        
        int [] m = new int[100];
        
        for(int a=0;a<m.length;a++){
            m[a]=(int) (Math.random()*80+10);
        }
        //primero contamos cuantos valores unicos hay y luego hacemos un array con esa cantidad y vamos poniendo uno en cada
        int [] contar = new int[91];
        
        for(int a=0;a<m.length;a++){
            contar[m[a]]++;
        }
        
        //buscamos cual es el que mas tiene
        int max=0;
        for(int b=0;b<contar.length;b++){//sacamos el maximo
            if(contar[b]>max){
                max=contar[b];
            }
        }
        
        for(int b=0;b<contar.length;b++){//buscamos la casilla que coincida con el numero maximo y mostramos el numero de casilla
            if(contar[b]==max){
                System.out.println("El valor que mas se repite es "+b);
            }
        }
    }
    
}
