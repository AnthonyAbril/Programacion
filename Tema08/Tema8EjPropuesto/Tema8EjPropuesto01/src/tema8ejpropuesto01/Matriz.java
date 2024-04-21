
package tema8ejpropuesto01;

public class Matriz {

    int numFilas;
    int numColumnas;
    int m [][];
    
    //Constructor
    public Matriz() {
    }
    
    //solicitará por teclado el número de filas y de columnas que tendrá la matriz y la creará con esas dimensiones.
    public void solicitarTamanyo(int f, int c){
        numFilas = f;
        numColumnas = c;
        m = new int[f][c];
    }
    
    //rellenará la matriz con números al azar entre 1 y 100.
    public void asignarDatos(){
        for(int j=0;j<m.length;j++){
            for(int i=0;i<m[j].length;i++){
                m[j][i]=(int) (Math.random()*100+1);
            }
        }
    }

    //devolverá el número máximo de los que contenga la matriz.
    public int maximo(){
        int max=1;
        for(int j=0;j<m.length;j++){
            for(int i=0;i<m[j].length;i++){
                if(m[j][i]>max){
                    max=m[j][i];
                }
            }
        }
        
        return max;
    }

    //devolverá el número mínimo de los que contenga la matriz.
    public int minimo(){
        int min=100;
        for(int j=0;j<m.length;j++){
            for(int i=0;i<m[j].length;i++){
                if(m[j][i]<min){
                    min=m[j][i];
                }
            }
        }
        
        return min;
    }
    
    //sumará los valores de la propia matriz con los valores de una matriz pasada como argumento.
    public void suma(Matriz matriz){
        //Debe comprobar primero que ambas matrices tienen el mismo tamaño para poder sumarlas.
        
        for(int j=0;j<this.m.length;j++){
            for(int i=0;i<this.m[j].length;i++){
                this.m[j][i]=(this.m[j][i])+(matriz.m[j][i]);
            }
        }
    }
    
    //multiplicará los valores de la propia matriz con los valores de una matriz pasada como argumento.
    void producto(Matriz matriz){
        //Debe comprobar primero que ambas matrices son cuadradas y de igual tamaño para poder realizar la multiplicación
        //Para poder multiplicar las dos matrices, es necesario declarar una tercera matriz como variable local del método, para guardar el resultado. Pero al finalizar el algoritmo, se deberán volcar los valores de esta tercera matriz a la propia matriz
        //El algoritmo de multiplicación de matrices cuadradas lo encontrarás aquí.
        int c [][]= new int[this.m.length][this.m.length];
        
        for (int i=0; i<this.m.length; i++)
            for (int j=0; j<c.length; j++){
              c[i][j] = 0;
              for (int k=0; k<this.m.length; k++)
                c[i][j] += this.m[i][k] * matriz.m[k][j];
            }
        this.m=c;
    }
    
    //realizará la trasposición de la matriz.
    public void traspuesta(){
        //Debe comprobar primero que la matriz es cuadrada para poder realizarla.
        //También va a necesitar de una matriz auxiliar para hacer la trasposición, que luego deberá modificar la propia matriz.
        
        int c [][]= new int[this.m[0].length][this.m.length];
        
        for(int j=0;j<this.m.length;j++){
            for(int i=0;i<this.m.length;i++){
                c[j][i]=m[i][j];
            }
        }
        
        this.m=c;
    }
    
    //mostrará el contenido de la matriz.
    public void mostrarMatriz(){
        for(int j=0;j<m.length;j++){
            for(int i=0;i<m[j].length;i++){
                System.out.print(m[j][i]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public boolean isCuadrada(){
        if(numFilas==numColumnas){
            return true;
        }
        return false;
    }
    
    
}
