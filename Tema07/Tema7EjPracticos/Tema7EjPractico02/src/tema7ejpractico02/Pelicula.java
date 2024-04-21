
package tema7ejpractico02;

public class Pelicula extends Multimedia{
    private String actorP;
    private String actrizP;
    
    public Pelicula (String titulo, String autor, Formato formato, int duracion, String autor, String actriz){
        super(titulo, autor, formato, duracion);//se llama a las variables del padre
        if(actor == null && actriz == null){
            throw new IllegalArgumentException("Ambos atributos " + "no pueden estar vacios");
            
        }
        actorP = actor;
        actrizP = actriz;
    }
    
    public String getActor(){
        return actorP;
    }
    
    public void setActor(String a){
        actorP = a;
    }
}
