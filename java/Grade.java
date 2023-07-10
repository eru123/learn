import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner Input = new Scanner(System.in);
	    
	    
	    // Get Name
	    System.out.print("Enter name: ");
	    String name = Input.nextLine();
	    
	    // Get Course
	    System.out.print("Enter course: ");
	    String course = Input.nextLine();
	    
	    // Get Year
	    System.out.print("Enter year: ");
	    int year = Input.nextInt();
	    
	    // Get 1st periodic grade
	    System.out.print("Enter 1st Periodic Grade: ");
	    float g1 = Input.nextFloat();
	    
	    // Get 2st periodic grade
	    System.out.print("Enter 2nd Periodic Grade: ");
	    float g2 = Input.nextFloat();
	    
	    // Get 3rd periodic grade
	    System.out.print("Enter 3rd Periodic Grade: ");
	    float g3 = Input.nextFloat();
	    
	    // Final Grade
	    int fg = Math.round((g1 + g2 + g3) / 3);
	    System.out.println("Final Grade is: " + fg);
	    
	    // Remarks
	    if(fg < 50) {
	        System.out.println("You Failed!!");
	    } else {
	        System.out.println("You Passed!");
	    }
	}
}
