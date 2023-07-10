using System;

class ActivityEight {
  static void Main() {
    
    // INPUT
    Console.Write("Enter your age: ");
    int age = Convert.ToInt32(Console.ReadLine());
    
    // PROCESS 
    string remarks;
    if(age >= 18) {
      remarks= "You are qualified to vote";
    } else {
      remarks = "You are not qualified to vote";
    }

    // OUTPUT
    Console.WriteLine(remarks);
  }
}
