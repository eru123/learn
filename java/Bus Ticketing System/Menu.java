import java.io.*;

public class Menu {
  static Console console = System.console();
  private String title = "Menu";
  private String[] options;

  Menu(String title, String[] options) {
    this.title = title;
    this.options = options;
  }

  void title(String title) {
    this.title = title;
  }

  void options(String[] options) {
    this.options = options;
  }

  public static void clear() {
    // Clears the console
    console.printf("\033[H\033[2J");
    console.flush();

    try {
      // clear screen windows
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        // linux and mac
        Runtime.getRuntime().exec("clear");
      }

    } catch (IOException | InterruptedException ex) {
      // ignore exception
    }
  }

  public int show() {
    System.out.println(title);
    for (int i = 0; i < options.length; i++) {
      System.out.format("[%d] %s\n", i + 1, options[i]);
    }
    int choice = 0;
    while ((choice < 1 || choice > options.length)) {
      try {
        choice = Integer.parseInt(console.readLine("Enter your choice: "));
        if (choice < 1 || choice > options.length)
          throw new Exception();
      } catch (Exception e) {
        System.out.print("Invalid input! Try again. ");
      }
    }
    return choice - 1;
  }

  public int show(boolean clearBefore) {
    if (clearBefore)
      clear();
    return show();
  }

  public int show(boolean clearBefore, boolean clearAfter) {
    if (clearBefore)
      clear();
    int choice = show();
    if (clearAfter)
      clear();
    return choice;
  }

  public String show(boolean clearBefore, boolean clearAfter, boolean returnSelected) {
    if (clearBefore)
      clear();
    int choice = show();
    if (clearAfter)
      clear();
    if (returnSelected)
      return this.options[choice];
    return Integer.toString(choice);
  }

  static int menu(String title, String[] options, boolean clearBefore, boolean clearAfter) {
    Menu menu = new Menu(title, options);
    return menu.show(clearBefore, clearAfter);
  }

  static String menu(String title, String[] options, boolean clearBefore, boolean clearAfter, boolean returnSelected) {
    Menu menu = new Menu(title, options);
    return menu.show(clearBefore, clearAfter, returnSelected);
  }
  
  static int minmax(String msg, int min, int max){
    int choice = 0;
    while (choice < min || choice > max) {
      try {
        choice = Integer.parseInt(console.readLine(msg));
        if (choice < min || choice > max)
          throw new Exception();
      } catch (Exception e) {
        System.out.print("Invalid input! Try again. ");
      }
    }
    return choice;
  }
}
