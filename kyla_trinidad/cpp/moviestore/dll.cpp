#include <iostream>

using namespace std;

struct node {
    int data;
    node *next;
    node *prev;
} *head = NULL, *tail = NULL;


void getInitialElements(int n){
    if(head == NULL){
        cout << "List is empty! Insert now..." << endl;
    }
    cout << "Enter values one by one: " << endl;
    for(int i =0; i<n;i++){
        int x;
        cin>>x;
        node *temp = new node;
        temp->data = x;
        temp->next = NULL;
        temp->prev = NULL;

        if(head == NULL){
            head = temp;
            tail = temp;
        }
        else{
            tail->next = temp;
            temp->prev = tail;
            tail = temp;
        }
    }
}

void insert(){
    int position;
    int data;
    cout << "What position of the element you want to insert in the linked list: ";
    cin >> position;
    cout << "Enter new element: ";
    cin >> data;
    node *temp = new node;
    temp->data = data;
    temp->next = NULL;
    temp->prev = NULL;
    if(position == 0){
        temp->next = head;
        head->prev = temp;
        head = temp;
    }
    else{
        node *current = head;
        for(int i = 0; i<position-1; i++){
            current = current->next;
        }
        if(current == tail){
            tail->next = temp;
            temp->prev = tail;
            tail = temp;
        }
        else{
            temp->next = current->next;
            temp->prev = current;
            current->next->prev = temp;
            current->next = temp;
        }
    }
}

void display(){
    node *p = head;
    cout << "[";
    while(p != NULL){
        cout << p->data;
        p = p->next;
        if(p != NULL){
            cout << ", ";
        }
    }
    cout << "]" << endl;
}

void search(){
    int data;
    cout << "Enter the value to find what position in the linked list: ";
    cin >> data;
    node *p = head;
    int index = 0;
    while(p != NULL){
        if(p->data == data){
            cout << data << " data is present at location " << index << endl;
            cout << "Next element is: " << p->next->data << endl;
            cout << "Previous element is: " << p->prev->data << endl;
            return;
        }
        index++;
        p = p->next;
    }
    cout << data << " data is not in the linked list" << endl;
}

void remove(){
    int data;
    cout << "Enter the value to remove from the linked list: ";
    cin >> data;
    node *p = head;
    while(p != NULL){
        if(p->data == data){
            if(p == head){
                head = p->next;
                head->prev = NULL;
            }
            else if(p == tail){
                tail = p->prev;
                tail->next = NULL;
            }
            else{
                p->prev->next = p->next;
                p->next->prev = p->prev;
            }
            cout << data << " data is removed from the linked list" << endl;
            return;
        }
        p = p->next;
    }
    cout << data << " data is not in the linked list" << endl;
}

int main() 
{   
    getInitialElements(3);

    int n;
    do {
        cout << "Please select what you want to do?" << endl;
        cout << "1. Insert" << endl;
        cout << "2. Display" << endl;
        cout << "3. Search" << endl;
        cout << "4. Delete" << endl;
        cout << "5. Terminate" << endl;
        cin >> n;
        switch (n) {
            case 1:
                insert();
                break;
            case 2:
                cout << "Original Linked List: ";
                display();
                break;
            case 3:
                search();
                break;
            case 4:
                remove();
                break;
            case 5:
                cout << "Final Linked List: ";
                display();
                break;
            default:
                cout << "Invalid input! Try again" << endl;
                break;
        }
    } while (n != 5);
    return 0;
}