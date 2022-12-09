#!/bin/bash

#step one get into the directory where the action is:
cd /home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/

# run our Java program, which prints out weather info to weather_data.txt
# shotcoaller decides whether to water & writes date & t/f (did we water?) to activity_log.txt
java Main > output.json

# checks the activity log to see if it's supposed to turn on the water. Sends power to the pins
# on the Pi to water if we want to water today
python3 powertothepins.py

