
package examen3ev;


import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream{
    //Sobrescribimos el método que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException{
        //no hacer nada (para que no escriba la cabecera)
    }
    
    //constructores
    public MiObjectOutputStream() throws IOException{
        super();
    }
    
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
}
