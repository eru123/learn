#include <iostream>
#include <stack>

using namespace std;

int main(){
    stack<int> q;
    for (int i = 0; i < 10; i++)
        q.push(i);

    cout << "size: " << q.size() << endl;
    cout << "top: " << q.top() << endl;

    while (!q.empty()){
        cout << q.top() << endl;
        q.pop();
    }

    return 0;
}