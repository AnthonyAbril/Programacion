
package ejresuelto9;

public class JuegodeDados {

    Dado d1;
    Dado d2;
    Dado d3;

    public void definir(){
        d1 = new Dado();
        d2 = new Dado();
        d3 = new Dado();
    }
    
    public void tirar(){
        d1.constructor();
        d2.constructor();
        d3.constructor();
        
        if((d1.dadoval==d2.dadoval)&&(d2.dadoval==d3.dadoval)){
            System.out.println("Has ganado!!");
        }
        else
        {
            System.out.println("Has perdido :(");
        }
        System.out.println(d1.dadoval+", "+d2.dadoval+", "+d3.dadoval);
    }
    
    public static void main(String[] args) {
        JuegodeDados j = new JuegodeDados();
        
        j.definir();
        j.tirar();
    }
    
}
