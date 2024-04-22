
package figurasgeométricas;

public class Trapecio extends Figura{
    
    int Base;

    public Trapecio(int Base, int base, int altura) {
        super(base, altura);
        this.Base = Base;
    }
    
    @Override
    double getArea() {
        return ((Base+base)*altura)/2;
    }

    @Override
    double getPerimetro() {
        int cateto=(Base-base)/2;
        double hipotenusa;
        hipotenusa = Math.sqrt((Math.pow(cateto, 2))+(Math.pow(altura, 2)));
        return base+hipotenusa+hipotenusa+Base;
    }

    public int getBase() {
        return Base;
    }

    public void setBase(int Base) {
        this.Base = Base;
    }

    @Override
    public String toString() {
        return "\na. Tipo de figura: trapecio"+
               "\nb. Datos: "
                + "\n\tbase: " + base+", altura: " + altura+", Base: " + Base+
               "\nc. Área: " + getArea()+
               "\nd. Perímetro: " + getPerimetro();
    }
    
    @Override
    public void Dibujar(){
        int s = (int) (Math.random()*5+1);
        String simbolo = simbolos.get(s);
        
        for(int a=altura;a>0;a--){//filas
            //System.out.print(altura-a+1);
            for(int b=a-1;b>-1;b--){//espacios
                System.out.print(" ");
            }
            for(int c=1;c<(base+altura-(a-1)+(altura-(a)));c++){//simbolo
                System.out.print(simbolo);
            }
            System.out.println("");
        }
    }
}
