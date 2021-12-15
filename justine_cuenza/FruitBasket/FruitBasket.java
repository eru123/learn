import java.util.Scanner;
import java.util.Stack;

public class FruitBasket {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Stack<String> basket = new Stack<String>();
        System.out.println("Catch and eat any of these fruits: ('apple', 'orage', 'mango', 'guava')");
        System.out.print("How many fruits would you like to catch? ");
        int numFruits = scanner.nextInt();
        System.out.println("Choose a fruit to catch. Press A, O, M or G.");
        for (int i = 0; i < numFruits; i++) {
            System.out.format("Fruit %d of %d: ", i + 1, numFruits);
            char fruit = scanner.next().toUpperCase().charAt(0);
            if (fruit == 'A') {
                basket.push("apple");
            } else if (fruit == 'O') {
                basket.push("orange");
            } else if (fruit == 'M') {
                basket.push("mango");
            } else if (fruit == 'G') {
                basket.push("guava");
            } else {
                System.out.println("Invalid fruit!");
            }
        }
        System.out.println("Your basket now has: " + basket);
        while (!basket.isEmpty()) {
            System.out.print("press E to eat a fruit. ");
            char eat = scanner.next().toLowerCase().charAt(0);
            if (eat == 'e') {
                basket.pop();
            } 
            if (!basket.isEmpty()) {
                System.out.println("Fruit(s) in the basket: " + basket);
            } else {
                System.out.println("No more fruits");
            }
        }
    }
}