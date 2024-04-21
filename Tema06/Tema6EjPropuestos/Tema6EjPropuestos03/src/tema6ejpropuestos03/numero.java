
package tema6ejpropuestos03;

/**
 *
 * @author abril
 */
import java.util.Scanner;

public class numero {
    int entero;
    
    public numero(){
        //Constructor por defecto que inicializa a 0 el número interno.
        entero=0;
    }
    
    public numero(int a){
        //Constructor que inicializa el número interno.
        entero=a;
    }
    
    public void anyade(int a){
        //Método anyade que permite sumarle un número al valor interno.
        entero=entero+a;
    }
    
    public void resta(int a){
        //Método resta que resta un número al valor interno.
        entero=entero-a;
    }
    
    public int getValor(){
        //Método getValor que devuelve el valor interno.
        return entero;
    }
    
    public int getDoble(){
        //Método getDoble que devuelve el doble del valor interno.
        return entero*2;
    }
    
    public int getTriple(){
        //Método getTriple que devuelve el triple del valor interno.
        return entero*3;
    }
    
    public void setNumero(int a){
        //Método setNumero que inicializa de nuevo el valor interno.
        entero=a;
    }

    public static void main(String[] args) {
        numero n1;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuieres introducir un valor al numero?\n1-Si\n2-No");
        int introducir = 0;
            do{
                introducir = sc.nextInt();
            }while(introducir<1||introducir>2);
        
        if(introducir==1){
            System.out.print("\nIntroduce el numero: ");
            int a = sc.nextInt();
            n1=new numero(a);
        }
        else{
            n1=new numero();
        }
        
        
        int terminar=1;
        do{
            int hacer= 7;
            
            do{
                System.out.println("\nQue quieres hacer?\n1-Añadir\n2-Restar\n3-Mostrar valor\n4-Mostrar el doble del valor\n5-Mostrar el triple del valor\n6-Cambiar valor del numero");

                hacer=sc.nextInt();
                if(hacer==1){
                    int a = sc.nextInt();
                    n1.anyade(a);
                }
                if(hacer==2){
                    int a = sc.nextInt();
                    n1.resta(a);
                }
                
                if(hacer==3)
                    System.out.println("--> "+n1.getValor());
                if(hacer==4)
                    System.out.println("--> "+n1.getDoble());
                if(hacer==5)
                    System.out.println("--> "+n1.getTriple());

                if(hacer==6){
                    int a = sc.nextInt();
                    n1.setNumero(a);
                }
            }while(hacer<1||hacer>6);
            
            System.out.println("\nQuieres terminar el programa?\n(presiona 1 para seguir o cualquier otro numero para terminar)");
            terminar=sc.nextInt();
            
        }while(terminar==1);
    }
    
}
