import java.util.Scanner;
import java.io.*;

public class MainMenu {
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
    // name,address,phone,restaurant,orders,quantities,is delivered,is paid,employee id
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
        this.employee_id = new int[MAX_ID];
        this.employee_name = new String[MAX_ID];
        this.employee_phone = new String[MAX_ID];
        this.employee_address = new String[MAX_ID];
        try {
            Scanner input = new Scanner(new File("employee.txt"));
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                this.employee_id[i] = Integer.parseInt(line[0]);
                this.employee_name[i] = line[1];
                this.employee_phone[i] = line[2];
                this.employee_address[i] = line[3];
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("employee.txt File not found\n");
        }
    }

    public void loadFoodData() {
        this.food_id = new int[MAX_ID];
        this.food_name = new String[MAX_ID];
        this.food_price = new double[MAX_ID];

        try {
            File file = new File("food.txt");
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                this.food_id[i] = Integer.parseInt(line[0]);
                this.food_name[i] = line[1];
                this.food_price[i] = Double.parseDouble(line[2]);
                i++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("food.txt File not found\n");
        }
    }

    // load data from transaction.txt
    public void loadTransactionData() {
        this.transaction_name = new String[MAX_ID];
        this.transaction_address = new String[MAX_ID];
        this.transaction_phone = new String[MAX_ID];
        this.transaction_restaurant = new String[MAX_ID];
        this.transaction_orders = new int[MAX_ID][MAX_ID];
        this.transaction_quantities = new int[MAX_ID][MAX_ID];
        this.transaction_isDelivered = new boolean[MAX_ID];
        this.transaction_isPaid = new boolean[MAX_ID];
        this.transaction_employee_id = new int[MAX_ID];

        try {
            Scanner input = new Scanner(new File("transaction.txt"));
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                if(line[0] != ""){
                    this.transaction_name[i] = line[0];
                    this.transaction_address[i] = line[1];
                    this.transaction_phone[i] = line[2];
                    this.transaction_restaurant[i] = line[3];
                    this.transaction_isDelivered[i] = Boolean.parseBoolean(line[6]);
                    this.transaction_isPaid[i] = Boolean.parseBoolean(line[7]);
                    this.transaction_employee_id[i] = Integer.parseInt(line[8]);
                    
                    String orders_str[] = line[4].split(" ");
                    int orders[] = new int[orders_str.length];
                    for (int j = 0; j < orders_str.length; j++) {
                        orders[j] = Integer.parseInt(orders_str[j]);
                    }
                    this.transaction_orders[i] = orders;
                    
                    String quantities_str[] = line[5].split(" ");
                    int quantities[] = new int[quantities_str.length];
                    for (int j = 0; j < quantities_str.length; j++) {
                        quantities[j] = Integer.parseInt(quantities_str[j]);
                    }
                    this.transaction_quantities[i] = quantities;
                    i++;
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("transaction.txt File not found\n");
        }
    }
}
