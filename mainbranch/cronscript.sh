#!/bin/bash
# ok this one shows you how its all done currently:

#step one get into the directory where the action is:
cd /home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/

# right now I have the first one called Main, its arbitrary
# but this 'Main' is where the api calls for the weather
# and puts it out into a file called output.json
java Main > output.json

# then here we have the json reading file called 'MainParser' and it parses for the ID code
# of the weather and puts that into a text file called raincode.txt

java -cp .:json-java.jar MainParser > raincode.txt

#then theres this java thing called shotcaller which just knows
#which ID codes involve rain and puts out an 'isItRain' file which
#is either 'rain' or 'nope'
java shotcaller > isItRain.txt

# the last thing that gets called is the python program
# that controls the pins. This program reads the isItRain.txt
# file to get a boolean representing rain and sending power if
# theres no rain
python3 powertothepins.py

