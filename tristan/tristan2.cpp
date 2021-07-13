#include <iostream>
using namespace std;

int main(){
	int data[5];
	int i;
	int search;
	
	for(i=0; i<5; i++){
		cout << "Enter input " << i + 1 << ": ";
		cin >> data[i];
	}

	cout << "Search: ";
	cin >> search;
	
	for(i=0; i < 5; i++){
		if(data[i] == search){
			cout << "Searched number is found!";
			return 0;
		}
	}
	
	cout << "Searched number is lost";
	return 0;
}
