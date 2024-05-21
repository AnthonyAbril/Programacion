
package gestion_de_parking;

public class PlazaEspecial extends Plaza{
    Conductor Inquilino;

    public PlazaEspecial(Conductor Inquilino, String dni, String matricula, String marca, String modelo, String color, int fechayhora, String desperfectos) {
        super(dni, matricula, marca, modelo, color, fechayhora, desperfectos);
        this.Inquilino = Inquilino;
    }

    public PlazaEspecial(Conductor Inquilino, String dni, String matricula, String marca, String modelo, String color, int fechayhora) {
        super(dni, matricula, marca, modelo, color, fechayhora);
        this.Inquilino = Inquilino;
    }

    public PlazaEspecial(Conductor Inquilino) {
        this.Inquilino = Inquilino;
    }
    
    
}
