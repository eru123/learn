import java.util.Arrays;

// admin menu class, subclass of MainMenu
public class AdminMenu extends MainMenu {
	// array string of username and password for admin
	// you can add more admin username and password in the array
	// array index must be same for username and password
	private String[] ADMIN_ID = { "1", "2" };
	private String[] ADMIN_PASSWORD = { "admin123", "admin321" };

	// login admin
	boolean login() {
		try {
			System.out.println("\n- - - LOGIN - - -");

			// get username and password
			System.out.print("Enter Admin ID: ");
			String id = scan.nextLine();
			System.out.print("Enter Admin Password: ");
			String password = scan.nextLine();

			// check if username and password is in the ADMIN_ID and ADMIN_PASSWORD array
			if (Arrays.stream(ADMIN_ID).anyMatch(id::equals)
					&& Arrays.stream(ADMIN_PASSWORD).anyMatch(password::equals)) {
				// get array index of username
				int index = Arrays.asList(ADMIN_ID).indexOf(id);

				// check if password is correct using username index
				if (password.equals(ADMIN_PASSWORD[index])) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Ther is Error in Admin Login\n");
			// if any error occur, return false
			return false;
		}

		// if not in the array, return false
		return false;
	}

	// add student
	private void addStudent() {
		try {
			// get student ID
			System.out.print("Enter Student ID: ");
			String id = scan.nextLine();

			// check if student id is already in the students arrayList
			if (students.stream().anyMatch(student -> student.hasId(id))) {
				// if student id is already in the database, print error message
				// and return to ADD MENU
				System.out.println("Student ID already exists.\n");
				return;
			}

			// get student's name, and password
			System.out.print("Enter Student Name: ");
			String name = scan.nextLine();
			System.out.print("Enter Student Password: ");
			String password = scan.nextLine();

			// create empty array for sem1 and sem2 with size of number of subjects
			double[] sem1 = new double[SUBJECTS[0].length];
			double[] sem2 = new double[SUBJECTS[1].length];

			// create student object
			Student student = new Student(id, name, password, sem1, sem2);

			// add student to students arrayList
			students.add(student);

			// print success message
			System.out.println("Student added successfully.\n");
		} catch (Exception e) {
			// if any error occur, print error message
			System.out.println("There is Error in Adding Student\n");
		}
	}

	// add teacher
	private void addTeacher() {
		try {
			// get teacher ID
			System.out.print("Enter Teacher ID: ");
			String id = scan.nextLine();

			// check if teacher id is already in the teachers arrayList
			if (teachers.stream().anyMatch(teacher -> teacher.hasId(id))) {
				// if teacher id is already in the database, print error message
				// and return to ADD MENU
				System.out.println("Teacher ID already exists.\n");
				return;
			}

			// get teacher's name, and password
			System.out.print("Enter Teacher Name: ");
			String name = scan.nextLine();
			System.out.print("Enter Teacher Password: ");
			String password = scan.nextLine();

			// create teacher object
			Teacher teacher = new Teacher(id, name, password);

			// add teacher to teachers arrayList
			teachers.add(teacher);

			// print success message
			System.out.println("Teacher added successfully.\n");
		} catch (Exception e) {
			// if any error occur, print error message
			System.out.println("There is Error in Adding Teacher\n");
		}
	}

	// add menu for adding student and teacher
	private void addMenu() {
		// set choice initially to 0
		int choice = 0;

		// while choice is not equal to 3
		// or user doesn't enter correct choice
		// or user doesn't choose back
		while (choice != 3) {
			System.out.println("\n- - - - ADD - - - -");
			System.out.println("[1] ADD STUDENT");
			System.out.println("[2] ADD TEACHER");
			System.out.println("[3] BACK");
			System.out.print("Input your choice: ");

			try {
				// get choice from user
				choice = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// if any error occur set choice to 0
				choice = 0;
			}
	
			switch (choice) {
				case 1:
					// add student
					addStudent();
					break;
				case 2:
					// add teacher
					addTeacher();
					break;
				case 3:
					// back to main menu
					break;
				default:
					// if user doesn't choose correct choice
					// print error message
					System.out.println("Invalid choice. Please try again.\n");
					break;
			}
		}
	}

	// remove student
	private void removeStudent() {
		try {
			// get student ID
			System.out.print("Enter Student ID to remove: ");
			String id = scan.nextLine();

			// check if student id is already in the students arrayList
			if (!students.stream().anyMatch(student -> student.hasId(id))) {
				// if student id is not in the database, print error message
				// and return to REMOVE MENU
				System.out.println("Student ID doesn't exists.\n");
				return;
			}

			// remove student from students arrayList
			students.removeIf(student -> student.hasId(id));

			// print success message
			System.out.println("Student removed successfully.\n");
		} catch (Exception e) {
			// if any error occur, print error message
			System.out.println("There is Error in Removing Student\n");
		}
	}

	// remove teacher
	private void removeTeacher() {
		try {
			// get teacher ID
			System.out.print("Enter Teacher ID to remove: ");
			String id = scan.nextLine();

			// check if teacher id is already in the teachers arrayList
			if (!teachers.stream().anyMatch(teacher -> teacher.hasId(id))) {
				// if teacher id is not in the database, print error message
				// and return to REMOVE MENU
				System.out.println("Teacher ID doesn't exists.\n");
				return;
			}

			// remove teacher from teachers arrayList
			teachers.removeIf(teacher -> teacher.hasId(id));

			// print success message
			System.out.println("Teacher removed successfully.\n");
		} catch (Exception e) {
			// if any error occur, print error message
			System.out.println("There is Error in Removing Teacher\n");
		}
	}

	// remove menu for removing student and teacher
	private void removeMenu() {
		// set choice initially to 0
		int choice = 0;

		// while choice is not equal to 3
		// or user doesn't enter correct choice
		// or user doesn't choose back
		while (choice != 3) {
			System.out.println("\n- - - - REMOVE - - - -");
			System.out.println("[1] REMOVE STUDENT");
			System.out.println("[2] REMOVE TEACHER");
			System.out.println("[3] BACK");
			System.out.print("Input your choice: ");

			try {
				// get choice from user
				choice = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// if any error occur set choice to 0
				choice = 0;
			}
	
			switch (choice) {
				case 1:
					// remove student
					removeStudent();
					break;
				case 2:
					// remove teacher
					removeTeacher();
					break;
				case 3:
					// back to main menu
					break;
				default:
					// if user doesn't choose correct choice
					// print error message
					System.out.println("Invalid choice. Please try again.\n");
					break;
			}
		}
	}

	// view students
	private void viewStudents() {
		System.out.println("\n- - - - STUDENTS - - - -");
		
		// print students info including student id, name, and computed final grade
		listStudents();
	}

	// view teachers
	private void viewTeachers() {
		System.out.println("\n- - - - TEACHERS - - - -");

		// print teachers info including teacher id, name, and computed final grade
		listTeachers();
	}

	// view menu for viewing student and teacher
	private void viewMenu() {
		// set choice initially to 0
		int choice = 0;

		System.out.println("\n- - - - VIEW - - - -");
		System.out.println("[1] VIEW STUDENT");
		System.out.println("[2] VIEW TEACHER");
		System.out.println("[3] BACK");
		System.out.println("Input your choice: ");

		try {
			// get choice from user
			choice = Integer.valueOf(scan.nextLine());
		} catch (Exception e) {
			// if any error occur set choice to 0
			choice = 0;
		}

		switch (choice) {
			case 1:
				// view student
				viewStudents();
				break;
			case 2:
				// view teacher
				viewTeachers();
				break;
			case 3:
				// back to main menu
				break;
			default:
				// if user doesn't choose correct choice
				// print error message
				System.out.println("Invalid choice. Please try again.\n");
				break;
		}
	}

	// admin menu
	void menu() {
		// login user, true if user enter correct id and password
		boolean authenticated = login();

		if (authenticated) {
			// if login success, show admin menu

			// print welcome message for admin
			System.out.println("\nAccess Granted! Welcome!\n");

			// choice variable set initial value to 0
			int choice = 0;

			// loop until choice is not equal to 4
			do {
				System.out.println("\n- - - - ADMIN - - - -");
				System.out.println("[1] ADD");
				System.out.println("[2] REMOVE");
				System.out.println("[3] VIEW LIST");
				System.out.println("[4] BACK");
				System.out.print("Input your choice: ");

				try {
					// get choice from user
					choice = Integer.valueOf(scan.nextLine());
				} catch (Exception e) {
					// if user input is not integer, set choice to 0
					choice = 0;
				}

				switch (choice) {
					case 1:
						// add menu for adding student and teacher
						addMenu();
						break;
					case 2:
						// remove menu for removing student and teacher
						removeMenu();
						break;
					case 3:
						// view menu for viewing students and teachers
						viewMenu();
					case 4:
						// back to main menu
						break;
					default:
						// if choice is not in the menu, show error message
						System.out.println("Invalid choice! Try again\n");
						break;
				}
			} while (choice != 4);
		} else {
			// if username or password not matched/invalid print invalid message
			// and return to main menu
			System.out.println("Invalid Credentials!\n");
		}
	}
}
