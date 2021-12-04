import java.util.Scanner;

public class JavaFinals {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// Menu Objects
		AdminMenu admin = new AdminMenu();
		TeacherMenu teacher = new TeacherMenu();
		StudentMenu student = new StudentMenu();

		// variable for main menu options
		int choice;

		// this do-while loop will loop until the user choses the option 4 in the menu
		do {

			// Main Menu
			System.out.println("Welcome to Grading System ");
			System.out.println("Choose your role: ");
			System.out.println("[1] Admin: ");
			System.out.println("[2] Teacher: ");
			System.out.println("[3] Student: ");
			System.out.println("[4] Exit: ");
			System.out.print("Input your choice: ");

			try {
				// Get user input
				// Convert string input to integer object
				choice = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// if the user type letters or characters
				// set home to 0, which is an invalid option
				choice = 0;
			}

			switch (choice) {
				case 1:
					admin.readFromFile(); // load data from file
					admin.menu(); // go to admin menu
					admin.saveToFile(); // save data to file
					break;
				case 2:
					teacher.readFromFile(); // load data from file
					teacher.menu(); // go to teacher menu
					teacher.saveToFile(); // save data to file
					break;
				case 3:
					student.readFromFile(); // load data from file
					student.menu(); // go to student menu
					student.saveToFile(); // save data to file
					break;
				case 4:
					// exit the program
					break;
				default:
					// display invalid input
					break;
			}
		} while (choice != 4);

		// print some exit message here below
		// System.out.println("Thank you for using our Academy Grading System");

		// make sure that the user choose 4 to exit
		assert choice == 4;
	}
}

