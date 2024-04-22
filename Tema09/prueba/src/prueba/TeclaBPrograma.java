
package prueba;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TeclaBPrograma extends JFrame implements KeyListener {
    private JLabel etiqueta;
    
    public TeclaBPrograma() {
        etiqueta = new JLabel("Texto oculto");
        add(etiqueta);
        addKeyListener(this);
        setSize(300,200);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'b'){
            etiqueta.setText("Has presionado la tecla b!");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        
    }
    @Override
    public void keyReleased(KeyEvent e){
        
    }
    
    public static void main(String[] args){
        new TeclaBPrograma();
    }
}