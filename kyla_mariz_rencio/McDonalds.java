import java.util.Scanner;

public class McDonalds extends Restaurant {
    final static Scanner sc = new Scanner(System.in);
    public String location;
    public boolean playPlace;
    public float price = 0;

    public static void main(String[] args) {
        int choice;
        McDonalds r = new McDonalds();
        if (r.hasPlayPlace()) {
            System.out.println("The restaurant have play place");
        } else {
            System.out.println("The restaurant doesn't have play place");
        }

        r.menuItems();
        do {
            System.out.println("Total: PHP " + r.totalPrice());
            System.out.println("Enter '0' to confirm order");
            choice = sc.nextInt();

            if (choice == 1) {
                r.price += 80;
            } else if (choice == 2) {
                r.price += 60;
            } else if (choice == 2) {
                r.price += 70;
            }

        } while (choice != 0);

        System.out.println("The total price is : PHP " + r.totalPrice() + " with 6% tax.");
    }

    public double totalPrice() {
        return (this.price * 0.06) + this.price;
    }

    public void menuItems() {
        System.out.println("------------------------------------");
        System.out.println("Enter the assigned numbers to order:");
        System.out.println("1. 1pc chicken w/ rice : PHP 80");
        System.out.println("2. Fries : PHP 60");
        System.out.println("3. McFloat : PHP 70");
    }

    public String location() {
        return this.location;
    }

    public McDonalds() {
        System.out.println("Where's the location?");
        this.location = sc.nextLine();

        System.out.println("Enter the name of the restaurant");
        this.name = sc.nextLine();

        System.out.println("Does the restaurant have a play place? enter 'true' or 'false'");
        this.playPlace = sc.nextLine().equals("true");
    }

    public boolean hasPlayPlace() {
        return this.playPlace;
    }

}

abstract class Restaurant {
    public String name;

    public void printName() {
        System.out.println("The name of the restaurant is " + name);
    }

    abstract double totalPrice();
    abstract void menuItems();
    abstract String location();
}