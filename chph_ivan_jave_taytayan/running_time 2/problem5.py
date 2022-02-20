
import datetime

start = datetime.datetime.now()

time = 20
if time < 18:
  print("Good day")
else:
  print("Good evening")

end = datetime.datetime.now()
running_time = end - start
print(f"\n\nRunning time: {running_time.seconds}.{running_time.microseconds} seconds")
