import java.io.FileWriter;
import java.io.IOException;

public class Customer extends MainMenu {
    private String name;
    private String address;
    private String phone;
    private String restaurant;
    
    private int orders[] = new int[MAX_ID];
    private int qty[] = new int[MAX_ID];

    private boolean run;

    public void open() {
        this.loadFoodData();
        this.clearScreen();
        this.ask();

        this.run = true;

        while(this.run){
            this.title = "WELCOME TO EMERLU";
            this.options = new String[]{"Add Order", "Edit Order", "Delete Order", "View Orders/Receipt", "Checkout", "Return to Main Menu"};
            int choice = this.menu();
            assert choice >= 0 && choice < this.options.length;

            this.clearScreen();
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
                    this.run = false;
                    break;
            }
        }
        
        assert run == false;
    }

    private void ask(){
        this.clearScreen();
        System.out.println("CLIENT INFORMATION\n");
        this.name = console.readLine("Name: ");
        this.address = console.readLine("Address: ");
        this.phone = console.readLine("Phone Number: ");
        this.restaurant = console.readLine("Restaurant (Mcdo, Jollibee, Starbucks, Burger King, KFC): ");
        this.clearScreen();
    }
    
    private String[] getFoodMenu(){
        String foodMenu[] = new String[this.food_id.length];
        for(int i = 0; i < food_id.length; i++) 
            foodMenu[i] = this.food_name[i] + " - PHP " + this.food_price[i];
        return foodMenu;
    }

    private String[] getOrderedFoods(){
        String orderedFoods[] = new String[this.orders.length];
        for(int i = 0; i < orders.length; i++){
            if(this.orders[i] != 0) {
                for(int j = 0; j < this.food_id.length; j++){
                    if(this.orders[i] == this.food_id[j]){
                        orderedFoods[i] = this.food_name[j] + "  x" + this.qty[i] + " - PHP " + (this.food_price[j] * this.qty[i]);
                    }
                }
            }
        }
        return orderedFoods;
    }

    private void addOrder(){
        this.title = "ADD ORDER";
        this.options = this.getFoodMenu();

        if(this.options.length == 0){
            this.clearScreen();
            System.out.println("No food available");
            return;
        }
        
        int choice = this.menu();
        int qty = Integer.parseInt(console.readLine("Quantity (1): "));

        if(qty < 1) qty = 1;

        for(int i = 0; i < this.orders.length; i++){
            if(this.orders[i] == 0){
                this.orders[i] = this.food_id[choice];
                this.qty[i] = qty;
                break;
            }
        }

        this.clearScreen();

        System.out.println("Order added!\n");

        this.title = "Add more Order?";
        this.options = new String[]{"Yes", "No"};
        choice = this.menu();
        if(choice == 0){
            this.addOrder();
            return;
        } else {
            this.clearScreen();
        }
    }

    private void editOrder(){
        this.title = "EDIT ORDER";
        this.options = this.getOrderedFoods();

        if(this.options.length == 0){
            System.out.println("No orders yet!");
            return;
        }

        int choice = this.menu();

        if(this.orders[choice] == 0){
            System.out.println("System Error");
        } else {
            int qty = Integer.parseInt(console.readLine("Quantity (1): "));
            if(qty < 1) qty = 1;
            this.qty[choice] = qty;
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

    private void deleteOrder(){
        this.title = "DELETE ORDER";
        this.options = this.getOrderedFoods();
        if(this.options.length == 0){
            System.out.println("No orders yet!");
            return;
        }

        int choice = this.menu();

        this.orders[choice] = 0;
        this.qty[choice] = 0;

        for(int i = 0; i < this.orders.length; i++){
            if(this.orders[i] == 0){
                for(int j = i; j < this.orders.length - 1; j++){
                    this.orders[j] = this.orders[j + 1];
                    this.qty[j] = this.qty[j + 1];
                }
                this.orders[this.orders.length - 1] = 0;
                this.qty[this.qty.length - 1] = 0;
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

    private void printReceipt(){
        System.out.println("-----------------------------------");
        System.out.println("RECEIPT\n");
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Phone Number: " + this.phone);
        System.out.println("Restaurant: " + this.restaurant);
        System.out.println("Orders: ");

        double total = 0;

        for(int i = 0; i < this.orders.length; i++){
            if(this.orders[i] != 0){
                for(int j = 0; j < this.food_id.length; j++){
                    if(this.orders[i] == this.food_id[j]){
                        System.out.println("  " + (i + 1) + ". " + this.food_name[j] + "  x" + this.qty[i] + " - PHP " + (this.food_price[j] * this.qty[i]));
                        total += (this.food_price[j] * this.qty[i]);
                    }
                }
            }
        }

        System.out.println("\n  Total: PHP " + total);
        System.out.println("-----------------------------------\n");
        if(this.orders[0] == 0) {
            this.clearScreen();
            System.out.println("No orders yet!\n");
            return;
        }
    }

    private void viewOrders(){
        System.out.println("MY ORDERS\n");
        this.printReceipt();
    }

    private void checkout(){
        System.out.println("CHECKOUT\n");
        
        this.printReceipt();
        
        String tmp_orders = "";
        String tmp_qty = "";
        for(int i = 0; i < this.orders.length; i++){
            if(this.orders[i] != 0){
                tmp_orders += this.orders[i] + " ";
                tmp_qty += this.qty[i] + " ";
            }
        }

        tmp_orders = tmp_orders.trim();
        tmp_qty = tmp_qty.trim();

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
                System.out.println("Checkout success, thank you for buying\n");
                this.run = false;
                this.orders = new int[MAX_ID];
                this.qty = new int[MAX_ID];
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