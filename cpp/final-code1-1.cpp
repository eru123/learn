#include <iostream>
#include <ctime>
#include <windows.h> // access windows library
using namespace std;

// function for depositing money to savings and check accounts
double deposit(double current, double ammount){
	// add the deposit amount to the current balance
	return current + ammount;
}

// function for widthrawing savings and check balance
double widthdraw(double current, double ammount){
	// subtract the widthdraw amount from the current balance
	return current - ammount;
}

// function for testing deposit and widthdraw functions
void tests(){
	// test current savings balance
	double sbal = 5000;
	double amount;

	cout << "Testing 1: Savings Widthdrawal" << endl;
	cout << "Current savings balance:" << sbal << endl;
	cout << "Widthdraw: ";
	cin >> amount;
	sbal = widthdraw(sbal, amount);
	cout << "New savings balance: " << sbal << endl;


	// exit program
	exit(0);
}


int main()
{	
	tests();
	system("color 3f");
	int counter = 0;
	int pin;
	int password = 109929;
	int press, selection, yn, num;
	string cardno = "2549767882";
	double sbal(10000), cbal(50000), amount(0);
	time_t now = time(0);
	char *dt = ctime(&now);

	cout << endl;
	cout << "                 Welcome to Pinnacle Bank                    \n";
	cout << "There's only one true bank! Pinnacle Bank at your service\n";
	cout << endl;
	cout << "Please enter your 6 digit PIN number: ";

	while (counter != 3)
	{	
		cin >> pin;
		system("color 3f");
		if (pin == password)
		{
			do
			{
				cout << endl;
				cout << "What would you like to do?\n";
				cout << endl;
				cout << "Please select your desired transaction\n";
				cout << " -----------------------------------------\n";
				cout << "|(1) CASH DEPOSIT       (2) WITHDRAW CASH |\n";
				cout << "|(3) BALANCE INQUIRY    (4) EXIT          |\n";
				cout << " -----------------------------------------\n";
				cout << "~ ";
				cin >> press;

				if (press == 1) // deposit
				{
					cout << endl;
					cout << "**********************************************\n";
					cout << "               DEPOSIT CASH\n";
					cout << "**********************************************\n";
					cout << "Please select DESTINATION ACCOUNT type\n";
					cout << " -------------------------------\n";
					cout << "|(1) Deposit into PESO SAVINGS  |\n";
					cout << "|(2) Deposit into PESO CHECKING |\n";
					cout << " -------------------------------\n";
					cout << "~ ";
					cin >> selection;

					if (selection == 1) // deposit into savings
					{
						cout << endl;
						cout << "------------------SAVINGS ACCOUNT------------------\n";
						cout << endl;
						cout << " NOTE: Put your cash in designated bin below\n";
						cout << "**********************************************\n";
						cout << "Please enter the amount you wish to deposit: ";
						cin >> amount;
						sbal = deposit(sbal, amount); // call deposit function
						cout << endl;
						cout << "You have deposit PHP " << amount << " in your savings account\n";
						cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
						cout << "Please wait while your cash is being process...\n";
						cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
						cout << endl;
						cout << "Do you want to have another transaction?\n";
						cout << "(7) YES   (9) NO\n";
						cout << "~ ";
						cin >> yn;
					}
					else if (selection == 2) // deposit into checking
					{
						cout << endl;
						cout << "------------------CHECKING ACCOUNT------------------\n";
						cout << endl;
						cout << " NOTE: Put your cash in designated bin below\n";
						cout << "**********************************************\n";
						cout << "Please enter the amount you wish to deposit: ";
						cin >> amount;
						cbal = deposit(cbal, amount); // call deposit function
						cout << endl;
						cout << "You have deposited PHP " << amount << " in your checking account\n";
						cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
						cout << "Please wait while your cash is being process...\n";
						cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
						cout << endl;
						cout << "Do you want to have another transaction?\n";
						cout << "(7) YES   (9) NO\n";
						cout << "~ ";
						cin >> yn;
					}
				}
				else if (press == 2) // Withdrawal
				{
					cout << endl;
					cout << "**********************************************\n";
					cout << "                WITHDRAW CASH\n";
					cout << "**********************************************\n";
					cout << "Please select account type\n";
					cout << " -------------\n";
					cout << "|(1) SAVINGS  |\n";
					cout << "|(2) CHECKING |\n";
					cout << " -------------\n";
					cout << "~ ";
					cin >> selection;

					if (selection == 1) // savings withdrawal
					{
						cout << endl;
						cout << "------------------SAVINGS ACCOUNT------------------\n";
						cout << endl;
						cout << " ------------------------------------\n";
						cout << "|(1)PHP 500    (4)PHP 5,000          |\n";
						cout << "|(2)PHP 1,000  (5)PHP 10,000         |\n";
						cout << "|(3)PHP 2,000  (6)Enter other amount |\n";
						cout << " ------------------------------------\n";
						cout << "~ ";
						cin >> num;
						switch (num)
						{
						case 1:
							sbal = widthdraw(sbal, 500); // call widthdraw function
							cout << endl;
							cout << "PHP 500 will be deducted to your balance.\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
							break;
						case 2:
							sbal = widthdraw(sbal, 1000); // call widthdraw function
							cout << endl;
							cout << "PHP 1,000 will be deducted to your balance.\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
							break;
						case 3:
							sbal = widthdraw(sbal, 2000); // call widthdraw function
							cout << endl;
							cout << "PHP 2,000 will be deducted to your balance.\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
							break;
						case 4:
							sbal = widthdraw(sbal, 5000); // call widthdraw function
							cout << endl;
							cout << "PHP 5,000 will be deducted to your balance.\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
							break;
						case 5:
							sbal = widthdraw(sbal, 10000); // call widthdraw function
							cout << endl;
							cout << "PHP 10,000 will be deducted to your balance.\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
							break;
						case 6:
							cout << endl;
							cout << "Enter the amount only divisible to 100 and press enter key\n";
							cin >> amount;

							if (amount > sbal)
							{
								cout << endl;
								cout << "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
								cout << "You do not have enough funds on your account to withdraw.\n";
							}
							else if (amount < sbal)
							{
								sbal = widthdraw(sbal, amount); // call widthdraw function
								cout << "You are about to withdraw " << amount << endl;
								cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
								cout << "Please wait while your cash is being process...\n";
								cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
								cout << "PLEASE GET YOUR CASH.\n";
								cout << endl;
								cout << "Do you want to have another transaction?\n";
								cout << "(7) YES   (9) NO\n";
								cout << "~ ";
								cin >> yn;
							}
							break;
						}
					}
					else if (selection == 2) //  checking withdrawal
					{
						cout << endl;
						cout << "------------------CHECKING ACCOUNT------------------\n";
						cout << endl;
						cout << "Please enter the amount you wish to withdraw: ";
						cin >> amount;

						if (amount > cbal)
						{
							cout << endl;
							cout << "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
							cout << "You do not have enough funds on your account to withdraw.\n";
						}
						else if (amount < cbal)
						{
							cbal = widthdraw(cbal, amount); // call widthdraw function
							cout << "You are about to withdraw " << amount << endl;
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "Please wait while your cash is being process...\n";
							cout << ". . . . . . . . . . . . . . . . . . . . . . . .\n";
							cout << "PLEASE GET YOUR CASH.\n";
							cout << endl;
							cout << "Do you want to have another transaction?\n";
							cout << "(7) YES   (9) NO\n";
							cout << "~ ";
							cin >> yn;
						}
					}
				}
				else if (press == 3) // balance inquiry
				{
					cout << "**********************************************\n";
					cout << "              BALANCE INQUIRY\n";
					cout << "**********************************************\n";
					cout << "Savings account balance: " << sbal << endl;
					cout << "Checking account balance: " << cbal << endl;
					cout << endl;
					cout << "Do you want to have another transaction?\n";
					cout << "(7) YES   (9) NO\n";
					cout << "~ ";
					cin >> yn;
				}
				else if (press == 4) // exit
				{

					cout << endl;
					cout << "                          ATM TRANSACTION RECORD\n"; // on screen receipt
					cout << endl;
					cout << "DATE & TIME: " << dt;
					cout << "LOCATION: Sta. Mesa, Manila\n";
					cout << "CARD NUMBER: *********882" << endl;
					cout << "SAVINGS BAL: " << sbal << endl;
					cout << "CHECKING BAL: " << cbal << endl;
					cout << endl;
					cout << "                  Enjoy the convenience of 24/7 banking.\n";
					cout << "Do your money transaction via Pinnacle Bank and earn Pinnacle rewards points!\n";
					cout << "                  Visit any Pinnacle branch to know more.\n";
					cout << "                      THANK YOU FOR BANKING WITH US\n";
					cout << endl;
					cout << "                          ATM Account Exit " << endl;
					cout << "                -   Brought to you by Pinnacle Corp.   -" << endl;
					return 0;
				}
			} while (yn != 9);

			cout << endl;
			cout << "*******************************************************************\n";
			cout << "Account balance gets displayed if you choose not to print receipt.\n";
			cout << "*******************************************************************\n";
			cout << "DO YOU NEED A PRINTED RECEIPT?\n";
			cout << "(7)Yes   (9)No\n";
			cout << endl;
			cout << "~ ";
			cin >> yn;

			if (yn == 7)
			{

				cout << endl;
				cout << "TRANSACTION IS BEING PROCESSED.\n";
				cout << ". . . . . . . . . . . . . . . .\n";
				cout << ". . . . . . . . . . . . . . . .\n";
				cout << "    TRANSACTION COMPLETED\n";
				cout << "    RECEIPT ALREADY ISSUED\n";
				cout << " PLEASE GET YOUR CARD AND CASH\n";
				cout << endl;
				cout << "               ATM Account Exit " << endl;
				cout << "   -   Brought to you by Pinnacle Corp.   -" << endl;
				cout << "\n";
				return 0;
			}
			else if (yn == 9)
				cout << endl;
			cout << "TRANSACTION IS BEING PROCESSED.\n";
			cout << ". . . . . . . . . . . . . . . .\n";
			cout << ". . . . . . . . . . . . . . . .\n";
			cout << "   TRANSACTION COMPLETED\n";
			cout << "PLEASE GET YOUR CARD AND CASH\n";
			cout << endl;
			cout << endl;
			cout << "                          ATM TRANSACTION RECORD\n"; // on screen receipt
			cout << endl;
			cout << "DATE & TIME: " << dt;
			cout << "LOCATION: Sta. Mesa, Manila\n";
			cout << "CARD NUMBER: *********882" << endl;
			cout << "SAVINGS BAL: " << sbal << endl;
			cout << "CHECKING BAL: " << cbal << endl;
			cout << endl;
			cout << "                  Enjoy the convenience of 24/7 banking.\n";
			cout << "Do your money transaction via Pinnacle Bank and earn Pinnacle rewards points!\n";
			cout << "                  Visit any Pinnacle branch to know more.\n";
			cout << "                      THANK YOU FOR BANKING WITH US\n";
			cout << endl;
			cout << "                          ATM Account Exit " << endl;
			cout << "                -   Brought to you by Pinnacle Corp.   -" << endl;
			return 0;
		}
		else
		{
			counter += 1;
			system("color 4f");
			cout << "Invalid pin!\n"
				 << endl;

			cout << "Please re-enter your 6 digit PIN number: ";
		}
	}
	cout << endl;
	cout << "\nSorry. You cannot proceed to any transaction.\n";
	cout << "Your account is blocked due to multiple times of entering incorrect credentials.\n";
	cout << endl;
	cout << "Please contact your bank representative for assistance during bank opening hours.\n";
	cout << "                    Thank you for using Pinnacle ATM!\n";
	return 0;
}
