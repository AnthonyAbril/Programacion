
package tema8ejpropuesto07;

public class Principal {

    public static void main(String[] args) {
        //Realiza un método que tome como parámetros de entrada dos arrays de enteros y devuelva
        //como salida un único array con los elementos de los anteriores arrays ordenados de forma
        //ascendente.

        int[] m1 = {1,3,4,1,35};
        int[] m2 = {2,3,3,-4,32};
        
        System.out.println("El array es ");
        for(int a=0;a<m1.length+m2.length;a++){//mostramos los valores
            System.out.print((ordenado(m1,m2)[a])+" ");
        }
        System.out.println("");
    }
    
    public static int[] ordenado(int[] m1, int[] m2){
        int[] m3 = new int[m1.length+m2.length];
        
        for(int a=0;a<m3.length;a++){//metemos en m3 los valores de m1 y m2
            if(a<m1.length){
                m3[a]=m1[a];//metemos en m3 los valores de m1
            }
            else{
                m3[a]=m2[a-m1.length];//metemos en m3 los valores de m2
            }
        }
        
        java.util.Arrays.sort(m3);//ordenamos los valores
        
        return m3;
    }
    
}
