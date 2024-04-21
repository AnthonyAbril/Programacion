
package ejresuelto8;

import java.util.Scanner;

public class operaciones {
    int  A, B;
    
    public void constructor(int v1,int v2){
        A = v1;
        B = v2;
    }
    
    public void sumar(){
        System.out.println(A+B);
    }
    public void restar(){
        System.out.println(A-B);
    }
    public void multiplicar(){
        System.out.println(A*B);
    }
    public void dividir(){
        System.out.println((double)A/B);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        operaciones op = new operaciones();
        int a ,b=0;
        
        do{
            System.out.print("Introduzca un numero: ");
            a = sc.nextInt();
            System.out.print("Introduzca otro numero: ");
            b = sc.nextInt();
            op.constructor(a,b);
        }while(b==0);
        
        op.sumar();
        op.restar();
        op.multiplicar();
        op.dividir();
    }
}
