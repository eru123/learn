#include <iostream>
#include <queue>

using namespace std;

int main(){
    queue<int> q;
    for (int i = 0; i < 10; i++)
        q.push(i);

    cout << "size: " << q.size() << endl;
    cout << "front: " << q.front() << endl;
    cout << "back: " << q.back() << endl;

    while (!q.empty()) {
        cout << q.front() << endl;
        q.pop();
    }
    return 0;
}