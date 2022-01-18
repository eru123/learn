# create empty hashset group1, group2 and self
group1 = set()
group2 = set()
self = set()

# enter birth month of group1 for 3 people
for i in range(3):
    month = input(f"Enter birth month {i + 1}: ")
    group1.add(month)

# enter birth month of group2 for 3 people
for i in range(3):
    month = input(f"Enter birth month {i + 1}: ")
    group2.add(month)

# sort group1 and group2
group1 = set(sorted(group1))
group2 = set(sorted(group2))

# display group1 and group2
print("Group1: ", group1)
print("Group2: ", group2)

# ask user to enter their birth month and add it to self
month = input("Enter your birth month: ")
self.add(month)

# show the union, intersection and difference of group1 and group2
print("Union: ", group1.union(group2))
print("Intersection: ", group1.intersection(group2))
print("Difference: ", group1.difference(group2))

# check if self is a member of union of group1 and group2
if len(group1.union(group2).intersection(self)) > 0:
    print("You have the same birth month with one of your classmates.")