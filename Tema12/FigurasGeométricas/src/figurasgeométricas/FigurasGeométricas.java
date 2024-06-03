package figurasgeométricas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FigurasGeométricas {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Figura> figuras = new ArrayList<>();

    private static File ficherofiguras;
    private static final String RutaPorDefecto = "/home/alumnot/NetBeansProjects/Programacion/Tema12/FigurasGeometricas_ficheros";
    private static String ruta;

    public static void main(String[] args) {
        Figura.RellenarTabla();

        try {
            PreguntarRuta();

            CargarListaEmpleados(ficherofiguras);

            Menu();

            GuardarListaEmpleados(ficherofiguras);
        } catch (ClassNotFoundException ex) {
            System.out.println(" [ NO SE HA ENCONTRADO LA CLASE ] ");
        } catch (EOFException ex) {
            System.out.println("");
        }
    }

    public static double solodouble(String texto) {
        boolean isnumeric = false;
        double numero = 0;
        do {
            try {
                System.out.print(texto);
                numero = sc.nextDouble();
                if (numero <= 0) {
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                } else {
                    isnumeric = true;
                }

            } catch (java.util.InputMismatchException ex) {
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO DECIMAL ] ");
                sc.nextLine();
            }
        } while (isnumeric == false);
        return numero;
    }

    public static int solonumero(String texto) {
        boolean isnumeric = false;
        int numero = 0;
        do {
            try {
                System.out.print(texto);
                numero = sc.nextInt();
                if (numero <= 0) {
                    System.out.println(" [ EL VALOR TIENE QUE SER POSITIVO ] ");
                } else {
                    isnumeric = true;
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] ");
                sc.nextLine();
            }
        } while (isnumeric == false);
        return numero;
    }

    public static int eligeopcion(int min, int max, String texto) {
        int opcion = 0;
        do {
            opcion = solonumero(texto);
            if (opcion < min || opcion > max) {
                System.out.println(" [ OPCION NO DISPONIBLE ] ");
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    public static void PreguntarRuta() {
        System.out.print("Elige una ruta"
                + "\n\t1-ruta por defecto"
                + "\n\t2-escribir una ruta");
        int opcion = eligeopcion(1, 2, "\n>Elige una opcion: ");

        sc.nextLine();

        if (opcion == 1) {//ruta por defecto
            ruta = RutaPorDefecto;
        } else {//ruta del usuario
            System.out.print("Introduce la ruta de la carpeta contenedora del fichero: ");
            ruta = sc.nextLine();
        }

        ficherofiguras = new File(ruta);
        ficherofiguras.mkdirs();
        ficherofiguras = new File(ruta + "/ficherofiguras.ddr");
    }

    public static void titulo(String texto) {
        System.out.println("\n" + texto);
        for (int a = 1; a <= texto.length(); a++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void Menu() {
        try {

            int opcion = 0;
            do {
                System.out.print("OPCIONES"
                        + "\n\t1. Agregar una figura"
                        + "\n\t2. Consultar el número de figuras creadas"
                        + "\n\t3. Mostrar todas las figuras"
                        + "\n\t4. Mostrar la figura de la posición seleccionada"
                        + "\n\t5. Modificar los datos de la figura de la posición seleccionada y mostrar los cambios:"
                        + "\n\t6. Eliminar la figura de la posición seleccionada y mostrar un mensaje indicando el tipo de figura"
                        + "\n\t7. Vaciar la colección, previa confirmación por parte del usuario de dicha operación"
                        + "\n\t8. Salir"
                        + "\n>Elige una opcion: ");
                opcion = eligeopcion(1, 8, "\n>Elige opcion: ");

                switch (opcion) {
                    case 1:
                        AgregarFigura();    //HECHO
                        break;
                    case 2:    //HECHO
                        System.out.println("Hay " + figuras.size() + " figuras actualmente");
                        break;
                    case 3:
                        MostrarFiguras();    //HECHO
                        break;
                    case 4:
                        BuscarFigura();    //HECHO
                        break;
                    case 5:
                        ModificarDatos();    //HECHO
                        break;
                    case 6:
                        EliminarFigura();    //HECHO
                        break;
                    case 7:
                        VaciarColeccion();    //HECHO
                        break;
                    default:
                        break;
                }
            } while (opcion != 8);

        } catch (java.util.InputMismatchException ex) {
            System.out.println(" [ EL VALOR DEBE SER UN NUMERO ENTERO ] \n");
            sc.nextLine();  //limpiar el buffera
        }
    }

    public static void CargarListaEmpleados(File archivo) throws ClassNotFoundException, EOFException {
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //revisar si tienen informacion para preguntar si el usuario quiere usarla o no
            if (ficherofiguras.exists() && ficherofiguras.length() > 0) {//si ya existe un fichero ahi y tiene contenido
                System.out.print("ya hay un fichero con contenido en la ruta indicada"
                        + "\n\t1-usar la informacion fichero"
                        + "\n\t2-crear un nuevo fichero");
                int opcion = eligeopcion(1, 2, "\n>Elige una opcion: ");

                if (opcion == 1) {//lee la informacion fichero
                    while (true) {
                        figuras = (ArrayList<Figura>) ois.readObject();
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println(" - - Datos cargados - - ");
        }
    }

    public static void GuardarListaEmpleados(File archivo) {
        System.out.println("Quieres guardar?"
                + "\n\t1-Si"
                + "\n\t2-No");
        if (eligeopcion(1, 2, ">Elige una opcion: ") == 1) {
            try {
                if (archivo.exists()) {
                    FileOutputStream fos = new FileOutputStream(archivo, true);
                    MiObjectOutputStream moos = new MiObjectOutputStream(fos);

                    moos.writeObject(figuras);

                    fos.close();
                    moos.close();
                } else {
                    FileOutputStream fos = new FileOutputStream(archivo);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(figuras);

                    fos.close();
                    oos.close();
                }

                System.out.println("\n - - Datos guardados - - ");
                System.out.println("Se han guardado en: " + archivo);

            } catch (IOException ex) {
                System.out.println("Error al guardar los datos");
            }
        } else {
            System.out.println("Programa finalizado sin guardar");
        }
    }

    public static void AgregarFigura() {
        titulo("CREACIÓN DE UNA FIGURA");

        System.out.print("Que figura quieres agregar?"
                + "\n\t1-triangulo"
                + "\n\t2-rectangulo"
                + "\n\t3-trapecio"
                + "\n\t4-hexagono");
        int op = eligeopcion(1, 4, "\n>Elige opcion: ");
        int b = solonumero("Indica la base: ");
        int a = solonumero("Indica la altura: ");

        if (op == 1) {//triangulo
            figuras.add(new Triangulo(b, a));
        } else if (op == 2) {//rectangulo
            figuras.add(new Rectangulo(b, a));
        } else if (op == 3) {//trapecio
            int B = solonumero("Indica la base mayor: ");
            figuras.add(new Trapecio(B, b, a));
        } else if (op == 4) {//hexagono
            figuras.add(new Hexagono(b, a));
        }
    }

    public static void MostrarFiguras() {
        //a. Tipo de figura: triángulo, rectángulo, trapecio o hexágono
        //b. Datos: base, altura, Base (si es trapecio)
        //c. Área
        //d. Perímetro
        //e. Posición que ocupa en la colección
        int contador = 0;
        if (!figuras.isEmpty()) {
            for (Figura elemento : figuras) {
                contador++;
                System.out.println("\n - - - - FIGURA N" + contador + elemento.toString() + "\n");
            }
        } else {
            System.out.println("\n [NO HAY FIGURAS]\n");
        }
    }

    public static void BuscarFigura() {
        if (figuras.isEmpty()) {
            System.out.println(">La lista esta vacia");
        } else {
            MostrarFigura(eligeopcion(1, figuras.size(), ">Introducir la posicion de la figura a modificar:") - 1);
        }
    }

    public static void MostrarFigura(int posicion) {
        //for(int a=0;a<figuras.size();a++){
        //    System.out.println();
        //}
        System.out.println("\tDATOS" + figuras.get(posicion).toString());

        figuras.get(posicion).Dibujar();
    }

    public static void ModificarDatos() {

        if (figuras.size() == 0) {
            System.out.println(">La lista esta vacia");
        } else {
            int posicion = eligeopcion(1, figuras.size(), ">Introducir la posicion de la figura a mostrar:") - 1;
            //System.out.println(figuras.get(posicion).getClass().getSimpleName());

            int b = solonumero("Indica la base: ");
            int a = solonumero("Indica la altura: ");

            if (figuras.get(posicion) instanceof Triangulo) {//triangulo
                figuras.set(posicion, new Triangulo(b, a));
            } else if (figuras.get(posicion) instanceof Rectangulo) {//rectangulo
                figuras.set(posicion, new Rectangulo(b, a));
            } else if (figuras.get(posicion) instanceof Trapecio) {//trapecio
                int B = solonumero("Indica la base mayor: ");
                figuras.set(posicion, new Trapecio(B, b, a));
            } else if (figuras.get(posicion) instanceof Hexagono) {//hexagono
                figuras.set(posicion, new Hexagono(b, a));
            }

            MostrarFigura(posicion);
        }
    }

    public static void EliminarFigura() {
        if (figuras.size() == 0) {
            System.out.println(">La lista esta vacia");
        } else {
            int posicion = eligeopcion(1, figuras.size(), ">Introducir la posicion de la figura a eliminar:") - 1;
            figuras.remove(posicion).toString();
        }
    }

    public static void VaciarColeccion() {
        int op = eligeopcion(1, 2, "Desea vaciar la coleccion?"
                + "\n1-Si\n2-No");
        if (op == 1) {
            figuras.clear();
            System.out.println("Se ha vaciado la coleecion");
        } else if (op == 2) {
            System.out.println("No se ha vaciado la coleecion");
        }
    }
}
