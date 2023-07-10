student_list = {}

for i in range(3):
    student_number = input(f"Please enter student number {i + 1}: ")
    student_name = input(f"Please enter student name {i + 1}: ")
    student_list[student_number] = student_name

print("Student List:")
for student_number, student_name in student_list.items():
    print(f"{student_number}: {student_name}")

del student_list[list(student_list.keys())[2]]

student_number = input(f"Enter your student number: ")
student_name = input(f"Enter your student name: ")

student_list[student_number] = student_name

print("Student List:")
for student_number, student_name in student_list.items():
    print(f"{student_number}: {student_name}")