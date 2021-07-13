#include <stdio.h>

int main(){
	
	int n,a,s;
	int i,j;
	
	printf("Enter input: ");
	scanf("%d",&n);
	
	for(i=0;i < n;i++){
		a = (i*2)+ 1;
		s = n - i;
		
		for(j=0;j<s;j++){
			printf(" ");
		}
		
		for(j=0;j<a;j++){
			printf("*");
		}
		printf("\n");
	}
	
	for(i=n-2;i>=0;i--){
		a = (i*2)+ 1;
		s = n - i;
		
		for(j=0;j<s;j++){
			printf(" ");
		}
		
		for(j=0;j<a;j++){
			printf("*");
		}
		
		printf("\n");
	}
	
	return 0;
}
