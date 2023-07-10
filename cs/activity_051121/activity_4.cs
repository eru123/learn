using System;

class ActivityFour {
  static void Main() {
    
    // INPUT
    Console.Write("Enter Farenheit: ");
    double farenheit = Convert.ToDouble(Console.ReadLine());
    
    // PROCESS 
    double celsius = .5556 * ( farenheit - 32);

    // OUTPUT
    Console.WriteLine("The equivalent celsius is " + celsius);
  }
}
