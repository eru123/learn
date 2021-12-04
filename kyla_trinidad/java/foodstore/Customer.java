import java.util.ArrayList;

public class Customer extends MainMenu {
    private Foods foods = new Foods();
    private Transactions transactions = new Transactions();
    private Transaction transaction;

    private int store;
    private String[][] storeMenu;
    private String[] storeOptions;

    private void addOrder(){
        // check the menu is not empty
        if(storeOptions.length == 0){
            System.out.println("This store has no Food Menu! Try again later");
            return;
        }

        // get the order
        int n;
        int food_id;
        int qty;
        String ans = "y";
        do {
            // show the food menu for the selected store
            n = showMenu(STORES[store] + " Menu", storeOptions);
            try {
                food_id = Integer.parseInt(storeMenu[n][0]); // get the food id
                qty = Integer.parseInt(console.readLine("Quantity: ")); // get the quantity
                transaction.addOrder(food_id, qty); // add the order to the transaction
                // clear the screen and display a message
                clearScreen();
                System.out.println("Order added!");
            } catch (Exception e) {
                // if error occurs, clear the screen and display a message
                clearScreen();
                System.out.println("Invalid input! Try again");
            }

            // ask if the user wants to add another order
            ans = console.readLine("Add another order? (y/n):");
            clearScreen();

            // if the user does not want to add another order, 
            // break the loop and return to the main menu
        } while (ans.equalsIgnoreCase("y"));
    }

    private void editOrder(){
        // check if there is any order to edit
        if(transaction.orders.size() == 0){
            System.out.println("No orders to edit!");
            return;
        }
        try {
            // show all orders and get the order to edit
            int n = showMenu("Orders", transaction.getOrders());

            // get the new quantity
            int qty = Integer.parseInt(console.readLine("Quantity:"));

            // update the order
            transaction.updateOrder(n, qty);

            // clear the screen and show message
            clearScreen();
            System.out.println("Order edited!");
        } catch (Exception e) {
            // clear the screen and show message if error occurs
            clearScreen();
            System.out.println("Invalid input! Try again");
        }
    }

    private void deleteOrder(){
        // check if there are orders to delete
        if(transaction.orders.size() == 0){
            System.out.println("No orders to delete!");
            return;
        }

        try {
            // show orders
            int n = showMenu("Orders", transaction.getOrders());
            
            // delete selected order
            transaction.removeOrder(n);
            clearScreen(); // clear screen after deleting order
            System.out.println("Order deleted!"); // and print a message
        } catch (Exception e) {
            // if error occurs, clear screen and print error message
            clearScreen();
            System.out.println("Invalid input! Try again");
        }
    }

    private void viewReceipt(){
        // check if has orders
        if(transaction.orders.size() == 0){
            // no orders, print message and return
            System.out.println("No orders to view!");
            return;
        }

        // print the receipt
        System.out.println("Receipt:");
        transaction.printReceiptTable(true);
        return;
    }

    private boolean checkout(){
        // Check if there are any orders
        if(transaction.orders.size() == 0){
            System.out.println("No orders to checkout!");
            return false;
        }

        // show receipt
        viewReceipt();

        // ask if proceed to checkout
        String ans = "y";
        do {
            System.out.println("Are you sure you want to checkout? (y/n):");
            ans = console.readLine();
            clearScreen(); // clear screen after input
        } while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n"));

        // if proceed to checkout, return true if success
        if(ans.equalsIgnoreCase("y")){
            clearScreen();
            // add transaction to database
            transactions.add(transaction);
            System.out.println("Checkout successful!");
            return true;
        }

        // if not proceed to checkout, return false
        return false;
    }

    public void start() {
        // reinitialize objects to refresh data
        foods = new Foods();
        transactions = new Transactions();

        // get customer data
        System.out.println("CLIENT INFORMATION\n");
        String name = console.readLine("Name: "); // get name
        String address = console.readLine("Address: "); // get address
        String phone = console.readLine("Phone Number: "); // get phone number
        store = showMenu("SELECT STORE", STORES); // select store

        // Create new transaction with client information and blank orders
        transaction = new Transaction(name, address, phone, store, new ArrayList<Integer>(), new ArrayList<Integer>(), false, false, -1);

        // Menu details for chosen store
        storeMenu = foods.listByStore(store);

        // Food Menu List options for chosen store
        storeOptions = foods.parseList(storeMenu, 5);

        int choice = -1;
        do {
            // Main Menu
            choice = showMenu("WELCOME TO EMERLU", new String[]{"Add Order", "Edit Order", "Delete Order", "View Orders/Receipt", "Checkout", "Return to Main Menu"});
            
            // clear screen after valid input
            clearScreen();

            // process choice
            switch (choice) {
                case 0:
                    // Add Order
                    addOrder();
                    break;
                case 1:
                    // edit quantity of order
                    editOrder();
                    break;
                case 2:
                    // delete order 
                    deleteOrder();
                    break;
                case 3:
                    // view orders and receipt
                    viewReceipt();
                    break;
                case 4:
                    boolean co = checkout(); // checkout, returns true if checkout successful
                    if (co) choice = 5;  // if checkout is successful, return to main menu
                    if (!co) break; // if checkout unsuccessful, loop the menu again
                case 5:
                    // break the switch and should return to main menu
                    break;
                default:
                    // invalid input
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);

        // check if the loop is broken by while condition
        assert choice == 5;
    }
}
