import java.util.Scanner;

public class LifeActivity {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        // take input from the user
        System.out.print("Enter your Age: ");
        int age = input.nextInt();
        
        System.out.print("Enter your Gender (M/F): ");
        String gender = input.next();

        // Result
        if(gender.equals("F") && age > 65 && age < 70){
            System.out.println("Visit your grand kids");
        } else if(gender.equals("M") && age > 65 && age < 70){
            System.out.println("Visit old friends");
        } else if(gender.equals("F") && age > 40 && age < 50){
            System.out.println("Take up gardening");
        } else if(gender.equals("M") && age > 40 && age < 50){
            System.out.println("Play golf woth your buddies");
        } else if(gender.equals("F") && age > 25 && age < 35){
            System.out.println("Attend parties as much as you can");
        } else if(gender.equals("M") && age > 25 && age < 35){
            System.out.println("Start saving for your own car");
        } else {
            System.out.println("You can do whatever you want");
        }
    }
}
