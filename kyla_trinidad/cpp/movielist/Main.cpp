#include <iostream>
#include <limits>
#include <string>

#include "Data.h"
using namespace std;
using namespace ns;

MovieList movies;

string getMovieCode();
string getMovieTitle();
string getMovieGenre();
int getMovieYear();
int getChoice();
int menu();
void clear();

string getMovieCode()
{
	string code;
	cout << "Enter the Movie code: ";
	getline(cin >> ws, code);
	return code;
}

string getMovieTitle()
{
	string title;
	cout << "Enter the Movie title: ";
	getline(cin >> ws, title);
	return title;
}

string getMovieGenre()
{
	string genre;
	cout << "Enter the Movie genre: ";
	getline(cin >> ws, genre);
	return genre;
}

int getMovieYear()
{
	int year;
	cout << "Enter the Movie released year: ";
	cin >> year;
	if (cin.fail() || year < 1800 || year > 2021)
	{
		cin.clear();
		cout << "Invalid input. Please enter a valid year.\n\n";
		cin.ignore(numeric_limits<streamsize>::max(), '\n');
		return getMovieYear();
	}
	return year;
}

int getChoice()
{
	int choice;
	cout << "\nEnter your choice: ";
	cin >> choice;
	if (cin.fail() || choice < 1 || choice > 6)
	{
		cin.clear();
		cin.ignore(numeric_limits<streamsize>::max(), '\n');
		cout << "Invalid choice. Please try again." << endl;
		return getChoice();
	}
	clear();
	return choice;
}

int menu()
{
	cout << " << Main Menu >> \n\n";
	cout << "[1] Insert a New Movie" << endl;
	cout << "[2] Rent a Movie" << endl;
	cout << "[3] Return a Movie" << endl;
	cout << "[4] Show Movie Details" << endl;
	cout << "[5] Print Movie List" << endl;
	cout << "[6] Quit the program" << endl;

	return getChoice();
}
void clear()
{
	if (system("CLS"))
		system("clear");
}

int main()
{
	string code, title, genre;
	int year;

	clear();

	while (true)
	{
		switch (menu())
		{
		case 1:
			cout << " << Insert a New Movie >> \n\n";
			code = getMovieCode();
			title = getMovieTitle();
			genre = getMovieGenre();
			year = getMovieYear();
			clear();
			movies.insertMovie(code, title, genre, year);
			break;
		case 2:
			cout << " << Rent a Movie >> \n\n";
			code = getMovieCode();
			clear();
			movies.rentMovie(code);
			break;
		case 3:
			cout << " << Return a Movie >> \n\n";
			code = getMovieCode();
			title = getMovieTitle();
			genre = getMovieGenre();
			year = getMovieYear();
			clear();
			movies.returnMovie(code, title, genre, year);
			break;
		case 4:
			cout << " << Movie Details >> \n\n";
			code = getMovieCode();
			movies.showMovieDetails(code);
			break;
		case 5:
			cout << " << Movie List >> \n\n";
			movies.printMovieList();
			break;
		case 6:
			cout << " << Thank you for using our program. >> " << endl;
			return 0;
		default:
			break;
		}
	}
}
