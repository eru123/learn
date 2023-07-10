#include <iostream>
using namespace std;

int main(){
  bool run = true;

  while(run){
    char s_volume;
    char s_again;

    int s, l ,w , h, a, r, v;
    double volume;

    cout << "Getting the volume\n" << endl;
    cout << "  A. Volume of a Cube" << endl;
    cout << "  B. Volume of a Cylinder" << endl;
    cout << "  C. Volume of a Cone" << endl;
    cout << "  D. Volume of a Sphere" << endl;
    cout << "\nEnter selection: ";
    cin >> s_volume;
    s_volume = tolower(s_volume);

    while(s_volume != 'a' && s_volume != 'b' && s_volume != 'c' && s_volume != 'd'){
      cout << "Invalid selection. Please enter a valid selection: ";
      cin >> s_volume;
      s_volume = tolower(s_volume);
    }

    switch(s_volume){
      case 'a':
        cout << "\nVolume of a Cube" << endl;
        cout << "Enter the length of one side: ";
        cin >> s;
        volume = s * s * s;
        cout << "The volume of the cube with a length of one side of " << s << " is " << volume << endl;
        break;
      case 'b':
        cout << "\nVolume of a Cylinder" << endl;
        cout << "Enter the radius of the cylinder: ";
        cin >> r;
        cout << "Enter the height of the cylinder: ";
        cin >> h;
        volume = (3.14 * r * r * h);
        cout << "The volume of the cylinder with a radius of " << r << " and a height of " << h << " is " << volume << endl;
        break;
      case 'c':
        cout << "\nVolume of a Cone" << endl;
        cout << "Enter the radius of the cone: ";
        cin >> r;
        cout << "Enter the height of the cone: ";
        cin >> h;
        volume = (3.14 * r * r * h) / 3;
        cout << "The volume of the cone with a radius of " << r << " and a height of " << h << " is " << volume << endl;
        break;
      case 'd':
        cout << "\nVolume of a Sphere" << endl;
        cout << "Enter the radius of the sphere: ";
        cin >> r;
        volume = (4.0 / 3.0) * 3.14 * r * r * r;
        cout << "The volume of the sphere with a radius of " << r << " is " << volume << endl;
        break;
    }

    cout << "\nWould you like to run the program again? (y/n): ";
    cin >> s_again;
    s_again = tolower(s_again);

    while(s_again != 'y' && s_again != 'n'){
      cout << "Invalid selection. Please enter a valid selection: ";
      cin >> s_again;
      s_again = tolower(s_again);
    }

    if(s_again == 'n'){
      run = false;
    }
    
  }
  return 0;
}