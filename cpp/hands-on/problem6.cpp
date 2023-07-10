#include <iostream>
using namespace std;

int main()
{	
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