import java.util.Scanner;
import java.io.*;

public abstract class MainMenu implements Menu {
    static int MAX_ID = 1000;
    static Console console = System.console();

    // Menu variables
    public String title;
    public String[] options;

    // admin account
    public int admin_id[] = new int[MAX_ID];
    public String admin_name[] = new String[MAX_ID];
    public String admin_password[] = new String[MAX_ID];

    // employee account
    public int employee_id[] = new int[MAX_ID];
    public String employee_name[] = new String[MAX_ID];
    public String employee_phone[] = new String[MAX_ID];
    public String employee_address[] = new String[MAX_ID];

    // customer account
    public String customer_name[] = new String[MAX_ID];

    // transaction
    public String transaction_name[] = new String[MAX_ID];
    public String transaction_address[] = new String[MAX_ID];
    public String transaction_phone[] = new String[MAX_ID];
    public String transaction_restaurant[] = new String[MAX_ID];
    public int transaction_orders[][] = new int[MAX_ID][MAX_ID];
    public int transaction_quantities[][] = new int[MAX_ID][MAX_ID];
    public boolean transaction_isDelivered[] = new boolean[MAX_ID];
    public boolean transaction_isPaid[] = new boolean[MAX_ID];
    public int transaction_employee_id[] = new int[MAX_ID];

    // food
    public int food_id[] = new int[MAX_ID];
    public String food_name[] = new String[MAX_ID];
    public double food_price[] = new double[MAX_ID];

    public int menu() {
        int counter = 0;
        while (true) {
            System.out.println(this.title + "\n");
            for (int i = 0; i < this.options.length; i++) {
                if(this.options[i] != null &&  this.options[i] != "") {
                    System.out.println(i + 1 + ". " + this.options[i]);
                    counter++;
                }
            }
            try {
                int choice = Integer.parseInt(console.readLine("\nEnter your choice: "));
                if (choice > 0 && choice <= counter) {
                    this.clearScreen();
                    return choice - 1;
                } else {
                    this.clearScreen();
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } catch (Exception e) {
                this.clearScreen();
                System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    public void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public void loadEmployeeData() {
        int t_employee_id[] = new int[MAX_ID];
        String t_employee_name[] = new String[MAX_ID];
        String t_employee_phone[] = new String[MAX_ID];
        String t_employee_address[] = new String[MAX_ID];

        try {
            Scanner input = new Scanner(new File("employee.txt"));
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                t_employee_id[i] = Integer.parseInt(line[0]);
                t_employee_name[i] = line[1];
                t_employee_phone[i] = line[2];
                t_employee_address[i] = line[3];
                i++;
            }
            input.close();

            
            this.employee_id = new int[i];
            this.employee_name = new String[i];
            this.employee_phone = new String[i];
            this.employee_address = new String[i];

        } catch (FileNotFoundException e) {
            System.out.println("employee.txt File not found\n");
        }
    }

    public void loadFoodData() {
        int t_food_id[] = new int[MAX_ID];
        String t_food_name[] = new String[MAX_ID];
        double t_food_price[] = new double[MAX_ID];

        try {
            File file = new File("food.txt");
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                t_food_id[i] = Integer.parseInt(line[0]);
                t_food_name[i] = line[1];
                t_food_price[i] = Double.parseDouble(line[2]);
                i++;
            }
            input.close();

            this.food_id = new int[i];
            this.food_name = new String[i];
            this.food_price = new double[i];

            for (int j = 0; j < i; j++) {
                this.food_id[j] = t_food_id[j];
                this.food_name[j] = t_food_name[j];
                this.food_price[j] = t_food_price[j];
            }
        } catch (FileNotFoundException e) {
            System.out.println("food.txt File not found\n");
        }
    }

    public void loadTransactionData() {
        String t_transaction_name[] = new String[MAX_ID];
        String t_transaction_address[] = new String[MAX_ID];
        String t_transaction_phone[] = new String[MAX_ID];
        String t_transaction_restaurant[] = new String[MAX_ID];
        int t_transaction_orders[][] = new int[MAX_ID][MAX_ID];
        int t_transaction_quantities[][] = new int[MAX_ID][MAX_ID];
        boolean t_transaction_isDelivered[] = new boolean[MAX_ID];
        boolean t_transaction_isPaid[] = new boolean[MAX_ID];
        int t_transaction_employee_id[] = new int[MAX_ID];

        int orders_counter[] = new int[MAX_ID];
        try {
            Scanner input = new Scanner(new File("transaction.txt"));
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                if(line[0] != ""){
                    t_transaction_name[i] = line[0];
                    t_transaction_address[i] = line[1];
                    t_transaction_phone[i] = line[2];
                    t_transaction_restaurant[i] = line[3];
                    t_transaction_isDelivered[i] = Boolean.parseBoolean(line[6]);
                    t_transaction_isPaid[i] = Boolean.parseBoolean(line[7]);
                    t_transaction_employee_id[i] = Integer.parseInt(line[8]);
                    
                    String orders_str[] = line[4].split(" ");
                    int orders[] = new int[orders_str.length];
                    int j;
                    for ( j = 0; j < orders_str.length; j++) {
                        orders[j] = Integer.parseInt(orders_str[j]);
                    }
                    t_transaction_orders[i] = orders;
                    
                    String quantities_str[] = line[5].split(" ");
                    int quantities[] = new int[quantities_str.length];
                    for ( j = 0; j < quantities_str.length; j++) {
                        quantities[j] = Integer.parseInt(quantities_str[j]);
                    }
                    orders_counter[i] = j;
                    t_transaction_quantities[i] = quantities;
                    i++;
                }
            }
            input.close();

            this.transaction_name = new String[i];
            this.transaction_address = new String[i];
            this.transaction_phone = new String[i];
            this.transaction_restaurant = new String[i];
            this.transaction_orders = new int[i][MAX_ID];
            this.transaction_quantities = new int[i][MAX_ID];
            this.transaction_isDelivered = new boolean[i];
            this.transaction_isPaid = new boolean[i];
            this.transaction_employee_id = new int[i];

            for (int j = 0; j < i; j++) {
                this.transaction_name[j] = t_transaction_name[j];
                this.transaction_address[j] = t_transaction_address[j];
                this.transaction_phone[j] = t_transaction_phone[j];
                this.transaction_restaurant[j] = t_transaction_restaurant[j];
                this.transaction_isDelivered[j] = t_transaction_isDelivered[j];
                this.transaction_isPaid[j] = t_transaction_isPaid[j];
                this.transaction_employee_id[j] = t_transaction_employee_id[j];
                for (int k = 0; k < orders_counter[j]; k++) {
                    this.transaction_orders[j][k] = t_transaction_orders[j][k];
                    this.transaction_quantities[j][k] = t_transaction_quantities[j][k];
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("transaction.txt File not found\n");
        }
    }
}
