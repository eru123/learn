import java.util.Scanner;

public class Palindromee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.toUpperCase();

        boolean notPalindrome = false;
        
        for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                notPalindrome = true;
            }
        }

        if (!notPalindrome) {
            System.out.println("True. It is a PALINDROME.");
        } else {
            System.out.println("False. It is not a PALINDROME.");
        }
    }
}