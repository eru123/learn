#include <iostream>
using namespace std;

int main(){
	int data[12][1];
	int i;
	int search;
	int occurence = 0;
	
	for(i=0; i<12; i++){
		cout << "Enter input " << i + 1 << ": ";
		cin >> data[i][0];
	}

	cout << "Enter a number to search: ";
	cin >> search;
	
	for(i=0; i < 12; i++){
		if(data[i][0] == search){
			occurence++;
		}
	}
	
	cout << "Occurence(s): " << occurence << endl;
	return 0;
}
