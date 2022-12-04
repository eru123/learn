import java.util.*;

public class ControlStructure {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter count: ");
        int count = sc.nextInt();

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (count > 10) {
            System.out.println("Count is greater than 10");
        } else {
            System.out.println("Count is less than 10");
        }

        if (number % 2 == 1) {
            System.out.println("This number is not an even number");
        } else {
            System.out.println("This number is an even number");
        }

        if (age > 18 && age <= 40) {
            System.out.println("You're not getting old!");
        } else {
            System.out.println("You're not getting younger");
        }
    }
}