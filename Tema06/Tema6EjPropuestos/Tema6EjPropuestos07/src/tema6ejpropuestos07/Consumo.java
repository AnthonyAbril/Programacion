
package tema6ejpropuestos07;

/**
 *
 * @author abril
 */
import java.util.Scanner;

public class Consumo {

    float Kms; //Kilómetros recorridos por el coche.
    float litros; //Litros de combustible consumido.
    float vmed; //Velocidad media.
    float Pgas; //Precio de la gasolina

    public Consumo(float a, float b, float c, float d){
        Kms=a;
        litros=b;
        vmed=c;
        Pgas=d;
    }
    
    public float getTiempo() {
        //Indicará el tiempo empleado en realizar el viaje. 
        return (Kms/vmed);
    }
    
    public float consumoMedio() {
        //Consumo medio del vehículo (en litros cada 100 Km.) 
        return Kms*(litros/100);
    }
    
    public float consumoEuros() {
        //Consumo medio del vehículo (en euros cada 100 Km.)
        return Pgas*(litros/100);
    }
    
    public void setKms(float Kms) {
        this.Kms = Kms;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public void setVmed(float vmed) {
        this.vmed = vmed;
    }

    public void setPgas(float Pgas) {
        this.Pgas = Pgas;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        float Kms;
        float litros;
        float vmed;
        float Pgas;
        
        System.out.println("Introduzca los datos del coche:\n");
        System.out.print("Kilometros recorridos por el coche: ");
        Kms=sc.nextFloat();
        System.out.print("Litros de combustible consumido: ");
        litros=sc.nextFloat();
        System.out.print("Velocidad media: ");
        vmed=sc.nextFloat();
        System.out.print("Precio de la gasolina: ");
        Pgas=sc.nextFloat();
        
        Consumo c = new Consumo(Kms,litros,vmed,Pgas);
        
        int opcion;
        do{
            System.out.println("Que quieres ver?\n1-El tiempo empleado en realizar el viaje\n2-Consumo medio del vehiculo (en litros cada 100 Km)\n3-Consumo medio del vehiculo (en euros cada 100 Km)\n4-Cambiar valor de kilometros recorridos\n5-Cambiar valor de los litros consumidos\n6-Cambiar valor de la velocidad media\n7-Cambiar valor del precio del gas");
            System.out.println("Elige opcion: ");
            
            opcion = sc.nextInt();
            
            if(opcion==1){
                System.out.println("El viaje dura "+c.getTiempo()+" km/s");
            }
            if(opcion==2){
                System.out.println("El consumo medio del vehiculo en litros es " + c.consumoMedio());
            }
            if(opcion==3){
                System.out.println("El Consumo medio del vehiculo en euros es " + c.consumoEuros());
            }
            if(opcion==4){
                System.out.print("Indique el valor nuevo: ");
                c.setKms(sc.nextFloat());
            }
            if(opcion==5){
                System.out.print("Indique el valor nuevo: ");
                c.setLitros(sc.nextFloat());
            }
            if(opcion==6){
                System.out.print("Indique el valor nuevo: ");
                c.setPgas(sc.nextFloat());
            }
            if(opcion==7){
                System.out.print("Indique el valor nuevo: ");
                c.setVmed(sc.nextFloat());
            }
        }while(opcion>0&&opcion<8);
    }
    
}
