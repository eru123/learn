#include <iostream>
using namespace std;

// problem 1
void sampleprint(){
	cout << "This is a sample printing function" << endl;
}

// problem 2
void countryvalidation (string country){
	cout << (country == "Philippines" ? "You are a Filipino" : "You are not a Filipino") << endl;
}

// problem 3
int multiplier(int x, int y, int z){
	return x * y * z;
}

int main()
{	
	// problem 1
	sampleprint();
	sampleprint();
	sampleprint();
	sampleprint();
	sampleprint();

	// problem 2
	string country;
	cout << "Enter your country: ";
	cin >> country;
	countryvalidation(country);

	// problem 3
	int x, y, z;
	cout << "Enter three numbers: ";
	cin >> x >> y >> z;
	cout << "The product of the numbers is: " << multiplier(x, y, z) << endl;

	// problem 4
	string str[5] = {"Hello", "World", "!", "This", "is"};
	char chr[5] = {'H', 'e', 'l', 'l', 'o'};
	int num[5] = {1, 2, 3, 4, 5};
	cout << "String array: " << str[2] << endl;
	cout << "Char array: " << chr[2] << endl;
	cout << "Int array: " << num[2] << endl;

	// problem 5
	int nums[5];
	cout << "Enter 5 numbers: ";
	for (int i = 0; i < 5; i++){
		cin >> nums[i];
	}
	for (int i = 0; i < 4; i++){
		for (int j = 0; j < 4; j++){
			if (nums[j] > nums[j+1]){
				int temp = nums[j];
				nums[j] = nums[j+1];
				nums[j+1] = temp;
			}
		}
	}
	cout << "Sorted numbers: ";
	for (int i = 0; i < 5; i++){
		cout << nums[i] << " ";
	}
	cout << endl;

	// problem 6
	int twoD[4][5] = {
		{88, 77, 56, 23, 22},
		{90, 34, 72, 98, 45},
		{78, 80, 23, 18, 19},
		{21, 33, 35, 45, 58}
	};
	for (int i = 0; i < 4; i++){
		for (int j = 0; j < 5; j++){
			cout << twoD[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}