import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(17, GPIO.OUT) # pin 11 on the board




weatherData = open('./activity_log.txt', 'r')
for line in weatherData:
    pass
last_line = line


code = last_line.readline()

if (code == 'rain\n'):
    rain = True
    print("rain = True")
if(code == 'nope\n'):
    rain = False
    print("rain = False")
else:
    print("input error")
    print(code)
    for letter in code:
        print(ord(letter))
    print("string nope")
    for letter in "nope":
        print(ord(letter))

# if it didn't rain
if(rain != True):
    print("no rain, watering...")
#    GPIO.output(17, GPIO.HIGH) # turn on the pin (to start the watering)
    print("for 100 seconds")
    time.sleep(100) # water for 100 seconds
    print("complete")
#    GPIO.output(17, GPIO.LOW)
    print("valve closed")
