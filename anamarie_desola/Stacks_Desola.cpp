#include <iostream>
#include <stack>

using namespace std;

int main(){
  stack<int> s;
  stack<int> t;
  int choice;

  while (choice != 4){
    cout << "\nMenu\n1. Display\n2. Push\n3. Pop\n4. Exit\nWhat? ";
    cin >> choice;

    switch (choice){
      case 1:
        if (s.empty()){
          cout << "Stack is empty\n";
        } else {
          t = s;
          while (!t.empty()){
            cout << t.top() << " ";
            t.pop();
          }
          cout << endl;
        }
        break;
      case 2:
        int x;
        cout << "What element? ";
        cin >> x;
        cout << "PUSH = " << x << endl;
        s.push(x);
        break;
      case 3:
        if (s.empty()){
          cout << "Stack is empty\n";
        } else {
          cout << "POP = " <<s.top() << endl;
          s.pop();
        }
        break;
      case 4:
        cout << "Exiting\n";
        break;
      default:
        cout << "Invalid choice\n";
    }
  }

  return 0;
}