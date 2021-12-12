import java.util.Scanner;

public class Point {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String answer;
		double total, price, amount, vatable;
		double vat = 0.12;
		double grandTotal = 0;

		do {
			System.out.println("------------------------------------------------------------------");
			// Entering the price
			System.out.println("Enter the Price: ");
			price = keyboard.nextDouble();
			// how many items did the shopper get
			System.out.println("Enter the Quantity: ");
			int qnty = keyboard.nextInt();
			// total of the item
			vatable = price * vat;
			total = price * qnty;
			grandTotal += total;

			System.out.println("The total is Php: " + total);

			System.out.println(" Do you want to calculate another total? Yes or No ");
			answer = keyboard.next();
			System.out.println("------------------------------------------------------------------");
		} while (answer.equalsIgnoreCase("Yes"));

		grandTotal++; // to sum up

		System.out.println("Your total payment is: " + grandTotal);

		System.out.println("Enter amount to pay: "); // payment
		amount = keyboard.nextInt();

		if (amount >= grandTotal) {
			// change

			double change = amount - grandTotal;
			System.out.println("=====================================");
			System.out.println("VAT: " + vat);
			System.out.printf("Vatable: %.2f \n", vatable);
			System.out.println("Your change is: " + change);
			System.out.println("THANK YOU FOR SHOPPING");
			System.out.println("=====================================");
		} else {
			System.out.println("Incorrect Amount");
		}
	}

}