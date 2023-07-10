import time

def find_odd_even(a = []):
	odds = []
	evens = []
	for i in a:
		if i % 2 != 0:
			odds.append(i)
		elif i % 2 == 0:
			evens.append(i)
	
	print(f"The odds are: {odds}")
	print(f"The evens are: {evens}")


start_time = int(round(time.time() * 1000))
find_odd_even([1,2,3,4,5,6,7,8,9,10])
end_time = int(round(time.time() * 1000))
running_time = (end_time - start_time) / 1000

print(f"\n\nThe running time is {running_time} seconds")