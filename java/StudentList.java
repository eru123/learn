import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class StudentList {
	final static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String, String> students = new HashMap<>();
		String studentNumber, studentName;

		for (int i = 1; i < 3; i++) {
			System.out.print("Enter Student Number " + i + " : ");
			studentNumber = s.nextLine();
			System.out.print("Enter Firstname      " + i + " : ");
			studentName = s.nextLine();
			students.put(studentNumber, studentName);
		}
		
		System.out.print("Enter Student Number 3 : ");
		studentNumber = s.nextLine();
		System.out.print("Enter Firstname 3      : ");
		studentName = s.nextLine();
		students.put(studentNumber, studentName);
		System.out.println();

		System.out.println("Student List : ");
		for (Map.Entry entry : students.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		students.remove(studentNumber, studentName);

		System.out.print("Enter your Student Number : ");
		studentNumber = s.nextLine();
		System.out.print("Enter your Firstname      : ");
		studentName = s.nextLine();
		students.put(studentNumber, studentName);
		System.out.println();

		System.out.println("Student List : ");
		for (Map.Entry entry : students.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}