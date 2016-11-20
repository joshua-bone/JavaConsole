# Project Euler Java Solutions (Self Study)
#### Ongoing project by Joshua Bone



### Overview (from the Wikipedia page)
'''
Project Euler (named after Leonhard Euler) is a website dedicated to a series of computational problems intended to be solved with computer programs. The project attracts adults and students interested in mathematics and computer programming. Since its creation in 2001 by Colin Hughes, Project Euler has gained notability and popularity worldwide. It includes over 575 problems, with a new one added every weekend (except during the summer). Problems are of varying difficulty but each is solvable in less than a minute using an efficient algorithm on a modestly powered computer. Problems can be sorted on difficulty. A forum specific to each question may be viewed after the user has correctly answered the given question. As of November 2016 Project Euler has about 650,000 users from all over the world (who solved at least one problem).
'''

##### Notes
Each problem is contained in its own class named "PExxx.java" where xxx = 001 for the first problem, 002 for the 2nd, etc. All methods within each of these classes are static. Occasionally I have created certain "helper" classes containing reusable code for some of the more common themes (such as prime numbers). 

##### Example
Problem 5: 
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
```
Test case (1-10):
Factors: {2=3, 3=2, 5=1, 7=1}
Calculated answer: 2520

Assigned case (1-20):
Factors: {2=4, 3=2, 5=1, 7=1, 11=1, 13=1, 17=1, 19=1}
Calculated answer: 232792560

Verified answer from Project Euler: 232792560
```
