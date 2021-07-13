#include <iostream>
using namespace std;

double percentage(double amount) {
	if(amount < 500){
		return 50;
	} else if (amount >= 500 || amount <= 999.99) {
		return 30;
	} else if (amount >= 1000 || amount <= 5000) {
		return 40;
	} else {
		return 50;
	}
}
int main(){
	
	double charge = 180.00;
	
	double amount = 100;
	
	double rate = percentage(amount);
	
	cout << "Discount is " << rate << endl;
	
	return 0;
}

