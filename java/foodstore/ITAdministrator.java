public class ITAdministrator extends MainMenu {
    private Admins admins = new Admins();
    private Foods foods = new Foods();
    private Transactions transactions = new Transactions();
    private Employees employees = new Employees();

    public void register(int id, String name, String password) {
        admins.register(id, name, password);
        System.out.println("Registered " + name + " with id " + id + " as an admin");
    }

    private void login() {
        try {
            int id = Integer.parseInt(console.readLine("IT ADMINISTRATOR LOGIN\nEnter your id: "));
            String password = console.readLine("Enter your password: ");
            clearScreen();
            if (admins.login(id, password)) {
                System.out.println("Welcome " + admins.getName() + "\n");
            } else {
                System.out.println("Wrong ID or password. Try again\n");
            }
        } catch (Exception e) {
            clearScreen();
            System.out.println("Wrong ID or password. Try again\n");
        }
    }

    private void addFood(){
        try {
            int foodId = Integer.parseInt(console.readLine("Enter the food id: "));
            if(foods.foodIdExists(foodId)){
                clearScreen();
                System.out.println("ID is already used! Try again later with another ID\n");
                return;
            }
            String foodName = console.readLine("Enter the food name: ");
            double foodPrice = Double.parseDouble(console.readLine("Enter the food price: "));
            int store = showMenu("\nSELECT RESTAURANT", STORES);
            foods.add(foodId, foodName, foodPrice, store);
            clearScreen();
            System.out.format("%s has been added to the menu with an ID of %d\n\n", foodName, foodId);
        } catch (Exception e) {
            clearScreen();
            System.out.println("Invalid input! Try again later\n");
        }
    }

    private void updateFood(){
        try {
            int foodId = Integer.parseInt(console.readLine("Enter the food id: "));
            if(!foods.foodIdExists(foodId)){
                clearScreen();
                System.out.println("Invalid Food ID! Try again later\n");
                return;
            }

            String foodName = console.readLine("Enter the new food name: ");
            double foodPrice = Double.parseDouble(console.readLine("Enter the new food price: "));
            int store = showMenu("\nSELECT RESTAURANT", STORES);
            clearScreen();
            if(foods.update(foodId, foodName, foodPrice, store)){
                System.out.format("%s has been updated to the menu with an ID of %d\n\n", foodName, foodId);
            } else {
                System.out.format("Food ID %d is not in the menu\n\n");
            }
        } catch (Exception e) {
            clearScreen();
            System.out.println("Invalid input! Try again later\n");
        }
    }

    private void deleteFood(){
        try {
            int foodId = Integer.parseInt(console.readLine("Enter the food id: "));
            if(foods.foodIdExists(foodId)){
                System.out.println("Invalid ID! Try again later\n");
            }

            clearScreen();
            if(foods.remove(foodId)){
                System.out.format("Food ID %d has been deleted from the menu\n\n", foodId);
            } else {
                System.out.format("Food ID %d is not in the menu\n\n", foodId);
            }
        } catch (Exception e) {
            clearScreen();
            System.out.println("Invalid input! Try again later\n");
        }
    }

    private void viewFoods(){
        clearScreen();
        String[][] list = foods.listAll();
        System.out.println("FOOD MENU LIST");
        System.out.format("+-------+--------------------------------+------------+----------------------+\n");
        System.out.format("| %5s | %30s | %10s | %20s |\n", "ID", "NAME", "PRICE", "RESTAURANT");
        System.out.format("+-------+--------------------------------+------------+----------------------+\n");
        for(int i = 0; i < list.length; i++){
            System.out.format("| %5s | %30s | %10s | %20s |\n", list[i][0], list[i][1], list[i][2], list[i][4]);
        }
        System.out.format("+-------+--------------------------------+------------+----------------------+\n\n");
    }

    private void viewTransactions(){
        if(transactions.transactions.size() == 0){
            System.out.println("No transactions have been made yet\n");
            return;
        }

        System.out.println("TRANSACTION LIST:");
        for (int i = 0; i < transactions.transactions.size(); i++) {
            transactions.transactions.get(i).printReceiptTable(false);
            System.out.format("\n");
        }
    }

    private void addEmployee(){
        int id = Integer.parseInt(console.readLine("Enter the employee id: "));
        if(employees.employeeIdExists(id)){
            clearScreen();
            System.out.println("Employee ID already exists! Try again\n");
            return;
        }

        String name = console.readLine("Enter the employee name: ");
        String phone = console.readLine("Enter the employee phone: ");
        String address = console.readLine("Enter the employee address: ");

        clearScreen();
        employees.add(id, name, phone, address);
        System.out.format("%s has been added to the employee list with an ID of %d\n\n", name, id);
    }

    private void deleteEmployee(){
        int id = Integer.parseInt(console.readLine("Enter the employee ID to delete: "));
        clearScreen();
        if(employees.employeeIdExists(id)){
            employees.remove(id);
            System.out.format("Employee ID %d has been deleted from the employee list\n\n", id);
        } else {
            System.out.format("Employee ID %d is not in the employee list\n\n", id);
        }
    }

    private void viewCustomers(){
        if(transactions.transactions.size() == 0){
            System.out.println("No customer data have been made yet\n");
            return;
        }
        String[][] list = transactions.getTranstactionData();
        System.out.format("CUSTOMER(S) LIST\n");
        System.out.format("+-------+----------------------+-----------------+----------------------+\n");
        System.out.format("| %5s | %20s | %15s | %20s |\n", "ID", "NAME", "PHONE", "ADDRESS");
        System.out.format("+-------+----------------------+-----------------+----------------------+\n");
        for(int i = 0; i < list.length; i++){
            System.out.format("| %5s | %20s | %15s | %20s |\n", list[i][0], list[i][1], list[i][2], list[i][3]);
        }
        System.out.format("+-------+----------------------+-----------------+----------------------+\n");
    }

    private void viewEmployees(){
        if(employees.employees.size() == 0) {
            System.out.println("No employees have been made yet\n");
            return;
        }
        String[][] list = employees.getEmployeeData();
        System.out.format("EMPLOYEE(S) LIST\n");
        System.out.format("+-------+----------------------+-----------------+----------------------+\n");
        System.out.format("| %5s | %20s | %15s | %20s |\n", "ID", "NAME", "PHONE", "ADDRESS");
        System.out.format("+-------+----------------------+-----------------+----------------------+\n");
        for(int i = 0; i < list.length; i++){
            System.out.format("| %5s | %20s | %15s | %20s |\n", list[i][0], list[i][1], list[i][2], list[i][3]);
        }
        System.out.format("+-------+----------------------+-----------------+----------------------+\n\n");
    }

    public void start() {
        admins = new Admins();
        foods = new Foods();
        transactions = new Transactions();
        employees = new Employees();

        this.login();

        while (admins.isAuthenticated()) {
            int choice = this.showMenu("IT ADMINISTRATOR MENU", new String[] {
                    "Add Food to Menu",
                    "Update Menu",
                    "Delete Food to Menu",
                    "View Foods",
                    "Transaction History",
                    "Add Employee",
                    "Delete Employee",
                    "View Customers",
                    "View Employees",
                    "Return to Main Menu"
            });
            clearScreen();
            switch (choice) {
                case 0:
                    addFood();
                    break;
                case 1:
                    updateFood();
                    break;
                case 2:
                    deleteFood();
                    break;
                case 3:
                    viewFoods();
                    break;
                case 4:
                    viewTransactions();
                    break;
                case 5:
                    addEmployee();
                    break;
                case 6:
                    deleteEmployee();
                    break;
                case 7:
                    viewCustomers();
                    break;
                case 8:
                    viewEmployees();
                    break;
                case 9:
                    admins.logout();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
