#include <iostream>
#include <sstream>

using namespace std;
string tdata(string str,int max){
	if(str.length() < max)
		for(int i = str.length();i < max;i++)
			str += " ";
		
	str += "   ";
	return str;
}

int main(){
	
	// Subject
	string sub[8] = {
		"P.E.",
		"Purposive Communication",
		"Kontekswalisadong komunikasyon sa Filipino",
		"NSTP",
		"Introduction to computing",
		"ITSSB",
		"Mathematics in the Modern world",
		"Computer Programming"
	};
	
	// Final Grade
	float FG[8] = {
		1.5,
		1,
		3,
		2.5,
		2,
		1.5,
		1,
		1.25
	};
	
	// Credit Unit
	float CU[8] = {
		2,
		3,
		3,
		1.5,
		3,
		3,
		3,
		3
	};
	
	// Sum of the product
	float SP;
	
	// Sum of Credit Units
	float SU;
	
	// Computed GPA
	float GPA;
	
	// Remarks
	string REMARKS;
	
	// Compute Grade Point Average 
	for(int i=0; i < 8; i++)
	{
		SP += FG[i] * CU[i];
		SU += CU[i];
	}
	GPA = SP / SU;
	
	// Decide for Remarks
	if (GPA >= 1.0 && GPA <= 1.25)
	{
		REMARKS = "PARTIAL SCHOLARSHIP WITH 100% TUITION FEE DISCOUNT";
	} 
	else if (GPA >= 1.26 && GPA <= 1.50)
	{
		REMARKS = "PARTIAL SCHOLARSHIP WITH 75% TUITION FEE DISCOUNT";
	}
	else if (GPA >= 1.51 && GPA <= 1.75)
	{
		REMARKS = "PARTIAL SCHOLARSHIP WITH 50% TUITION FEE DISCOUNT";
	}
	else if (GPA >= 1.76 && GPA <= 2.0)
	{
		REMARKS = "PARTIAL SCHOLARSHIP WITH 25% TUITION FEE DISCOUNT";
	}
	else
	{
		REMARKS = "NOT QUALIFIED FOR SCHOLARSHIP";
	}
	
	// Output
	cout << "Name : Tristan Jay G. Bon" << endl;
	cout << "Course: Bs Information Technology\n" << endl;
	
	// Table for Subject, Final Grade and Credit Unit
	cout << tdata("Subject",42) << tdata("Final Grade",10) << tdata("Credit Units",10) << endl << endl;
	
	
	for(int i=0; i < 8; i++){
		std::ostringstream f1,f2;	
		f1 << FG[i];
		f2 << CU[i];
		cout << tdata(sub[i],42) << tdata(std::string(f1.str()),10) << tdata(f2.str(),10) << endl;
	}
	cout << endl;
	
	
	// Average Grade Point
   	cout << "GRADE POINT AVERAGE: " << GPA << endl;
	cout << "REMARKS: " << REMARKS << endl;
	
	//Exit Application
	return 0;
}
