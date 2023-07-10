#include <stdio.h>

int main(){
    int i, j, largest, count;
    char answer;
    
    do {
        largest = 0;
        count = 0;
        printf("Enter a number: ");
        for(i = 0; i < 13; i++){
            scanf("%d", &j);
            if(j > largest){
                largest = j;
                count = 1;
            }
            else if(j == largest){
                count++;
            }
        }
        printf("The largest value is %d and it was entered %d times.\n", largest, count);
        
        printf("Do you want to try again? (y/n): ");
        scanf("%c", &answer);
    } while(answer == 'y');

    printf("Goodbye!\n");

    return 0;
}