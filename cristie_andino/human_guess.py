import random
import os


def guess(x):
    random_number = random.randint(1, x)
    user_guess = 0
    while user_guess != random_number:
        user_guess = int(input(f'\nGuess a number between 1 and {x}: '))
        if user_guess < random_number:
            print('Sorry, guess again. Too low.')
        elif user_guess > random_number:
            print('Sorry, guess again. Too high.')

    print(
        f'Yay, congrats {name}, {age} years old, a {gender} {section} student from {address}. '
        f'You have guessed the number {random_number} correctly!!\n')


def try_again():
    print('Do you want to try again?')
    print('[1] Yes')
    print('[2] No')
    choice = input("\nEnter your choice: ")
    os.system('cls')
    if choice == "2":
        print('Thank you for playing!')
        exit()
    elif choice != "1":
        print('Invalid choice. Please try again.')
        try_again()


name = input('What is your name? ').capitalize()
age = int(input('How old are you? '))
gender = input('What is your gender? ').capitalize()
section = input('What is your section? ')
address = input('Where do you live? ').capitalize()

while True:
    guess(10)
    try_again()
