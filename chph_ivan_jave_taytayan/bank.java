import java.util.Scanner;

public class bank {
  final static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    double balance = 0, withdraw, deposit;
    double yearlyRate = .025;
  
  
    while(true)
    {
        System.out.println("Enter [d] for Deposit");
        System.out.println("Enter [z] for Withdrawal");
        System.out.println("Enter [x] for Exit");
        System.out.print("Option: ");
  
        char alphabet = scan.next().charAt(0);

        switch (alphabet)
        {
            case 'd':
                System.out.println("Beginning of Month Balance " + balance);
                System.out.print("Enter deposit amount: ");
                deposit = scan.nextDouble();
  
                balance += deposit; //computation
                System.out.println("Balance after Transaction " + balance);
                balance = balance + (yearlyRate/12) * balance; // computation
                break;
            case 'z':
                System.out.println("Beginning of Month Balance " + balance);
                System.out.print("Enter money to be Withdrawn:");
  
                withdraw = scan.nextInt();
  
                if (balance >= withdraw)
                {
                    balance -= withdraw;
                    System.out.println("Please collect your money:" + withdraw);
                }
                else
                {
                    System.out.println("Insufficient Balance");
                }
                System.out.println("");
                break;
            case 'x':
                System.exit(0);
        }
    }
  }
}