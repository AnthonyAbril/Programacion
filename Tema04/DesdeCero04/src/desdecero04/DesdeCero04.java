
package desdecero04;

public class DesdeCero04 {
    
    public static void main(String[] args) {
        int A=2, B=3, C=4, D=5, aux;
        
        aux=B;
        B=C;
        C=A;
        A=D;
        D=aux;
        System.out.println(A + ", " + B  + ", " + C + ", " + D);
    }
    
}
