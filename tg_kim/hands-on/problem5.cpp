#include <iostream>
using namespace std;

int main()
{	
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
	return 0;
}