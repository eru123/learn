using System;

class ActivityThree {
  static void Main() {
    
    // INPUT
    Console.Write("Enter Quiz 1: ");
    double q1 = Convert.ToDouble(Console.ReadLine());
    
    Console.Write("Enter Quiz 2: ");
    double q2 = Convert.ToDouble(Console.ReadLine());
    
    Console.Write("Enter Quiz 3: ");
    double q3 = Convert.ToDouble(Console.ReadLine());
    
    // PROCESS
    double ave = (q1 + q2 + q3) / 3;
    
    // OUTPUT
    Console.WriteLine("The Average is " + ave);
  }
}
