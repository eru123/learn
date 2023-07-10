#include <iostream>
using namespace std;

int multiplier(int x, int y, int z){
	return x * y * z;
}

int main()
{	
	int x, y, z;
	cout << "Enter three numbers: ";
	cin >> x >> y >> z;
	cout << "The product of the numbers is: " << multiplier(x, y, z) << endl;


	return 0;
}