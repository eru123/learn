import java.io.FileWriter;
import java.io.IOException;

public class Customer extends MainMenu {
    private String name;
    private String address;
    private String phone;
    private String restaurant;
    
    public int orders[] = new int[MAX_ID];
    public int qty[] = new int[MAX_ID];

    public void open() {
        this.loadFoodData();
        this.clearScreen();
        this.ask();
        
        boolean run = true;

        while(run){
            System.out.println("\n------------------\n");
            // list all orders
            for (int i = 0; i < this.orders.length; i++) {
                if (this.qty[i] != 0) {
                    System.out.println(i + " | " + this.orders[i] +" | " + this.qty[i]);
                }
            }
            System.out.println("\n------------------\n");
            this.title = "WELCOME TO EMERLU";
            this.options = new String[]{"Add Order", "Edit Order", "Delete Order", "View Orders/Receipt", "Checkout", "Exit"};
            int choice = this.menu();
            switch (choice) {
                case 0:
                    this.addOrder();
                    break;
                case 1:
                    this.editOrder();
                    break;
                case 2:
                    // this.deleteOrder();
                    break;
                case 3:
                    this.viewOrders();
                    break;
                case 4:
                    this.checkout();
                    break;
                case 5:
                    run = false;
                    break;
            }
        }        
    }

    public void ask(){
        this.name = console.readLine("Name: ");
        this.address = console.readLine("Address: ");
        this.phone = console.readLine("Phone Number: ");
        this.restaurant = console.readLine("Restaurant (Mcdo, Jollibee, Starbucks, Burger King, KFC): ");
        this.clearScreen();
    }
    
    public void addOrder(){
        this.clearScreen();

        System.out.println("FOOD MENU");
        int counter = 0;
        for (int i = 0; i < this.food_id.length; i++) {
            if(this.food_id[i] != 0){
                counter++;
                System.out.println(counter + ". " + this.food_name[i] + " - PHP " + this.food_price[i]);
            }
        }

        int choice;
        System.out.println();
        do {
            choice = Integer.parseInt(console.readLine("Enter the number: "));
        } while (choice < 1 || choice > counter);
        choice -= 1;
        int qty = Integer.parseInt(console.readLine("Quantity (1): ")) | 1;

        for (int i = 0; i < this.orders.length; i++) {
            if(this.orders[i] == 0){
                this.orders[i] = choice;
                this.qty[i] = qty;
                break;
            }
        }

        this.clearScreen();

        System.out.println("Order added!\n");

        this.title = "ADD MORE?";
        this.options = new String[]{"Yes", "No"};
        choice = this.menu();
        if(choice == 0){
            this.addOrder();
            return;
        } else {
            this.clearScreen();
        }
    }

    public void editOrder(){
        this.clearScreen();
        this.title = "My Orders";
        this.options = new String[MAX_ID];

        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] != 0){
                String tmp_name = this.food_name[this.orders[i]];
                double tmp_price = this.food_price[this.orders[i]];
                int tmp_qty = this.qty[i];
                double tmp_total = tmp_price * this.qty[i];
                this.options[i] = tmp_name + " x" + tmp_qty + " - PHP " + tmp_total;
            }
        }

        int choice = this.menu();
        int qty = Integer.parseInt(console.readLine("Quantity ("+ this.qty[choice] +"): ")) | this.qty[choice];

        this.orders[choice] = choice;
        this.qty[choice] = qty;

        this.clearScreen();

        System.out.println("Order updated!\n");

        this.title = "Edit more Order?";
        this.options = new String[]{"Yes", "No"};
        choice = this.menu();
        if(choice == 0){
            this.editOrder();
            return;
        } else {
            this.clearScreen();
        }
    }

    // view orders
    public void viewOrders(){
        this.clearScreen();
        System.out.println("My Orders\n");
        for (int i = 0; i < this.orders.length; i++) {
            if(this.orders[i] != 0){
                String tmp_name = this.food_name[this.orders[i]];
                double tmp_price = this.food_price[this.orders[i]];
                int tmp_qty = this.qty[i];
                double tmp_total = tmp_price * tmp_qty;
                int tmp_idx = i + 1;
                System.out.println(tmp_idx + ". " + tmp_name + " x" + tmp_qty + " - PHP " + tmp_total);
            }
        }
        System.out.println("\n--------------------------------------\n");
    }

    public void checkout(){
        this.clearScreen();
        System.out.println("CHECKOUT\n");

        System.out.println("-----------------------------------\n");
        System.out.println("RECEIPT\n");
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Phone Number: " + this.phone);
        System.out.println("Restaurant: " + this.restaurant);
        System.out.println("Orders: ");

        int counter = 0;
        double total = 0;
        for(int i = 0; i < this.orders.length; i++){
            if(this.qty[i] != 0){
                counter++;
                String f_name = this.food_name[this.orders[i]];
                double f_price = this.food_price[this.orders[i]] * this.qty[i];
                total += f_price;
                System.out.println("  " + counter + ". " + f_name + " x" + this.qty[i] + " - PHP " + f_price);
            }
        }

        if(counter <= 0) {
            this.clearScreen();
            System.out.println("No orders yet!\n");
            return;
        }

        System.out.println("\n  Total: PHP " + total);
        System.out.println("\n-----------------------------------\n");

        this.title = "Are you sure you want to Checkout?";
        this.options = new String[]{"Yes", "No"};
        int choice = this.menu();

        this.clearScreen();

        if(choice == 0){
            try {
                FileWriter fw = new FileWriter("transaction.txt", true);
                String tmp_orders = "";
                String tmp_qty = "";

                counter = -1;
                for (int i = 0; i < this.orders.length; i++) {
                    if(this.qty[i] != 0){
                        for (int j = 0; j < this.food_id.length; j++) {
                            int fm_id = this.orders[i];
                            if (this.food_id[fm_id] != 0 && this.orders[i] == this.food_id[fm_id]) {
                                counter++;
                                if(counter == 0){
                                    tmp_orders = this.food_id[j] + "";
                                    tmp_qty = this.qty[i] + "";
                                } else {
                                    tmp_orders += " " + this.food_id[j];
                                    tmp_qty += " " + this.qty[i];
                                }
                                
                            }
                        }
                    }
                }
                fw.write(this.name + "," + this.address + "," + this.phone + "," + this.restaurant + "," + tmp_orders + "," + tmp_qty + ",false,false\n");
                fw.close();
                System.out.println("Checkout success\n");
                return;
            } catch (IOException e) {
                System.out.println("Error: " + e + "\n");
            }
        } else {
            this.clearScreen();
            System.out.println("Checkout Cancelled!\n");
            return;
        }
    }
}