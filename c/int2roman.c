#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int num, i = 0;
    char *roman = malloc(100);

    printf("Enter a number: ");
    scanf("%d", &num);
    
    while (num >= 1000) {
        roman[i++] = 'M';
        num -= 1000;
    }
    if (num >= 900) {
        roman[i++] = 'C';
        roman[i++] = 'M';
        num -= 900;
    }
    if (num >= 500) {
        roman[i++] = 'D';
        num -= 500;
    }
    if (num >= 400) {
        roman[i++] = 'C';
        roman[i++] = 'D';
        num -= 400;
    }
    while (num >= 100) {
        roman[i++] = 'C';
        num -= 100;
    }
    if (num >= 90) {
        roman[i++] = 'X';
        roman[i++] = 'C';
        num -= 90;
    }
    if (num >= 50) {
        roman[i++] = 'L';
        num -= 50;
    }
    if (num >= 40) {
        roman[i++] = 'X';
        roman[i++] = 'L';
        num -= 40;
    }
    while (num >= 10) {
        roman[i++] = 'X';
        num -= 10;
    }
    if (num >= 9) {
        roman[i++] = 'I';
        roman[i++] = 'X';
        num -= 9;
    }
    if (num >= 5) {
        roman[i++] = 'V';
        num -= 5;
    }
    if (num >= 4) {
        roman[i++] = 'I';
        roman[i++] = 'V';
        num -= 4;
    }
    while (num >= 1) {
        roman[i++] = 'I';
        num -= 1;
    }
    roman[i] = '\0';
    printf("%s", roman);
    free(roman);
    return 0;
}
