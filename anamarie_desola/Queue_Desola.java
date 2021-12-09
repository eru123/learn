import java.util.*;

public class Queue_Desola {
  final static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<Integer>();

    int choice = 0;
    int arraySize = 0;

    System.out.print("Enter the size of the array: ");
    arraySize = sc.nextInt();


    while (choice != 4){
      System.out.println("Menu\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();

      switch(choice){
        case 1:
          System.out.print("Enter the element to be enqueued: ");
          if (arraySize > queue.size()){
            queue.add(sc.nextInt());
          }
          else{
            System.out.println("Queue is full");
          }
          break;
        case 2:
          if(queue.isEmpty()){
            System.out.println("Queue is empty.");
          }
          else{
            System.out.println("Element dequeued: " + queue.remove());
          }
          break;
        case 3:
          if(queue.isEmpty()){
            System.out.println("Queue is empty.");
          }
          else{
            System.out.println("Queue: " + queue);
          }
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice.");
          break;
      }
    }
  }
}
