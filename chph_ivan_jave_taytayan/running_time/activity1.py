import time

def find_max(a,b,c):
	if a > b:
		if a > c:
			print("a is the largest number")
		else:
			print("c is the largest number")
	else:
		if b > c:
			print("b is the largest number")
		else:
			print("c is the largest number")

start_time = int(round(time.time() * 1000))
find_max(1,2,3)
end_time = int(round(time.time() * 1000))
running_time = (end_time - start_time) / 1000

print(f"\n\nThe running time is {running_time} seconds")