import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// main menu class, parent class of all other menu classes
abstract class MainMenu {
	// abstract method to be implemented by all other menu classes
	abstract void menu();
	abstract boolean login();

	// constant variable
	final static Scanner scan = new Scanner(System.in);

	// delimeters for writing and reading files
	final static String DELIM1 = ",";
	final static String DELIM2 = ":";

	// files to read and write to
	final static String STUDENT_FILE = "students.txt";
	final static String TEACHER_FILE = "teachers.txt";

	// subjects 2d-array
	// array[0] is for 1st semester
	// array[1] is for 2nd semester
	final static String[][] SUBJECTS = {
			{
					"input Fundamentals of Gaming",
					"Introduction to Computing",
					"Introduction to Programming",
					"Mathematics in Modern World",
					"Physical Education I"
			},
			{
					"input Fundamentals of Gaming II",
					"Advanced Interface Design",
					"Introduction to Computing II",
					"Introduction to Programming II",
					"Physical Education II"
			}
	};

	// df for formatting decimal number
	final static DecimalFormat df = new DecimalFormat("#.##");

	// teachers arrayList for storing teacher objects
	final static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

	// students arrayList for storing student objects
	final static ArrayList<Student> students = new ArrayList<Student>();

	// write data to file
	void saveToFile() {
		try {
			// convert teachers arrayList to string array
			String[] teacherStrings = new String[teachers.size()];
			for (int i = 0; i < teachers.size(); i++)
				teacherStrings[i] = teachers.get(i).toString();

			// write teachers data to file
			FileWriter fw = new FileWriter(TEACHER_FILE); // open teacher file for writing
			for (String teacherString : teacherStrings)
				fw.write(teacherString + "\n"); // write each teacher to file
			fw.close(); // close file

			// convert students arrayList to string array
			String[] studentStrings = new String[students.size()];
			for (int i = 0; i < students.size(); i++)
				studentStrings[i] = students.get(i).toString();

			// write students data to file
			fw = new FileWriter(STUDENT_FILE); // open student file for writing
			for (String studentString : studentStrings)
				fw.write(studentString + "\n"); // write each student to file
			fw.close(); // close file
		} catch (IOException e) {
			// if error occur, print error message
			System.out.println("Error in saving to file.");
			System.out.println("  - This might likely to happen if file is being used by another program");
			System.out.println("  - Or you have no permission to create/write to the file\n");
		}
	}

	// read data from file
	void readFromFile() {
		try {
			// create temporary teachers arrayList
			ArrayList<Teacher> tempTeachers = new ArrayList<Teacher>();

			// read teacher file
			// open teacher file for reading
			BufferedReader br = new BufferedReader(new FileReader(TEACHER_FILE));

			// temporary string to store each line of file
			String line;

			while ((line = br.readLine()) != null) {
				// split line into array of strings
				String[] teacherString = line.split(DELIM1);

				// create teacher object from array of strings
				Teacher teacher = new Teacher(teacherString[0], teacherString[1], teacherString[2]);

				// add teacher to temporary teachers arrayList
				tempTeachers.add(teacher);
			}

			// close teacher file
			br.close();

			// replace teachers arrayList with temporary teachers arrayList
			teachers.clear();
			teachers.addAll(tempTeachers);

			// create temporary students arrayList
			ArrayList<Student> tempStudents = new ArrayList<Student>();

			// read student file
			BufferedReader br2 = new BufferedReader(new FileReader(STUDENT_FILE));

			// read each line of student file
			while ((line = br2.readLine()) != null) {
				// split line into array of strings
				String[] studentString = line.split(DELIM1);

				// split sem1 string and convert to double type using DELIM2
				String[] sem1Strings = studentString[3].split(DELIM2);
				double[] sem1 = new double[sem1Strings.length];
				for (int i = 0; i < sem1Strings.length; i++)
					sem1[i] = Double.parseDouble(sem1Strings[i]);

				// split sem2 string and convert to double type using DELIM2
				String[] sem2Strings = studentString[4].split(DELIM2);
				double[] sem2 = new double[sem2Strings.length];
				for (int i = 0; i < sem2Strings.length; i++)
					sem2[i] = Double.parseDouble(sem2Strings[i]);

				// create student object from array of strings
				Student student = new Student(studentString[0], studentString[1], studentString[2], sem1, sem2);

				// add student to temporary students arrayList
				tempStudents.add(student);
			}

			// close student file
			br2.close();

			// replace students arrayList with temporary students arrayList
			students.clear();
			students.addAll(tempStudents);

		} catch (IOException e) {
			// if error occurs, print error message
			System.out.println("Error reading database");
			System.out.println("  - This might likely to happen if database is empty.");
			System.out.println("  - Or the file is corrupted.");
			System.out.println("  - Or the file doesn't exists.\n");
		}
	}

	// method for listing all students with id and name
	// in tabular format
	void listStudents(){
		System.out.format("+--------+--------------------------------+\n");
		System.out.format("| %6s | %30s |\n", "ID", "Name");
		System.out.format("+-----------------------------------------+\n");
		if (students.size() == 0) {
			System.out.format("| %39s |\n", "No students found");
		} else {
			for (Student s : students) {
				System.out.format("| %6s | %30s |\n", s.getId(), s.getName());
			}
		}
		System.out.format("+--------+--------------------------------+\n");
	}

	// method for listing all teachers with id and name
	// in tabular format
	void listTeachers(){
		System.out.format("+--------+--------------------------------+\n");
		System.out.format("| %6s | %30s |\n", "ID", "Name");
		System.out.format("+-----------------------------------------+\n");
		if (teachers.size() == 0) {
			System.out.format("| %39s |\n", "No teachers found");
		} else {
			for (Teacher t : teachers) {
				System.out.format("| %6s | %30s |\n", t.getId(), t.getName());
			}
		}
		System.out.format("+--------+--------------------------------+\n");
	}

	// Teacher class type definition
	class Teacher {
		// class properties
		private String id;
		private String name;
		private String password;

		// Teacher class constructor
		Teacher(String id, String name, String password) {
			this.id = id;
			this.name = name;
			this.password = password;
		}

		// check if name and password parameters are equals to name and password
		// properties, this will use for teacher login
		boolean equals(String id, String password) {
			return this.id.equals(id) && this.password.equals(password);
		}

		// get teacher name
		String getName() {
			return this.name;
		}

		// get teacher information in string format delimited by DELIM1
		public String toString() {
			return this.id + DELIM1 + this.name + DELIM1 + this.password;
		}

		// check if teacher id is equals to parameter id
		// this will use to check if teacher id is already exists
		boolean hasId(String id) {
			return this.id.equals(id);
		}

		// get teacher id
		String getId() {
			return this.id;
		}
	}

	// Student class type definition
	class Student {
		private String id;
		private String password;
		private String name;
		private double[] sem1;
		private double[] sem2;

		// Student class constructor
		Student(String id, String name, String password,  double[] sem1, double[] sem2) {
			this.id = id;
			this.password = password;
			this.name = name;
			this.sem1 = sem1;
			this.sem2 = sem2;
		}

		// check if id and password parameters are equals to id and password
		// properties, this will use for student login
		boolean equals(String user, String pass) {
			return this.id.equals(user) && this.password.equals(pass);
		}

		// get student name and id
		String getName() {
			return this.name;
		}

		// get sem1 computed grade
		double getSem1Grade() {
			double grade = 0;
			for (int i = 0; i < sem1.length; i++) {
				// add all grades
				grade += sem1[i];
			}

			// return grade divided by number of subjects
			return grade / sem1.length;
		}

		// set sem1 value
		void setSem1(double[] s1){
			this.sem1 = s1;
		}

		// get sem2 computed grade
		double getSem2Grade() {
			double grade = 0;
			for (int i = 0; i < sem2.length; i++) {
				grade += sem2[i];
			}
			return grade / 
			sem2.length;
		}

		// get calculated grade for all semesters
		private double[] getFinalGrades() {
			double[] finalGrade = new double[2];
			finalGrade[0] = getSem1Grade();
			finalGrade[1] = getSem2Grade();
			return finalGrade;
		}

		// get total calculated grade for all semesters
		private double getFinalGrade() {
			double[] finalGrade = getFinalGrades();
			double grade = 0;
			for (int i = 0; i < finalGrade.length; i++) {
				grade += finalGrade[i];
			}
			return grade / finalGrade.length;
		}

		// set sem2 value 
		void setSem2(double[] s2){
			this.sem2 = s2;
		}

		// get student information in string format delimited by DELIM1
		// sem1 and sem2 grades are delimited by DELIM2
		public String toString() {
			String sem1String = "";
			for (int i = 0; i < sem1.length; i++) {
				if (i == sem1.length - 1) {
					// if last element, do not add delimiter
					sem1String += sem1[i];
				} else {
					// if not last element, add delimiter
					sem1String += sem1[i] + DELIM2;
				}
			}
			String sem2String = "";
			for (int i = 0; i < sem2.length; i++) {
				if (i == sem2.length - 1) {
					// if last element, do not add delimiter
					sem2String += sem2[i];
				} else {
					// if not last element, add delimiter
					sem2String += sem2[i] + DELIM2;
				}
			}

			// return student information in string format
			return this.id + DELIM1 + this.name + DELIM1 + this.password + DELIM1 + sem1String + DELIM1 + sem2String;
		}

		// check if student id is equals to id parameter
		// this will be use to check if student is already registered
		boolean hasId(String id) {
			return this.id.equals(id);
		}

		// get student id
		String getId() {
			return this.id;
		}

		// print sem1 table
		void sem1Table(){
			System.out.format("+-------------------------------------+-------+\n");
			System.out.format("| %35s | %5s |\n", "SUBJECT", "GRADE");
			System.out.format("+-------------------------------------|-------+\n");
			for (int i = 0; i < sem1.length; i++) {
				System.out.format("| %35s | %5s |\n", SUBJECTS[0][i], df.format(sem1[i]));
			}
			System.out.format("+-------------------------------------|-------+\n");
			System.out.format("| %35s | %5s |\n", "TOTAL", df.format(getSem1Grade()));
			System.out.format("+-------------------------------------+-------+\n");
		}

		// print sem2 table
		void sem2Table(){
			System.out.format("+-------------------------------------+-------+\n");
			System.out.format("| %35s | %5s |\n", "SUBJECT", "GRADE");
			System.out.format("+-------------------------------------|-------+\n");
			for (int i = 0; i < sem2.length; i++) {
				System.out.format("| %35s | %5s |\n", SUBJECTS[1][i], df.format(sem2[i]));
			}
			System.out.format("+-------------------------------------|-------+\n");
			System.out.format("| %35s | %5s |\n", "TOTAL", df.format(getSem2Grade()));
			System.out.format("+-------------------------------------+-------+\n");
		}

		// print final table
		void finalTable(){
			System.out.format("+---------------------------+-------+\n");
			System.out.format("| %25s | %5s |\n", "SEMESTER", "GRADE");
			System.out.format("+---------------------------|-------+\n");
			System.out.format("| %25s | %5s |\n", "Semester 1", df.format(getSem1Grade()));
			System.out.format("| %25s | %5s |\n", "Semester 2", df.format(getSem2Grade()));
			System.out.format("+---------------------------|-------+\n");
			System.out.format("| %25s | %5s |\n", "TOTAL", df.format(getFinalGrade()));
			System.out.format("+---------------------------+-------+\n");
		}
	}
}
