#include <iostream>

using namespace std;

void perimeterSquare()
{
	double side;
	cout << "Square\n\n"
			 << "Enter side measurement of the square: ";

	cin >> side;
	double perimeter = side * 4;

	cout << "\nThe perimeter of a square with a side measurement of "
			 << side << " units is " << perimeter << " units\n\n";
}
void perimeterRectangle()
{
	double length;
	double width;

	cout << "Rectangle\n\n"
			 << "Enter the length of the rectangle: ";
	cin >> length;

	cout << "Enter the width of the rectangle: ";
	cin >> width;

	double perimeter = 2 * (length + width);

	cout << "\nThe perimeter of a rectangle with a length of "
			 << length << " and width of " << width << " units is " << perimeter << " units\n\n";
}
void perimeterMenu()
{
	int option;

	cout << "Perimeter\nGeometric\n\n"
			 << "MENU\n\n"
			 << "1] Square\n"
			 << "2] Rectangle\n"
			 << "3] Back\n\n"
			 << "\tEnter 1/2/3: ";

	cin >> option;
	switch (option)
	{
	case 1:
		system("cls");
		perimeterSquare();
		system("pause && cls");
		perimeterMenu();
		break;
	case 2:
		system("cls");
		perimeterRectangle();
		system("pause && cls");
		perimeterMenu();
		break;
	case 3:
		system("cls");
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		perimeterMenu();
		break;
	}
}
void areaSquare()
{
	double side;
	cout << "Square\n\n"
			 << "Enter side measurement of the square: ";

	cin >> side;
	double area = side * side;

	cout << "\nThe area of a square with a side measurement of "
			 << side << " units is " << area << " square units\n\n";
}
void areaRectangle()
{
	double length;
	double width;

	cout << "Rectangle\n\n"
			 << "Enter the length of the rectangle: ";
	cin >> length;

	cout << "Enter the width of the rectangle: ";
	cin >> width;

	double area = length * width;

	cout << "\nThe area of a rectangle with a length of "
			 << length << " and width of " << width << " units is " << area << " square units\n\n";
}
void areaMenu()
{
	int option;

	cout << "Area\nGeometric\n\n"
			 << "MENU\n\n"
			 << "1] Square\n"
			 << "2] Rectangle\n"
			 << "3] Back\n\n"
			 << "\tEnter 1/2/3: ";

	cin >> option;
	switch (option)
	{
	case 1:
		system("cls");
		areaSquare();
		system("pause && cls");
		areaMenu();
		break;
	case 2:
		system("cls");
		areaRectangle();
		system("pause && cls");
		areaMenu();
		break;
	case 3:
		system("cls");
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		areaMenu();
		break;
	}
}
void cubeSquare()
{
	double side;
	cout << "Cube\n\n"
			 << "Enter side measurement of the cube: ";

	cin >> side;
	double cube = side * side * side;

	cout << "\nThe cubic area of a cube with a side measurement of "
			 << side << " units is " << cube << " cubic units\n\n";
}
void cubeRectangle()
{
	double length;
	double width;
	double height;

	cout << "Rectanglular Prism\n\n"
			 << "Enter the length of the rectangular prism: ";
	cin >> length;

	cout << "Enter the width of the rectangular prism: ";
	cin >> width;

	cout << "Enter the height of the rectangular prism: ";
	cin >> height;

	double cube = length * width * height;

	cout << "\nThe cubic area of a rectanglular prism with a length of "
			 << length << ", width of " << width << ", and height of "
			 << height << " units is " << cube << " cubic units\n\n";
}
void cubeMenu()
{
	int option;

	cout << "Surface Area\nGeometric\n\n"
			 << "MENU\n\n"
			 << "1] Cube\n"
			 << "2] Rectanglar Prism\n"
			 << "3] Back\n\n"
			 << "\tEnter 1/2/3: ";

	cin >> option;
	switch (option)
	{
	case 1:
		system("cls");
		cubeSquare();
		system("pause && cls");
		cubeMenu();
		break;
	case 2:
		system("cls");
		cubeRectangle();
		system("pause && cls");
		cubeMenu();
		break;
	case 3:
		system("cls");
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		cubeMenu();
		break;
	}
}
void optionAMenu()
{
	int option;

	cout << "Conditional Structure\n\n"
			 << "MENU\n\n"
			 << "1] Perimeter\n"
			 << "2] Area\n"
			 << "3] Surface Area\n"
			 << "4] Back to Main Menu\n\n"
			 << "\tEnter 1/2/3/4: ";

	cin >> option;

	switch (option)
	{
	case 1:
		system("cls");
		perimeterMenu();
		optionAMenu();
		break;
	case 2:
		system("cls");
		areaMenu();
		optionAMenu();
		break;
	case 3:
		system("cls");
		cubeMenu();
		optionAMenu();
		break;
	case 4:
		system("cls");
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		optionAMenu();
		break;
	}
}
void optionBMenu()
{
	string subjects[3] = {"CEE100", "CEE101", "CEE102"};
	float grades[3][3] = {
			{2.5, 2.0, 2.1},
			{3.5, 3.0, 3.1},
			{1.5, 1.0, 1.1}};

	int no_students;
	cout << "Enter number of Students: ";
	cin >> no_students;

	for (int s = 0; s < no_students; s++)
	{
		cout << "\n\nStudent No. " << (s + 1) << endl;
		for (int g = 0; g < 3; g++)
		{
			cout << "\n\tSubject " << (g + 1) << ": " << subjects[g]
					 << "\n\tGrade\t : " << grades[s][g] << endl;
		}
	}
	cout << "\n\n";
	system("pause");
}
void formulaDistance()
{
	float time;
	float velocity;
	cout << "Find the distance (d)\n"
			 << "Formula: d = v * t\n\n";

	cout << "Enter velocity (v): ";
	cin >> velocity;

	cout << "Enter time (t): ";
	cin >> time;

	float distance = velocity * time;
	cout << "\nThe distance is " << distance << " units.\n\n";
}
void formulaForce()
{
	float mass;
	float acceleration;
	float force;

	cout << "Find the Force (F)\n"
			 << "Formula: F = ma\n\n";

	cout << "Enter mass (m): ";
	cin >> mass;

	cout << "Enter acceleration (a): ";
	cin >> acceleration;

	force = mass * acceleration;
	cout << "\nThe force is " << force << "\n\n";
}
void formulaKelvinToCelsius()
{
	float kelvin;

	cout << "Convert kelvin(k) into celsius(c)\n"
			 << "Formula: c = k - 273.15\n\n";

	cout << "Enter Kelvin (k): ";
	cin >> kelvin;

	float celsius = kelvin - 273.15;

	cout << "\n"
			 << kelvin << " kelvin is equal to "
			 << celsius << " degree celsius\n\n";
}
void formulaCelsiusToKelvin()
{
	float celsius;

	cout << "Convert celcius(c) into kelvin(k)\n"
			 << "Formula: k = c + 273.15\n\n";

	cout << "Enter Celcius (c): ";
	cin >> celsius;

	float kelvin = celsius + 273.15;

	cout << "\n"
			 << celsius << " celsius is equal to "
			 << kelvin << " degree kelvin\n\n";
}
void formulaCelsiusToFarenheit()
{
	float celsius;

	cout << "Convert celcius(c) into farenheit(f)\n"
			 << "Formula: f = (c * 9/5) + 32\n\n";

	cout << "Enter Celcius (c): ";
	cin >> celsius;

	float farenheit = (celsius * 9 / 5) + 32;

	cout << "\n"
			 << celsius << " celsius is equal to "
			 << farenheit << " degree farenheit\n\n";
}
void optionCMenu()
{
	int option;

	cout << "Programmer-Defined Functions\n\n"
			 << "MENU\n\n"
			 << "1] Find the distance\n"
			 << "2] Find the force\n"
			 << "3] Convert Kelvin to Celsius\n"
			 << "4] Convert Celsius to Kelvin\n"
			 << "5] Convert Celsius to Farenhiet\n"
			 << "6] Back to Main Menu\n\n"
			 << "\tEnter 1/2/3/4/5/6: ";

	cin >> option;

	switch (option)
	{
	case 1:
		system("cls");
		formulaDistance();
		system("pause && cls");
		optionCMenu();
		break;
	case 2:
		system("cls");
		formulaForce();
		system("pause && cls");
		optionCMenu();
		break;
	case 3:
		system("cls");
		formulaKelvinToCelsius();
		system("pause && cls");
		optionCMenu();
		break;
	case 4:
		system("cls");
		formulaCelsiusToKelvin();
		system("pause && cls");
		optionCMenu();
		break;
	case 5:
		system("cls");
		formulaCelsiusToFarenheit();
		system("pause && cls");
		optionCMenu();
		break;
	case 6:
		system("cls");
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		optionCMenu();
		break;
	}
}

main()
{
	char option;

	cout << "EDP 101/L\n\n"
			 << "Programming Plate\n\n"
			 << "A] ULO 2-B Conditional Structure\n"
			 << "B] ULO 2-C Looping Structure\n"
			 << "C] Programmer-Defined Functions\n"
			 << "D] Exit\n\n"
			 << "\tEnter A/B/C/D: ";

	cin >> option;

	switch (option)
	{
	case 'A':
		system("cls");
		optionAMenu();
		system("cls");
		main();
		break;
	case 'B':
		system("cls");
		optionBMenu();
		system("cls");
		main();
		break;
	case 'C':
		system("cls");
		optionCMenu();
		system("cls");
		main();
		break;
	case 'D':
		system("cls");
		cout << "Name: Jericho Aquino\n"
				 << "Subject: EDP101L\n"
				 << "Time: 4:30PM July 10, 2021\n";
		break;
	default:
		system("cls");
		cout << "Invalid Action! Please try again\n\n";
		system("pause && cls");
		main();
		break;
	}
}
