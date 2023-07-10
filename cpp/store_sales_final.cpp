#include <iostream>

using namespace std;

string stores[10] = {
		"Store 1",
		"Store 2",
		"Store 3",
		"Store 4",
		"Store 5",
		"Store 6",
		"Store 7",
		"Store 8",
		"Store 9",
		"Store 10",
};

float sales[10] = {
		100345.45,
		450345.45,
		153445.45,
		54655.45,
		74345.45,
		40345.45,
		895345.45,
		345345.45,
		430345.45,
		550345.45};

void info()
{
	cout << "NAME: Jericho Aquino" << endl
			 << "FILENAME: final.cpp" << endl
			 << "TIME: 5:25PM" << endl;
}

int getIndexOfHighestSales()
{
	int index = 0;
	for (int i = 0; i < 10; i++)
	{
		if (sales[i] > sales[index])
		{
			index = i;
		}
	}
	return index;
}

main()
{

	int storeIndex = getIndexOfHighestSales();

	cout << "The store with the highest sales is "
			 << stores[storeIndex]
			 << " with a sales of "
			 << sales[storeIndex] << endl;

	info();
}
