import java.util.*;
import java.io.*;

public class Stacks_Desola {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    Scanner sc = new Scanner(System.in);

    int choice = 0;

    while (choice != 4){
      System.out.print("\nMenu\n1. Display\n2. Push\n3. Pop\n4. Exit\nWhat? ");
      choice = sc.nextInt();

      switch (choice){
        case 1:
          if (stack.empty()){
            System.out.println("Stack is empty");
          } else {
            while (!stack.empty()){
              System.out.print(stack.peek() + " ");
              temp.push(stack.pop());
            }
            System.out.println();
            while (!temp.empty()){
              stack.push(temp.pop());
            }
          }
          break;
        case 2:
          System.out.print("What element? ");
          int x = sc.nextInt();
          System.out.println("PUSH = " + x);
          stack.push(x);
          break;
        case 3:
          if (stack.empty()){
            System.out.println("Stack is empty");
          } else {
            System.out.println("POP = " + stack.peek());
            stack.pop();
          }
          break;
        case 4:
          System.out.println("Exiting");
          break;
        default:
          System.out.println("Invalid choice");
      }
    }
  }
}