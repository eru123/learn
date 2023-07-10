#include <iostream>
using namespace std;

struct node {
  int data;
  node *next;
};

void copy (node *source, node **destination) {
  node *temp = source;
  while (temp != NULL) {
    node *newNode = new node;
    newNode->data = temp->data;
    newNode->next = NULL;
    if (*destination == NULL) {
      *destination = newNode;
    } else {
      node *temp2 = *destination;
      while (temp2->next != NULL) {
        temp2 = temp2->next;
      }
      temp2->next = newNode;
    }
    temp = temp->next;
  }
}

int main (){
  node *n1 = new node;
  n1->data = 2;
  n1->next = NULL;
  node *n1a = new node;
  n1a->data = 3;
  n1a->next = n1;
  node *n1b = new node;
  n1b->data = 4;
  n1b->next = n1a;

  node *n2 = new node;
  copy(n1b, &n2);

  // print n2
  node *temp = n2;
  while (temp != NULL) {
    cout << temp->data << endl;
    temp = temp->next;
  }

  return 0;
}