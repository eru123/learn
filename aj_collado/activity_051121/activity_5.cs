using System;

class ActivityFive {
  static void Main() {
    
    // INPUT
    Console.Write("Enter dollar: ");
    double dollar = Convert.ToDouble(Console.ReadLine());
    
    // PROCESS 
    double peso = dollar * 51.50;

    // OUTPUT
    Console.WriteLine("The equivalent peso value is " + peso);
  }
}
