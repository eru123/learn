using System;

class ActivitySix {
  static void Main() {
    
    // INPUT
    Console.Write("Enter inches: ");
    double inches = Convert.ToDouble(Console.ReadLine());
    
    // PROCESS 
    double cm = inches * 2.54;

    // OUTPUT
    Console.WriteLine("The equivalent centimeter is " + cm);
  }
}
