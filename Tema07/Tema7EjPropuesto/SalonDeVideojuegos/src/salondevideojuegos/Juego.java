
package salondevideojuegos;

public abstract class Juego {
    String titulo, fabricante;
    int anyo;//no podrá ser anterior a 1970 ni posterior al año actual
    static int ntotal;//numero total de juegos del salon
    
    double precio;
    int ncopiasdisp;
    
    public Juego(){
        titulo="Sin titulo";
        fabricante="Desconocido";
        anyo=1970;
        ntotal++;
    }
    
    public Juego(String t, String f, int a, double p, int nc){
        titulo=t;
        fabricante=f;
        anyo=a;
        ntotal++;
        this.comprobarAnyo(a);
        precio=p;
        ncopiasdisp=nc;
    }
    
    //1. Consultores de los atributos que se necesiten.
    public String getTitulo() {
        return titulo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnyo() {
        return anyo;
    }

    public int getNtotal() {
        return ntotal;
    }
            
    //2. Modificadores de los atributos que se necesiten.
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }
            
    //3. comprobarAnyo(int a): comprueba que el año está dentro del rango especificado.
    private final boolean comprobarAnyo(int a){
        
        //Si no es correcto, se pondrá el año por defecto.
        //Se invocará al crear un objeto.
        //No podrá ser sobreescrito por la subclase.
        //No será visible desde fuera de la clase.
        if (anyo>=1970&&anyo<2024){
            return true;//esta dentro del rango
        }
        anyo=1970;
        return false;//no esta dentro del rango
    }
    
    //4. toString: devuelve un String con los datos del juego.
    @Override
    public String toString() {
        return "El juego\n" 
                + "\ntitulo=" + titulo 
                + "\nfabricante=" + fabricante 
                + "\nanyo=" + anyo 
                + "\nprecio=" + precio 
                + "\nncopiasdisp=" + ncopiasdisp;
    }
            
    //5. equals: dos juegos son iguales si tienen el mismo título, fabricante y año.
    public boolean equals(Juego j) {
        
        if((this.titulo.equals(j.titulo)) && (this.fabricante.equals(j.fabricante))){
            if((this.anyo == j.anyo)){
                return true;
            }
        }
        return false;
    }
    
    //6. compareTo: un juego es menor que otro si su título es menor. En caso de igual título, si su fabricante es menor. En caso de igual título y fabricante, si su año es menor.
    public int compareTo(Juego j){
        //un juego es menor que otro si su título es menor
        if(this.titulo.compareTo(j.titulo)<0){
            System.out.println("es menor");
            return -1;
        }
        else if(this.titulo.compareTo(j.titulo)==0){
            if(this.fabricante.compareTo(j.fabricante)<0){
                return -1;
            }
            else if(this.fabricante.compareTo(j.fabricante)==0){
                if(this.anyo<j.anyo){
                    return -1;
                }
                if(this.anyo==j.anyo){
                    return 0;
                }
            }
        }
        return 1;
    }
    
}
