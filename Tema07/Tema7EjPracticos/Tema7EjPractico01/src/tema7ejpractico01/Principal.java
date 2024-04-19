
package tema7ejpractico01;

public class Principal {

    public static void main(String[] args) {
        Fecha f1 = new Fecha(25, 1, 2024);
        Hora h1 = new Hora (15,5);
        
        Examen e1 = new Examen("Programacion","14",f1,h1);
        
        System.out.println(e1.toString());
        
        Fecha f2 = new Fecha(6,2,2024);
        Hora h2 = new Hora(14,20);
        
        e1.setFecha(f2);
        e1.setHora(h2);
        
        System.out.println(e1.toString());
    }
    
}
