using System;

class ActivityOne
{
  static void Main ()
  { 
    // INPUT
    Console.Write ("Enter first number: ");
    int num1 = Convert.ToInt32 (Console.ReadLine ());
    Console.Write ("Enter second number: ");
    int num2 = Convert.ToInt32 (Console.ReadLine ());
    
    // PROCESS
    int sum = num1 + num2;
    
    // OUTPUT
    Console.WriteLine ("The sum of {0} and {1} is {2}", num1, num2, sum);
  }
}
