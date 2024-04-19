
package pkg8.pkg1;

public class Main {
        
    public static int[] m (int[] b){
        for(int c=0; c<b.length; c++){
            int a=(int)(Math.random()*25+1);
            b[c] = a;
        }
        return b;
    }
    
    public static void main(String[] args) {
        
        int [] a = new int[100];
        int total=0;
        
        a=m(a);
        
        for(int d=(a.length-1); d>0; d--){
            System.out.println(d+": "+a[d]);
            total=a[d]+total;
        }
        
        System.out.println("total"+total);
    }
    
}
