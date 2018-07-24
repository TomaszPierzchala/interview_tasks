package eu.tp.interview_tasks.tt;

public class Solution2 {

	public static void main(String[] args) {

		Solution2 sol = new Solution2();

	}

	public int[] solution(int K, int M, int[] A) {
		// The goal is to find all of the numbers that may become a leader (a value in the array
		// which occurs more than half of the elements) after performing exactly one array modification
		// (e.i. increasing by 1 every element of some chosen segment of length K).
		//
		// Solution proposal :
		//   1) will go through the table A and create a Map - as a key take numbers found in the table A (0 to M)
		// and as a value its counts; assume a segment of size K is at position [0, ..., K-1]
		//   2) then iterate over table A moving the segment of size K by 1, modifying in parallel the Map in such way that
		// increase counter value for key which get into the window 
		// and decrease counter for key which flew out the window respectively.
		// Every time after step 1) or 2) check if there is a Leader of A add it to result collection.
		//   3) finally after the segment K reaches the end of the table A,
		// finalize analysis with sorting collection in ascending order and returning it into the result table. 
		//
		// write your code in Java SE 8
		
		return new int[1];
	}
}
