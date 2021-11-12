import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class ITAdministrator extends MainMenu {
    private boolean is_login = false;

    public void open() {
        this.loadAdminData();
        this.loadEmployeeData();
        this.loadFoodData();
        this.login();

        while (this.is_login) {
            this.title = "IT ADMINISTRATOR MENU";
            this.options = new String[] { "Add Food to Menu", "Update Menu", "Delete Food to Menu", "View Foods",
                    "Transaction History", "Add Employee", "Delete Employee", "View Customers", "View Employees",
                    "Exit" };
            int choice = this.menu();
            switch (choice) {
            case 0:
                this.clearScreen();
                this.addFood();
                break;
            case 1:
                this.clearScreen();
                this.updateFood();
                break;
            case 2:
                this.clearScreen();
                this.deleteFood();
                break;
            case 3:
                this.clearScreen();
                this.viewFoods();
                break;
            case 4:
                this.clearScreen();
                // this.viewTransactions();
                System.out.println("Transaction History: Not yet done\n");
                break;
            case 5:
                this.clearScreen();
                this.addEmployee();
                break;
            case 6:
                this.clearScreen();
                this.deleteEmployee();
                break;
            case 7:
                this.clearScreen();
                // this.viewCustomers();
                System.out.println("View Customers: Not yet done\n");
                break;
            case 8:
                this.clearScreen();
                this.viewEmployees();
                break;
            case 9:
                this.is_login = false;
                break;
            default:
                this.clearScreen();
                break;
            }
        }
    }

    public void addFood() {
        System.out.println("Add Food to Menu\n");

        int id = Integer.parseInt(console.readLine("Enter Food ID: "));
        String name = console.readLine("Enter Food Name: ");
        double price = Double.parseDouble(console.readLine("Enter Food Price: "));

        this.clearScreen();

        for (int i = 0; i < this.food_id.length; i++) {
            if (this.food_id[i] == id) {
                System.out.println("Food ID already exist\n");
                return;
            }
        }

        for (int i = 0; i < this.food_id.length; i++) {
            if (this.food_id[i] == 0) {
                this.food_id[i] = id;
                this.food_name[i] = name;
                this.food_price[i] = price;
                break;
            }
        }

        try {
            FileWriter fw = new FileWriter("food.txt", true);
            fw.write(id + "," + name + "," + price + "\n");
            fw.close();
            System.out.println("Food added successfully\n");
        } catch (IOException e) {
            System.out.println("Error: " + e + "\n");
        }
    }

    public void updateFood() {
        System.out.println("Update Menu\n");

        int id = Integer.parseInt(console.readLine("Enter Food ID: "));
        
        for (int i = 0; i < this.food_id.length; i++) {
            if (this.food_id[i] == id) {
                String name = console.readLine("Enter Food Name: ");
                double price = Double.parseDouble(console.readLine("Enter Food Price: "));

                this.clearScreen();

                this.food_name[i] = name;
                this.food_price[i] = price;

                try {
                    FileWriter fw = new FileWriter("food.txt", false);
                    for (int j = 0; j < this.food_id.length; j++) {
                        if(this.food_id[j] != 0){
                            fw.write(this.food_id[j] + "," + this.food_name[j] + "," + this.food_price[j] + "\n");
                        }
                    }
                    System.out.println("Menu has been updated\n");
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e + "\n");
                }
                return;
            } else if (i == this.food_id.length - 1) {
                this.clearScreen();
                System.out.println("Food ID not found\n");
                return;
            }
        }

    }

    public void deleteFood() {
        System.out.println("Delete Food to Menu\n");

        Scanner input_int = new Scanner(System.in);

        System.out.print("Enter Food ID: ");
        int id = input_int.nextInt();
        input_int.close();


        this.clearScreen();

        for (int i = 0; i < this.food_id.length; i++) {
            if (this.food_id[i] == id) {
                this.food_id[i] = 0;
                this.food_name[i] = "";
                this.food_price[i] = 0;
                break;
            } else if (i == this.food_id.length - 1) {
                System.out.println("Food ID not found\n");
                return;
            }
        }
        
        try {
            FileWriter fw = new FileWriter("food.txt", false);
            for (int j = 0; j < this.food_id.length; j++) {
                fw.write(this.food_id[j] + "," + this.food_name[j] + "," + this.food_price[j] + "\n");
            }
            System.out.println("Food deleted successfully\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e + "\n");
        }
    }

    public void viewFoods() {
        System.out.println("View Foods\n");

        for (int i = 0; i < this.food_id.length; i++) {
            if (this.food_id[i] != 0) {
                System.out.println("ID: " + this.food_id[i] + "\nName: " + this.food_name[i] + "\nPrice: " + this.food_price[i] + "\n");
            }
        }        

        System.out.println("-----------------------------\n");
    }

    public void addEmployee() {
        System.out.println("Add Employee\n");

        int id = Integer.parseInt(console.readLine("Enter employee id: "));
        String name = console.readLine("Enter employee name: ");
        String phone = console.readLine("Enter employee phone: ");
        String address = console.readLine("Enter employee address: ");

        this.clearScreen();

        for (int i = 0; i < this.employee_id.length; i++) {
            if (this.employee_id[i] == id) {
                System.out.println("Employee id is already exist.\n");
                return;
            }
        }

        for (int i = 0; i < this.employee_id.length; i++) {
            if (this.employee_id[i] == 0) {
                this.employee_id[i] = id;
                this.employee_name[i] = name;
                this.employee_phone[i] = phone;
                this.employee_address[i] = address;
                break;
            }
        }

        try {
            FileWriter fw = new FileWriter("employee.txt", true);
            fw.write(id + "," + name + "," + phone + "," + address + "\n");
            fw.close();
            System.out.println("Add employee success.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e + "\n");
        }
    }

    public void deleteEmployee() {
        System.out.println("Delete Employee\n");

        int id = Integer.parseInt(console.readLine("Enter employee id: "));

        this.clearScreen();

        for (int i = 0; i < this.employee_id.length; i++) {
            if (this.employee_id[i] == id) {
                this.employee_id[i] = 0;
                this.employee_name[i] = "";
                this.employee_phone[i] = "";
                this.employee_address[i] = "";
                break;
            } else if (i == this.employee_id.length - 1) {
                System.out.println("Employee id not found.\n");
                return;
            }
        }

        try {
            FileWriter fw = new FileWriter("employee.txt", false);
            for (int i = 0; i < this.employee_id.length; i++) {
                if (this.employee_id[i] != 0) {
                    fw.write(this.employee_id[i] + "," + this.employee_name[i] + "," + this.employee_phone[i] + ","
                            + this.employee_address[i] + "\n");
                }
            }
            fw.close();
            System.out.println("Delete employee success.\n");
        } catch (IOException e) {
            System.out.println("Error: " + e + "\n");
        }
    }

    public void viewEmployees() {
        System.out.println("View Employees\n");
        for (int i = 0; i < this.employee_id.length; i++) {
            if (this.employee_id[i] != 0) {
                System.out.println(
                    "Employee id: " + this.employee_id[i] + "\n" +
                    "Employee name: " + this.employee_name[i] + "\n" + 
                    "Employee phone: " + this.employee_phone[i] + "\n" + 
                    "Employee address: " + this.employee_address[i] + "\n");
            }
        }
        System.out.println("-----------------------------\n");
    }

    public void login() {
        System.out.println("IT ADMINISTRATOR LOGIN\n");
        
        int id;
        String password;

        try {
            id = Integer.parseInt(console.readLine("Enter your ID: "));
            password = console.readLine("Enter your password: ");
        } catch (Exception e){
            this.clearScreen();
            System.out.println("Wrong ID or password. Try again\n");
            return;
        }
        for (int i = 0; i < this.admin_id.length; i++) {
            if (id == this.admin_id[i] && password.equals(this.admin_password[i])) {
                this.clearScreen();
                System.out.println("Welcome " + this.admin_name[i] + "\n");
                this.is_login = true;
                break;
            } else if (i == this.admin_id.length - 1) {
                this.clearScreen();
                System.out.println("Wrong ID or password. Try again\n");
                break;
            }
        }
    }

    public void loadAdminData() {
        try {
            this.admin_id = new int[MAX_ID];
            this.admin_name = new String[MAX_ID];
            this.admin_password = new String[MAX_ID];
            File file = new File("admin.txt");
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNext()) {
                String line[] = input.nextLine().split(",");
                this.admin_id[i] = Integer.parseInt(line[0]);
                this.admin_name[i] = line[1];
                this.admin_password[i] = line[2];
                i++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("admin.txt file not found\n");
        }
    }

    public void register() {
        System.out.println("IT ADMINISTRATOR REGISTRATION\n");
        
        String user_id = console.readLine("Admin ID: ");
        String name = console.readLine("Name: ");
        String password = console.readLine("Password: ");
        String confirm_password = console.readLine("Confirm password: ");

        for (int i = 0; i < 100; i++) {
            if (this.admin_id[i] == Integer.parseInt(user_id)) {
                this.clearScreen();
                System.out.println("User id is already exist.\n");
                return;
            }
        }

        if (password.equals(confirm_password)) {
            this.clearScreen();
            System.out.println("Account created\n");

            try {
                FileWriter writer = new FileWriter("admin.txt", true);
                String admin_info = user_id + "," + name + "," + password + "\n";
                writer.write(admin_info);
                writer.close();
                System.out.println("Admin account created\n");
            } catch (IOException e) {
                System.out.println("Error creating Admin account\n");
            }
        } else {
            this.clearScreen();
            System.out.println("Password and confirm password are not the same. Try again\n");
            return;
        }
    }
}
