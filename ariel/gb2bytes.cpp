#include <iostream>

using namespace std;

int main()
{

	// initialization
	float specified;

	// input
	cout << "Enter the size of the hard drive specified by the manufacturer in GB" << endl;
	cout << "Enter: ";
	cin >> specified; // ieenter ni user dito ay GB for example 40 GB

	// compute
	// first convert muna natin si GB to bytes, para gawin yun, multiply molang si 'specified' sa 1 billion
	// bale magiging ganto sya 'specified * 1000000000'
	// tapos multiply mo si 1024 ng 3 times parang ganto '1024 * 1024 * 1024'
	// yung unang 1024 para yan sa bytes, yung pangalawa sa megabytes, yung pangatlo para gigabytes kaya tatlong beses
	// tapos ipag devide mo sila
	float actual = (specified * 1000000000) / (1024 * 1024 * 1024);

	// ouput
	cout << "The actual storage capacity is approximately " << actual << " GB." << endl;

	return 0;
}
