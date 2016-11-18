##Make Change Project
###by Joshua Bone
####Skill Distillery SD7 2016.09.30

This program calculates the amount of change returned to a customer
after a purchase of a given price and prints out graphical feedback
showing the number of each type of US Currency to be disbursed.

Coins are displayed in parentheses: (1¢) (5¢) (10¢) (25¢)
Bills are displayed in square brackets: [$1$] [$5$] [$10$] [$20$] [$50$] [$100]

When the program is run in normal mode it prompts the user to enter the price
of the item, followed by the amount of cash tendered. The program then prints
the correct output.

The program can also be run in "test" mode by supplying the argument "test".
(i.e. type 'java MakeChange test' on the command line.) In test mode the program
loops through 6 predefined scenarios and prints the correct output for each.

A sample output for one scenario is given below:

          What is the item price? $5.01
          How much money was tendered? $20.00
          ----------------------------------------------
          Price: $5.01, Amount tendered: $20.00
          Total change due is $14.99
          [$10$]
          [$1$] [$1$] [$1$] [$1$]
          (25¢) (25¢) (25¢)
          (10¢) (10¢)
          (1¢) (1¢) (1¢) (1¢)
