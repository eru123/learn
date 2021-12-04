#include <iostream>
#include "Data.h"

using namespace std;
using namespace ns;

// Constructor
MovieList::MovieList()
{
  head = NULL;
}

// destructor
MovieList::~MovieList()
{
  Node *nodePtr, *nextNode;

  nodePtr = head;
  while (nodePtr != NULL)
  {
    nextNode = nodePtr->next;
    delete nodePtr;
    nodePtr = nextNode;
  }

  cout << "Movies List has been destroyed!\n\n";
}

// prepend a new node to the beginning of the list
void MovieList::insertMovie(string code, string title, string genre, int year)
{
  Node *newNode;

  newNode = new Node;
  newNode->code = code;
  newNode->title = title;
  newNode->genre = genre;
  newNode->year = year;
  newNode->next = head;
  head = newNode;

  cout << "\nA Movie has been added!\n\n";
}

// deletes a node from the list
void MovieList::rentMovie(string code)
{
  Node *nodePtr, *previousNode;
  nodePtr = head;
  previousNode = NULL;

  while (nodePtr != NULL)
  {
    if (nodePtr->code == code)
    {
      if (previousNode != NULL && nodePtr->next != NULL)
        previousNode->next = nodePtr->next;
      else if (previousNode != NULL && nodePtr->next == NULL)
        previousNode->next = NULL;
      else if (previousNode == NULL && nodePtr->next != NULL)
        head = nodePtr->next;
      else
        head = NULL;

      delete nodePtr;
      cout << "\nA Movie has been rented!\n\n";
      return;
    }

    previousNode = nodePtr;
    nodePtr = nodePtr->next;
  }
  cout << "Movie not found!\n\n";
}

// append a new node to the end of the list
void MovieList::returnMovie(string code, string title, string genre, int year)
{
  Node *newNode, *nodePtr;

  newNode = new Node;
  newNode->code = code;
  newNode->title = title;
  newNode->genre = genre;
  newNode->year = year;
  newNode->next = NULL;

  if (head == NULL)
  {
    head = newNode;
  }
  else
  {
    nodePtr = head;
    while (nodePtr->next != NULL)
    {
      nodePtr = nodePtr->next;
    }
    nodePtr->next = newNode;
  }
  cout << "\nA Movie has been returned\n\n";
}

// search and display a node
void MovieList::showMovieDetails(string code)
{
  Node *nodePtr;
  nodePtr = head;

  while (nodePtr != NULL)
  {
    if (nodePtr->code == code)
    {
      cout << "Movie found: \n\n";
      cout << "Code     : " << nodePtr->code << endl;
      cout << "Title    : " << nodePtr->title << endl;
      cout << "Genre    : " << nodePtr->genre << endl;
      cout << "Released : " << nodePtr->year << "\n\n";
      return;
    }
    nodePtr = nodePtr->next;
  }
  cout << "Movie not found!\n\n";
}

// display the list
void MovieList::printMovieList()
{
  Node *nodePtr;
  if (head == NULL)
  {
    cout << "No record\n\n";
  }
  else
  {
    nodePtr = head;
    while (nodePtr)
    {
      cout << "Code     : " << nodePtr->code << endl;
      cout << "Title    : " << nodePtr->title << endl;
      cout << "Genre    : " << nodePtr->genre << endl;
      cout << "Released : " << nodePtr->year << "\n\n";
      nodePtr = nodePtr->next;
    }
  }
}
