# Java 8 solutions of interview tasks:

* #### Plane seats reservation - Solution1.java
The plane has N rows of seats (1 ... N). There are 10 seats in each row (from A to K - no letter **I** is used).

row | A | B | C | |D|E|F|G| |H|J|K
----|---|---|---|-|-|-|-|-|-|-|-|-
1   |   |   |   |X| | | | |X| | |  
2   |   |   |   |X| | | | |X| | |  
.........
N   |   |   |   |X| | | | |X| | |  

An example string S = "2B 7E 3K" can represent taken seats in arbitrary order.

The method ` public int solution(int N, String S)`, where N is number of rows and S in string of taken seats mentioned above,
returns the maximum number of 3-persons families that can be seated without separation (either by new row or by corridor between seats C&D or G&H).

The JUnit tests are placed in TestSolution1.java.

* #### Main elements of the table - Solution2.java
Definitions:
 1. *the main element*  of an array is element which occures more then half times in the array
 2. *the segemnt*  of an array is a sequence of consecutive elements
 
 The method `public int[] solution(int K, int M, int[] A)` returns a table of all elements which can become a main element,
 after increasing by 1 every element of exactly one segment of A of length K (table A consist of integers not bigger then M).
 The returend array is ASC ordered without duplication.

* #### The word machine - Solution3.java
*The word machine* performs a sequence of simple operations on a stack of integers.
Operations are given as a string, separated by single spaces.
There are five types of operations:
- an integer between 0 and 2<sup>20</sup> - 1; machine pushes it onto the stack
- "POP" : removes topmost number from stack
- "DUP" : duplicate the topmost number onto the stack
- "+" : pops two topmost numbers, adds them and pushes the sum onto the stack
- "-" : pops two topmost numbers, substracts second one from the first and pushes the difference onto the stack.

After processing all operations, machine returns topmost value from the stack.

Posible errors:
- overflow (>2<sup>20</sup> -1) or underflow (<0) errors
- an error when the machine operations needs more numbers than is currently on the stack
- an error when the stack is empty after performing all operations - nothing to return

The result function returns ```-1``` in case of an error.

For example, an input string ```13 DUP 4 POP 5 DUP + DUP + -``` causes the result function ```public int solution(String S)``` to return 7.

--------------------
I found task to be difficult in ascending order as : (the easiest) 3 , 1, 2 (the most dififcult).
