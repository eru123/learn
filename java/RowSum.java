import javax.swing.JOptionPane;

public class RowSum {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter 9 numbers seperated by spaces");

        String[] numbers = input.split(" ");

        int[][] rows = new int[3][3];
        int[] sumRow = new int[3];
        int[] sumCol = new int[3];
        String output = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rows[i][j] = Integer.parseInt(numbers[i * 3 + j]);
                sumRow[i] += rows[i][j];
                sumCol[j] += rows[i][j];
            }
            output += rows[i][0] + "    " + rows[i][1] + "    " + rows[i][2] + "    =  " + sumRow[i] + "\n";
        }
        output += "____________\n";
        for (int i = 0; i < 3; i++) {
            output += sumCol[i] + "  ";
        }
        
        JOptionPane.showMessageDialog(null, output);
    }
}
