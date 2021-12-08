import javax.swing.JOptionPane;

class TwoDimensionalArray {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter twelve numbers");
        String[] inputArray = input.split(" ");
        int[][] array = new int[3][4];
        int row = 0;
        int column = 0;
        for (int i = 0; i < inputArray.length; i++) {
            array[row][column] = Integer.parseInt(inputArray[i]);
            column++;
            if (column == 4) {
                row++;
                column = 0;
            }
        }
        int max = array[0][0];
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "The highest is " + max + "\nThe lowest is " + min);
    }
}