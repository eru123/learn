#include <iostream>
using namespace std;

int main()
{	
	string str[5] = {"Hello", "World", "!", "This", "is"};
	char chr[5] = {'H', 'e', 'l', 'l', 'o'};
	int num[5] = {1, 2, 3, 4, 5};
	cout << "String array: " << str[2] << endl;
	cout << "Char array: " << chr[2] << endl;
	cout << "Int array: " << num[2] << endl;

	return 0;
}