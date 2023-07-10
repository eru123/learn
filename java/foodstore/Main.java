public class Main extends MainMenu {
    public static void main(String[] args) {
        MainMenu menu = new Main();
        ITAdministrator admin = new ITAdministrator();
        Employee employee = new Employee();
        Customer customer = new Customer();

        clearScreen();

        try {
            if(args[0].equalsIgnoreCase("register")){
                admin.register(Integer.parseInt(args[1]), args[2], args[3]);
            }
        } catch (Exception e) {
            // ignore errors
        }

        int choice = -1;
        do {
            choice = menu.showMenu("MAIN MENU", new String[]{"Admin", "Employee", "Customer", "Exit Program"});
            clearScreen();
            switch (choice) {
                case 0:
                    admin.start();
                    break;
                case 1:
                    employee.start();
                    break;
                case 2:
                    customer.start();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);
    }

}