import java.io.*;

class AdminMenu extends TicketSystem {
  String[] username = { "admin", "admin2", "admin3" };
  String[] password = { "1234", "1234", "1234" };
  String[] name = { "Admin 1", "Admin 2", "Admin 3" };

  boolean authentication = false;
  static Console console = System.console();

  private void login() {
    Menu.clear();
    System.out.println("Admin Login");
    String username = console.readLine("Username: ");
    String password = console.readLine("Password: ");
    for (int i = 0; i < this.username.length; i++) {
      if (username.equals(this.username[i]) && password.equals(this.password[i])) {
        Menu.clear();
        System.out.format("Welcome %s\n\n", this.name[i]);
        authentication = true;
        break;
      }
    }
    if (!authentication) {
      Menu.clear();
      System.out.format("Invalid Admin username or password! Try again.\n\n");
    }
  }

  private void logout() {
    Menu.clear();
    authentication = false;
  }

  private void viewTickets(){
    Menu.clear();
    printTicketsTable();
  }

  private void deleteTicket(){
    Menu.clear();
    System.out.println("Available Tickets");
    for (int i = 0; i < tickets.size(); i++) {
      Ticket t = tickets.get(i);
      System.out.format("[%d] %s - %s %s\n", i + 1, t.name, t.destination, t.time);
    }
    int ticketNumber = Menu.minmax("\nEnter Ticket # to delete: ", 1, tickets.size()) - 1;
    tickets.remove(ticketNumber);
    Menu.clear();
    System.out.println("Ticket deleted!");
  }
  
  void start(){
    this.login();

    int choice = 0;
    while (authentication) {  
      choice = Menu.menu("Admin Menu", new String[]{"View Tickets", "Delete a Ticket", "Logout"}, false, true);
      switch (choice) {
        case 0:
          this.viewTickets();
          break;
        case 1:
          this.deleteTicket();
          break;
        case 2:
          this.logout();
          System.out.println("Admin Account has been logout");
          break;
        default:
            System.out.println("Invalid choice!\n");
            break;
      }
    }

    assert authentication == false;
  }
}
