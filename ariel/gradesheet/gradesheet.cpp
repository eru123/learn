#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

string currentText;
char path[255] = "grades.txt";
int lineCount = 0;
int x,y;

void getLinesCount(){
	fstream MyReadFile(path);
	while (getline (MyReadFile, currentText)) lineCount++;
	MyReadFile.close();
}

// string to int - improvised
int stoii(string s){
	stringstream toi(s);
	int x = 0;
	toi >> x;
	return x;
}

int main() {
	getLinesCount();
	
	int id[lineCount]; // student id
	int g1[lineCount]; // grade for prelim
	int g2[lineCount]; // grade for midterm
	int g3[lineCount]; // grade for tentative final grade
	double fg[lineCount]; // final grade
	string rm[lineCount]; // remarks
	string name[lineCount]; // student name
	
	
	// GET STRING FROM FILE
	fstream MyReadFile(path);
	string line[lineCount];
	string token;
	
	// PROCESS THE STRING
	for(x =0;x < lineCount;x++) {
		if(getline (MyReadFile, currentText)){
			line[x] = currentText; 
			istringstream curLine(currentText);
			vector<string> tokens;
			while(getline(curLine,token,'\t')) tokens.push_back(token);
			
			// COLUMNS PER LINE
			id[x] = stoii(tokens[0]);
			name[x] = tokens[1];
			g1[x] = stoii(tokens[2]);
			g2[x] = stoii(tokens[3]);
			g3[x] = stoii(tokens[4]);
			
			// FINAL GRADE
			fg[x] = (g1[x] * .30) + (g2[x] * .30) + (g3[x] * .40);
			
			// REMARKS
			rm[x] = fg[x] > 75 ? "Passed" : "Failed";
		}
	}
	
	MyReadFile.close();
	
	// OUTPUT
	cout << "ID\tName\t\tFinal Grade\tRemarks" << endl;
	for(x=0;x<lineCount;x++)
		cout << id[x] << "\t" << name[x] << "\t" << fg[x] << "\t\t" << rm[x] << endl;
}
