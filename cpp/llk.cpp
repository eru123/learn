#include <iostream>
using namespace std;

struct Cart
{
	int code;
	int qty;
	Cart *next;
} * Customer;

string product[5] = {"Apple", "Mango", "Orange", "Banana", "Grapes"};
float price[5] = {27.5, 32.9, 17.25, 8.75, 35.75};

int items = sizeof(product) / sizeof(product[0]);

void addToCart(Cart **ref, int code, int qty = 1)
{
	Cart *tmp = new Cart;
	Cart *last = *ref;
	tmp->code = code;
	tmp->qty = qty;
	tmp->next = NULL;
	if (*ref == NULL)
	{
		*ref = tmp;
		return;
	}
	while (last->next != NULL)
		last = last->next;
	last->next = tmp;
}

void checkout(Cart *n)
{
	if (n == NULL)
	{
		cout << "There are no items to checkout.\n";
		return;
	}
	float total = 0;
	cout << "--------------------------\n";
	cout << "CHECKOUT RECEIPT:\n\n";
	cout << "PRODUCT\t"
			 << "PRICE\t"
			 << "QTY\n";
	while (n != NULL)
	{
		int i = n->code;
		int qty = n->qty;
		cout << product[i] << "\t" << price[i] << "\t" << qty << endl;
		total += price[i] * qty;
		n = n->next;
	}
	cout << endl;
	cout << "TOTAL AMOUNT: " << total << endl;
	cout << "--------------------------\n\n";
}
void displayProducts()
{
	cout << "Welcome, here are the products that we have:\n";
	cout << "CODE\t"
			 << "PRODUCT\t"
			 << "PRICE\n";
	for (int i = 0; i < items; i++)
		cout << i << "\t" << product[i] << "\t" << price[i] << endl;
	cout << endl;
}
void clear()
{
	if (system("cls"))
		system("clear");
}
int getAction()
{
	int action;
	do
	{
		cout << "What would you like to do?: ";
		cin >> action;
		if (action < 0 || action > 2)
		{
			cout << "Invalid action! Try again.\n"
					 << endl;
		}
	} while (action < 0 || action > 2);
	return action;
}
int getQuantity(int code)
{
	int qty;
	cout << "How many '" << product[code] << "' you want to buy?: ";
	cin >> qty;
	return qty;
}
int getSelectedItem()
{
	int selected;
	do
	{
		cout << "Enter Product Code: ";
		cin >> selected;

		if (selected < 0 || selected >= items)
		{
			cout << "Invalid item code! Try again.\n"
					 << endl;
		}
	} while (selected < 0 || selected >= items);
	return selected;
}
main()
{
	int action;
	int code;
	do
	{
		displayProducts();
		cout << "ACTIONS" << endl
				 << "1. Select Product." << endl
				 << "2. View Shopping cart & Checkout." << endl
				 << "0. Exit\n"
				 << endl;
		action = getAction();

		if (action == 1)
		{
			bool buyAgain = true;
			string buy;
			while (buyAgain)
			{
				code = getSelectedItem();
				int qty = getQuantity(code);
				addToCart(&Customer, code, qty);
				cout << qty << " '" << product[code] << "' are added to cart.\n"
						 << endl
						 << "Add another Item? (yes/no): ";

				cin >> buy;
				buyAgain = buy == "yes";
			}
			clear();
		}
		else if (action == 2)
		{
			clear();
			checkout(Customer);
		}
	} while (action != 0);

	clear();
	cout << "Thank you for shopping. Come again\n"
			 << endl
			 << "MEMBERS:" << endl
			 << "   Kyla Bajar" << endl
			 << "   Shannen Castaneda" << endl
			 << "   Kyle Reyes" << endl
			 << "   Kyla Trinidad" << endl;

	return 0;
}
