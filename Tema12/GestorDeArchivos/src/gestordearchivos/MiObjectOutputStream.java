/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestordearchivos;

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