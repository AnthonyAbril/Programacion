
package salondevideojuegos;

public class Test {

    public static void main(String[] args) {
        
        JuegoEnAlquiler ja1 = new JuegoEnAlquiler("Mario Bros", "Nintendo", 1986, 5.0d, 10, 2);
        JuegoEnVenta jv1 = new JuegoEnVenta("Mario Bros", "Nintendo", 1986, 40.0d, 10);
        Juego jv2 = new JuegoEnVenta("Mario Bros", "Nintendo", 1985, 35.0d, 10);
        
        //Crea una copia de ja1 (ja2).
        JuegoEnAlquiler ja2 = new JuegoEnAlquiler(ja1);
        
        //Muestra en pantalla el número total de juegos del salón
        presentacion("NÚMERO TOTAl DE JUEGOS DEL SALÓN");
        System.out.println("Actualmente hay " + ja1.getNtotal() + " Juegos en el salon\n");
        
        //Alquila ja1 (después muestra por pantalla el resultado)
        ja1.alquilar();
        presentacion("SE HA ALQUILADO "+ ja1.titulo);
        System.out.println(ja1.toString());
        
        //Devuelve ja1 (después muestra por pantalla el resultado)
        ja1.devolver();
        presentacion("SE HA DEVUELTO "+ ja1.titulo);
        System.out.println(ja1.toString());
        
        //Comprueba si ja1 y jv1 son iguales, y muestra un mensaje que lo indique
        presentacion("SON IGUALES ja1 Y jv1?");
        System.out.println(ja1.equals(jv2) ? "son iguales" : "no son iguales");
        
        //Comprueba si ja1 y jv2 son iguales, y muestra un mensaje que lo indique
        presentacion("SON IGUALES ja1 Y ja2?");
        System.out.println(ja1.equals(ja2) ? "son iguales" : "no son iguales");
        
        //Compara jv1 con jv2 y muestra un mensaje que indique cuál es mayor, o si son iguales.
        presentacion("COMPARACION ENTRE jv1 Y jv2");
        System.out.print("jv1 es ");
        if(jv1.compareTo(jv2)==1){
            System.out.print("mayor");
        }
        else if(jv1.compareTo(jv2)==-1){
            System.out.print("menor");
        }
        else{
            System.out.print("igual");
        }
        System.out.println(" que jv2");
        
        //Compara ja1 con jv1 y muestra un mensaje que indique cuál es mayor, o si son iguales.
        presentacion("COMPARACION ENTRE ja1 Y jv1");
        System.out.print("ja1 es ");
        if(ja1.compareTo(jv1)==1){
            System.out.print("mayor");
        }
        else if(ja1.compareTo(jv1)==-1){
            System.out.print("menor");
        }
        else{
            System.out.print("igual");
        }
        System.out.println(" que jv1");
    }
    
    static public void presentacion (String s){
        System.out.println("\n\t"+s);
        for(int a=1;a<=100;a++){
            System.out.print("*");
        }
        System.out.println("");
    }
    
}
