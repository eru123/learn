public class Main {
  public static void main(String[] args) {
    AdminMenu admin = new AdminMenu();
    CustomerMenu customer = new CustomerMenu();

    TicketSystem.destinations.add(new Destination("Destination 1", 19));
    TicketSystem.destinations.add(new Destination("Destination 2", 45));
    TicketSystem.destinations.add(new Destination("Destination 3", 35));
    TicketSystem.destinations.add(new Destination("Destination 5", 29));
    TicketSystem.destinations.add(new Destination("Destination 6", 32));
    TicketSystem.destinations.add(new Destination("Destination 7", 45));
    TicketSystem.destinations.add(new Destination("Destination 8", 54));
    TicketSystem.destinations.add(new Destination("Destination 9", 76));

    Menu.clear();

    int choice = 0;

    while(choice != 2){
      choice = Menu.menu("Select Account", new String[] { "Admin", "Customer", "Exit" }, false, true);
      switch(choice){
        case 0:
          admin.start();
          break;
        case 1:
          customer.start(); 
          break;
        case 2:
          Menu.clear();
          System.out.println("Thank you! Good Bye.");
          break;
        default:
          Menu.clear();
          System.out.println("Invalid choice\n");
          break;
      }
    } 
  }
}