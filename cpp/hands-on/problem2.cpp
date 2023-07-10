#include <iostream>
using namespace std;

void countryvalidation (string country){
	cout << (country == "Philippines" ? "You are a Filipino" : "You are not a Filipino") << endl;
}


int main()
{	
	string country;
	cout << "Enter your country: ";
	cin >> country;
	countryvalidation(country);

	return 0;
}