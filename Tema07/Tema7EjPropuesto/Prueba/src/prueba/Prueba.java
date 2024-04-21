
package prueba;

public class Prueba {

    public static void main(String[] args) {
        
        String c1 = "La casa es verde y la cochera azul";
        
        System.out.println("Hay "+contar(c1)+ " palabras");
    }
    
    public static int contar (String a){
        System.out.println();
        
        String palabra = a.toLowerCase();//minusculas
        
        String [] h = palabra.split(" "); 
        int numero=0;
        
        for(int b=0;b<=h.length-1;b++){
            System.out.println(b + " " + h[b]);
            numero++;
        }
        
        return numero;
    }
    
}
