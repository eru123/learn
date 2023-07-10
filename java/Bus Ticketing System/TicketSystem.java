import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;

class TicketSystem {
  static Console console = System.console();
  final static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
  final static ArrayList<Destination> destinations = new ArrayList<Destination>();
  final static DecimalFormat df = new DecimalFormat("0.00");

  static String[] getDestinationNames() {
    String[] r = new String[destinations.size()];
    for (int i = 0; i < destinations.size(); i++) {
      r[i] = destinations.get(i).getName();
    }
    return r;
  }

  static double[] getDestinationPrices() {
    double[] r = new double[destinations.size()];
    for (int i = 0; i < destinations.size(); i++) {
      r[i] = destinations.get(i).getPrice();
    }
    return r;
  }

  static String[] getDestinationsMenu() {
    String[] r = new String[destinations.size()];
    for (int i = 0; i < destinations.size(); i++) {
      r[i] = destinations.get(i).getName() + " - " + destinations.get(i).getPrice();
    }
    return r;
  }

  void printTicketsTable() {
    System.out.format("+--------------------------------+----------------------+------------+\n");
    System.out.format("| %30s | %20s | %10s |\n", "NAME", "DESTINATION", "TIME");
    System.out.format("+--------------------------------|----------------------|------------+\n");
    for (int i = 0; i < tickets.size(); i++) {
      Ticket t = tickets.get(i);
      System.out.format("| %30s | %20s | %10s |\n", t.name, t.destination, t.time);
    }
    System.out.format("+--------------------------------+----------------------+------------+\n");
  }
}
