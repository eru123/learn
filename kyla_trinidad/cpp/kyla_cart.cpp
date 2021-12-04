#include <iostream>
#include <iomanip>
using namespace std;

// Products Count
#define items 5
int *cart;
//Product Names
string product[items] = {
		"Apple",
		"Mango",
		"Orange",
		"Banana",
		"Grapes"};

// Product Prices
float price[items] = {
		27.5,
		32.9,
		17.25,
		8.75,
		35.75};

void displayItems()
{
	cout << "Welcome, here are the products that we have:" << endl; // Welcome message
	cout << setfill(' ') << setw(04) << "CODE"
			 << setfill(' ') << setw(13) << "PRODUCT"
			 << setfill(' ') << setw(10) << "PRICE" << endl;

	for (int i = 0; i < items; i++)
	{
		cout << setfill(' ') << setw(01) << i
				 << setfill(' ') << setw(16) << product[i]
				 << setfill(' ') << setw(10) << price[i] << endl;
	}

	cout << endl;
}

void selectProduct()
{
	int input;

	do
	{
		cout << "\nSelect Product" << endl;
		cout << "Enter Product Code: ";
		cin >> input;
		if (input < 0 || input >= items)
		{
			cout << "[ERROR] Invalid product code! Try again." << endl;
		}
	} while (input < 0 || input >= items);

	//	addToCart(input);
}

void option2()
{
}

void displayActionsMenu()
{
	if (system("CLS"))
		system("clear");
	displayItems();
	while (true)
	{
		cout << "ACTIONS" << endl
				 << "1. Select Product." << endl
				 << "2. View Shopping cart & Checkout." << endl
				 << "0. Exit\n"
				 << endl;

		int action;

		cout << "What would you like to do?: ";
		cin >> action;
		if (action == 1)
		{ // Select Product
			selectProduct();
		}
		else if (action == 2)
		{ // View Shopping cart & Checkout
			option2();
		}
		else if (action == 0)
		{												 // Exit App
			cout << "Bye" << endl; // Dito mo ilagay yung good bye message mo
			exit(1);
		}
		else
		{
			if (system("CLS"))
				system("clear");
			cout << "[ERROR] Invalid Action! Try again.\n"
					 << endl;
			displayItems();
		}
	}
}

int addToCart(int item)
{
}

int main()
{
	cart = new int[10];
	cart[0] = 11;
	cart = new int[20];
	cart[1] = 22;

	cout << cart[0] << ":" << cart[1] << endl;
	cout << "Welcome, here are the products that we have:" << endl;

	return 0;
}
