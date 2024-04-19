
package tema7ejpractico01;

public class Examen {
    private String nom;
    private String aula;
    private Fecha fecha;
    private Hora hora;
    
    public Examen(String n, String a, Fecha f, Hora h){
        nom = n;
        aula = a;
        fecha = f;
        hora = h;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public String getNom() {
        return nom;
    }

    public String getAula() {
        return aula;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }
    
    @Override
    public String toString(){
        return ("El examen de " + nom + " se realizara en el aula " + aula + " el dia " + fecha.toString() + " a las " + hora);
    }
}
