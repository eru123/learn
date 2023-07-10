import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        // Initialize Input 
        Scanner input = new Scanner(System.in);

        // Reciept variables
        String orders = "";
        float total = 0; // total amount
        float fee = 35; // delivery fee

        // Greetings
        System.out.println("Greetings Ma'am/Sir, thanks for coming!");
        System.out.println("Welcome to CJ Pizza Delivery\n\n");

        // Menu Loop
        do {

            // Initialize Menu Variables
            int i; // index
            int flavor; // pizza flavor
            int size; // pizza size

            // Available Pizza Flavor
            String[] pizza = {
                "Hawaiian Pizza",
                "Ham and Cheese Pizza",
                "Pepperoni Pizza",
                "Yummy Meaty Pizza",
                "Original Veggie Pizza"
            };

            // Pizza Sizes
            String[] sizes = {
                "Small",
                "Medium",
                "Large"
            };

            // Prices
            float[] prices = {
                55,
                125,
                325
            };

            // Get Order Loop
            while (true) {

                // Display Pizza Flavors
                System.out.println("CJ Pizza Menu\n");
                for (i = 0; i < pizza.length; i++) {
                    System.out.println((i + 1) + ". " + pizza[i]);
                }

                // Ask the user for flavor
                System.out.print("\nWhat do you want to order?\nEnter item number: ");
                flavor = input.nextInt();

                // Process input 
                if (flavor < 1 || flavor > pizza.length) {
                    // invalid input/flavor

                    // display error
                    System.out.println("Invalid Order, Item not exists! Please try again!\n");
                } else {
                    // valid input/flavor

                    // fix the indexing for flavor
                    flavor -= 1; // reduce the index by 1

                    // exit flavor loop
                    break;
                }
            }

            // Get Size Loop
            while (true) {

                // Display Pizza Sizes
                System.out.println("Size of your order");
                for (i = 0; i < sizes.length; i++) {
                    System.out.println(
                        (i + 1) + ". " + // item number
                        sizes[i] + "\t" + // pizza size
                        " - PHP (" + prices[i] + " + " + fee + " delivery fee)" // Price
                    );
                }

                // Ask the user for the size
                System.out.print("\nSize of your order?\nEnter number: ");
                size = input.nextInt();

                // Process input 
                if (size < 1 || size > sizes.length) {
                    // invalid input/flavor

                    // display error
                    System.out.println("Invalid size, Please try again!\n");
                } else {
                    // valid input/flavor

                    // fix the indexing for size
                    size -= 1; // reduce the index by 1

                    // exit size loop
                    break;
                }
            }

            // Record Order 
            orders += "\t- PHP " + prices[size] + "\t| " + pizza[flavor] + " - " + sizes[size] + "\n";
            total += prices[size];


            // Ask if user want to order again
            System.out.print("\nDo you want to Order again? (y/N): ");

            // I add additional nextLine() to remove excess line. 
            // Source: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
            input.nextLine();
            String answer = input.nextLine();

            // process user input
            if (answer.equalsIgnoreCase("N")) {
                break;
            }

        } while (true);

        // Get Date and time
        LocalDateTime dateTimeObject = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:m a");
        String date = dateTimeObject.format(dateFormat);
        String time = dateTimeObject.format(timeFormat);

        // Display reciept 
        System.out.println("\n**************************************");
        System.out.println("OFFICIAL RECEIPT\n");
        System.out.println("Date:\t" + date);
        System.out.println("Time:\t" + time);
        System.out.println("Orders:\t");
        System.out.println(orders);
        System.out.println("Delivery fee:\tPHP " + fee);
        System.out.println("Total Amount:\tPHP " + (total + fee));
        System.out.println("**************************************\n");

        // Farewell Message
        System.out.println("\nThank you for using our Service, Come again next time!");
    }
}
