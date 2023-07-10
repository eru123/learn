#include <iostream>
#include <limits>
#include "Data.h"
using namespace std;
using namespace ns;


int main()
{	
	MovieStore store;
	store.loadData();

	int choice;
	int cm;

	while (true)
	{	
		cout << "\nMENU:" << endl;
		cout << "1. NEW VIDEO" << endl;
		cout << "2. RENT A VIDEO" << endl;
		cout << "3. RETURN A VIDEO" << endl;
		cout << "4. SHOW VIDEO DETAILS" << endl;
		cout << "5. DISPLAY ALL VIDEOS" << endl;
		cout << "6. CHECK VIDEO AVAILABILITY" << endl;
		cout << "7. CUSTOMER MAINTENANCE" << endl;
		cout << "8. Exit" << endl;

		choice = store.getInt("Enter your choice: ");
		system("cls");
		cout << endl;
		switch (choice)
		{
		case 1:
			store.addVideo();
			system("pause && cls");
			break;
		case 2:
			store.addRent();
			system("pause && cls");
			break;
		case 3:
			store.removeRent();
			system("pause && cls");
			break;
		case 4:
			store.readVideo(false);
			system("pause && cls");
			break;
		case 5:
			store.readVideos();
			system("pause && cls");
			break;
		case 6:
			store.readVideo(true);
			system("pause && cls");
			break;
		case 7:
			cout << "CUSTOMER MAINTENANCE:" << endl;
			cout << "1. Add new Customer" << endl;
			cout << "2. Show Customer Details" << endl;
			cout << "3. List of Videos Rented by a Customer" << endl;
			cm = store.getInt("Enter your choice: ");
			switch (cm) {
				case 1:
					store.addCustomer();
					break;
				case 2:
					store.readCustomer();
					break;
				case 3:
					store.readCustomerRentals();
					break;
				default:
					cout << "Invalid input! Try again" << endl;
					break;
			}
			break;
		case 8:
			store.saveData();
			return 0;
		default:
			cout << "Invalid input! Try again" << endl;
			break;
		}
	}

	return 0;
}
