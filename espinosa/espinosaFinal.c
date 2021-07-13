#include <stdio.h>

int main()
{
	// input
	int n;
	
	// Loop
	int i,j;
	
	// User input
	printf("Enter number: ");
	scanf("%d",&n);
	
	for(i=0;i<n;i++)
	{	
		// Space
		for(j=0;j<i;j++){
			printf(" ");
		} 
		
		// Asterisk
		for(j=0;j<n;j++) {
			printf("*");
		}
		
		// Newline
		printf("\n");
	}
	
	// exit
	return 0;
}
