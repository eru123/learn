import java.util.Scanner;

class year {
    // a method that takes a year as input and returns a valid year
    static int readYear(){
        Scanner input = new Scanner(System.in);
        
        // a loop that ask the user to enter a year until the user enters a valid year 
        while(true){
            // ask the user to enter a year
            System.out.print("Enter a year: ");
            int year = input.nextInt();

            // check if the year is valid
            if(year >= 1582){
                return year;
            }

            // if the year is invalid, print an error message
            System.out.println("Invalid year. Try again! ");
        }
    }
    // a function that returns true if the year is a leap year and false otherwise
    static boolean isLeapYear(int year){
        // check if the year is divisible by 4
        if(year % 4 == 0){
            // check if the year is divisible by 100
            if(year % 100 == 0){
                // check if the year is divisible by 400
                if(year % 400 == 0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    // a function that ask yes or no and return y or n character
    static String repeatProcess(String message){
        Scanner input = new Scanner(System.in);
        // a loop that ask the user to enter a valid answer until the user enters a valid answer
        while(true){
            // ask the user to enter a valid answer
            System.out.print(message);
            String answer = input.nextLine();

            // check if the answer is valid
            if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")){
                // if the answer is valid, return the answer
                return answer.toLowerCase().charAt(0) + "";
            }

            // if the answer is invalid, print an error message
            System.out.println("Invalid answer. Try again! ");
        }
    }
    public static void main(String[] args) {
        while(true){
            // get a valid year
            int year = readYear();

            // check if the year is a leap year
            if (isLeapYear(year)){
                // if the year is a leap year, print a message
                System.out.println("The year " + year + " is a leap year.");
            }
            else {
                // if the year is not a leap year, print a message
                System.out.println("The year " + year + " is not a leap year.");
            }

            // ask the user if they want to continue
            String answer = repeatProcess("Do you want to continue? (y/n) ");
            
            // if user wants to continue, continue the loop
            if(answer.equals("n")){
                break;
            }
        }
    }
}