import java.io.*;
import java.util.*;

class Sort {
  public static void main(String[] args) {
    // try to read the input.txt file
    try {

      // open the file
      File file = new File("input.txt"); 

      // create a scanner to read the file
      Scanner sc = new Scanner(file); 

      // create an arraylist to store the unsorted numbers
      ArrayList<Integer> raw = new ArrayList<Integer>();  

      // while there are still numbers to read
      while (sc.hasNextInt()) { 
        // check if the number is a valid integer
        if (sc.hasNextInt()) {
          // add the number to the arraylist
          raw.add(sc.nextInt());
        }
      }

      // close the scanner
      sc.close(); 
      
      // print the unsorted numbers
      System.out.println("Unsorted array: \n" + raw);

      // sort the arraylist
      ArrayList<Integer> sorted = sort(raw);

      // print the sorted numbers
      System.out.println("Array Sorted using Heapsort: \n" + sorted);

      // write the sorted numbers to the output.txt file
      writeToFile(sorted);

    } catch (IOException e) {
      // if the file cannot be read, print an error message
      System.out.println("\n\nAn error occurred while reading input.txt");
    }
  }


  // sort the arraylist using heapsort algorithm
  public static ArrayList<Integer> sort(ArrayList<Integer> raw) {
    
    // create a new arraylist to store the sorted numbers
    ArrayList<Integer> sorted = new ArrayList<Integer>();

    // while there are still numbers to sort
    while (raw.size() > 0) {
      // get the largest number in the unsorted array
      int max = 0;
      for (int i = 0; i < raw.size(); i++) {
        if (raw.get(i) > raw.get(max)) {
          max = i;
        }
      }

      // add the largest number to the sorted array
      sorted.add(raw.get(max));

      // remove the largest number from the unsorted array
      raw.remove(max);
    }

    // return the sorted array
    return sorted;
  }

  static void writeToFile(ArrayList<Integer> sorted){
    try {
      // open the file
      File file = new File("output.txt"); 

      // create a scanner to read the file
      PrintWriter pw = new PrintWriter(file); 

      // write the sorted numbers to the file
      for (int i = 0; i < sorted.size(); i++) {
        // if last number, don't add a space
        if (i == sorted.size() - 1) {
          pw.print(sorted.get(i));
        } else {
          pw.print(sorted.get(i) + " ");
        }
      }

      // close the file
      pw.close(); 
    } catch (IOException e) {
      // if an error occurs, print an error message
      System.out.println("\n\nAn error occurred while writing to output.txt");
    }
  }
}