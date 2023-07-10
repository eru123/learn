import datetime

print("Input a three integer a, b and c")
a = int(input("a: "))
b = int(input("b: "))
c = int(input("c: "))

start = datetime.datetime.now()

step1 = a + b
step2 = b * c
print("\nResults:")
print(f"a + b = {step1}")
print(f"b * c = {step2}")

end = datetime.datetime.now()
running_time = end - start
print(f"\n\nRunning time: {running_time.seconds}.{running_time.microseconds} seconds")