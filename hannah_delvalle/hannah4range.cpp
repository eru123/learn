#include <iostream>
using namespace std;

int main(){
	int N1,N2,M;
	int i,count;
	
	N1 = 4;
	N2 = 12;
	M = 4;
	
	count = 0;
	
	for(i=N1;i<=N2;i++){
		if(i%M==0){
			count++;
			cout << i << endl;
		}
	}
	cout << "Value: " << count << endl;
	
	return 0;
}
