#include <iostream>
using namespace std;

char ch;

int n=0;
int c=0;

string contact[1000][3];
string fp, sp, m;
string info[1000][4];
string id, name, age, add;

string prefix = "\t\t\t\t ";

bool conCheck(string fp,string sp){
    for(int i =0;i<c;i++){
        if(contact[i][0] == fp && contact[i][1] == sp){
            return true;
        } else if(contact[i][1] == fp && contact[i][0] == sp) {
        	return true;
		}
    }
    return false;
}
bool IDExists(string id){
    for(int i = 0; i<n; i++){
        if(info[i][0] == id){
            return true;
        }
    }
    return false;
}
bool nameExists(string name){
    for(int i = 0; i<n; i++){
        if(info[i][1] == name){
            return true;
        }
    }
    return false;
}

void viewAllName(){
	system("cls");
    cout << "\n";
	cout << prefix << "#####################################################" << endl;
    cout << prefix << "#                   ALL RECORDS                     #" << endl;
    cout << prefix << "#####################################################" << endl;
    for(int i =0;i<n;i++){
        cout << prefix << "ID      : "<<info[i][0] <<endl;
        cout << prefix << "NAME    : "<<info[i][1] <<endl;
        cout << prefix << "AGE     : "<<info[i][2] <<endl;
        cout << prefix << "ADDRESS : "<<info[i][3] <<endl;
        cout << prefix << "#####################################################" <<endl;
    }
}
void addContact(){
    do{	
    	ac:
    	cout << "\n";
	    cout << prefix << "#################################################" <<endl;
	    cout << prefix << "#               [1] View Name                   #" <<endl;
	    cout << prefix << "#               [2] Add contact                 #" <<endl;
	    cout << prefix << "#               [3] Back                        #" <<endl;
	    cout << prefix << "#################################################\n" <<endl;
	    
		cout << prefix << "Enter Number : ";
	    cin >> ch;
	    
		if(ch == '1'){
	        system("cls");
	        viewAllName();
	    } else if(ch =='2') {

	        cout << prefix << "First Person Name  : ";
	        cin >> fp;
	        
	        if(!nameExists(fp)) {
	        	system("cls");
				cout << "\n" << prefix << "NAME NOT FOUND!" << endl;
				goto ac;
			}
	        
	        cout << prefix << "Second Person Name : ";
	        cin >> sp;
	        
	        if(!nameExists(sp)) {
	        	system("cls");
				cout << "\n" << prefix << "NAME NOT FOUND!" << endl;
				goto ac;
			} else if(fp==sp){
				system("cls");
				cout << "\n" << prefix << "Invalid input!"<<endl;
				goto ac;
		    } else if(conCheck(fp,sp)){
				system("cls");
				cout << "\n" << prefix << "This record is already exist" <<endl;
				goto ac;
			}
	        
			cout << "\n" << prefix << "Where they met? : ";
			cin >> m;
			
			contact[c][0] = fp;
			contact[c][1] = sp;
			contact[c][2] = m;
			c++;
			
			system("cls");
			cout << "\n" << prefix << "Successfully Added" <<endl;
		} else if(ch == '3'){
			system("cls");
		} else {
			system("cls");
			cout << "\n" << prefix << "Invalid input! Try again ..." << endl;
		}
		
    } while (ch != '3');
}
void addName(){
	cout << "\n";
    cout << prefix << "#####################################################" <<endl;
    cout << prefix << "#                      ADD NAME                     #" <<endl;
    cout << prefix << "#####################################################\n" <<endl;
    
    cout << prefix << "ID         : ";
    cin >> id;
    
    if(IDExists(id)){
        system("cls");
        cout << "\n" << prefix << "THIS ID IS ALREADY TAKEN!" << endl;
    } else {
        cout << prefix << "Enter Name : ";
        cin >> name;
        
		cout << prefix << "Age        : ";
        cin >> age;
        
		cout << prefix << "Address    : ";
        cin >> add;
        
		info[n][0] = id;
        info[n][1] = name;
        info[n][2] = age;
        info[n][3] = add;
        
        n++;
        
		system("cls");
        cout << "\n" << prefix << "Successfully added" <<endl;
    }
}
void tracing(){

        cout << "\n" << prefix << "Enter Name : ";
        cin >> name;
        
        cout << "\n" << prefix << "Enter Location : ";
        cin >> add;
        
        cout << "\n";
        cout << prefix << "#####################################################" <<endl;
        cout << prefix << "#                WITH KNOWN EXPOSURE TO :           #" <<endl;
        cout << prefix << "#####################################################\n" <<endl;
        
        int total = 0;
        
        for(int i = 0;i < c; i++){
        	if((contact[i][0] == name || contact[i][1] == name) && contact[i][2] == add){
        		if (contact[i][0] == name){
        			sp = contact[i][1];
				} else {
        			sp = contact[i][0];
				}
        		
        		cout << prefix << "THEY MEET AT : " << contact[i][2] <<endl;
        		for(int j =0;j<n;j++){
                    if(info[j][1] == sp){
	                    cout << prefix << "ID           : "<<info[j][0] <<endl;
	                    cout << prefix << "NAME         : "<<info[j][1] <<endl;
	                    cout << prefix << "AGE          : "<<info[j][2] <<endl;
	                    cout << prefix << "ADDRESS      : "<<info[j][3] <<endl;
	                    cout << prefix << "#####################################################\n" <<endl;
                    }
                }
        		total++;
			} 
        }
        
        cout << prefix << "TOTAL : " << total << endl;
        cout << "\n" << prefix << "[1] BACK\n" << endl;
        
        cout << prefix << "ENTER NUMBER : ";
        cin >> ch;
        
        system("cls");
        
        if(ch == '1'){
        	return;
        }
        
		return tracing();
}

char mainMenu(){
    cout <<"\n";
    cout << prefix << "#################################################"<<endl;
    cout << prefix << "#               CONTACT TRACING                 #"<<endl;
    cout << prefix << "#################################################"<<endl;
    cout << prefix << "#               [1]     Add Name                #"<<endl;
    cout << prefix << "#               [2]     Add Contact             #"<<endl;
    cout << prefix << "#               [3]     Trace                   #"<<endl;
    cout << prefix << "#               [4]     View all                #"<<endl;
    cout << prefix << "#               [5]     EXIT                    #"<<endl;
    cout << prefix << "#################################################\n"<<endl;
    cout << prefix << "ENTER NUMBER: ";
	cin >> ch;
	return ch;
}

int main() {
    do{
        system("color E0");
        ch = mainMenu();
        system("cls");
        switch(ch){
			case '1':
	            addName();
				break;
	        
	        case '2':
	            addContact();
	        	break;
	        
	        case '3':
	        	tracing();
	        	break;
	        
	        case '4':
	            viewNames:
		            viewAllName();
		            cout << "\n" << prefix << "[1] BACK" << endl;
		            cout << "\n" << prefix << "Enter Number: ";
		            cin >> ch;
		            if(ch == '1')
		        		system("cls");
		            else
						goto viewNames; 
		        break;
		        
	        case '5':
	            cout << "System is Exiting ...\n\n" << endl;
	        	break;
	        
	        default:
	        	cout << "\n" << prefix << "Invalid input! Try again ..." << endl;
	        	break;
	        	
        }
    } while(ch !='5');
    return 0;
}