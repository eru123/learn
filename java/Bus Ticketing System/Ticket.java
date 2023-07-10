import java.io.*;

class Ticket {
  static Console console = System.console();
  String name;
  String phone;
  String email;
  String address;
  String destination;
  String time;
  int seat;
  double price;

  public Ticket() {
    System.out.println("Ticket Application Form");
    this.name = console.readLine("Name: ");
    this.phone = console.readLine("Phone: ");
    this.email = console.readLine("Email: ");
    this.address = console.readLine("Address: ");
    
    int destinationIndex = Menu.menu("\nSelect Your Destination", TicketSystem.getDestinationsMenu(), false, false);
    this.destination = TicketSystem.destinations.get(destinationIndex).getName();
    this.price = TicketSystem.destinations.get(destinationIndex).getPrice();
    this.seat = Menu.minmax("\nSelect your Seat (1-45): ", 1, 45);
    this.time = Menu.menu("\nSelect Travel Time", new String[]{"Morning", "Afternoon", "Evening"}, false, true, true);

    TicketSystem.tickets.add(this);

    Menu.clear();
    System.out.println("A new Ticket has been created\n");
  }

  void printTable(){
    System.out.format("+-------------+--------------------------------+\n");
    System.out.format("| %19sTicket%19s |\n", "", "");
    System.out.format("+-------------+--------------------------------+\n");
    System.out.format("| %11s | %30s |\n", "Name", this.name);
    System.out.format("| %11s | %30s |\n", "Phone", this.phone);
    System.out.format("| %11s | %30s |\n", "Email", this.email);
    System.out.format("| %11s | %30s |\n", "Address", this.address);
    System.out.format("| %11s | %30s |\n", "Destination", this.destination);
    System.out.format("| %11s | %30s |\n", "Time", this.time);
    System.out.format("| %11s | %30s |\n", "Seat Number", Integer.toString(this.seat));
    System.out.format("| %11s | %30s |\n", "Price", TicketSystem.df.format(this.price));
    System.out.format("+-------------+--------------------------------+\n");
  }
}