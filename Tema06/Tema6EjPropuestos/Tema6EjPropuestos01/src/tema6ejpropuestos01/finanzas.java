
package tema6ejpropuestos01;
/**
 *
 * @author abril
 */
import java.util.Scanner;

// conversiones entre euros y dólares
public class finanzas {
    double cambio;
    
    public finanzas(){
        //constructor q establecerá el cambio Dólar-Euro en 1.36
        cambio = 1.36;
    }
    
    public finanzas(double a){
        //constructor q permitirá configurar el cambio dólar-euro
        cambio = a;
    }
    
    public double dolaresToEuros(double a){
        return a/cambio;
    }
    
    public double eurosToDolares(double a){
        return a*cambio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int conversion=0;
        int establecer=0;
        finanzas f;
        
        System.out.println("Que conversion quieres hacer?\n1- De dolares a euros\n2- De euros a dolares");
        do{
            conversion=sc.nextInt();
        }while((conversion<1)||(conversion>2));
        
        System.out.println("Establecer cambio?\n1- Si\n2- No");
        do{
            establecer=sc.nextInt();
        }while((establecer<1)||(establecer>2));
        
        
        if(establecer==1){
            double a;
            System.out.print("Establece cambio: ");
            a = sc.nextDouble();
            f = new finanzas(a);
        }
        else{
            f = new finanzas();
        }
        
        System.out.print("Introduce la cifra a cambiar: ");
        double cifra = sc.nextDouble();
        
        
        if(conversion==1){
            System.out.printf("%.2f€",f.dolaresToEuros(cifra));
        }
        else if(conversion==2){
            System.out.printf("%.2f$",f.eurosToDolares(cifra));
        }
    }
}
