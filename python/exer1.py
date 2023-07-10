import re
from datetime import datetime

add_friend_data = 'Yes'
friends = []

while add_friend_data != 'No':
    last_name = input('Enter Last name: ').strip()
    while len(last_name) == 0:
        print('Invalid input!')
        last_name = input('Enter Last name: ').strip()

    first_name = input('Enter First name: ').strip()
    while len(first_name) == 0:
        print('Invalid input!')
        first_name = input('Enter First name: ').strip()

    birthdate = input('Enter Birthdate: ').strip()
    while len(birthdate) == 0 or not re.match(r'(0[1-9]|1[0-2])/(0[1-9]|[12]\d|3[01])/\d{4}', birthdate):
        print('Invalid input!')
        birthdate = input('Enter Birthdate: ').strip()
    birthdate = datetime.strptime(birthdate, '%m/%d/%Y').strftime('%B %d, %Y')

    gender = input('Enter Gender: ').strip()
    while len(gender) == 0 or gender not in ['M', 'F']:
        print('Invalid input!')
        gender = input('Enter Gender: ').strip()
    gender = "Male" if gender == 'M' else 'Female'

    contact_number = input('Enter Contact Number: ').strip()
    while len(contact_number) == 0 or not re.match(r'\d{11}', contact_number):
        print('Invalid input!')
        contact_number = input('Enter Contact Number: ').strip()

    add_friend_data = input('Add More? ').strip()
    while len(add_friend_data) == 0 or add_friend_data not in ['Yes', 'No']:
        print('Invalid input!')
        add_friend_data = input('Add More? ').strip()

    friends.append({
        'last_name': last_name,
        'first_name': first_name,
        'birthdate': birthdate,
        'gender': gender,
        'contact_number': contact_number
    })

    print()

for friend in friends:
    print(f'Name: {friend["first_name"]} {friend["last_name"]}')
    print(f'Birthdate: {friend["birthdate"]}')
    print(f'Gender: {friend["gender"]}')
    print(f'Contact No.: {friend["contact_number"]}')
    print()
    