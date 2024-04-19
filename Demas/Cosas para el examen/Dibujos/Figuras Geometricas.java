/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package figurasgeometricas;

import java.util.Scanner;

/**
 *
 * @author alumnot
 */
public class FigurasGeometricas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //triángulo, rectángulo, trapecio y hexágono
        Scanner sc = new Scanner(System.in);
        int base = 0, altura = 0, op, Base=0;
        String rell = "";
        do  {//Este do while es para repetirlo todo hasta que el usuario decida salir
            do {//Este do while es para determinar la selección del usuario y determinar si es válida
                System.out.println("1. Triángulo");
                System.out.println("2. Rectángulo");
                System.out.println("3. Trapecio");
                System.out.println("4. Hexágono");
                System.out.println("0. Salir");
                System.out.println("Introduce tu opción deseada");
                op = sc.nextInt();
                if (op < 0 || op > 4) {
                    System.out.println("El número introducido no es correcto\n");
                }
            } while (op < 0 || op > 4);

            if (op == 0) {
            } else {//Aquí se determinan la base y altura, y en caso de ser un trapecio, la Base
                System.out.println("Introduce la base");
                base = sc.nextInt();
                System.out.println("Introduce la altura");
                altura = sc.nextInt();
                if (op == 3) {
                    do {
                        System.out.println("Introduce la Base");
                        Base = sc.nextInt();
                        if (base >= Base) {
                            System.out.println("El número introducido no es correcto");
                        }
                    } while (base >= Base);
                }

                //Este switch es para determinar el relleno que se utilizará
                switch ((int) (Math.random() * 5 - 1) + 1) {
                    case 1:
                        rell = "*";
                        break;
                    case 2:
                        rell = "$";
                        break;
                    case 3:
                        rell = "@";
                        break;
                    case 4:
                        rell = "&";
                        break;
                    case 5:
                        rell = "€";
                        break;
                }
            }

            switch (op) {//Llamadas según la selección del usuario
                case 1://triángulo
                    System.out.println("Has seleccionado el triángulo");
                    triángulo(base, altura, rell);
                    break;
                case 2://rectángulo
                    System.out.println("Has seleccionado el rectángulo");
                    rectángulo(base, altura, rell);
                    break;
                case 3://trapecio
                    System.out.println("Has seleccionado el trapecio");
                    trapecio(base, altura, Base, rell);
                    break;
                case 4://hexágono
                    System.out.println("Has seleccionado el hexágono");
                    //hexágono(base, altura, rell);
                    break;
                case 0://salir
                    System.out.println("Has seleccionado salir");
                    break;
            }
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");
        } while (op != 0);
    }

    private static void triángulo(int base, int altura, String rell) {
        double a, c, cat, per;
        System.out.println("El área es " + base * altura / 2);
        cat = (base * altura) / 2;
        a = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(altura, 2));
        per = (a * 2 + base);
        System.out.println("El perímetro es " + per);
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (int h = 1; h <= (2 * i) - 1; h++) {
                System.out.print(rell);
            }
            System.out.println("");
        }
    }

    private static void rectángulo(int base, int altura, String rell) {
        int i,j;
        System.out.println("El área es " + base*altura);
        System.out.println("El perímetro es " + 2*(base+altura));
        for (i=1; i<=altura; i++){
            System.out.print(" ");
            for (j=1; j<= base; j++){
                System.out.print(rell);
            }
            System.out.println(" ");
        }
    }
    
    private static void trapecio(int base, int altura, int Base, String rell){
    int i,j,h,cat;
    double a,c;
        System.out.println("El área es "+((base+Base)*altura)/2);
        cat = (Base-base)/2;
         a = Math.sqrt(Math.pow(cat, 2) + Math.pow(altura, 2));
        System.out.println("El perímetro es "+ (base+Base+(a*2)));
        for (i = 1; i <= altura; i++) {
            for (j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (h = 1; h <= ((2 * i) - 1) + (base - 1); h++) {
                System.out.print(rell);
            }
            System.out.println("");
    }
}
    
    private static void hexágono(int base, int altura, String rell){
    int i,j,h,cat;
    double a,c;
        System.out.println("El área es "+ (base*6*(altura/2))/2);
        System.out.println("El perímetro es "+base*6);
        
        //Dibujo de un trapecio
        for (i = 1; i <= altura; i++) {
            for (j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (h = 1; h <= ((2 * i) - 1) + (base - 1); h++) {
                System.out.print(rell);
            }
            System.out.println("");
        }
        
        //Dibujo de trapecio invertido
        for (i = altura-1/*El -1 para que no dibuje la línea más grande duplicada*/; i >= 1; i--) {
            for (j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            for (h = 1; h <= ((2 * i) - 1) + (base - 1); h++) {
                System.out.print(rell);
            }
            System.out.println("");
    }
}
}