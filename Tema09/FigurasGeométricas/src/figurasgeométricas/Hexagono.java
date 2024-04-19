
package figurasgeométricas;

public class Hexagono extends Figura{
    
    public Hexagono(int base, int altura) {
        super(base, altura);
    }
    
    @Override
    double getArea() {
        return ((getPerimetro())*(altura/2))/2;
    }

    @Override
    double getPerimetro() {
        return base*6;
    }
    
    @Override
    public String toString() {
        return "\na. Tipo de figura: hexágono"+
               "\nb. Datos: "
                + "\n\tbase: " + base+", altura: " + altura+
               "\nc. Área: " + getArea()+
               "\nd. Perímetro: " + getPerimetro();
    }
    
    @Override
    public void Dibujar(){
        int s = (int) (Math.random()*5+1);
        String simbolo = simbolos.get(s);
        
        if(base%2==0){
            //System.out.print("base par");
            if(altura%2==0){
                //System.out.println(" altura par");
                for(int a=altura/2;a>0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
            }else{
                //System.out.println(" altura impar");
                for(int a=altura/2;a>=0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
            }
        }else{
            //System.out.print("base impar");
            if(altura%2==0){
                //System.out.println(" altura par");
                for(int a=(altura/2);a>0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
                for(int a=0;a<altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=1;c<(base-(a+1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
            }else{
                //System.out.println(" altura imppar");
                for(int a=altura/2;a>=0;a--){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a;b>0;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=2;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
                for(int a=1;a<=altura/2;a++){//filas
                    //System.out.print(altura-a+1);
                    for(int b=a-1;b>-1;b--){//espacios
                        System.out.print(" ");
                    }
                    for(int c=2;c<(base-(a-1)+(altura-(a)));c++){//simbolo
                        System.out.print(simbolo);
                    }
                    System.out.println("");
                }
            }
        }
    }
}
