#include <iostream>

using namespace std;

string places[11] = {
	"La Paz",
	"Victoria",
	"Gerona",
	"Paniqui",
	"Moncada",
	"Carmen",
	"Urdaneta",
	"Binalonan",
	"Pozorrubio",
	"Sison",
	"Rosario"
};

double prices[11][11] = {
	{  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,},
	{ 76,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,},
	{145, 70,  0,  0,  0,  0,  0,  0,  0,  0,  0,},
	{197,122, 52,  0,  0,  0,  0,  0,  0,  0,  0,},
	{247,171,102, 50,  0,  0,  0,  0,  0,  0,  0,},
	{410,334,264,213,163,  0,  0,  0,  0,  0,  0,},
	{540,464,394,343,293,130,  0,  0,  0,  0,  0,},
	{587,511,441,390,340,177, 47,  0,  0,  0,  0,},
	{675,599,530,478,428,265,135, 88,  0,  0,  0,},
	{726,651,581,529,479,316,186,139, 51,  0,  0,},
	{778,702,632,581,531,368,238,191,103, 52,  0,},
};


int placesMenu(string message){
	cout << "Available Stops" <<endl;
	
	int i;
	for(i =0;i < 11;i++){
		cout << (i + 1) << ". " << places[i] << endl;
	}
	
	int in;
	cout << "\n" << message ;
	cin >> in;
	
	in -= 1;
	
	if(in < 0 || in > 10){
		cout << "Invalid Input!" << endl;
		return placesMenu(message);
	} else {
		return in;
	}
}

int main(){
	
	int entry = placesMenu("Entry Location\nEnter number: ");
	int exit = placesMenu("Exit Location\nEnter number: ");
	
	double fee = prices[entry][exit];
	
	cout << "Fee: " << fee <<endl;
	
}
