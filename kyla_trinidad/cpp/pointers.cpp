// #include <cstddef>
#include <iostream>

using namespace std;


struct node {
  int data;
  node *next;
} *cart;

void prepend(node ** ref, int i){
	node * n = new node;
	n->data = i;
	n->next = (*ref);
	(*ref) = n;
}

void append(node ** ref, int i){
	node * n = new node;
	node * l = *ref;
	n->data = i;
	n->next = NULL;
	if (*ref == NULL)  { *ref = n; return; }
	while (l->next != NULL) l = l->next;
	l->next = n; 
    return;
}

void printNodes(node * n)
{	
	int i;
    while (n != NULL)
    {	
    	i = n->data;
        cout<< i * 2 << endl;
        n = n->next;
    }
}

main(){

	append(&cart,1);
	append(&cart,2);
	prepend(&cart,3);
	prepend(&cart,4);

	printNodes(cart);
}