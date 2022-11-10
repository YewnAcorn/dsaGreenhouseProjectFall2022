import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(17, GPIO.OUT) # pin 11 on the board


x = 10

# if it didn't rain
if(x == 10):
    print("watering")
    GPIO.output(17, GPIO.HIGH) # turn on the pin (to start the watering)
    print("for 100 seconds")
    time.sleep(100) # water for 100 seconds
    print("complete")
    GPIO.output(17, GPIO.LOW)
    print("valve closed")


