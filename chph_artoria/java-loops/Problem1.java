import java.util.Scanner;

public class Problem1 {
	final static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int even = 0;
		int odd = 0;

		System.out.println("Enter four numbers >>> ");

		for (int i = 0; i < 4; i++) {
			int num = input.nextInt();
			if (num % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		System.out.println("# of even: " + even);
		System.out.println("# of odd: " + odd);
	}
}