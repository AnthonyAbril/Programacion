/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

/**
 *
 * @author alumnot
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Imprimir(9,4);//hecho
        
    }
    
    public static void Imprimir(int altura, int base){
        if(base%2==0){
            System.out.print("base par");
            if(altura%2==0){
                System.out.println(" altura par");
                for(int a=altura/2;a>0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
            }else{
                System.out.println(" altura impar");
                for(int a=altura/2;a>=0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
            }
        }else{
            System.out.print("base impar");
            if(altura%2==0){
                System.out.println(" altura par");
                for(int a=(altura/2);a>0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                for(int a=0;a<altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a+1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
            }else{
                System.out.println(" altura imppar");
                for(int a=altura/2;a>=0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a;b>0;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=2;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=2;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print("*");
                    }
                    System.out.println("");
                }
            }
        }
    }
}
