#include <iostream>
#include <limits>
#include <string>
#include <sstream>
#include <fstream>
#include <cstring>

using namespace std;

struct StudentRec {	
	int 	numID;
	int 	yearLevel;
	char 	gender;		
	string 	name;
	string 	address;
	string 	bday;
	string 	degree;
	StudentRec *next;
} *studentInfo;

// Functions for Validating user input
int 	getNumID();
int 	getYearLevel();
char 	getGender();
string 	getName();
string 	getAddress();
string 	getBday();
string 	getDegree();

// Functions for Data Handling
void recSave();
void recAdd();
void recGet();
StudentRec * recSearch(int numID);
bool recUpdate(int numID);
bool recRemove(int numID);

// Functions for Menu
void mainMenu();
void insert();
void display();
void modify();
void search();
void deleted();

int getNumID(){
	int id;
	cout << "\t \t \t \t   Enter Student ID no.: ";
	if(!(cin >> id)){
		cin.clear();
	    cin.ignore(numeric_limits<streamsize>::max(), '\n');
	    cout << "\t \t \t \t   Invalid ID! Try again.\n\n";
	    return getNumID();
	}
	return id;
}
int getYearLevel(){
	int level;
	cout << "\t \t \t \t   Enter Student year level (1-4): ";
	cin >> level;
	if(level < 1 || level > 4){
		cout << "\t \t \t \t   Invalid year level! Must be a number from 1 - 4, try again.\n\n";
		cin.clear();
	    cin.ignore(numeric_limits<streamsize>::max(), '\n');
		return getYearLevel();
	}
	return level;
}
char getGender(){
	char gender;
	cout << "\t \t \t \t   Enter Gender (M/F): "; 
	cin >> gender;
	switch(gender){
		case 'm': 
			gender = 'M';
			break;
		case 'f':
			gender = 'F';
			break;
	}
	if(gender == 'M' || gender == 'F') return gender;
	cout << "\t \t \t \t   Invalid Gender! M or F ONLY, try again.\n\n";
	return getGender();
}
string getAddress(){
	string address;
	cout << "\t \t \t \t   Enter Student address: ";
	getline(cin >> ws, address);
	return address;
}
string getName(){
	string name;
	string charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	size_t found = name.find_first_not_of(charset);
	cout << "\t \t \t \t   Enter Student name: ";
	getline(cin >> ws, name); 
	if(name.find_first_not_of(charset) != string::npos){
		cout << "\t \t \t \t   Invalid name! Must be letters and spaces only, try again.\n\n";
		return getName();
	}
	return name;
}
string getBday(){
	int month;
	int day;
	int year;
	stringstream bday;
	do {
		cout << "\t \t \t \t   Enter Birth Month (1-12): ";
		cin >> month;
		if(month < 1 || month > 12)	{
			cout << "\t \t \t \t   Invalid Birth month! Must be a number from 1 - 12, try again.\n\n";
			cin.clear();
	    	cin.ignore(numeric_limits<streamsize>::max(), '\n');
		}
	} while(month < 1 || month > 12);

	do {
		cout << "\t \t \t \t   Enter Birth date (1-31): ";
		cin >> day;
		if(day < 1 || day > 31)	{
			cout << "\t \t \t \t   Invalid Birth date! Must be a number from 1 - 31, try again.\n\n";
			cin.clear();
	    	cin.ignore(numeric_limits<streamsize>::max(), '\n');
		}
	} while(day < 1 || day > 31);

	do {
		cout << "\t \t \t \t   Enter Birth year (1950-2021): ";
		cin >> year;
		if(year < 1950 || year > 2021)	{
			cout << "\t \t \t \t   Invalid Birth year! Must be a number from 1950 - 2021, try again.\n\n";
			cin.clear();
	    	cin.ignore(numeric_limits<streamsize>::max(), '\n');
		}
	} while(year < 1950 || year > 2021);

	bday << month << '/' << day << '/' << year;

	return bday.str();
}
string getDegree(){
	string degree;
	cout << "\t \t \t \t   Enter Student Degree: ";
	getline(cin >> ws, degree);
	return degree;
}
void recSave(){
	if(studentInfo == NULL) return;

	fstream file;
   	file.open("studentRecord.txt", ios::trunc | ios::out);
	
   	StudentRec * rec = studentInfo;

   	while(rec != NULL){
   		file << rec->name 
			 << "|" << rec->numID 
			 << "|" << rec->bday 
			 << "|" << rec->gender 
			 << "|" << rec->address 
			 << "|" << rec->degree 
			 << "|" << rec->yearLevel 
			 << endl;
		rec = rec->next;
   	}
   	
    file.close();
}
void recAdd(){
	StudentRec * temp = new StudentRec();

	temp->numID 	= getNumID();
	temp->name 		= getName();
	temp->yearLevel = getYearLevel();
	temp->gender 	= getGender();
	temp->address 	= getAddress();
	temp->bday 		= getBday();
	temp->degree 	= getDegree();

	temp->next = *&studentInfo;
	*&studentInfo = temp;

	recSave();
}
void recGet(){
    ifstream file("studentRecord.txt");
    string text;

    if (file) {
    	while(getline(file,text)) {
    		StudentRec * temp = new StudentRec();

    		string del = "|";
    		int start = 0;
		    int end = text.find(del);
		    int index = 0;
		    string tmp[7];
		    while (end != -1) {
		        tmp[index] = text.substr(start, end - start);
		        start = end + del.size();
		        end = text.find(del, start);
		        index++;
		    }
		    tmp[index] = text.substr(start, end - start);

			stringstream ssa;		    
			ssa << tmp[1];
			ssa >> temp->numID;

			stringstream ssb;
			ssb << tmp[6];
			ssb >> temp->yearLevel;

			temp->name 		= tmp[0];
			temp->bday 		= tmp[2];
			temp->gender 	= *&tmp[3][0];
			temp->address 	= tmp[4];
			temp->degree 	= tmp[5];

			temp->next = *&studentInfo;
			*&studentInfo = temp;
    	}
    }

    file.close();
}
StudentRec * recSearch(int numID){
	if(studentInfo == NULL) return NULL;
	StudentRec * rec = studentInfo;
	while(rec != NULL){
   		if(rec->numID == numID) return rec;
		rec = rec->next;
   	}
	return NULL;
}
bool recRemove(int numID){
	StudentRec * cur, *next, *prev;
	cur = *&studentInfo;

	while(cur != NULL){
		next = cur->next;
		if(cur->numID == numID){
			if(prev != NULL && next != NULL) prev->next = next;	
			else if(prev != NULL && next == NULL) prev->next = NULL;
			else if(prev == NULL && next != NULL) *&studentInfo = next;
			else *&studentInfo = NULL;
			
			delete cur;
			recSave();
			return true;
		}

		prev = cur;
		cur = cur->next;
	}
	return false;
}
bool recUpdate(int numID){
	StudentRec * cur = *&studentInfo;
	while(cur != NULL){
		if(cur->numID == numID){
			cur->numID 		= getNumID();
			cur->name 		= getName();
			cur->yearLevel 	= getYearLevel();
			cur->gender 	= getGender();
			cur->address 	= getAddress();
			cur->bday 		= getBday();
			cur->degree 	= getDegree();

			recSave();
			return true;
		}
		cur = cur->next;
	}
	return false;
}
void insert(){
	int added = 0;
	char addAgain;
	while(true){
		added++;
		system("cls");
		cout << "\n\n";
		recAdd();
		cout << "\n\n\t \t \t \t   Add another Student? (Y/N): ";
		cin >> addAgain;
		if(addAgain == 'n' || addAgain == 'N') break;
	}
	system("cls");
	cout << "\n\n\t \t \t \t   " << added << " students added to the database.\n";
}
void display(){
	system("cls");
    cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Student Record Table --------------------------------------------" << endl;
    if (studentInfo == NULL) {
        cout << "\n\t\t\tNo Data Is Present...";
    } else {
    	StudentRec * rec = *&studentInfo;
    	int total = 0;
        while (rec != NULL) {
        	total++;
        	cout << "\n\n";
            cout << "\t\t\t Student No. : " << total << endl;
            cout << "\t\t\t Name        : " << rec->name << endl;
            cout << "\t\t\t ID number   : " << rec->numID << endl;
            cout << "\t\t\t Birthday    : " << rec->bday << endl;
            cout << "\t\t\t Gender      : " << rec->gender << endl;
            cout << "\t\t\t Address     : " << rec->address << endl;
            cout << "\t\t\t Degree      : " << rec->degree << endl;
            cout << "\t\t\t Year Level  : " << rec->yearLevel << endl;
            rec = rec->next;
        }
    }
    cout << "\n\n\t\t\t ";
    system("pause && cls");
}
void modify(){
	system("cls");
	cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Student Modify Details ------------------------------------------\n" << endl;
    if (studentInfo == NULL) {
        cout << "\n\t\t\t No Data Is Present...";
    } else {
    	int id;
    	while(cout << "\n\t\t\t Enter Student ID number: " && !(cin >> id)){
    		cin.clear();
		    cin.ignore(numeric_limits<streamsize>::max(), '\n');
		    cout << "\t\t\t Invalid ID! Try again.\n\n";
    	}
    	system("cls");
    	cout << "\n\n";
    	if(!recUpdate(id)) cout << "\t\t\t Failed to delete! Student not found.\n";
    }
    cout << "\n\n\t\t\t ";
    system("pause && cls");
    cout << "\n\n\t \t \t \t   1 student record updated\n";
}
void search(){
	system("cls");
	cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "--------------------------------------- Student Search Data -------------------------------------------\n" << endl;
    if (studentInfo == NULL) {
        cout << "\n\t\t\t No Data Is Present...";
    } else {
    	int id;
    	while(cout << "\n\t\t\t Enter Student ID number: " && !(cin >> id)){
    		cin.clear();
		    cin.ignore(numeric_limits<streamsize>::max(), '\n');
		    cout << "\t\t\t Invalid ID! Try again.\n\n";
    	}
    	cout << "\n\n";

    	StudentRec * rec = recSearch(id);

    	if(rec == NULL) {
    		cout << "\t\t\t Student not found! try again later.\n";
    	} else {
            cout << "\t\t\t Name        : " << rec->name << endl;
            cout << "\t\t\t ID number   : " << rec->numID << endl;
            cout << "\t\t\t Birthday    : " << rec->bday << endl;
            cout << "\t\t\t Gender      : " << rec->gender << endl;
            cout << "\t\t\t Address     : " << rec->address << endl;
            cout << "\t\t\t Degree      : " << rec->degree << endl;
            cout << "\t\t\t Year Level  : " << rec->yearLevel << endl;
    	}
    }
    cout << "\n\n\t\t\t ";
    system("pause && cls");
}
void deleted(){
	system("cls");
	cout << "\n-------------------------------------------------------------------------------------------------------" << endl;
    cout << "------------------------------------- Delete Student Details ------------------------------------------\n" << endl;
    if (studentInfo == NULL) {
        cout << "\n\t\t\t No Data Is Present...";
    } else {
    	int id;
    	while(cout << "\n\t\t\t Enter Student ID number: " && !(cin >> id)){
    		cin.clear();
		    cin.ignore(numeric_limits<streamsize>::max(), '\n');
		    cout << "\t\t\t Invalid ID! Try again.\n\n";
    	}
    	cout << "\n\n";

    	if(!recRemove(id)){
    		cout << "\t\t\t Failed to delete! Student not found.\n";
    	} else {
    		cout << "\t\t\t Student record successfully deleted.\n";
    	}
    }
    cout << "\n\n\t\t\t ";
    system("pause && cls");
}
void mainMenu(){
	
	int choice;
    char x;

	cout << " \n \n -------------------------------------------------------------------------------------------------------------------------------------------------------------------" << endl;
	cout << "\t \t \t \t      Good Day Mr. Calleja and Mr. Ramos! Welcome to group Uniquelo's Student Information Program! " << endl;
	cout << " -------------------------------------------------------------------------------------------------------------------------------------------------------------------" << endl;
	cout <<  endl << endl<<endl;
	cout << "\t \t \t \t ============================================================================================"<<endl;
	cout << "\t \t \t \t || \t \t \t \t      M  A  I  N    M  E  N  U                             ||"<<endl;
	cout << "\t \t \t \t ||----------------------------------------------------------------------------------------||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Add New Record: \t \t \t \t \t \t Enter 1           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Display Record: \t \t \t \t \t \t Enter 2           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Modify Record : \t \t \t \t \t \t Enter 3           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Search Record : \t \t \t \t \t \t Enter 4           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Delete Record : \t \t \t \t \t \t Enter 5           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
	cout << "\t \t \t \t || \t Exit Program  : \t \t \t \t \t \t Enter 6           ||" << endl;
	cout << "\t \t \t \t || \t \t \t \t \t \t                                           ||"<<endl;
    cout <<	"\t \t \t \t ============================================================================================"<<endl<<endl<<endl<<endl;
    cout << "\t \t \t \t   Please type your selection:   "; 

    cin >> choice;

    switch (choice) {
	    case 1:
	    	insert();
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
	    	return;
	    default:
	    	cin.clear();
	    	cin.ignore(numeric_limits<streamsize>::max(), '\n');
	    	system("cls");
	        cout << "\n\t\t\t Invalid choice... Please Try Again..";
	        break;
    }

	mainMenu();
}


int main(){
	recGet();
	mainMenu();

	system("cls");

	cout << "\n\n";
	cout << "\t \t \t \t ===================================================================================================" << endl;
	cout << "\t \t \t \t ||                 T H A N K   Y O U   F O R  U S I N G  O U R  P R O G R A M !                  ||" << endl;	
	cout << "\t \t \t \t ||-----------------------------------------------------------------------------------------------||" << endl;
	cout << "\t \t \t \t ||                                        U N I Q U E L O                                        ||" << endl;													
	cout << "\t \t \t \t ||                                                                                               ||" << endl;													
	cout << "\t \t \t \t ||                  LEADER:                               BAJAR, KYLA MARIE E.                   ||" << endl;
	cout << "\t \t \t \t ||                  MEMBER:                               CASTANEDA, SHANNEN ASHLEY              ||" << endl;
	cout << "\t \t \t \t ||                  MEMBER:                               REYES, CHRISTIAN JEROME KYLE S.        ||" << endl;
	cout << "\t \t \t \t ||                  MEMBER:                               TRINIDAD, KYLA B.                      ||" << endl; 
	cout << "\t \t \t \t ===================================================================================================" << endl << endl;

	return 0;
}