import java.util.Scanner;

public class RemainderQuotient {
	final static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
    int total = 0;
		System.out.println("Enter 5 numbers: ");
		for (int i = 0; i < 5; i++) {
      total += input.nextInt();
		}

    int quotient = (int) total / 5;
    double remainder = (total % 5 * 10 / 5) * .1;


    System.out.println("Quotient: " + quotient);
    System.out.println("Remainder: " + remainder);
	}
}