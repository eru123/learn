using System;

class ActivityTwo {
  static void Main() {
      
    // INPUT
    Console.Write("Enter radius: ");
    double radius = Convert.ToDouble(Console.ReadLine());
    
    // PROCESS
    double area = Math.PI * radius * radius;
    
    // OUTPUT
    Console.WriteLine("The area is " + area);
  }
}
