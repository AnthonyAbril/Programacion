
package piramide;

/**
 *
 * @author anthony
 */
public class Piramide {

    public static void main(String[] args) {
        int i, j, k;
        for (k = 1; k <= 3; k++) { //the loop counts until 3 using k to count the lines
            for (i = 1; i <= 3 - k; i++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * (k - 1) + 1; j++) {    //[j <= 2 * (j - 1) + 1] is not correct because j would be always higher than the limit to stop the loop making it infinit. To correct it I use the k to replace it and now the operation uses the line counter
                System.out.print("*");
            }
            System.out.println("");    //I quit the point because this order only have to put the program on the next line without writting any other thing on the piramid
        }
    }
}
    
