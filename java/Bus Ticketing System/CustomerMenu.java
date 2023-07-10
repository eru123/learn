class CustomerMenu extends TicketSystem {
  void start() {
    int choice = 0;
    boolean hasLastTicket = false;
    while (choice != 3) {
      choice = Menu.menu("Customer Menu",
          new String[] { "Buy new Ticket", "View Last Ticket", "Cancel Last ticket", "Return to Menu" }, false, true);
      switch (choice) {
        case 0:
          new Ticket();
          hasLastTicket = true;
          break;
        case 1:
          if (hasLastTicket && tickets.size() > 0)
            tickets.get(tickets.size() - 1).printTable();
          else
            System.out.println("No tickets to view\n");
          break;
        case 2:
          if (hasLastTicket && tickets.size() > 0) {
            hasLastTicket = false;
            tickets.remove(tickets.size() - 1);
            System.out.println("Last Ticket has been Cancelled\n");
          } else {
            System.out.println("No tickets to cancel\n");
          }
          break;
        case 3:
          break;
        default:
          System.out.println("Invalid choice\n");
          break;
      }
    }

    assert choice == 3;
  }
}
