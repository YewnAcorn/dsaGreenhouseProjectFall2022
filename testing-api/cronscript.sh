#!/bin/bash

cd /home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/

java Main > output.txt

# this is the script that cron runs
# these comments will attempt to describe how it does that and
# how to set it up

#line 1: this tells the computer its a bash script. the rest is like you're writing in a terminal
# so line 3: is a command to change directory (cd) to the directory where the action is
# this will probably be a different directory on your machine
# but thats the folder where I have main. So now that the script will take us to the folder,
# line 5: it can run the program there, in this case Main (Main.class)
# it could be called something else in your case so write that instead
# then the output gets put in output.txt that part is just to test it

# so to get cron to do this job, I dont know how to get a script to configure cron for you
# to give the job to cron is like one well placed line of code though so check it out:
# get to cron's table in editor mode with the command 
# crontab -e
# then you should see a page where it tells you how to set it up
# but you put in one line per job in the format it says which is like
#[minute] [hour] [day] [month] [dayofweek] [command] without brackets
#if you want to do every day you do
# a wildcard character * for day etc.
# so in my daemon cron's table it says:
# 05 00  * * * /home/pi/Gardenbot/dsaGreenhouseProjectFall2022/testing-api/cronscript.sh
# which means run this script 5 minutes after midnight every day, every month, any day of the week
# so you can set it to be in 2 minutes and then wait and see if it works, you should have an output.txt
# file somewhere. other helpful commands are 
# crontab -l 
# to see what jobs you have scheduled
# and the command 
# date 
# will print what time your computer thinks it is
# so hopefully that made sense
# basically, write a script that goes to your folder where the program is (already compiled)
# then tell cron where that script is and when you want it run. fun!
