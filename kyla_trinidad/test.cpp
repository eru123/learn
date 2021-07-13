#include <iostream>
using namespace std;

#define items 5

int* cart;
int cartLen = 0;

string product[items] = {"Apple", "Mango", "Orange", "Banana", "Grapes"};
float price[items] = {27.5, 32.9, 17.25, 8.75, 35.75 };

void addToCart(int item){
	cartLen++;
	int* tmp = new int[cartLen];
	for(int i=0; i<cartLen-1; i++){
		tmp[i] = cart[i];
	}
	tmp[cartLen-1] = item;
	cart = tmp;
}
void displayCart(){
	// mag display ng 'There are no items in the cart' if walang 
	//	laman yung cart then mag eexit na sa function
	if (cartLen == 0){
		cout << "There are no items in the cart." << endl;
		return;
	}
	
	cout << "CART:" << endl;
	cout << "PRODUCT\t" << "PRICE" << endl;
	
	// display lahat ng laman ng cart
	for(int i=0; i < cartLen;i++) {
		int cartIndex = cart[i];
		cout << product[cartIndex] << "\t"
			 << price[cartIndex] << endl;
	}
	
	// nag lagay lang ako ng extra line
	cout << endl;
}
void displayProducts(){
	cout << "Welcome, here are the products that we have:" << endl; // Welcome message
	cout << "CODE\t" << "PRODUCT\t" << "PRICE" << endl;
	
	// Display products
	for(int i=0; i<items; i++) {
		cout << i << "\t"
			 << product[i] << "\t"
			 << price[i] << endl;
	}
	
	cout << endl;
}
void displayReceipt(){
	// if walang laman yung cart magdidisplay 'There are no items to checkout'
	// then mag eexit na sya sa function at hindi na madidisplay yung receipt
	if (cartLen == 0){
		cout << "There are no items to checkout." << endl;
		return;
	}
	
	float total = 0; // total amount ng laman ng cart
	cout << "-----------------------------" << endl;
	cout << "CHECKOUT RECEIPT:" << endl;
	cout << "PRODUCT\t" << "PRICE" << endl;
	for(int i=0; i < cartLen;i++) {
		int cartIndex = cart[i];
		
		// print yung current item ng cart
		cout << product[cartIndex] << "\t"
			 << price[cartIndex] << endl;
		
		// i-add yung current item amout sa total amount
		total += price[cartIndex]; 
	}
	
	// display total amount
	cout << endl;
	cout << "TOTAL AMOUNT: " << total << endl;
	cout << "-----------------------------\n" << endl;
}
void clearScreen() {
	if (system("CLS")) system("clear");
}
int getAction(){
	int action;
	do {
		cout << "What would you like to do?: ";
		cin >> action;
		if(action < 0 || action > 2){
			cout << "Invalid action! Try again.\n" << endl;
		}
	} while(action < 0 || action > 2);
	return action;
}
int getSelectedItem(){
	int selected;
	do {
		cout << "Enter Product Code: ";
		cin >> selected;
		
		if(selected < 0 || selected >= items){
			cout << "Invalid item code! Try again.\n" << endl;
		}
	} while(selected < 0 || selected >= items);
	return selected;
}
int main(){
	int action;
	int selectedItem;
	do {
		displayProducts();
		cout << "ACTIONS" << endl
			 << "1. Select Product." << endl
			 << "2. View Shopping cart & Checkout." << endl
			 << "0. Exit\n" << endl;
		action = getAction();
		
		if(action == 1){
			// Select Product
			bool buyAgain = true;
			string buy;
			while(buyAgain){
				selectedItem = getSelectedItem();
				addToCart(selectedItem);
				cout << "Item '" << product[selectedItem] << "' is added to cart.\n" << endl
					 << "Add another Item? (yes/no): ";
				
				cin >> buy;	
				buyAgain = buy == "yes";
			}
			clearScreen();
		} else if(action == 2){
			clearScreen();
			displayReceipt();
		}
	} while(action != 0);
	
	// Dito yung message before mag close yung program
	clearScreen();
	cout << "Thank you for shopping. Come again\n" << endl
		 << "MEMBERS:" << endl
		 << "   Kyla Bajar" << endl
		 << "   Shannen Castaneda" << endl
		 << "   Kyle Reyes" << endl
		 << "   Kyla Trinidad" << endl;
	
	return 0;
}

