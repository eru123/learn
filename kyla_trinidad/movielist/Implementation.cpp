#include <iostream>
#include "Data.h"

using namespace std;
using namespace ns;

FloatList::FloatList()
{
  head = NULL;
}

FloatList::~FloatList()
{
  ListNode *nodePtr, *nextNode;

  nodePtr = head;
  while (nodePtr != NULL)
  {
    nextNode = nodePtr->next;
    delete nodePtr;
    nodePtr = nextNode;
  }
  cout << "Linked List has been destroyed!" << endl;
}

void FloatList::appendNode(float num)
{
  ListNode *newNode, *nodePtr;
  // Allocate a new node & store num
  newNode = new ListNode;
  newNode->value = num;
  newNode->next = NULL;
  // If there are no nodes in the list
  // make newNode the first node
  if (!head)
    head = newNode;
  else // Otherwise, insert newNode at end
  {
    // Initialize nodePtr to head of list
    nodePtr = head;
    // Find the last node in the list
    while (nodePtr->next)
      nodePtr = nodePtr->next;
    // Insert newNode as the last node
    nodePtr->next = newNode;
  }
  cout << endl
       << "Input has been successfully Appended!" << endl;
}

void FloatList::displayList()
{
  ListNode *nodePtr;
  if (head == NULL)
    cout << "The list is empty!" << endl;
  else
  {
    cout << "The nodes in the List are... " << endl;
    nodePtr = head;
    while (nodePtr)
    {
      cout << nodePtr->value << endl;
      nodePtr = nodePtr->next;
    }
  }
}

void FloatList::insertNode(float num)
{
  ListNode *newNode, *nodePtr, *previousNode;

  // Allocate a new node & store Num
  newNode = new ListNode;
  newNode->value = num;

  // If there are no nodes in the list
  // make newNode the first node
  if (!head)
  {
    head = newNode;
    newNode->next = NULL;
  }
  else // Otherwise, insert newNode.
  {
    // Initialize nodePtr to head of list
    nodePtr = head;
    previousNode = NULL;

    // Skip all nodes whose value member is less
    // than num.
    while (nodePtr != NULL && nodePtr->value < num)
    {
      previousNode = nodePtr;
      nodePtr = nodePtr->next;
    }
    // If the new mode is to be the 1st in the list,
    // insert it before all other nodes.
    if (previousNode == NULL)
    {
      head = newNode;
      newNode->next = nodePtr;
    }
    else
    {
      previousNode->next = newNode;
      newNode->next = nodePtr;
    }
  }
  cout << endl
       << "Input has been successfully Inserted!" << endl;
}

void FloatList::deleteNode(float num)
{
  ListNode *nodePtr, *previousNode;
  int found = 0;

  // If the list is empty, do nothing.
  if (!head)
  {
    cout << "List is empty!" << endl;
    return;
  }

  // Determine if the first node is the one.
  if (head->value == num)
  {
    nodePtr = head->next;
    delete head;
    head = nodePtr;
    cout << "Input has been successfully DELETED!" << endl;
    found = 1;
  }
  else
  {
    // Initialize nodePtr to head of list
    nodePtr = head;
    previousNode = NULL;

    // Skip all nodes whose value member is
    // not equal to num.
    while (nodePtr != NULL && nodePtr->value != num)
    {
      previousNode = nodePtr;
      nodePtr = nodePtr->next;
    }

    // Link the previous node to the node after
    // nodePtr, then delete nodePtr.
    if (nodePtr != NULL)
    {
      previousNode->next = nodePtr->next;
      delete nodePtr;
      cout << "Input has been successfully DELETED!" << endl;
      found = 1;
    }
  }
  if (found == 0)
    cout << "Input is not found in the list!" << endl;
}