#include <iostream>
#include <cstring>
#include <fstream>
#include <iomanip>
#include <conio.h>
#include <windows.h>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <cstdlib>
#define MAX_ADDRESS_LENGTH 100
using namespace std;
 void menu();
    void insert();
    void display();
    void modify();
    void search();
    void deleted();
	
struct StudentRec
{
	char address[MAX_ADDRESS_LENGTH];
	string numID;
	string name;
	string bday;
	string gender;		
	string degree;
	string yearLevel;
	StudentRec *next;
}studentInfo;

void MainMenu()
{
	menustart:
	int choice;
    char x;
	system("cls");
	cout << " \n \n -------------------------------------------------------------------------------------------------------------------------------------------------------------------" << endl;
	cout << "\t \t \t \t      Good Day Mr. Calleja and Mr. Ramos! Welcome to group Uniquelo's Student Information Program! " << endl;
	cout << " -------------------------------------------------------------------------------------------------------------------------------------------------------------------" << endl;
	cout <<  endl<< endl<<endl;
	cout << "\t \t \t \t ============================================================================================"<<endl;
	cout << "\t \t \t \t || \t \t \t \t      M  A  I  N    M  E  N  U                             ||"<<endl;
	cout << "\t \t \t \t ||----------------------------------------------------------------------------------------||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Add New Record: \t \t \t \t \t \t Enter 1           ||" << endl;
	cout <<"\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Display Record: \t \t \t \t \t \t Enter 2           ||" << endl;
	cout <<" \t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Modify Record : \t \t \t \t \t \t Enter 3           ||" << endl;
	cout <<" \t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Search Record : \t \t \t \t \t \t Enter 4           ||" << endl;
	cout <<" \t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Delete Record : \t \t \t \t \t \t Enter 5           ||" << endl;
	cout <<" \t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Exit Program  : \t \t \t \t \t \t Enter 6           ||" << endl;
    cout <<	"\t \t \t \t ============================================================================================"<<endl<<endl<<endl<<endl;
    cout << "\t \t \t \t   Please type your selection:   "; 
     cin >> choice;
    switch (choice)
    {
    case 1:
        do
        {
            insert();
            cout << "\n\t\t\t Add Another Student Record (Y,N): ";
            cin >> x;
        } while (x == 'y' || x == 'Y');
        break;
    case 2:
        display();
        break;
    case 3:
        modify();
        break;
    case 4:
        search();
        break;
    case 5:
        deleted();
        break;
    case 6:
        exit(0);
    default:
        cout << "\n\t\t\t Invalid choice... Please Try Again..";
    }
    getch();
    goto menustart;
}

void insert() // add student details
{
    system("cls");
    fstream file;
    StudentRec rec;
	cout<<"---------- ADD SUDENT RECORD ----------"<<endl;
	cout<<"Student Full Name: ";
	cin.ignore();
	getline(cin,rec.name);
	cout<<"Student ID Number: ";
	cin>>rec.numID;
	cin.ignore();
	cout<<"Birthday (mm/dd/yy): ";
	cin>>rec.bday;
	cout<<"Gender: ";
	cin>>rec.gender;
	cin.ignore();		
	cout<<"Address: ";	
	cin.getline (rec.address, MAX_ADDRESS_LENGTH);
	cout<<"Degree Program: ";
	cin>>rec.degree;
	cin.ignore();
	cout<<"Year Level (1st, 2nd...): ";
	getline(cin,rec.yearLevel);
	cout<< "\nThe record is sucessfully added! \n";
	
	file.open("studentRecord.txt", ios::app | ios::out);
	file << "\n" << rec.name << "\n" << rec.numID << "\n" << rec.bday << "\n" << rec.gender << "\n" << rec.address << "\n" << rec.degree << "\n" << rec.yearLevel <<endl;
    file.close();
}

void display() // display students details
{
    system("cls");
    StudentRec rec;
    fstream file;
    int total = 1;
    cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Student Record Table --------------------------------------------" << endl;
    file.open("studentRecord.txt", ios::in);
    if (!file)
    {
        /* code */
        cout << "\n\t\t\tNo Data Is Present...";
        file.close();
    }
    else
    {
        file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel;
        while (!file.eof())
        {
            cout << "\n\n\t\t\t Student No.: " << total++ << endl;
            cout << "\t\t\t Student Name: " << rec.name << endl;
            cout << "\t\t\t ID number   : " << rec.numID << endl;
            cout << "\t\t\t Birthday    : " << rec.bday << endl;
            cout << "\t\t\t Gender      : " << rec.gender << endl;
            cout << "\t\t\t Student Address: " << rec.address << endl;
            cout << "\t\t\t Degree      : " << rec.degree << endl;
            cout << "\t\t\t Year Level  : " << rec.yearLevel << endl;
            file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel;
        }
        if (total == 0)
        {
            cout << "\n\t\t\tNo Data Is Present...";
        }
    }
    file.close();
}

void modify() // Modify Students Details
{
    system("cls");
    StudentRec rec;
    fstream file, file1;
    string numID;
    int found = 0;
    cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Student Modify Details ------------------------------------------" << endl;
    file.open("studentRecord.txt", ios::in);
    if (!file)
    {
        cout << "\n\t\t\tNo Data is Present..";
    }
    else
    {
        cout << "\nEnter Student Number of Student which you want to Modify: ";
        cin >> numID;
        file1.open("record.txt", ios::app | ios::out);
        file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >>rec.yearLevel;
        while (!file.eof())
        {
            if (numID != rec.numID)

                file1 << "\n" << rec.name << "\n" << rec.numID << "\n" << rec.bday << "\n" << rec.gender<< "\n" << rec.address << "\n" << rec.degree << "\n" << rec.yearLevel <<endl;
            else
            {
                cout << "\n\t\t\tEnter Name: ";
                cin >> rec.name;
                cout << "\t\t\Enter Student Number: ";
                cin >> rec.numID;
                cout << "\t\t\tEnter Birthday: ";
                cin >> rec.bday;
                cout << "\t\t\tEnter Gender: ";
                cin >> rec.gender;
                cout << "\t\t\tEnter Address: ";
                cin >> rec.address ;
                cout << "\t\t\Enter Degree: ";
                cin >> rec.degree;
                cout << "\t\t\tEnter Yearlevel: ";
                cin >> rec.yearLevel;
                file1 << "\n" << rec.name << "\n" << rec.numID << "\n" << rec.bday << "\n" << rec.gender << "\n" << rec.address << "\n" << rec.degree << "n" << rec.yearLevel <<endl;
                found++;
            }
            file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel; 
            if (found == 0)
            {
                cout << "\n\n\t\t\t Student Roll No. Not Found....";
            }
        }
        file1.close();
        file.close();
        remove("studentRecord.txt");
        rename("record.txt", "studentRecord.txt");
    }
}

void search() // search data of student
{
    system("cls");
    StudentRec rec;
    fstream file;
    int found = 0;
    file.open("studentRecord.txt", ios::in);
    if (!file)
    {
        cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
        cout << "------------------------------------- Student Search Data ------------------------------------------" << endl;
        cout << "\n\t\t\t No Data Is Present...";
    }
    else
    {
        string numID;
        cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
        cout << "------------------------------------- Student Search Data ------------------------------------------" << endl;
        cout << "\n Enter Roll No. of Student Which You Want to Search: ";
        cin >> numID;
        file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel; 
        while (!file.eof())
        {
            if (numID == rec.numID)
            {
                cout << "\t\t\t Student Name: " << rec.name << endl;
	            cout << "\t\t\t ID number   : " << rec.numID << endl;
	            cout << "\t\t\t Degree      : " << rec.degree << endl;
	            cout << "\t\t\t Gender      : " << rec.gender << endl;
	            cout << "\t\t\t Birthday    : " << rec.bday << endl;
	            cout << "\t\t\t Year Level  : " << rec.yearLevel << endl;
	            cout << "\t\t\t Student Address: " << rec.address << endl;
                found++;
            }
            file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel; 
        }
        if (found == 0)
        {
            cout << "\n\t\t\tStudent Roll No. Not Found...";
        }
        file.close();
    }
}

void deleted()
{
    system("cls");
    StudentRec rec;
    fstream file, file1;
    int found = 0;
    string roll;
    cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Delete Student Details ------------------------------------------" << endl;
    file.open("studentRecord.txt", fstream::in);
    if (!file)
    {
        cout << "\n\t\t\tNo Data is Present..";
        file.close();
    }
    else
    {
        cout << "\nEnter Student Number of Student which you want Delete Data: ";
        cin >> roll;
        file1.open("record.txt", ios::app | ios::out);
      	file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel;
        while (!file.eof())
        {
            if (roll != rec.numID)
            {
                 file1 << "\n" << rec.name << "\n" << rec.numID << "\n" << rec.bday << "\n" << rec.gender<< "\n" << rec.address << "\n" << rec.degree << "\n" << rec.yearLevel <<endl;
            }
            else
            {
                found++;
                cout << "\n\t\t\tSuccessfully Delete Data";
            }
           file >> rec.name >> rec.numID >> rec.bday >> rec.gender >> rec.address >> rec.degree >> rec.yearLevel; 
        }
        if (found == 0)
        {
            cout << "\n\t\t\t Student Roll NO. Not Found....";
        }
        file1.close();
        file.close();
        remove("studentRecord.txt");
        rename("record.txt", "studentRecord.txt");
    }
}

main()
{
    StudentRec rec;
    MainMenu();
    return 0;
}