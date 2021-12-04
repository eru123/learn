public class Employee extends MainMenu {
    private Employees employees = new Employees();
    private EmployeeType employee;
    private Transactions transactions = new Transactions();
    private Transaction transaction;

    public void login(){
        System.out.println("EMPLOYEE LOGIN\n");
        int id = Integer.parseInt(console.readLine("Enter Employee ID: "));
        clearScreen();
        if(employees.login(id)){
            employee = employees.getCurrentEmployee();
            System.out.println("Welcome " + employee.name + "\n");
        } else {
            System.out.println("Invalid Employee ID\n");
        }
    }

    // returns 1 if updated
    // return 0 if no changes
    // return -1 if error or no transaction left
    public int isCurrentTransactionUpdated(){
        if(transaction == null){
            transaction = transactions.getCurrent();
            if(transaction == null){
                System.out.println("There are no receipt to pay/deliver left, come again later");
                return 0;
            }
            return 1;
        }

        if(!transaction.equals(transactions.getCurrent())){
            transaction = transactions.getCurrent();
            if(transaction == null){
                System.out.println("There are no receipt to pay/deliver left, come again later");
                return -1;
            } else {
                System.out.println("The new receipt has been loaded");
                return 1;
            }
        }
        return 0;
    }

    public void orderStatus(){
        clearScreen();

        if (isCurrentTransactionUpdated() == -1) return;

        boolean run = true;

        System.out.println("ORDER STATUS\n");
        while(run){
            System.out.println("Receipt:");
            transaction.printReceiptTable(false);

            int n = showMenu("ACTION", new String[]{"Pay", "Deliver", "Return to Main Menu"});
            clearScreen();
            switch(n){
                case 0:
                    transactions.payCurrent(employee.id);
                    transaction.isPaid = true;
                    System.out.println("The order has been paid");
                    break;
                case 1:
                    transactions.deliverCurrent(employee.id);
                    transaction.isDelivered = true;
                    System.out.println("The order has been delivered");
                    break;
                case 2:
                    run = false;
                    break;
            }
            int ct = isCurrentTransactionUpdated();
            if ((ct == -1 || ct == 0) && transaction == null) run = false;
        }
    }

    public void viewChekoutOrder(){
        int ct = isCurrentTransactionUpdated();
        if ((ct == -1 || ct == 0) && transaction == null) return;
        System.out.println("Current Receipt Transaction");
        transaction.printReceiptTable(false);
    }

    public void start(){
        employees = new Employees();
        transactions = new Transactions();
        transaction = transactions.getCurrent();

        if (isCurrentTransactionUpdated() == -1) return;

        login();

        while(employees.isAuthenticated()){
            int n = showMenu("EMPLOYEE MENU", new String[]{"Order Status", "View Checkout Order", "Return to Main Menu"});
            clearScreen();
            switch(n){
                case 0: 
                    orderStatus();
                    break;
                case 1:
                    viewChekoutOrder();
                    break;
                case 2:
                    employees.logout();
                    break;
                default:
                    System.out.println("Invalid Input! Try again later");
            }
            
            if (transaction == null) employees.logout();
        }
    }
}
