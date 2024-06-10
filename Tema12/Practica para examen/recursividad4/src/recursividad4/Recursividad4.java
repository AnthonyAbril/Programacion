
package recursividad4;

public class Recursividad4 {

    public static void main(String[] args) {
        int alto=4;
        
        for(int y=1;y<=alto;y++){
            int sx=1;
            for(int x=1;x<=alto+y;x++){
                if(x<alto-y+1){
                    System.out.print(" ");
                }else
                    if((x+y)%2!=0){
                        System.out.print(m(sx,y));
                        sx++;
                    }else
                        System.out.print(" ");
            }
            System.out.println("");
        }  
    }
    
    public static int m(int x, int y){
        int n=0;
        if(x<1||y<1)
            return 0;
        else
            if(y==1){
                return 1;
            }else{
                return m(x-1,y-1)+m(x,y-1);
            }
    }
}
