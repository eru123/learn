#include <iostream>
using namespace std;

int main()
{   
    int choice;
    double money = 0;
    double tmp;
    cout << "Your Name here" << endl;
    cout << money << endl;
    do {
        cin >> choice;
        if (choice == 1) {
            cin >> tmp;
            money += tmp;
        } else if (choice == 2){
            cin >> tmp;
            money -= tmp;
        }
    } while (choice != 3);
    cout << money << endl;
    return 0;
}

