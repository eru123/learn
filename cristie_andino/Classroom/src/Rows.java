import java.util.Scanner;

public class Rows {
  final static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.print("Enter the number of rows: ");
    int rows = in.nextInt();
    System.out.print("Enter the number of columns: ");
    int cols = in.nextInt();

    int[][] matrix = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = in.nextInt();
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j + 1 != cols && matrix[i][j] < matrix[i][j + 1]) {
          System.out.println("Position: " + i + ", " + j);
          break;
        }
      }
    }
  }
}
