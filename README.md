# 3308 Campaign 02 -- Wait Time Simulator

## Due Date: February 10, 2019 @ 2300

## Problem Statement
The TSA (Transportation Security Administration) has had trouble recently balancing customer service with operating costs. At many airports, they don't have enough security lines open making travelers angry, because they have to wait in line for so long. However, at other airports, they have too many lines open, which costs money (paying the personnel and managing extra equipment). The Director of the TSA has decided that the agency needs software that will tell each airport how many lines to keep open. Luckily for them, your are the Chief Data Scientist of Bloated Government Contracts, Inc. and are willing to produce this for only several million dollars.

You need to build a simulator for wait times in a line. The input for your program will be an integer representing the arrival rate (average number of people arriving at the security checkpoint per minute) as well as an integer representing the maximum number of lines that can be open (the user will pick that based on personnel and equipment availability). The arrival rate will be used to determine the number of people that arrive to the checkpoint each minute. The output for your program will be the average wait times (in minutes) of travelers at the checkpoint over a 12 hour period (720 minutes) for each potential number of lines. In other words, the user will determine what they expect the arrival rate to be that day (e.g. average of 18 people per minute) and the maximum number of lines they are able to open (e.g. 10) and will get output from your program that looks like this (you numbers should be close, but probably not exact). This will enable them to determine the best number of lines to open.

For a maximum arrival rate of 18 people/per minute and maximum number of lines at 10 and an initial seed of 1024 you should see the following values (each +/- 1):
```
Arrival rate: 18
Average wait time using 1 queue(s): 320
Average wait time using 2 queue(s): 280
Average wait time using 3 queue(s): 240
Average wait time using 4 queue(s): 200
Average wait time using 5 queue(s): 160
Average wait time using 6 queue(s): 120
Average wait time using 7 queue(s): 80
Average wait time using 8 queue(s): 41
Average wait time using 9 queue(s): 3
Average wait time using 10 queue(s): 1
```

The general flow of your simulation will follow this pattern: Every minute a random number of people arrive to the security checkpoint (call `getRandomNumPeople()` to get that random value). Each of those people (one at a time) join the line that is currently shortest. After each person joins a line (still in the same minute), two people (or fewer if there aren't that many people in the line) from the front of each line proceed through the checkpoint (leave) and have their wait time recorded. Do this each minute for 720 minutes and calculate the average wait time for people that got through. Don't worry about people that remain in the lines after 720 minutes are over. That is one iteration for the given number of lines. Since we need realistic values, run this for 50 iterations with the same parameters and average the average wait times. This is the value that you will report for the given number of lines. Do this for each possible number of lines (up to the value passed).

As an example, suppose I have some arrival rate and the maximum number of lines are two. I'll start with having one line for everyone. For each minute of the 720 minutes, I'll add `getRandomNumPeople()` to that line and remove two from the front (recording their wait time). After the 720 minutes are over, I'll determine the average wait time for people that got through over the past 720 minutes and put that value somewhere. I'll then do the same exact thing 49 more times. After that is complete, I'll average those 50 values to get the average wait time using one line. Then, I'll move to two lines. Each minute I'll add `getRandomNumPeople()` to the line(s) (person 1 picks the shortest, person 2 picks the shortest, ...) and remove two from the front of each line. After the 720 minutes, I'll determine the average wait time for everyone that got through (regardless of the line they were in). I'll do this 49 more time, average the results, and report everything.

## Assignment
1. Fork this repository and then clone the new repo to your system.
2. Start with the provided code.
3. You must use `LinkedQueue` objects to represent your lines.
4. Complete the `Simulation` class to solve the problem defined in the Problem Statement.
5. Any methods/constructors defined should not be renamed or their headers changed (for testing purposes).
6. Build the classes/methods needed to execute the simulation described.

## Submission
When you have completed the assignment (all tests pass) or it is reaching midnight of the due date, make sure you have completed the following:
1. Committed all changes to your repo
2. Pushed your changes to GitHub
3. Tagged your repo as "COMPLETE"
4. Pushed the "COMPLETE" tag to GitHub
5. Submitted your repository URL to Moodle in the Mission 01 submission section.

## Grading (50 Points)
* The simulation works for one iteration of some number (larger than one) of lines given the arrival rate. - 15 points
* The simulation successfully considers the number of lines available from one to the maximum provided. - 10 points
* The simulation runs 50 times per scenario and averages the results. - 10 points
* Program by Contract - 5 points
* Documentation and Style - 10 points

## Hints
1. What should you add to the queue when a person joins the line?
2. There could be up to hundreds of lines, so how will you represent them? What if you had 162 Car Objects, how would you keep track of them? Not 162 individual variables, I hope...
