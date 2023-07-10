// student menu class, subclass of MainMenu
public class StudentMenu extends MainMenu {
	private Student currentStudent;

	// login admin
	boolean login() {
		try {
			System.out.println("\n- - - LOGIN - - -");

			// get username and password
			System.out.print("Enter Student ID: ");
			String id = scan.nextLine();
			System.out.print("Enter Student Password: ");
			String password = scan.nextLine();

			// check if username and password is in the students arrayList
			for (Student student : students) {
				if (student.equals(id, password)) {
					currentStudent = student;
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Ther is Error in Teacher Login\n");
			// if any error occur, return false
			return false;
		}

		// if not in the array, return false
		return false;
	}

	private void viewGrades(){
		// choose semester 
		System.out.println("\n- - - VIEW GRADES - - -");
		System.out.println("[1]. SEMESTER 1");
		System.out.println("[2]. SEMESTER 2");
		System.out.println("[3]. FINAL");

		int sem;
		try {

			// get sem from user
			System.out.print("Enter your choice: ");
			sem = Integer.valueOf(scan.nextLine());
		} catch (Exception e) {
			// if user input is not integer, set choice to 0
			sem = 0;
		}

		if (sem != 1 && sem != 2 && sem != 3) {
			System.out.println("Invalid input! Try again");
			return;
		}

		if (sem == 1) {
			// if sem is 1, get sem1 grades and print
			System.out.println("\n- - - SEMESTER 1 GRADES - - -");
			currentStudent.sem1Table();
		} else if (sem == 2) {
			// if sem is 2, get sem2 grades and print
			System.out.println("\n- - - SEMESTER 2 GRADES - - -");
			currentStudent.sem2Table();
		} else if (sem == 3) {
			// if sem is 3, get final grades and print
			System.out.println("\n- - - FINAL GRADES - - -");
			currentStudent.finalTable();
		}
		
	}

	void menu() {
		// login student
		boolean authenticated = login();

		if (authenticated) {
			// show greeting
			System.out.println("\nWelcome " + currentStudent.getName() + "!\n");

			// show student menu
			int choice = 0;
			while (choice != 3) {
				System.out.println("\n- - - - - STUDENT - - - -");
				System.out.println("[1] VIEW GRADES");
				System.out.println("[2] VIEW TUITION FEE"); 
				System.out.println("[3] BACK");

				// get user choice
				System.out.print("Enter your choice: ");

				try {
					// get choice from user
					choice = Integer.valueOf(scan.nextLine());
				} catch (Exception e) {
					// if user input is not integer, set choice to 0
					choice = 0;
				}

				// switch case for choice
				switch (choice) {
					case 1:
						// view grades
						viewGrades();
						break;
					case 2:
						// view tuition fee
						System.out.println("\n- - - - - TUITION FEE - - - -");
						System.out.println("Total Assessment: PHP 50,000.00\n");

						// press enter to continue
						System.out.print("Press Enter to continue...");
						scan.nextLine();
						break;
					case 3:
						// back to main menu
						break;
					default:
						// if user input is not 1-3, show error message
						System.out.println("Invalid Input! Please try again.");
						break;
				}
			}
		} else {
			// if username or password not matched/invalid print invalid message
			// and return to main menu
			System.out.println("Invalid Student Credentials!\n");
		}

		// System.out.println("\n- - - - - STUDENT - - - -");
		// System.out.println("[1]VIEW GRADES");
		// if ("1".equals(choice)) {
		// 	System.out.println("Choose semester: ");
		// 	System.out.println("1st semester");
		// 	System.out.println("2nd semester");
		// }

		// System.out.println("[2]VIEW TUITION FEE"); // JUST OUTPUT OF TUITION //Total Assessment 50,000.00
		// 											// choice: return to studcnet menu
		// System.out.println("[3]BACK");
		// break;
	}
}
