#include <iostream>
#include <cctype>
using namespace std;

// Single Linked List Node
struct Single
{
	int data;
	Single *next;
} * single;

// Doubly Linked List Node
struct Double
{
	int data;
	Double *next;
	Double *prev;
} * doubly;

// Circular Linked List Node
struct Circular
{
	int data;
	Circular *next;
	Circular *prev;
} * circular;


// ----------------------------------------

void single_insertAtFirst(Single **head, int data)
{
	Single *newNode = new Single;
	newNode->data = data;
	newNode->next = NULL;

	if (*head == NULL)
	{
		// if list is empty, make newNode as head
		*head = newNode;
	}
	else
	{
		// if list is not empty, make next of newNode as current head
		newNode->next = *head;
		// then make newNode as new head
		*head = newNode;
	}
}

void single_insertAtMiddle(Single **head, int data)
{
	// count number of nodes in list
	int count = 0;
	Single *cur = *head;
	while (cur != NULL)
	{
		count++;
		cur = cur->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	Single *current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;
	Single *newNode = new Single;

	// insert new node between current and next of current
	newNode->data = data;
	newNode->next = current->next;
	current->next = newNode;
}

void single_insertAtLast(Single **head, int data)
{
	Single *newNode = new Single;
	newNode->data = data;
	newNode->next = NULL;
	if (*head == NULL)
	{
		// if list is empty, insert at first
		*head = newNode;
	}
	else
	{
		// if list is not empty, go to last node
		Single *current = *head;
		while (current->next != NULL)
			current = current->next;
		// insert new node at last
		current->next = newNode;
	}
}

void single_deleteAtFirst(Single **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	// delete first node
	Single *temp = *head;
	*head = (*head)->next;
	delete temp;
}

void single_deleteAtMiddle(Single **head)
{
	// count number of nodes in list
	if (*head == NULL)
		return;
	Single *current = *head;
	Single *prev = NULL;
	int count = 0;
	while (current != NULL)
	{
		count++;
		prev = current;
		current = current->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;

	// delete middle node
	prev->next = current->next;
	delete current;
}

void single_deleteAtLast(Single **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	// goto last node
	Single *current = *head;
	Single *prev = NULL;
	while (current->next != NULL)
	{
		prev = current;
		current = current->next;
	}

	// delete last node
	prev->next = NULL;
	delete current;
}

void single_display(Single *head)
{
	// if list is empty, do nothing
	if (head == NULL)
		return;

	// go to first node
	Single *current = head;

	// traverse list and print data of each node
	cout << "\nThe values in the link are ";
	while (current != NULL)
	{
		cout << current->data << " ";
		current = current->next;
	}
	cout << "\n\n";
}

void double_insertAtFirst(Double **head, int data)
{
	if (*head == NULL)
	{
		// if list is empty, insert at first
		Double *newNode = new Double;
		newNode->data = data;
		newNode->next = NULL;
		newNode->prev = NULL;
		*head = newNode;
	}
	else
	{
		// if list is not empty, insert at first and make next of newNode as current head
		Double *newNode = new Double;
		newNode->data = data;
		newNode->next = *head;
		newNode->prev = NULL;
		(*head)->prev = newNode;

		// make newNode as new head
		*head = newNode;
	}
}

void double_insertAtMiddle(Double **head, int data)
{
	// count number of nodes in list
	int count = 0;
	Double *cur = *head;
	while (cur != NULL)
	{
		count++;
		cur = cur->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	Double *current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;

	// insert new node between current and next of current
	Double *newNode = new Double;
	newNode->data = data;
	newNode->next = current->next;
	newNode->prev = current;
	current->next = newNode;
	newNode->next->prev = newNode;
}

void double_insertAtLast(Double **head, int data)
{
	// set new node
	Double *newNode = new Double;
	newNode->data = data;
	newNode->next = NULL;
	newNode->prev = NULL;

	if (*head == NULL)
	{
		// if list is empty, insert at first
		*head = newNode;
	}
	else
	{
		// if list is not empty, go to last node
		Double *current = *head;
		while (current->next != NULL)
			current = current->next;

		// insert new node at last
		current->next = newNode;
		newNode->prev = current;
	}
}

void double_deleteAtFirst(Double **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	// delete first node
	Double *temp = *head;
	*head = (*head)->next;
	(*head)->prev = NULL;
	delete temp;
}

void double_deleteAtMiddle(Double **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	Double *current = *head;
	Double *prev = NULL;

	// count number of nodes in list
	int count = 0;
	while (current != NULL)
	{
		count++;
		prev = current;
		current = current->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;

	// delete middle node
	prev->next = current->next;
	current->next->prev = prev;
	delete current;
}

void double_deleteAtLast(Double **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	Double *current = *head;
	Double *prev = NULL;

	// go to last node
	while (current->next != NULL)
	{
		prev = current;
		current = current->next;
	}

	// delete last node
	prev->next = NULL;
	delete current;
}

void double_display(Double *head)
{
	// if list is empty, do nothing
	if (head == NULL)
		return;

	// go to first node
	Double *current = head;

	// traverse list and print data of each node
	cout << "\nThe values in the link are ";
	while (current != NULL)
	{
		cout << current->data << " ";
		current = current->next;
	}
	cout << endl;
}

void circular_insertAtFirst(Circular **head, int data)
{
	if (*head == NULL)
	{
		// if list is empty, insert at first
		Circular *newNode = new Circular;
		newNode->data = data;
		newNode->next = NULL;
		newNode->prev = NULL;
		*head = newNode;
	}
	else
	{
		// if list is not empty, insert at first and make next of newNode as current head
		Circular *newNode = new Circular;
		newNode->data = data;
		newNode->next = *head;
		newNode->prev = NULL;
		(*head)->prev = newNode;
		*head = newNode;
	}
}

void circular_insertAtMiddle(Circular **head, int data)
{
	// count number of nodes in list
	int count = 0;
	Circular *cur = *head;
	while (cur != NULL)
	{
		count++;
		cur = cur->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	Circular *current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;

	// insert new node between current and next of current
	Circular *newNode = new Circular;
	newNode->data = data;
	newNode->next = current->next;
	newNode->prev = current;
	current->next = newNode;
	newNode->next->prev = newNode;
}

void circular_insertAtLast(Circular **head, int data)
{
	// set new node
	Circular *newNode = new Circular;
	newNode->data = data;
	newNode->next = NULL;
	newNode->prev = NULL;

	if (*head == NULL)
	{
		// if list is empty, insert at first
		*head = newNode;
	}
	else
	{
		// if list is not empty, go to last node
		Circular *current = *head;
		while (current->next != NULL)
			current = current->next;

		// insert new node at last
		current->next = newNode;
		newNode->prev = current;
	}
}

void circular_deleteAtFirst(Circular **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	// delete first node
	Circular *temp = *head;
	*head = (*head)->next;
	(*head)->prev = NULL;
	delete temp;
}

void circular_deleteAtMiddle(Circular **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	Circular *current = *head;
	Circular *prev = NULL;

	// count number of nodes in list
	int count = 0;
	while (current != NULL)
	{
		count++;
		prev = current;
		current = current->next;
	}

	// middle node index
	int index = count / 2;

	// go to the middle node
	current = *head;
	for (int i = 0; i < index; i++)
		current = current->next;

	// delete middle node
	prev->next = current->next;
	current->next->prev = prev;
	delete current;
}

void circular_deleteAtLast(Circular **head)
{
	// if list is empty, do nothing
	if (*head == NULL)
		return;

	Circular *current = *head;
	Circular *prev = NULL;

	// go to last node
	while (current->next != NULL)
	{
		prev = current;
		current = current->next;
	}

	// delete last node
	prev->next = NULL;
	delete current;
}

void circular_display(Circular *head)
{
	// if list is empty, do nothing
	if (head == NULL)
		return;

	// go to first node
	Circular *current = head;

	// traverse list and print data of each node
	cout << "\nThe values in the link are ";
	while (current != NULL)
	{
		cout << current->data << " ";
		current = current->next;
	}
	cout << endl;
}

int menu()
{
	int choice;
	// show menu
	cout << "\nMENU" << endl;
	cout << "[1] Singly Linked List" << endl;
	cout << "[2] Doubly Linked List" << endl;
	cout << "[3] Circular Linked List" << endl;
	cout << "[4] Exit" << endl;
	cout << "Enter your choice: ";
	cin >> choice;

	// if choice is not in range, show error message, and try again
	while (choice < 1 || choice > 4)
	{
		cout << "Invalid choice! Try again. Enter your choice: ";
		cin >> choice;
	}

	return choice;
}

int menu2()
{
	int choice;
	// show menu
	cout << "\nAction to perform" << endl;
	cout << "[1] Inserting value in the link" << endl;
	cout << "[2] Deleting value in the link" << endl;
	cout << "[3] Exit" << endl;
	cout << "Enter your choice: ";
	cin >> choice;

	// if choice is not in range, show error message, and try again
	while (choice < 1 || choice > 3)
	{
		cout << "Invalid choice! Try again. Enter your choice: ";
		cin >> choice;
	}

	return choice;
}

char menu3(int m2)
{
	char choice;
	// show menu
	cout << (m2 == 1 ? "\nInserting a value at" : "\nDeleting a value at") << endl;
	cout << "[a] the beginning of the link" << endl;
	cout << "[b] the middle of the link" << endl;
	cout << "[c] the end of the link" << endl;
	cout << "[d] Exit" << endl;
	cout << "Enter your choice: ";
	cin >> choice;
	choice = tolower(choice);

	// if choice is not in range, show error message, and try again
	while (choice != 'a' && choice != 'b' && choice != 'c' && choice != 'd')
	{
		cout << "Invalid choice! Try again. Enter your choice: ";
		cin >> choice;
		choice = tolower(choice);
	}
	return choice;
}

void getResult(int m, int m2, int m3)
{
	char a, c;
	int data;
	if (m2 == 1)
	{
		// insert data
		a = 'y';
		while (a == 'y')
		{
			cout << "\nInput the value to be inserted: ";
			cin >> data;

			if (m3 == 'a')
			{
				// insert at first
				switch (m)
				{
				case 1:
					single_insertAtFirst(&single, data);
					single_display(single);
					break;
				case 2:
					double_insertAtFirst(&doubly, data);
					double_display(doubly);
					break;
				case 3:
					circular_insertAtFirst(&circular, data);
					circular_display(circular);
					break;
				}
			}
			else if (m3 == 'b')
			{
				// insert at middle
				switch (m)
				{
				case 1:
					single_insertAtMiddle(&single, data);
					single_display(single);
					break;
				case 2:
					double_insertAtMiddle(&doubly, data);
					double_display(doubly);
					break;
				case 3:
					circular_insertAtMiddle(&circular, data);
					circular_display(circular);
					break;
				}
			}
			else if (m3 == 'c')
			{
				// insert at last
				switch (m)
				{
				case 1:
					single_insertAtLast(&single, data);
					single_display(single);
					break;
				case 2:
					double_insertAtLast(&doubly, data);
					double_display(doubly);
					break;
				case 3:
					circular_insertAtLast(&circular, data);
					circular_display(circular);
					break;
				}
			}

			// ask if wants to insert more
			cout << "Insert another value? (y/n): ";
			cin >> a;
			a = tolower(a);
			while (a != 'y' && a != 'n')
			{
				cout << "Invalid choice! Try again. Insert another value? (y/n): ";
				cin >> a;
				a = tolower(a);
			}

			if (a == 'y')
			{	
				c = 'n';
				// if yes, ask if wants to change other case
				cout << "Select another case? (y/n): ";
				cin >> c;
				c = tolower(c);
				while (c != 'y' && c != 'n')
				{
					cout << "Invalid choice! Try again.Select another case? (y/n): ";
					cin >> c;
					c = tolower(c);
				}

				if (c == 'y')
				{
					// if yes, ask which case
					m3 = menu3(m2);
				}
			}
		}
	}
	else if (m2 == 2)
	{
		// delete data
		a = 'y';
		while (a == 'y')
		{

			if (m3 == 'a')
			{
				// delete at first
				switch (m)
				{
				case 1:
					single_deleteAtFirst(&single);
					single_display(single);
					break;
				case 2:
					double_deleteAtFirst(&doubly);
					double_display(doubly);
					break;
				case 3:
					circular_deleteAtFirst(&circular);
					circular_display(circular);
					break;
				}
			}
			else if (m3 == 'b')
			{
				// delete at middle
				switch (m)
				{
				case 1:
					single_deleteAtMiddle(&single);
					single_display(single);
					break;
				case 2:
					double_deleteAtMiddle(&doubly);
					double_display(doubly);
					break;
				case 3:
					circular_deleteAtMiddle(&circular);
					circular_display(circular);
					break;
				}
			}
			else if (m3 == 'c')
			{
				// delete at last
				switch (m)
				{
				case 1:
					single_deleteAtLast(&single);
					single_display(single);
					break;
				case 2:
					double_deleteAtLast(&doubly);
					double_display(doubly);
					break;
				case 3:
					circular_deleteAtLast(&circular);
					circular_display(circular);
					break;
				}
			}
		}

		// ask if wants to delete more
		cout << "Do you want to delete more? (y/n): ";
		cin >> a;
		a = tolower(a);
		while (a != 'y' && a != 'n')
		{
			cout << "Invalid choice! Try again. Do you want to delete more? (y/n): ";
			cin >> a;
			a = tolower(a);
		}

		if (a == 'y')
			{	
				c = 'n';
				// if yes, ask if wants to change other case
				cout << "Select another case? (y/n): ";
				cin >> c;
				c = tolower(c);
				while (c != 'y' && c != 'n')
				{
					cout << "Invalid choice! Try again.Select another case? (y/n): ";
					cin >> c;
					c = tolower(c);
				}

				if (c == 'y')
				{
					// if yes, ask which case
					m3 = menu3(m2);
				}
			}
	}
}

int main()
{
	single = NULL;
	doubly = NULL;
	circular = NULL;
	int m = 0;
	int m2;
	char m3, a;

	// get 3 initial values for each list
	cout << "Input the three integer values of the link: ";
	for (int i = 0; i < 3; i++){
		int x;
		cin >> x;
		single_insertAtLast(&single, x);
		double_insertAtLast(&doubly, x);
		circular_insertAtLast(&circular, x);
	}

	// run loop while user doesn't choice 4 (exit) in the main menu
	while (m != 4)
	{
		// show main menu and get user choice
		m = menu();
		if (m != 4)
		{
			// if user choose not to exit
			// show sub menu and get user choice
			m2 = menu2();
			if (m2 != 3)
			{
				// if user choose not to exit the sub menu
				// show sub menu and get user choice
				m3 = menu3(m2);
				if (m3 != 'd')
				{
					// if user choose not to exit the sub menu
					// process the data and get the result
					getResult(m, m2, m3);
				} // else if user choose to exit sub menu, the user will redirect to main menu
			}		// else if user choose to exit sub menu, the user will redirect to main menu
		}			// else the prog will exit
	}
	return 0;
}
