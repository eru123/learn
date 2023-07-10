#include <iostream>
using namespace std;

void square()
{
	int s;
	double area;
	cout << "\nArea of a Square" << endl;
	cout << "Enter the length of one side: ";
	cin >> s;
	area = s * s;
	cout << "The area of the square with a length of one side of " << s << " is " << area << endl;
}

void rectangle()
{
	int h, w;
	double area;
	cout << "\nArea of a Rectangle" << endl;
	cout << "Enter the height of the rectangle: ";
	cin >> h;
	cout << "Enter the width of the rectangle: ";
	cin >> w;
	area = h * w;
	cout << "The area of the rectangle with a height of " << h << " and a width of " << w << " is " << area << endl;
}

void triangle()
{
	int b, h;
	double area;
	cout << "\nArea of a Triangle" << endl;
	cout << "Enter the base of the triangle: ";
	cin >> b;
	cout << "Enter the height of the triangle: ";
	cin >> h;
	area = (b * h) / 2;
	cout << "The area of the triangle with a base of " << b << " and a height of " << h << " is " << area << endl;
}

void parallelogram()
{
	int b, h;
	double area;
	cout << "\nArea of a Parallelogram" << endl;
	cout << "Enter the base of the parallelogram: ";
	cin >> b;
	cout << "Enter the height of the parallelogram: ";
	cin >> h;
	area = b * h;
	cout << "The area of the parallelogram with a base of " << b << " and a height of " << h << " is " << area << endl;
}

void trapezoid()
{
	int b1, b2, h;
	double area;
	cout << "\nArea of a Trapezoid" << endl;
	cout << "Enter the length of the base 1: ";
	cin >> b1;
	cout << "Enter the length of the base 2: ";
	cin >> b2;
	cout << "Enter the height of the trapezoid: ";
	cin >> h;
	area = (b1 + b2 * h) / 2;
}

void circle(){
	int r;
	double area;
	cout << "\nArea of a Circle" << endl;
	cout << "Enter the radius of the circle: ";
	cin >> r;
	area = 3.14159 * r * r;
	cout << "The area of the circle with a radius of " << r << " is " << area << endl;
}

int main()
{
	bool run = true;

	while (run)
	{
		char s_area;
		char s_again;
		int s, w, h, b, c, a, b1, b2, r;
		double area;

		cout << "Getting the area\n"
			 << endl;
		cout << "  A. Area of a Square" << endl;
		cout << "  B. Area of a Rectangle" << endl;
		cout << "  C. Area of a Triangle" << endl;
		cout << "  D. Area of a Parallelogram" << endl;
		cout << "  E. Area of a Trapezoid" << endl;
		cout << "  F. Area of a Circle" << endl;

		cout << "\nEnter selection: ";
		cin >> s_area;
		s_area = tolower(s_area);

		while (s_area != 'a' && s_area != 'b' && s_area != 'c' && s_area != 'd' && s_area != 'e' && s_area != 'f')
		{
			cout << "Invalid selection. Please enter a valid selection: ";
			cin >> s_area;
			s_area = tolower(s_area);
		}

		switch (s_area)
		{
		case 'a':
			square();
			break;
		case 'b':
			rectangle();
			break;
		case 'c':
			triangle();
			break;
		case 'd':
			parallelogram();
			break;
		case 'e':
			trapezoid();
			break;
		case 'f':
			circle();
			break;
		}

		cout << "\nWould you like to run the program again? (y/n): ";
		cin >> s_again;
		s_again = tolower(s_again);

		while (s_again != 'y' && s_again != 'n')
		{
			cout << "Invalid selection. Please enter a valid selection: ";
			cin >> s_again;
			s_again = tolower(s_again);
		}

		if (s_again == 'n')
		{
			run = false;
		}
	}
	return 0;
}