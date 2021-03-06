# Project Euler Solutions (Problems 1-10)

### Problem 11 - Largest product in a grid
###### Problem Statement

In the 20×20 grid below, four numbers along a diagonal line have been marked in red.

<img src="http://i.imgur.com/NX07Uz3.png" alt="Grid" style="width: 100"/>

The product of these numbers is 26 × 63 × 78 × 14 = 1788696.

What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?


###### Solution Output [(View Code)] (PE011.java)
```
Found new max product: 279496
Row 1, column 1
[8, 49, 31, 23]

Found new max product: 1909600
Row 1, column 1
[22, 70, 31, 40]

Found new max product: 3654745
Row 1, column 2
[31, 95, 73, 17]

Found new max product: 6414210
Row 1, column 3
[22, 99, 31, 95]

Found new max product: 6514520
Row 1, column 4
[97, 40, 73, 23]

Found new max product: 21408786
Row 1, column 7
[63, 42, 93, 87]

Found new max product: 41076896
Row 1, column 10
[92, 68, 67, 98]

Found new max product: 51267216
Row 7, column 16
[66, 91, 88, 97]

Found new max product: 70600674
Row 12, column 4
[87, 97, 94, 89]

Max product found: 70600674
Verified answer from Project Euler: 70600674
```

### Problem 12 - Highly divisible triangle number
###### Problem Statement
The sequence of triangle numbers is generated by adding the natural numbers. 
So the 7th triangle number would be ``1 + 2 + 3 + 4 + 5 + 6 + 7 = 28``. 
The first ten terms would be:
``
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
``

Let us list the factors of the first seven triangle numbers:

```
1: 1 
3: 1,3 
6: 1,2,3,6
10: 1,2,5,10 
15: 1,3,5,15
21: 1,3,7,21 
28: 1,2,4,7,14,28 
```


We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?

###### Solution Output [(View Code)] (PE012.java)
```
First triangle number with > 500 divisors: 76576500
Verified answer from Project Euler: 76576500
```


### Problem 13 - Large sum
###### Problem Statement
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
```
37107287533902102798797998220837590246510135740250
46376937677490009712648124896970078050417018260538
74324986199524741059474233309513058123726617309629
91942213363574161572522430563301811072406154908250
23067588207539346171171980310421047513778063246676
89261670696623633820136378418383684178734361726757
28112879812849979408065481931592621691275889832738
44274228917432520321923589422876796487670272189318
47451445736001306439091167216856844588711603153276
70386486105843025439939619828917593665686757934951
62176457141856560629502157223196586755079324193331
64906352462741904929101432445813822663347944758178
92575867718337217661963751590579239728245598838407
58203565325359399008402633568948830189458628227828
80181199384826282014278194139940567587151170094390
35398664372827112653829987240784473053190104293586
86515506006295864861532075273371959191420517255829
71693888707715466499115593487603532921714970056938
54370070576826684624621495650076471787294438377604
53282654108756828443191190634694037855217779295145
36123272525000296071075082563815656710885258350721
45876576172410976447339110607218265236877223636045
17423706905851860660448207621209813287860733969412
81142660418086830619328460811191061556940512689692
51934325451728388641918047049293215058642563049483
62467221648435076201727918039944693004732956340691
15732444386908125794514089057706229429197107928209
55037687525678773091862540744969844508330393682126
18336384825330154686196124348767681297534375946515
80386287592878490201521685554828717201219257766954
78182833757993103614740356856449095527097864797581
16726320100436897842553539920931837441497806860984
48403098129077791799088218795327364475675590848030
87086987551392711854517078544161852424320693150332
59959406895756536782107074926966537676326235447210
69793950679652694742597709739166693763042633987085
41052684708299085211399427365734116182760315001271
65378607361501080857009149939512557028198746004375
35829035317434717326932123578154982629742552737307
94953759765105305946966067683156574377167401875275
88902802571733229619176668713819931811048770190271
25267680276078003013678680992525463401061632866526
36270218540497705585629946580636237993140746255962
24074486908231174977792365466257246923322810917141
91430288197103288597806669760892938638285025333403
34413065578016127815921815005561868836468420090470
23053081172816430487623791969842487255036638784583
11487696932154902810424020138335124462181441773470
63783299490636259666498587618221225225512486764533
67720186971698544312419572409913959008952310058822
95548255300263520781532296796249481641953868218774
76085327132285723110424803456124867697064507995236
37774242535411291684276865538926205024910326572967
23701913275725675285653248258265463092207058596522
29798860272258331913126375147341994889534765745501
18495701454879288984856827726077713721403798879715
38298203783031473527721580348144513491373226651381
34829543829199918180278916522431027392251122869539
40957953066405232632538044100059654939159879593635
29746152185502371307642255121183693803580388584903
41698116222072977186158236678424689157993532961922
62467957194401269043877107275048102390895523597457
23189706772547915061505504953922979530901129967519
86188088225875314529584099251203829009407770775672
11306739708304724483816533873502340845647058077308
82959174767140363198008187129011875491310547126581
97623331044818386269515456334926366572897563400500
42846280183517070527831839425882145521227251250327
55121603546981200581762165212827652751691296897789
32238195734329339946437501907836945765883352399886
75506164965184775180738168837861091527357929701337
62177842752192623401942399639168044983993173312731
32924185707147349566916674687634660915035914677504
99518671430235219628894890102423325116913619626622
73267460800591547471830798392868535206946944540724
76841822524674417161514036427982273348055556214818
97142617910342598647204516893989422179826088076852
87783646182799346313767754307809363333018982642090
10848802521674670883215120185883543223812876952786
71329612474782464538636993009049310363619763878039
62184073572399794223406235393808339651327408011116
66627891981488087797941876876144230030984490851411
60661826293682836764744779239180335110989069790714
85786944089552990653640447425576083659976645795096
66024396409905389607120198219976047599490197230297
64913982680032973156037120041377903785566085089252
16730939319872750275468906903707539413042652315011
94809377245048795150954100921645863754710598436791
78639167021187492431995700641917969777599028300699
15368713711936614952811305876380278410754449733078
40789923115535562561142322423255033685442488917353
44889911501440648020369068063960672322193204149535
41503128880339536053299340368006977710650566631954
81234880673210146739058568557934581403627822703280
82616570773948327592232845941706525094512325230608
22918802058777319719839450180888072429661980811197
77158542502016545090413245809786882778948721859617
72107838435069186155435662884062257473692284509516
20849603980134001723930671666823555245252804609722
53503534226472524250874054075591789781264330331690
```
###### Solution Output [(View Code)] (PE013.java) 
```
Added first  1 digits of each number, first ten digits of sum are        506.
Added first  2 digits of each number, first ten digits of sum are       5488.
Added first  3 digits of each number, first ten digits of sum are      55323.
Added first  4 digits of each number, first ten digits of sum are     553682.
Added first  5 digits of each number, first ten digits of sum are    5537323.
Added first  6 digits of each number, first ten digits of sum are   55373710.
Added first  7 digits of each number, first ten digits of sum are  553737574.
Added first  8 digits of each number, first ten digits of sum are 5537376181.
Added first  9 digits of each number, first ten digits of sum are 5537376225.
Added first 10 digits of each number, first ten digits of sum are 5537376229.
Added first 11 digits of each number, first ten digits of sum are 5537376230.
Added first 12 digits of each number, first ten digits of sum are 5537376230.
First ten digits of sum are 5537376230
Verified answer from Project Euler: 5537376230
```
###### Notes
The issue here is that we know we don't have to add all the digits of all the numbers to find the first ten digits of the sum, but we can intuitively guess that we need to add at least the first 10 and maybe a few more. But how do we know for sure we've chosen enough digits? I'm sure there's a mathematical solution out there, but here I chose to simply add one digit at a time until no additional precision was gained. For illustrative purposes I started by just adding the first digit of each number.

### Problem 14 - Longest Collatz sequence
###### Problem Statement
The following iterative sequence is defined for the set of positive integers:

```
n → n/2 (n is even)
n → 3n + 1 (n is odd)
```

Using the rule above and starting with 13, we generate the following sequence:

```
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

###### Solution Output [(View Code)] (PE014.java)
```
Found new longest chain starting at 999999 and containing 259 terms
Found new longest chain starting at 999667 and containing 290 terms
Found new longest chain starting at 999295 and containing 396 terms
Found new longest chain starting at 997823 and containing 440 terms
Found new longest chain starting at 970599 and containing 458 terms
Found new longest chain starting at 939497 and containing 507 terms
Found new longest chain starting at 837799 and containing 525 terms
Longest chain found starts at 837799
Verified answer from Project Euler: 837799
```

### Problem 15 - 
###### Problem Statement
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
there are exactly 6 routes to the bottom right corner.

<img src="http://i.imgur.com/chrpaeY.png">

How many such routes are there through a 20×20 grid?

###### Solution Output [(View Code)] (PE015.java)
```
Paths through a 2x2 grid: 6
Paths through a 20x20 grid: 137846528820
Verified answer from Project Euler: 137846528820
```

###### Notes
This is solved quickly by building a [Pascal's Triangle](https://en.wikipedia.org/wiki/Pascal's_triangle) of depth 42 (2 x (grid size + 1)).

### Problem 16 - Power digit sum
###### Problem Statement
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?

###### Solution Output [(View Code)] (PE016.java)
```
Sum of digits of 2^15: 26
Sum of digits of 2^1000: 1366
Verified answer from Project Euler: 1366
```

### Problem 17 - Number letter counts
###### Problem Statement
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

###### Solution Output [(View Code)] (PE017.java) 
```
Sum of letters in first 5 numbers = 19
Sum of letters in first 1000 numbers = 21124
Verified answer from Project Euler: 21124
```

### Problem 18 - Maximum path sum I
###### Problem Statement
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

<img src="http://i.imgur.com/W9RhGvQ.png" align="middle">

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

<img src="http://i.imgur.com/cLkFEQm.png">

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67 is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)

###### Solution Output [(View Code)] (PE018.java)
```
Maximum path sum: 1074
Verified answer from Project Euler: 1074
```
###### Notes
My solution takes the maximum value from either of a cell's parents (if they exist) and increments the value of each cell by that maximum value. There is no way to use this method to store the actual route through the triangle, but it efficiently finds the solution in O(n) time. 

### Problem 19 - Counting Sundays

###### Problem Statement
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.

Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.

A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

###### Solution Output [(View Code)] (PE019.java)
```
Number of Sundays that fell on the first of the month: 171
Verified answer from Project Euler: 171
```

### Problem 20 - 

###### Problem Statement
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

###### Solution Output [(View Code)] (PE020.java) 
```
Sum of digits of 100!: 648
Verified answer from Project Euler: 648
```

