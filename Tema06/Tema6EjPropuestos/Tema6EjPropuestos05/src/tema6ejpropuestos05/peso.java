
package tema6ejpropuestos05;

/**
 *
 * @author abril
 */
import java.util.Scanner;

public class peso {
    double Kg;  //Tendrá un atributo donde se almacene el peso de un objeto en Kg. 
    
    peso(double p, String medida){
        //En el constructor se le pasará el peso y la medida en la que se ha tomado.
        if(medida.equals("Lb")){
            //‘Lb’ para Libras (1 Libra = 0.453 kilogramos)
            Kg = p*0.453d;
        }
        else if(medida.equals("Li")){
            //‘Li’ para lingotes (1 Lingote = 32,17 libras = 14,59 kg)
            Kg = p*14.59d;
        }
        else if(medida.equals("Oz")){
            //‘Oz’ para onzas (1 Onza = 0,0625 libras = 0.02835 kg)
            Kg = p*0.02835d;
        }
        else if(medida.equals("P")){
            //‘P’ para peniques (1 Penique = 0,05 onzas = 1,55 gramos)
            Kg = p*0.00155d;
        }
        else if(medida.equals("K")){
            //‘K’ para kilos 
            Kg = p;
        }
        else if(medida.equals("Q")){
            //‘Q’ para quintales (1 Quintal = 100 libras = 43,3 kg)
            Kg = p*43.3d;
        }
    }
    
    double getLibras(){
        //Devuelve el peso kg en libras. 
        return Kg*2.207d;
    }
    
    double getLingotes(){
        //Devuelve el peso kg en lingotes. 
        return Kg*0.0685d;
    }
    
    double getPeso(String medida){
        //Devuelve el peso kg en la medida que se le pase como parámetro (‘Lb’ para Libras, ‘Li’ para lingotes, ‘Oz’ para onzas, ‘P’ para peniques, ‘K’ para kilos, ‘G’ para gramos y ‘Q’ para quintales) 
        
        
        if(medida.equals("Lb")){
            //‘Lb’ para Libras (1 Libra = 0.453 kilogramos)
            return Kg*2.207d;
        }
        else if(medida.equals("Li")){
            //‘Li’ para lingotes (1 Lingote = 32,17 libras = 14,59 kg)
            return Kg*0.0685d;
        }
        else if(medida.equals("Oz")){
            //‘Oz’ para onzas (1 Onza = 0,0625 libras = 0.02835 kg)
            return Kg*35.335d;
        }
        else if(medida.equals("P")){
            //‘P’ para peniques (1 Penique = 0,05 onzas = 1,55 gramos)
            return Kg*645.1612d;
        }
        else if(medida.equals("K")){
            //‘K’ para kilos 
            return Kg;
        }
        else if(medida.equals("Q")){
            //‘Q’ para quintales (1 Quintal = 100 libras = 43,3 kg)
            return Kg*0.0231d;
        }
        return Kg;
    }
    
    
    public static void main(String[] args) {
        //Crea además un método main para testear y verificar los métodos de esta clase. 
        Scanner sc = new Scanner(System.in);
        peso pes;
        double p;
        String s;
        
        System.out.println("(Lb para Libras, Li para lingotes, Oz para onzas, P para peniques, K para kilos, G para gramos y Q para quintales)");
        System.out.print("Introduce la medida en la que introduciras el peso: ");
        s = sc.nextLine();
        System.out.print("Introduce el peso: ");
        p = sc.nextDouble();
        
        pes= new peso(p,s);
        
        System.out.println("Que quieres hacer?\n1-Ver el peso en libras\n2-Ver el peso en lingotes\n3-Elegir la medida con la que se quiere ver el peso");
        int opcion = sc.nextInt();
        if(opcion==1){
            System.out.println("El peso en libras es "+ pes.getLibras());
        }
        if(opcion==2){
            System.out.println("El peso en lingotes es " + pes.getLingotes());
        }
        if(opcion==3){
            System.out.print("Elige la medida en la que quieres recibir el peso: ");
            
            System.out.println("El peso es "+pes.getPeso(sc.nextLine()));
        }
    }
    
}
