#include <iostream>

using namespace std;

int main(){
	
	float human;
	float dog = 0;
	
	cout << "Enter the human years: ";
	cin >> human;
	
	if(human <= 0) { // the human years is negative or equal to zero
		cout << "Please enter a positive integer" << endl;
		return 0;
	} else if (human >= 2) { // the human year is greater than 2 years
		dog = 10.5 + ((human - 2) * 4); 
	} else if (human < 2) { // the human year is less than 2 years
		dog = human * 5.25;
	}
	
	cout << "Dog years: " << dog << endl;
	return 0;
}
