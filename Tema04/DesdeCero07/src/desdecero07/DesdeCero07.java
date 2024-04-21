
package desdecero07;

public class DesdeCero07 {

    public static void main(String[] args) {
        int C = 36;
        System.out.println(C>-1 ? "positivo" : "negativo");
        System.out.println((C%2==0 ? "par": "impar"));
        System.out.println((C%5==0 ? "es multiplo de 5": "no es multiplo de 5"));
        System.out.println((C%10==0 ? "es multiplo de 10": "no es multiplo de 10"));
        System.out.println(C>100 ? "Es mayor que 100" : "Es menor que 100");
    }
    
}
