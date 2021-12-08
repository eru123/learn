import java.util.Scanner;

// matrix program
public class matrix {
    public static void main(String[] args) {
        // takes two user-defined matrices from the user and will solve for their product, if the product is defined
        // The first line of input contains two integer values indicating the number of rows, rA, and number of columns, cA, of matrix A.  The succeeding rA, lines contain cA integers that indicate the values of each row of matrix A. After the elements of matrix A, are entered, the next line contains two integers again indicating the number of rows, rB,  and number of columns, cB, of matrix B. The next rB lines have cB integers to fill matrix B.
        // The output should be the product of the two matrices.
        Scanner scan = new Scanner(System.in);
        int rA = scan.nextInt();
        int cA = scan.nextInt();
        int[][] A = new int[rA][cA];
        for (int i = 0; i < rA; i++) {
            for (int j = 0; j < cA; j++) {
                A[i][j] = scan.nextInt();
            }
        }
        int rB = scan.nextInt();
        int cB = scan.nextInt();
        int[][] B = new int[rB][cB];
        for (int i = 0; i < rB; i++) {
            for (int j = 0; j < cB; j++) {
                B[i][j] = scan.nextInt();
            }
        }

        // close scan
        scan.close();

        // outputs the product of the two matrices
        if (cA == rB) {
            int[][] C = new int[rA][cB];
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cB; j++) {
                    for (int k = 0; k < cA; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cB; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("The matrices cannot be multiplied.");
        }
    }
}