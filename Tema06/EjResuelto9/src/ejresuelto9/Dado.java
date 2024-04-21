/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejresuelto9;

/**
 *
 * @author alumnot
 */
public class Dado {
    int dadoval;
    
    public void constructor(){
        dadoval = (int)(Math.random()*6+1);
    }
    
    public void imprimidor(){
        System.out.println(dadoval);
    }
    
    public int retornador(){
        return dadoval;
    }
}
