
package tema8ejpracticos04;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int [][] a = new int[4][4];
        Scanner sc = new Scanner(System.in);
        
        //introducir numeros en matriz
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a.length-1;b++){
                //poner System.out.print("Introduce el numero: ");
                //poner a[ext][b]=sc.nextInt();
                a[ext][b]=(int) (Math.random()*9+1);
            }
        }
        
        //mostrar numeros de matriz
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a[ext].length-1;b++){
                System.out.print(a[ext][b]+" ");
            }
            System.out.println("(Fila " + (ext+1) + " )");
        }
        
        //Mostrar la suma de una fila que se pedirá al usuario (controlar que elija una fila correcta
        int fila = 1;
        do{
            System.out.print("\nMuestra la suma de la fila: ");
            fila = sc.nextInt();
            
            if(fila<5&&fila>0){
                int suma=0;
                for(int columna=0;columna<=a.length-1;columna++){
                    suma = suma+a[fila-1][columna];
                }
                System.out.println(suma);
            }
        }while(fila<1||fila>4);
        
        //Mostrar la suma de una columna que se pedirá al usuario (controlar que elija una columna correcta).
        int columna = 1;
        do{
            System.out.print("\nMuestra la suma de la columna: ");
            columna = sc.nextInt();
            
            if(columna<5&&columna>0){
                int suma=0;
                for(int f=0;f<=a.length-1;f++){
                    suma = suma+a[f][columna-1];
                }
                System.out.println(suma);
            }
        }while(columna<1||columna>4);
        
        
        //Mostrar la suma de la diagonal principal.
        System.out.println("\nSuma diagonal principal");

        int suma=0;
        
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a[ext].length-1;b++){
                
                if(ext==b){
                    suma = suma + a[ext][b];
                }
                
            }
        }
        System.out.println(suma + "\n");
        
        
        //Mostrar la suma de la diagonal inversa.
        System.out.println("\nSuma diagonal inversa");

        suma=0;
        
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a[ext].length-1;b++){
                
                if(a.length-ext==b){
                    suma = suma + a[ext][b];
                }
                
            }
        }
        System.out.println(suma + "\n");

        
        //Mostrar la media de todos los valores de la matriz.
        System.out.println("\nMedia de todos los valores de la matriz");

        suma=0;
        int contador=0;
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a[ext].length-1;b++){
                suma = suma + a[ext][b];
                contador++;
            }
        }
        System.out.println(((float) suma/(contador)) + "\n");
        
        
        
        //Mostrar la suma de la diagonal inferior. (no lo pide)
        System.out.println("\nSuma diagonal inferior");

        suma=0;
        
        for (int ext=0;ext<=a.length-1;ext++){
            for (int b=0;b<=a[ext].length-1;b++){
                
                if(ext>b){
                    suma = suma + a[ext][b];
                }
                
            }
        }
        System.out.println(suma + "\n");
    }
    
}
