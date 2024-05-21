
package gestion_de_parking;

public class PlazaEspecial extends Plaza{
    Conductor Inquilino;
    
    public void OcuparPlaza(String dni, String matricula, String marca, String modelo, String color, int fechayhora, Conductor Inquilino) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fechayhora = fechayhora;
        this.desperfectos= "No hay desperfectos";
        this.Inquilino= Inquilino;
    }
    
    public PlazaEspecial(Conductor Inquilino) {
        this.Inquilino = Inquilino;
    }
    
    
}
