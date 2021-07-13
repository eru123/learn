#include <iostream>
#include <string>
using namespace std;


int main() {
	char answer;
	
	int correct = 0;
	
	string questions[3] = {
		"What is stockholders' equity?\nA. Sales of products or resources\nB. Owners' claim to resources\n\n",
		"What are Expenses?\nA. Costs of Selling products or services\nB. Distributions to Stockholders\n\n",
		"What's Revenue?\nA. Costs of selling products or services\nB. Sales of products or services\n\n"
	};
	
	char answers[3] = {
		'b',
		'b',
		'a'
	};
	
	for(int i = 0; i < 3; i++) {
	  cout << questions[i] << "Enter the letter of your answer: ";
	  cin >> answer;
	  
	  if (tolower(answer,locale()) == answers[i]){
	  	cout << "\nGets mo!\n\n";
	  	correct++;
	  } else {
	  	cout << "\nNice try!\n\n";
	  }
	  
	}
	
	if(correct == 3){
		cout << "Congratulations, you are a millionaire!";
	} else {
		cout << "Thank you for joining the show!";
	}
  
	return 0;
  
}
