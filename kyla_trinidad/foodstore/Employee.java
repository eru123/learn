import java.io.FileWriter;
import java.io.IOException;
public class Employee extends MainMenu {
    private int current_id;
    private boolean is_login = false;

    public void open(){
        this.clearScreen();
        this.loadEmployeeData();
        this.loadFoodData();
        this.loadTransactionData();
        this.login();
        if(is_login) System.out.println("Welcome, " + this.getEmployeeName(current_id) + "!\n");
        while(is_login){
            this.title = "EMPLOYEE MENU";
            this.options = new String[]{"Order Status", "View Checkout Order", "Return to Main Menu"};
            int choice = this.menu();
            assert choice >= 0 && choice < this.options.length;
            this.clearScreen();
            switch(choice){
                case 0:
                    this.orderStatus();
                    break;
                case 1:
                    System.out.println("CHECKOUT RECEIPT\n");
                    this.viewCheckoutOrder();
                    break;
                case 2:
                    this.is_login = false;
                    break;
            }
        }
    }

    private String getEmployeeName(int id){
        String name = "";
        for(int i = 0; i < this.employee_id.length; i++){
            if(this.employee_id[i] == id){
                name = this.employee_name[i];
            }
        }
        return name;
    }

    private void login(){
        System.out.println("Employee\n");
        current_id = Integer.parseInt(console.readLine("Enter Employee ID: "));
        for(int i = 0; i < this.employee_id.length ; i++){
            if(current_id == this.employee_id[i]){
                is_login = true;
                this.clearScreen();
                break;
            }
        }
        if(!is_login){
            this.clearScreen();
            System.out.println("Invalid Employee ID\n");
            return;
        }
    }

    private void orderStatus(){
        boolean run = true;
        while(run){
            System.out.println("ORDER STATUS\n");
            this.viewCheckoutOrder();
            this.title = "ACTION";
            this.options = new String[]{"Pay", "Deliver", "Return to Main Menu"};

            int choice = this.menu();
            assert choice >= 0 && choice < this.options.length;
            this.clearScreen();
            switch(choice){
                case 0:
                    this.pay();
                    break;
                case 1:
                    this.deliver();
                    break;
                case 2:
                    run = false;
                    break;
            }
        }
    }

    // save transaction data to transaction.txt
    private void saveTransactionData(){
        try {
            FileWriter fw = new FileWriter("transaction.txt", false);
            for(int i=0;i<this.transaction_name.length;i++){
                String tmp_orders = "";
                String tmp_qty = "";
                for(int j = 0; j < this.transaction_orders[i].length; j++){
                    if(this.transaction_orders[i][j] != 0){
                        tmp_orders += this.transaction_orders[i][j] + " ";
                        tmp_qty += this.transaction_quantities[i][j] + " ";
                    }
                }
                tmp_orders = tmp_orders.trim();
                tmp_qty = tmp_qty.trim();

                fw.write(
                    this.transaction_name[i] + "," + 
                    this.transaction_address[i] + "," + 
                    this.transaction_phone[i] + "," + 
                    this.transaction_restaurant[i] + "," + 
                    tmp_orders + "," + 
                    tmp_qty + "," + 
                    this.transaction_isDelivered[i] + "," + 
                    this.transaction_isPaid[i] + "," + 
                    this.transaction_employee_id[i] + "\n"
                );
            }
            fw.close();
            return;
        } catch (IOException e) {
            System.out.println("Error: " + e + "\n");
        }
    }

    private void pay(){
        for(int i = 0; i < this.transaction_name.length; i++){
            if(this.transaction_name[i] != null && (!this.transaction_isDelivered[i] || !this.transaction_isPaid[i])){
                this.transaction_isPaid[i] = true;
                this.saveTransactionData();
                System.out.println("Order has been paid\n");
                return;
            }
        }
        this.clearScreen();
        System.out.println("Invalid Order ID\n");
    }

    private void deliver(){
        for(int i = 0; i < this.transaction_name.length; i++){
            if(this.transaction_name[i] != null && ((!this.transaction_isDelivered[i] || !this.transaction_isPaid[i]))){
                this.transaction_isDelivered[i] = true;
                this.saveTransactionData();
                System.out.println("Order has been delivered\n");
                return;
            }
        }
        this.clearScreen();
        System.out.println("Invalid Order ID\n");
    }

    private void viewCheckoutOrder(){
        for (int i = 0; i < this.transaction_name.length; i++) {
            if(this.transaction_name[i] != null) {
                if(!this.transaction_name[i].equals("") && (!this.transaction_isDelivered[i] || !this.transaction_isPaid[i])){
                    System.out.println("-----------------------------------");
                    System.out.println("RECEIPT #" + (i+1) + "\n");
                    System.out.println("Delivery Status: " + (this.transaction_isDelivered[i] ? "Delivered" : "Pending"));
                    System.out.println("Payment Status: " + (this.transaction_isPaid[i] ? "Paid" : "Pending"));
                    System.out.println("Name: " + this.transaction_name[i]);
                    System.out.println("Address: " + this.transaction_address[i]);
                    System.out.println("Phone Number: " + this.transaction_phone[i]);
                    System.out.println("Restaurant: " + this.transaction_restaurant[i]);
                    System.out.println("Orders: ");
            
                    double total = 0;
                    for (int j = 0; j < this.transaction_orders[i].length; j++) {
                        if(this.transaction_orders[i][j] != 0) {
                            int f_id = this.transaction_orders[i][j];
                            int f_qty = this.transaction_quantities[i][j];
                            String f_name = "(Deleted Food)";
                            double f_price = 0;

                            for(int k = 0; k < this.food_id.length; k++){
                                if(this.food_id[k] == f_id){
                                    f_name = this.food_name[k];
                                    f_price = this.food_price[k] * f_qty;
                                    break;
                                }
                            }

                            total += f_price;
                            System.out.println("  " + (j + 1) + ". " + f_name + " x" + f_qty + " - PHP " + f_price);
                        }
                    }
                    System.out.println("\n  Total: PHP " + total);
                    System.out.println("-----------------------------------\n");
                    return;
                }
            }
        }
    }
}
