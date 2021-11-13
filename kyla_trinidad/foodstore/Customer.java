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
            this.title = "WELCOME TO EMERLU";
            this.options = new String[]{"Add Order", "Edit Order", "Delete Order", "View Orders/Receipt", "Checkout", "Return to Main Menu"};
            int choice = this.menu();
            assert choice >= 0 && choice < this.options.length;

            switch (choice) {
                case 0:
                    this.addOrder();
                    break;
                case 1:
                    this.editOrder();
                    break;
                case 2:
                    this.deleteOrder();
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
        
        assert run == false;
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

        if(counter == 0){
            this.clearScreen();
            System.out.println("No food available");
            return;
        }

        System.out.println();
        do {
            choice = Integer.parseInt(console.readLine("Enter the number: "));
        } while (choice < 1 || choice > counter);
        choice -= 1;
        int qty = Integer.parseInt(console.readLine("Quantity (1): "));
        if(qty < 1){
            qty = 1;
        }

        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] == 0){
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
        this.title = "Edit Order";
        this.options = new String[MAX_ID];

        int counter = 0;
        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] != 0){
                String tmp_name = this.food_name[this.orders[i]];
                double tmp_price = this.food_price[this.orders[i]];
                int tmp_qty = this.qty[i];
                double tmp_total = tmp_price * this.qty[i];
                this.options[counter] = tmp_name + " x" + tmp_qty + " - PHP " + tmp_total;
                counter++;
            }
        }

        if(counter == 0){
            System.out.println("No orders yet!");
            return;
        }

        int choice = this.menu();

        counter = 0;
        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] != 0){
                if(counter == choice){
                    this.qty[i] = Integer.parseInt(console.readLine("Quantity ("+ this.qty[i] +"): "));
                    this.clearScreen();
                    System.out.println("Order updated!\n");
                    break;
                }
                counter++;
            }
        }

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

    public void deleteOrder(){
        this.clearScreen();
        this.title = "Delete Order";
        this.options = new String[MAX_ID];

        int counter = 0;
        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] != 0){
                String tmp_name = this.food_name[this.orders[i]];
                double tmp_price = this.food_price[this.orders[i]];
                int tmp_qty = this.qty[i];
                double tmp_total = tmp_price * this.qty[i];
                this.options[counter] = tmp_name + " x" + tmp_qty + " - PHP " + tmp_total;
                counter++;
            }
        }

        if(counter == 0){
            System.out.println("No orders yet!");
            return;
        }

        int choice = this.menu();

        counter = 0;
        for (int i = 0; i < this.orders.length; i++) {
            if(this.qty[i] != 0){
                if(counter == choice){
                    this.qty[i] = 0;
                    this.clearScreen();
                    System.out.println("Order deleted!\n");
                    break;
                }
                counter++;
            }
        }

        this.title = "Delete more Order?";
        this.options = new String[]{"Yes", "No"};
        choice = this.menu();
        if(choice == 0){
            this.deleteOrder();
            return;
        } else {
            this.clearScreen();
        }
    }

    public void viewOrders(){
        this.clearScreen();
        System.out.println("-----------------------------------");
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
        System.out.println("-----------------------------------\n");
    }

    public void checkout(){
        this.clearScreen();
        System.out.println("CHECKOUT\n");

        System.out.println("-----------------------------------");
        System.out.println("RECEIPT\n");
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Phone Number: " + this.phone);
        System.out.println("Restaurant: " + this.restaurant);
        System.out.println("Orders: ");

        int counter = 0;
        double total = 0;
        String tmp_orders = "";
        String tmp_qty = "";

        for(int i = 0; i < this.orders.length; i++){
            if(this.qty[i] != 0){
                counter++;
                String f_name = this.food_name[this.orders[i]];
                double f_price = this.food_price[this.orders[i]] * this.qty[i];
                total += f_price;
                System.out.println("  " + counter + ". " + f_name + " x" + this.qty[i] + " - PHP " + f_price);

                if(counter == 1){
                    tmp_orders = this.orders[i] + "";
                    tmp_qty = this.qty[i] + "";
                } else {
                    tmp_orders += " " + this.orders[i];
                    tmp_qty += " " + this.qty[i];
                }

            }
        }

        if(counter <= 0) {
            this.clearScreen();
            System.out.println("No orders yet!\n");
            return;
        }

        System.out.println("\n  Total: PHP " + total);
        System.out.println("-----------------------------------\n");

        this.title = "Are you sure you want to Checkout?";
        this.options = new String[]{"Yes", "No"};
        int choice = this.menu();

        this.clearScreen();

        if(choice == 0){
            try {
                FileWriter fw = new FileWriter("transaction.txt", true);
                // name,address,phone,restaurant,orders,quantities,is delivered,is paid,employee id
                fw.write(this.name + "," + this.address + "," + this.phone + "," + this.restaurant + "," + tmp_orders + "," + tmp_qty + ",false,false,0\n");
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