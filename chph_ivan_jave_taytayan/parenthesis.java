package parenthesis;

// import the scanner class
import java.util.Scanner;

class parenthesis {
    public static void main(String[] args) {
        // input variable for integer
        Scanner input_int = new Scanner(System.in);

        // input variable for string
        Scanner input_str = new Scanner(System.in);

        // ask user to input an integer
        int num = input_int.nextInt();

        // close the scanner for integer input
        // input_int.close();

        // string variable that holds an array of parenthesis input
        String str[] = new String[num];

        // a loop that ask user to input a string based on the num input
        for (int i = 0; i < num; i++) {
            // ask user to input a string of parenthesis
            str[i] = input_str.nextLine();
        }

        // a loop that test all parenthesis input
        for (int i = 0; i < num; i++) {
            int open = 0; // open parenthesis counter
            int close = 0; // close parenthesis counter

            // a loop that test each character in the string
            for (int j = 0; j < str[i].length(); j++) {
                // if the character is an open parenthesis
                if (str[i].charAt(j) == '(') {
                    // increase the open parenthesis count
                    open++;
                }
                // if the character is a close parenthesis
                else if (str[i].charAt(j) == ')') {
                    // increase the close parenthesis count
                    close++;
                }
            }

            int caseNum = i + 1; // current case number
            boolean match = open == close; // boolean variable that holds if the parenthesis match

            // display the result of the current case
            if(match) {
                // if the parenthesis match
                System.out.println("Case #" + caseNum + ": " + "properly matched");
            } else {
                // if the parenthesis do not match
                System.out.println("Case #" + caseNum + ": " + "not properly matched");
            }
        }

        // close the scanner for integer input
        input_int.close();

        // close the scanner for string input
        input_str.close();
    }
}