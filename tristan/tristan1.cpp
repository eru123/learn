#include <iostream>

using namespace std;

int main(){
	int data[5];
	int i;
	int sum = 0;
	int average;
	
	for(i=0; i<5; i++){
		cout << "Enter input " << i + 1 << ": ";
		cin >> data[i];
		sum += data[i];
	}

	average = sum / 5;
	
	cout << "SUM: " << sum << endl;
	cout << "AVERAGE: " << average << endl;
	
	return 0;
}
