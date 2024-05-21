/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_de_parking;

public class Plaza {
        //Una vez asignada la plaza, se deben guardar una serie de datos del coche que va a aparcar
        //en dicha plaza asignada: dni del conductor, matrícula, marca, modelo, color, si presenta
        //desperfectos claramente visibles y una descripción breve de los mismos (sólo en caso de
        //que presente desperfectos). Además, deberá guardarse la fecha y la hora en la que entra al
        //parking.
    
    String dni;
    String matricula;
    String marca;
    String modelo;
    String color;
    String desperfectos;
    int fechayhora; //ejemplo (31 de diciembre de 2024 a las 23:59 = 311220242359) (1 de enero de 2012 a las 00:00 = 010120120000)

    public Plaza(String dni, String matricula, String marca, String modelo, String color, int fechayhora, String desperfectos) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.desperfectos = desperfectos;
        this.fechayhora = fechayhora;
    }

    public Plaza(String dni, String matricula, String marca, String modelo, String color, int fechayhora) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fechayhora = fechayhora;
        this.desperfectos= "No hay desperfectos";
    }

    public Plaza() {
    }
    
    
}
