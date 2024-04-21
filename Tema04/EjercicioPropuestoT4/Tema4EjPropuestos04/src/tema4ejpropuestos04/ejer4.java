
package tema4ejpropuestos04;

class ejer4 {
    public static void main (String[] args) {
        int num = 5;
        int a = num - 1 * 4 + 1;
        num += a;
        System.out.println(num);
        num = 4;
        num %= 7 * num % 3 * 7 >> 1;
        System.out.println(num);
        //La variable num esta mal declarada como "nunero"
        //en la linea en la que se intenta sumarle a la variable (num) la cantidad (num – 1 * 4 + 1) no es posible ya que la operacion tiene que hacerse antes y guardarse en una segunda variable donde guardar el resultado para sumarselo a num
    }
}
