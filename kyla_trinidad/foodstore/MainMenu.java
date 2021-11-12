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
    public int transaction_id[] = new int[MAX_ID];
    public String transaction_date[] = new String[MAX_ID];
    public String transaction_time[] = new String[MAX_ID];
    public int transaction_customer_id[] = new int[MAX_ID];
    public int transaction_employee_id[] = new int[MAX_ID];
    public int transaction_item_id[] = new int[MAX_ID];
    public int transaction_quantity[] = new int[MAX_ID];
    public int transaction_price[] = new int[MAX_ID];
    public int transaction_total[] = new int[MAX_ID];

    // food
    public int food_id[] = new int[MAX_ID];
    public String food_name[] = new String[MAX_ID];
    public double food_price[] = new double[MAX_ID];

    public int menu() {
        int counter = 0;
        while (true) {
            System.out.println(this.title + "\n");
            for (int i = 0; i < this.options.length; i++) {
                if(this.options[i] != null || this.options[i] != "") {
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
}
