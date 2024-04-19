
package ejercicioshashmap02;

public class Principal {
    //Crea una clase colegio que almacene la nacionalidad de los alumnos de un colegio.
    //La clase tendrá los siguientes métodos:
        //● addAlumno(String nacionalidad): añade la nacionalidad de un nuevo alumno.
        //● showAll(): Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad.
        //● showNacionalidad(String nacionalidad): Muestra la nacionalidad y el número de alumnos de esa nacionalidad.
        //● cuantos(): Muestra cuántas nacionalidades diferentes existen en el colegio.
        //● borrarNacionalidad(String nacionalidad): Borra una nacionalidad.
        //● borrarAll(): Elimina los datos insertados.
    //Crea también una clase para testear la clase anterior.
    //Nota: Las nacionalidades se almacenan en mayúsculas
    
    private static Colegio c = new Colegio();
    public static void main(String[] args) {
        c.addAlumno("ESPAÑOLA");
        c.addAlumno("FRANCESA");
        c.addAlumno("ALEMANA");
        c.addAlumno("ECUATORIANA");
        c.addAlumno("FRANCESA");
        c.addAlumno("FRANCESA");
        c.addAlumno("ESPAÑOLA");
        c.addAlumno("FRANCESA");
        c.addAlumno("ALEMANA");
        
        System.out.println("\n>Mostrar cuantos alumnos tiene cada nacionalidad");
        c.showAll();
        System.out.println("\n>Mostrar cuantos alumnos hay en esta nacionalidad");
        c.showNacionalidad("ALEMANA");
        System.out.println("\n>Mostrar cuantas nacionalidades hay");
        c.cuantos();
        System.out.println("\n>Borra la nacionalidad Española");
        c.borrarNacionalidad("ESPAÑOLA");
        c.showAll();
        System.out.println("\n>Elimina todos los datos insertados");
        c.borrarAll();
        c.showAll();
        
        
    }
    
}
