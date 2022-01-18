import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BirthMonth {
  final static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    // create empty hashset group1, group2 and self
    HashSet<String> group1 = new HashSet<String>();
    HashSet<String> group2 = new HashSet<String>();
    HashSet<String> self = new HashSet<String>();

    // enter birth month of group1 for 3 people
    for (int i = 0; i < 3; i++) {
      System.out.format("Enter birth month %d: ", i + 1);
      String birthMonth = in.nextLine();
      group1.add(birthMonth);
    }

    // enter birth month of group2 for 3 people
    for (int i = 0; i < 3; i++) {
      System.out.format("Enter birth month %d: ", i + 1);
      String birthMonth = in.nextLine();
      group2.add(birthMonth);
    }

    // sort group1 and group2
    List<String> list = new ArrayList<String>(group1);
    Collections.sort(list);
    List<String> list2 = new ArrayList<String>(group2);
    Collections.sort(list2);

    // display the sorted values of group1 and group2
    System.out.println("Group 1: " + list);
    System.out.println("Group 2: " + list2);

    // ask user to enter their birth month and add it to self
    System.out.println("Enter your birth month: ");
    String birthMonth = in.nextLine();
    self.add(birthMonth);

    // show the union, intersection and difference of group1 and group2
    Set<String> union = new HashSet<String>(group1);
    union.addAll(group2);
    list = new ArrayList<String>(union);
    Collections.sort(list);
    System.out.println("Union: " + list);

    Set<String> intersection = new HashSet<String>(group1);
    intersection.retainAll(group2);
    list = new ArrayList<String>(intersection);
    Collections.sort(list);
    System.out.println("Intersection: " + list);

    Set<String> difference = new HashSet<String>(group1);
    difference.removeAll(group2);
    list = new ArrayList<String>(difference);
    Collections.sort(list);
    System.out.println("Difference: " + list);

    // check if self is a member of group1 or group2
    group1.retainAll(self);
    group2.retainAll(self);
    if (group1.size() + group2.size() > 0) {
      System.out.println("You have the same birth month with one of your classmates.");
    }
  }
}