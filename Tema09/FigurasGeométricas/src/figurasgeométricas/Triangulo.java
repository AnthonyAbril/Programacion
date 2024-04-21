
package figurasgeométricas;

public class Triangulo extends Figura{

    public Triangulo(int base, int altura) {
        super(base, altura);
    }
    
    @Override
    double getArea() {
        return (base*altura)/2;
    }

    @Override
    double getPerimetro() {
        double hipotenusa;
        hipotenusa = Math.sqrt((Math.pow(base, 2))+(Math.pow(altura, 2)));
        return base+hipotenusa+hipotenusa;
    }

    @Override
    public String toString() {
        return "\na. Tipo de figura: triángulo"+
               "\nb. Datos: "
                + "\n\tbase: " + base+", altura: " + altura+
               "\nc. Área: " + getArea()+
               "\nd. Perímetro: " + getPerimetro();
    }
    
    @Override
    public void Dibujar(){
        int s = (int) (Math.random()*5+1);
        String simbolo = simbolos.get(s);
        
        for(int a=altura;a>0;a--){//filas
            //System.out.print(altura-a+1);
            for(int b=a-1;b>0-1;b--){//espacios
                System.out.print(" ");
            }
            for(int c=1;c<(altura-(a-2)+(altura-(a)));c++){//simbolo
                System.out.print(simbolo);
            }
            System.out.println("");
        }
    }
}
