using System;

class ActivitySeven {
  static void Main() {
    
    // INPUT
    Console.Write("Enter the value of X: ");
    string x = Console.ReadLine();

    Console.Write("Enter the value of Y: ");
    string y = Console.ReadLine();
    
    // PROCESS 
    string tmp = x;
    x = y;
    y = tmp;

    // OUTPUT
    Console.WriteLine("The current value of X is " + x);
    Console.WriteLine("The current value of Y is " + y);
  }
}
