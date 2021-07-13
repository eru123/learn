using System;

class ActivityNine {
  static void Main() {
    
    // INPUT
    Console.Write("Enter grade: ");
    int grade = Convert.ToInt32(Console.ReadLine());
    
    // PROCESS 
    char remarks;

    if(grade >= 90) {
        remarks = 'A';
    } else if(grade >= 80 && grade <= 89){
        remarks = 'B';
    } else if(grade >= 70 && grade <= 79){
        remarks = 'C';
    } else if(grade >= 60 && grade <= 69){
        remarks = 'D';
    } else {
        remarks = 'E';
    }

    // OUTPUT
    Console.WriteLine("Your grade in character is " + remarks);
  }
}
