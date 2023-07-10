import java.util.Scanner;

abstract class Restaurant {
    final static Scanner sc = new Scanner(System.in);
    public String name;

    public void printName() {
        System.out.println("The name of the restaurant is " + name);
    }

    abstract double totalPrice();
    abstract void menuItems();
    abstract String location();
}