
package figurasgeométricas;

public class Rectangulo extends Figura{
    
    public Rectangulo(int base, int altura) {
        super(base, altura);
    }
    
    @Override
    double getArea() {
        return (base*altura);
    }

    @Override
    double getPerimetro() {
        return 2*(base+altura);
    }
    
    @Override
    public String toString() {
        return "\na. Tipo de figura: rectángulo"+
               "\nb. Datos: "
                + "\n\tbase: " + base+", altura: " + altura+
               "\nc. Área: " + getArea()+
               "\nd. Perímetro: " + getPerimetro();
    }
    
    @Override
    public void Dibujar(){
        int s = (int) (Math.random()*5+1);
        String simbolo = simbolos.get(s);
        
        for(int a=0;a<altura;a++){
            for(int b=0;b<base;b++){
                System.out.print(simbolo);
            }
            System.out.println("");
        }
    }
}
