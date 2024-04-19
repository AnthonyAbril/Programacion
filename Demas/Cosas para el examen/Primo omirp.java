package ej08;

import java.util.Scanner;

public class Ej08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce numero: ");
        int num = sc.nextInt();
        System.out.println("¿Es primo? " + Primo(num));

        System.out.println("¿Es Omirp? " + Omirp(num));
    }

    private static boolean Primo(int num) {
        int cont = 2;
        boolean primo = true;
        while ((primo) && (cont != num)) {
            if (num % cont == 0) {
                primo = false;
            }
            cont++;
        }
        return primo;
    }

    private static int Invert(int num) {
        int reversed = 0;

        while (num > 0) {
            int resto = num % 10;
            reversed = reversed * 10 + resto;
            num /= 10;
        }
        return reversed;

    }

    private static boolean Omirp(int num) {

        if (Primo(num) == true && Primo(Invert(num)) == true) {
            return true;
        } else {
            return false;
        }
    }
}
