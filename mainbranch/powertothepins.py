import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(17, GPIO.OUT) # pin 11 on the board




weatherData = open('./activity_log.txt', 'r')
for line in weatherData:
    pass
last_line = line



weatherList = last_line.split(",")
action = weatherList[1]


# do we water?
if(action == true):
    print("no rain, watering...")
#    GPIO.output(17, GPIO.HIGH) # turn on the pin (to start the watering)
    print("for 100 seconds")
    time.sleep(100) # water for 100 seconds
    print("complete")
#    GPIO.output(17, GPIO.LOW)
    print("valve closed")
