labels = ["Strongly Dissatisfied", "Dissatisfied", "Neutral", "Satisfied", "Strongly Satisfied"]
data = [0] * len(labels)
for i in range(len(labels)):
    data[i] = input(f'Enter value for {labels[i]}: ')
    while len(data[i]) == 0 or not data[i].isdigit():
        print('Invalid input!')
        data[i] = input(f'Enter value for {labels[i]}: ')
    data[i] = int(data[i])
print()
for i in range(len(labels)):
    print(f'{labels[i]}: {"*" * data[i]}')