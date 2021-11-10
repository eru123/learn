#include <iostream>
using namespace std;
int main(){
	double money = 100;
	double price[3] = {20, 30, 40};
	string food[3] = {"Ice Cream", "Chocolate", "Burger"};
	int input;
	
	cout << "Thank you for ordering to our store. What is your order?" << endl;
	for (int i=0;i<3;i++) cout << i+1 << ". " << food[i] << " - ₱" << price[i] <<endl;
	cin >> input;
	money -= price[input-1];
	cout << "You ordered 1 " << food[input-1] << " that cost ₱" << price[input-1] << endl;
	cout << "Your change is: ₱" << money << endl;
	
}
