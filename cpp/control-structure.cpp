#include <iostream>
using namespace std;

int main(){

  // PROBLEM 1
  cout << "Finding the largest in 3 number inputs" << endl;
  int largest = 0;
  int num;
  for (int i = 0; i < 3; i++){
    cout << "Enter number " << i + 1 << ": ";
    cin >> num;
    if (num > largest) {
      largest = num;
    }
  }

  cout << "The largest number is " << largest << endl << endl;

  // PROBLEM 2
  string course = "";
  while (course != "BSIE" && course != "BSCPE" && course != "BSECE"){
    cout << "What is your course? ";
    cin >> course;
  }
  cout << "Your course is " << course << endl << endl;

  // PROBLEM 3
  string gender;
  do {
    cout << "Are you a 'Male' or 'Female'? ";
    cin >> gender;
    if (gender == "Male") {
      cout << "Your sports is Swimming\n" << endl;
    } else if (gender == "Female") {
      cout << "Your sports is Volleyball\n" << endl;
    } else {
      cout << "You entered an invalid input\n" << endl; 
    }
  } while (gender != "Male" && gender != "Female");
  
  // PROBLEM 4
  double money = 200;
  int choice;
  cout << "My Food Menu: " << endl;
  cout << "1. Adobo - PHP 40" << endl;
  cout << "2. Sinigang - PHP 50" << endl;
  cout << "3. Hotdog Jumbo - PHP 25" << endl;
  cout << "4. Lumpia - PHP 25" << endl;
  for (int i=0; i < 2; i++){
    cout << "Enter your choice " << i + 1 << ": ";
    cin >> choice;
    switch(choice){
      case 1:
        money -= 40;
        break;
      case 2:
        money -= 50;
        break;
      case 3:
        money -= 25;
        break;
      case 4:
        money -= 25;
        break;
    }
  }
  cout << "Money left is " << money << endl << endl;
  
  // PROBLEM 5
  int calculus;
  int algebra;
  cout << "What is the hardest subject?" << endl;
  cout << "Rate Algebra (1-10): ";
  cin >> algebra;
  cout << "Rate Calculus (1-10): ";
  cin >> calculus;
  if(algebra > calculus){
    cout << "The hardest for you is Algebra\n" << endl;
  } else if (calculus > algebra) {
    cout << "The hardest for you is Calculus\n" << endl;
  } else {
    cout << "The hardest for you is Both\n" << endl;
  }

  // PROBLEM 6
  int application = 0;
  int portability = 0;

  while (application != 1 && application != 2){
    cout << "\nWhat applications you need?\n1. Ordinary Ones\n2. High-Computing Ones\nEnter your choice: ";
    cin >> application;
  }

  while (portability != 1 && portability != 2){
    cout << "\nSelect Device\n1. Portable\n2. Non-Portable\nEnter your choice";
    cin >> portability;
  }

  string ram = "8-16";
  string device = "Desktop";
  
  if(application == 1) ram = "4";
  if (portability == 1) device = "Laptop";

  cout << device << " - " << ram << "GB RAM, 500GB SSD" << endl;

  return 0;
}