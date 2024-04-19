package PrimeraClase;
import java.util.Scanner;
public class PrimeraClase {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime 2 numeoros binarios: ");
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		
		System.out.println("***MENU***");
		System.out.println("1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Division");
		System.out.println("4. Multiplicacion");
		String resultado = "";
		int op = sc.nextInt();
		
		switch (op) {
		
		case 1:
			Suma(a, b);
		
			System.out.println("Resultado: " + resultado);
			break;
			
		case 2:
			Resta(a, b);	
			break;
		
		case 3:
			Division(a, b);
			break;
			
		case 4:
			Multiplicacion(a, b);
			break;
		}
		
			
			
		
		
	}
	public static String Suma(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 + b1;
        System.out.println("Resultado: " + Integer.toBinaryString(c1));
        return null ;
    }
 
    public static String Resta(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 - b1;
      System.out.println("Resultado: " + Integer.toBinaryString(c1));
	return null;
        
    }
 
    public static String Division(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 / b1;
        System.out.println("Resultado: " + Integer.toBinaryString(c1));
        return null;
    }
 
    public static String Multiplicacion(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 * b1;
        System.out.println("Resultado: " + Integer.toBinaryString(c1));
        return null;
    }
		
	
}
