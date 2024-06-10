
package recursividad1;

public class Recursividad1 {
    public static int n=5;
    public static void main(String[] args) {
        //Realiza una clase con dos métodos que generen el factorial de un número pasado por
        //parámetro, de la siguiente forma:
            //● método factorial_recursivo
            //● método factorial_iterativo
            //● método main que pruebe ambos métodos anteriores
            System.out.println(""+factorial_recursivo(5));
    }
    
    public static int factorial_recursivo(int n){
        int resultado;
        if(n==1){//caso base
            resultado= 1;
        }else{//caso general
            resultado=n*factorial_recursivo(n-1);
        }
        return resultado;
    }
        
    public static void factorial_iterativo(){
        for(int a=0;a<n;a++){
            a=a*(n-1);
            System.out.println(a);
        }
    }
}
