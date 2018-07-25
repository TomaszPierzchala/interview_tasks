package eu.tp.interview_tasks.tt;

import java.util.Arrays;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) {

		Solution2 sol = new Solution2();
		
		sol.solution(2, 3, new int [] { 1,0,2,3,1});
	}

	public int[] solution(int K, int M, int[] A) {
		// The goal is to find all of the numbers that may become a leader (a value in the array
		// which occurs more than half of the elements) after performing exactly one array modification
		// (e.i. increasing by 1 every element of some chosen segment of length K).
		//
		// Solution proposal :
		//   1) will go through the table A and create a Map - as a key take numbers found in the table A (0 to M)
		// and as a value its counts;
		//   2) perform the Map modification equivalent to the described array modification for a segment of size K 
		// starting at position [0] of table A (increase counter value for key==A[i]+1 
		// and decrease counter for key==A[i] as it was changed with new increased value A[i]+1)
		//   3) then iterate over table A, moving the segment/window of size K by 1 
		// and modifying in parallel the Map equivalently to described above table A modification  
		// (increase counter value for key which get into the window 
		// and decrease counter for key which flew out the window respectively).
		// Every time after step 2) or 3) check if there is a Leader of A add it to result TreeSet to have
		// unique and sorted elements.
		//   4) finally after the segment K reaches the end of the table A,
		// return result Set as a table. 
		
		
		// write your code in Java SE 8
		
		// 1) create the Map
		Map<Integer, Long> theMap = Arrays.stream(A).boxed().collect(Collectors.groupingBy(UnaryOperator.identity(), Collectors.counting()  ));
		
		theMap.entrySet().stream()
		.forEach(ent->System.out.println(ent.getKey() + " : " + ent.getValue()));
		System.out.println();
		
		// 2) Map modification equivalent to the described array modification for a segment K length started at A[0]
		for(int i=0;i<K;i++) {
			System.out.println("A="+A[i]);
			theMap.merge(A[i]+1, 1l, Long::sum);
			theMap.merge(A[i],  -1l, Long::sum);
		}
		System.out.println();
		
		theMap.entrySet().stream()
		.forEach(ent->System.out.println(ent.getKey() + " : " + ent.getValue()));
		
		
		return new int[1];
	}
}
