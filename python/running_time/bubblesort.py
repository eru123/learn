import time

def bubble_sort(a):
	for i in range(len(a), 1, 1):
		for j in range(1, i - 1):
			if a[j] > a[j+1]:
				a[j], a[j+1] = a[j+1], a[j]


start_time = time.time() * 1000
a = [i for i in range(9999)]
bubble_sort(a)
end_time = time.time() * 1000
running_time = (end_time - start_time) / 1000

print(f"\n\nThe running time is {running_time} seconds")