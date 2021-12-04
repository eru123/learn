// teacher menu class, subclass of MainMenu
class TeacherMenu extends MainMenu {
	private Teacher currenTeacher;
	private Student currentStudent;

	// login admin
	boolean login() {
		try {
			System.out.println("\n- - - LOGIN - - -");

			// get username and password
			System.out.print("Enter Teacher ID: ");
			String id = scan.nextLine();
			System.out.print("Enter Teacher Password: ");
			String password = scan.nextLine();

			// check if username and password is in the teachers arrayList
			for (Teacher teacher : teachers) {
				if (teacher.equals(id, password)) {
					System.out.println("\nLogin Successful!");
					currenTeacher = teacher;

					return true;
				}
			}

			// if not in the array, return false
			return false;
		} catch (Exception e) {
			System.out.println("Ther is Error in Teacher Login\n");
			// if any error occur, return false
			return false;
		}
	}

	// select student menu
	private void selectStudentMenu() {
		System.out.println("\n- - - SELECT STUDENT - - -");
		listStudents();
		System.out.print("Enter Student ID to grade: ");
		String id = scan.nextLine();

		// check if student id is in the students arrayList
		for (Student student : students) {
			if (student.hasId(id)) {
				// if student found in the array, set current student
				// and return to main menu
				currentStudent = student;
				return;
			}
		}

		// if not in the array, print error message
		System.out.println("\nStudent ID not found! Try again.");
	}

	// give grades to student in a specific semester
	private void gradeSemester(int semIndex) {
		try {
			if(semIndex != 0 && semIndex != 1) {
				System.out.println("\nInvalid Semester Index! Try again.");
				return;
			}

			// get subject list from selected sem
			String[] subs = SUBJECTS[semIndex];

			// temp semester grade array
			double[] sem = new double[subs.length];

			// give grades per subject
			for (int i = 0; i < subs.length; i++) {
				// display current subject
				System.out.println("SUBJECT: " + subs[i]);

				double wr = 0; // writen works
				double pt = 0; // performance task
				double me = 0; // midterm exam
				double fe = 0; // finals exam
				double fg = 0; // final grade

				// give grades for 4 written wors
				for (int j = 0; j < 4; j++) {
					// display current written works
					// get grade from user
					System.out.format("  - Written Work %d (10 items): ", j + 1);
					double wri = Double.valueOf(scan.nextLine());

					if (wri > 10) {
						// wri max of 10; 
						wri = 10;
					} else if (wri < 0) {
						// wri min of 0;
						wri = 0;
					}

					// add score to the wr variable for written works
					wr += wri;
				}

				// compute writen works, and get 20% of the grade
				wr /= 40;
				wr *= 100;
				wr *= 0.2;

				// give grades for 2 performance tasks
				for (int j = 0; j < 2; j++) {
					// display current performance task
					// get grade from user
					System.out.format("  - Performance Task %d (50 items): ", j + 1);
					double per = Double.valueOf(scan.nextLine());
					
					if (per > 50) {
						// per max of 50;
						per = 50;
					} else if (per < 0) {
						// per min of 0;
						per = 0;
					}

					// add score to the pt variable for performance task
					pt += per;
				}

				// compute performance task, and get 30% of the grade
				pt /= 100;
				pt *= 100;
				pt *= 0.3;

				// give grades for midterm exam
				// get grade from user
				System.out.format("  - Midterm Exam (100): ");
				me = Double.valueOf(scan.nextLine());

				if (me > 100) {
					// me max of 100;
					me = 100;
				} else if (me < 0) {
					// me min of 0;
					me = 0;
				}

				// compute midterm exam, and get 25% of the grade
				me /= 100;
				me *= 100;
				me *= 0.25;

				// give grades for finals exam
				// get grade from user
				System.out.format("  - Finals Exam (100): ");
				fe = Double.valueOf(scan.nextLine());

				if (fe > 100) {
					// fe max of 100;
					fe = 100;
				} else if (fe < 0) {
					// fe min of 0;
					fe = 0;
				}

				// compute finals exam, and get 25% of the grade
				fe /= 100;
				fe *= 100;
				fe *= 0.25;

				// compute the final grade 
				fg = wr + pt + me + fe;

				// display final grade
				System.out.format("  - Final Grade: %s\n", df.format(fg));

				// add computed grade to the current subject
				sem[i] = fg;
			}

			// set semester grade to the current student
			if(semIndex == 0 ) {
				currentStudent.setSem1(sem);
			} else {
				currentStudent.setSem2(sem);
			}

			// find current student in the arrayList and set the updated student 
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).hasId(currentStudent.getId())) {
					students.set(i, currentStudent);
					// print success message 
					System.out.println("\nGrades updated successfully!");
					break;
				}
			}
		} catch (Exception e) {
			// if error occur, print error message
			System.out.println("\nError occur while grading selected Semester! Try again\n");
		}
	}

	// give grades to student
	private void gradeStudent() {
		System.out.println("\n- - - SELECT SEMESTER - - -");
		if (currentStudent != null) {
			// select sem to grade
			int choice = 0;
			System.out.println("[1]. Semester 1");
			System.out.println("[2]. Semester 2");
			System.out.println("[3]. Back");
			System.out.print("Enter your choice: ");

			try {
				// get choice from user
				choice = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// if user input is not integer, set choice to 0
				choice = 0;
			}

			switch (choice) {
				case 1:
					// if choice is 1, grade semester 1
					gradeSemester(0);
					break;
				case 2:
					// if choice is 2, grade semester 2
					gradeSemester(1);
					break;
				case 3:
					// if choice is 3, go back to teacher menu
					break;
				default:
					// if choice invalid print error message
					System.out.println("\nInvalid choice! Try again.");
					break;
			}
		}
	}

	void menu() {
		// teacher login
		boolean authenticated = login();

		if (authenticated) {
			// if login successful

			// greet teacher
			System.out.println("\nAccess Granted! Welcome " + currenTeacher.getName() + "!");

			// loop until user choose to exit
			int choice = 0;
			while (choice != 2) {
				// show menu
				System.out.println("\n- - - - - TEACHER - - - -");
				System.out.println("[1] SELECT STUDENT");
				System.out.println("[2] BACK");
				System.out.print("Input your choice: ");

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
						// select student menu
						selectStudentMenu();

						// if a student has been selected
						gradeStudent();
						break;
					case 2:
						break;
					default:
						// if user input is not 1 or 2, show error message
						System.out.println("Invalid Input! Please try again.");
						break;
				}
			}

		} else {
			// if username or password not matched/invalid print invalid message
			// and return to main menu
			System.out.println("Invalid Teacher Credentials!\n");
		}
	}
}
