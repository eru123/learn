public class Main {
    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        menu.title = "MAIN MENU";
        menu.options = new String[] { "Admin", "Employee", "Customer", "Exit" };
        menu.clearScreen();
        
        ITAdministrator admin = new ITAdministrator();
        Employee employee = new Employee();
        Customer customer = new Customer();

        int choice;

        while (true) {
            choice = menu.menu();
            switch (choice) {
            case 0:
                admin.clearScreen();
                admin.open();
                break;
            case 1:
                employee.clearScreen();
                employee.open();
                break;
            case 2:
                customer.clearScreen();
                customer.open();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
            }
        }
    }
}