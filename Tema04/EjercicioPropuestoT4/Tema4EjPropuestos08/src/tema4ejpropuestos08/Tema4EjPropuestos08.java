
package tema4ejpropuestos08;

public class Tema4EjPropuestos08 {

    public static void main(String[] args) {
        int resultado;
        char letra;
        boolean es_vocal;

        resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII
        letra = (char)resultado;
        if((letra=='A') || (letra=='E') || (letra=='I') || (letra=='O') || (letra=='U'))
        {
            es_vocal=true;
        }
        else
        {
            es_vocal=false;
        }

        System.out.println("Letra obtenida: " + letra);
        System.out.println("¿Es una vocal?: " + es_vocal );
        System.out.println("¿Es una consonante?: " + !es_vocal);
    }
    
}
