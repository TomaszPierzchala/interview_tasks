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
to be filled in a caouple of days - I am at holidays now.

--------------------
I found task to be difficult in ascending order as : (the easiest) 3 , 1, 2 (the most dififcult).
