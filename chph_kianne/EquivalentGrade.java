import javax.swing.JOptionPane;

public class EquivalentGrade {
    public static void main(String[] args) {

        // two dimensional array consisting of raw scores and equivalent grades
        double[][] grades = new double[100][2];
        for (int i = 0; i < grades.length; i++) {
            grades[i][0] = i + 1;
            if (grades[i][0] >= 1 && grades[i][0] <= 74) {
                grades[i][1] = 5;
            } else if (grades[i][0] == 75) {
                grades[i][1] = 3;
            } else if (grades[i][0] >= 76 && grades[i][0] <= 78) {
                grades[i][1] = 2.75;
            } else if (grades[i][0] >= 79 && grades[i][0] <= 81) {
                grades[i][1] = 2.50;
            } else if (grades[i][0] >= 82 && grades[i][0] <= 84) {
                grades[i][1] = 2.25;
            } else if (grades[i][0] >= 85 && grades[i][0] <= 87) {
                grades[i][1] = 2;
            } else if (grades[i][0] >= 88 && grades[i][0] <= 90) {
                grades[i][1] = 1.75;
            } else if (grades[i][0] >= 91 && grades[i][0] <= 93) {
                grades[i][1] = 1.50;
            } else if (grades[i][0] >= 94 && grades[i][0] <= 96) {
                grades[i][1] = 1.25;
            } else if (grades[i][0] >= 76 && grades[i][0] <= 78) {
                grades[i][1] = 1;
            }
        }


       


        double rawScore;
        
        try {
            String input = JOptionPane.showInputDialog("Enter a raw score: ");
            rawScore = Double.parseDouble(input);
            if(rawScore < 1 || rawScore > 100) {
                JOptionPane.showMessageDialog(null, "Invalid input! Try again");
                main(args);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Try again");
            main(args);
            return;
        }
        
        String table = "";
        table += " RAW SCORE     EQUIVALENT GRADE \n";
        table += "      1  -  74                    5.00       \n";
        table += "          75                        3.00       \n";
        table += "      76 - 78                    2.75       \n";
        table += "      79 - 81                    2.50       \n";
        table += "      82 - 84                    2.25       \n";
        table += "      85 - 87                    2.00       \n";
        table += "      88 - 90                    1.75       \n";
        table += "      91 - 93                    1.50       \n";
        table += "      94 - 96                    1.25       \n";
        table += "      97 - 100                  1.00       \n\n";

        for (int i = 0; i < grades.length; i++) {
            if (rawScore == grades[i][0]) {
                JOptionPane.showMessageDialog(null, table + "The equivalent grade is " + grades[i][1]);
                return;
            }
        }
    }
}