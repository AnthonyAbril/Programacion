
package pg;


public class PG {

    static int X=1;
    static int Y=1;
    public static void main(String[] args) {
        //Ventana ventana;
        //ventana = new Ventana();
        //ventana.setVisible(true);
        print();
    }
    
    public static void print(){
        int altura=30;
        int anchura=30;
        for(int a=0; a<=altura;a++){
            for(int b=0;b<=anchura;b++){
                if(b==0||b==anchura||a==0||a==altura){
                    System.out.print("*");
                }else{
                    if(b==X&&a==Y){
                        System.out.print("#");
                    }else{
                        System.out.print(fondo(b,a));
                    }
                }
            }
            System.out.println("");
        }
    }
   
    
    public static String fondo(int x, int y){
        if((x%2==0&&y%2==0)||(x%2!=0&&y%2!=0)){
            return ("\\");
        }else{
            return ("/");
        }
    }
    
}
