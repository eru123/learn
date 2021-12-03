#include <stdio.h>
#include <stdlib.h>

// this programm will get a two large number with unlimited digits and will add them using linked list

struct node {
  int value;
  struct node *left;
} *n1, *n2, *n3, *t;


int charlen(char * s){
    int c = 0;
    while(*s){
        c++;
        s++;
    }
    return c;
}


int main(){
    char num1[1000];
    char num2[1000];
    
    // get the first number
    printf("Enter the first number: ");
    scanf("%s", num1);

    // get the second number
    printf("Enter the second number: ");
    scanf("%s", num2);
    
    // put the first number into a linked list
    int n1_len = charlen(num1);
    t = NULL;
    n1 = NULL;
    int i;
    for( i = 0; i < n1_len;i++){
      int v = num1[i] - '0';
      t = (struct node *)malloc(sizeof(struct node));
      t->value = v;
      t->left = NULL;

      if(n1 == NULL){
        n1 = t;
      }else{
        t->left = n1;
        n1 = t;
      }
    }

    // put the second number into a linked list
    int n2_len = charlen(num2);
    t = NULL;
    n2 = NULL;
    for( i = 0; i < n2_len;i++){
      int v = num2[i] - '0';
      t = (struct node *)malloc(sizeof(struct node));
      t->value = v;
      t->left = NULL;

      if(n2 == NULL){
        n2 = t;
      }else{
        t->left = n2;
        n2 = t;
      }
    }


    // calculate the sum of the two numbers
    int carry = 0;
    n3 = NULL;
    while(n1 != NULL || n2 != NULL){
      int v1 = 0;
      int v2 = 0;
      if(n1 != NULL){
        v1 = n1->value;
        n1 = n1->left;
      }
      if(n2 != NULL){
        v2 = n2->value;
        n2 = n2->left;
      }
      int v3 = v1 + v2 + carry;
      if(v3 >= 10){
        v3 -= 10;
        carry = 1;
      }else{
        carry = 0;
      }
      t = (struct node *)malloc(sizeof(struct node));
      t->value = v3;
      t->left = NULL;

      if(n3 == NULL){
        n3 = t;
      }else{
        t->left = n3;
        n3 = t;
      }
    }
    
    // print the sum of the two numbers
    printf("The sum of the two numbers is: ");
    while(n3 != NULL){
      printf("%d", n3->value);
      n3 = n3->left;
    }
    printf("\n");
    
    return 0;
}