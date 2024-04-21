
package tema12ejpracticos06;

import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream{
    //Sobrescribimos el método que crea la cabecera
    @Override
    protected void writeStreamHeader() throws IOException {
        // No hacer nada.
    }
    
    //Constructores
    public MiObjectOutputStream () throws IOException{
        super();
    }
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
