#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;


// Streamed Files
ifstream inUsers;
ifstream inProducts;

// User count
int uc = 10;

// Array variables for user data
string id[10];
string name[10];
string age[10];
string sex[10];

// products count
int pc = 3;

// Array variables for products data
string brand[3];
string model[3];
float price[3];
string engine[3];
string transmission[3];
string displacement[3];
string fuel[3];

// Parse clearance.txt file
void parseClearance(){
	// open file
	inUsers.open("clearance.txt");
	
	// Parse Clearance Data
	int x = 0;
	while(!inUsers.eof()){
		// store data to variables
		inUsers
			>> id[x] 
			>> name[x] 
			>> age[x] 
			>> sex[x];
		x++;
	}
	
	// close file
	inUsers.close();
}

// Parse products.txt file
void parseProducts(){
	// open file
	inProducts.open("products.txt");
	
	// Parse Products Data
	int x = 0;
	while(!inProducts.eof()){
		
		// store data to variables
		inProducts 
			>> brand[x] 
			>> model[x] 
			>> price[x] 
			>> engine[x] 
			>> transmission[x] 
			>> displacement[x] 
			>> fuel[x];
			
		x++;
	}
	
	// close file
	inProducts.close();
}


// Get baranggay clearance ID from the user to idetify user
// this function returns the index of current user from id array
int getID(){
	// this is an infinite loop that continues
	// until the user gives a valid ID
	while(true){
		// Get id from user
		string userID; 
		cout << "Enter your Baranggay ID: ";
		cin >> userID;
		
		// check if user is in the array
		for (int x=0;x<uc;x++){
			
			// if the user is in the array
			// return the index of the array
			if(id[x] == userID){
				return x;
			}
		}
		
		// If user does not provide a valid ID
		// display an Error
		cout << "Invalid Baranggay ID! Please try again\n" << endl;
		
	}
}

// Get selected product from the user
// this function returns the index of selected product from model array
int getOrder(){
	// this is an infinite loop that continues
	// until the user gives a valid ID
	while(true){
		// Get prodduct # from user
		cout << "\nAvailable products" << endl;
		cout << 
			setw(1) << "#" <<
			setw(9) << "Brand" << 
			setw(10) << "Model" << 
			setw(13) << "Price (PHP)" << 
			setw(34) << "Engine Type" << 
			setw(14) << "Transmission" << 
			setw(14) << "Displacement" << 
			setw(10) << "Fuel" <<
			endl;
	
		for(int x=0;x<pc;x++) cout <<
			setw(1) << (x + 1) <<
			setw(9) << brand[x] << 
			setw(10) << model[x] << 
			setw(13) << price[x] << 
			setw(34) << engine[x] << 
			setw(14) << transmission[x] << 
			setw(14) << displacement[x] << 
			setw(10) << fuel[x] << 
			endl; 
		 
		
		int product; 
		cout << "\nEnter product #: ";
		cin >> product;
		
		// check if product is existing
		if(product > 0 && product < pc + 1){
			// return index if true
			return product - 1;
			break;
		}
		
		// If user does not provide an existing prouduct
		// display an Error
		cout << "Invalid product! try again" << endl;
	}
}

// Get payment option from the user
// returns 0 if fully paid
// returns 1 is installment
int getPO(){
	while(true){
		int PO;
		cout << "\nPayment Options" << endl;
		cout << "1.	Fully Paid" << endl;
		cout << "2.	Installment" << endl;
		cout << "Enter payment option: ";
		cin >> PO;
		if(PO == 1|| PO == 2){
			return PO - 1;
		}
		
		cout << "Invalid Payment option! try again" << endl;
	}
}

// Get payment method from the user
// returns 0 if cash
// returns 1 is credit card
int getPM(){
	while(true){
		int PM;
		cout << "\nPayment Methods" << endl;
		cout << "1.	Cash" << endl;
		cout << "2.	Credit Card" << endl;
		cout << "Enter payment method: ";
		cin >> PM;
		if(PM == 1 || PM == 2){
			return PM - 1;
		}
		
		cout << "Invalid Payment method! try again" << endl;
	}
}

// this function returns the price for installments
float toInstallment(double price){
	float r = 0.02;
	float n = 6;
	float t = 12;
	float formula = (n*price) + (n*price * (r/100));
	float loan_pay = formula/(n*t);
	return loan_pay;
}

// this function display the transaction reciept
void displayReceipt(int userID,int productID,int payM,int payO){
	
	// Payment
	string paymentM = (payM == 0 ? "Cash, ": "Credit Card, ");
	string paymentO = (payO == 0 ? "Fully Paid": "Installment");
	
	//Price
	float priceCheck = (payO == 0 ? price[productID]: toInstallment(price[productID]));
	
	// User info
	cout << "\nReciept" << endl;
	cout << "No. " << id[userID] << " " << name[userID] << "\n" << endl;
	
	// Columns
	cout << 
		setw(8) << "Brand" << 
		setw(10) << "Model" << 
		setw(13) << "Price (PHP)" << 
		setw(34) << "Engine Type" << 
		setw(14) << "Transmission" << 
		setw(14) << "Displacement" << 
		setw(6) << "Fuel" << 
		setw(25) << "Payment" << 
		endl;
	
	// Row
	cout << 
		setw(8) << brand[productID] << 
		setw(10) << model[productID] << 
		setw(13) << priceCheck << 
		setw(34) << engine[productID] << 
		setw(14) << transmission[productID] << 
		setw(14) << displacement[productID] << 
		setw(6) << fuel[productID] << 
		setw(25) << paymentM + paymentO <<  
		endl; 
}

int main() {
	
	// Parse clearance.txt & products.txt
	parseClearance();
	parseProducts();
	
	// Get baranggay ID 
	// returns index of equivalent value in id array
	int idIndex = getID();
	
	// Get product order
	// returns index of selected product in model array
	int productIndex = getOrder();
	
	
	// Get Payment Method
	int paym = getPM();
	
	// Get Payment Option
	int payo = getPO();
	
	// Display Transaction Reciept
	displayReceipt(idIndex,productIndex,paym,payo);
	
	cout << "\nThank you for your transaction, Good Bye :)" << endl;
	
}
