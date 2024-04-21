
package tema12ejpracticos04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Principal {

    //Crea una aplicación que copie un fichero binario a otra localización (pregunta al usuario por ambas rutas). 
    //En lugar de leer y escribir byte a byte, crea un array de bytes con el tamaño
    //del fichero de origen (utiliza el método available()), copia el contenido del fichero a este
    //array (usa el método int read(byte[ ] array) y escribe a partir de este array.
    
    //Recuerda que debes controlar las excepciones que puedan aparecer. En caso de error,
    //mostrar un mensaje con la información del error.
    
    static String origen,destino;
    
    public static void main(String[] args) {
        origen = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/binario.txt";
        destino = "/home/alumnot/NetBeansProjects/Tema12/Tema12EjPracticos/ficheros/copia_binario.txt";
        //origen = "C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\Tema12EjPracticos\\ficheros\\binario.bin";
        //destino = "C:\\Users\\abril\\OneDrive\\Documentos\\JAVA\\NetBeans\\3Evaluacion\\Tema12\\Tema12EjPracticos\\ficheros\\copia_binario.bin";
        
        copiadeficheros(origen,destino);
        
    }
    
    public static void copiadeficheros(String original, String copia){
        try{
            FileInputStream fis=new FileInputStream(original);
            FileOutputStream fos=new FileOutputStream(copia);
            
            byte[] a = new byte[fis.available()];
            
            fis.read(a);
            
            fos.write(a);
            
            fis.close();
            fos.close();
        }catch(IOException ex){
            System.out.println(">Error al copiar el contenido");
        }
    }
    
}
