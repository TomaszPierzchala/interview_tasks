package eu.tp.interview_tasks.tt;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestSolution2 {

	@Test
	public void TestSolution() {
		Solution2 sol = new Solution2();
		
		// one
		int A[] = new int[] {2, 1, 3, 1, 2, 2, 3};
		int K = 3, M = 5;
		int Excpected[] = new int[] {2, 3};
		//
		int result[] = sol.solution(K, M, A);
		/*
		 * [ 3, 2, 4,		  1,2,2,3] : leader = null
		 * [ 2,		2, 4, 2,		2,2,3] : leader = 2
		 * [ 2,1,	  4, 2, 3,	  2,3] : leader = null
		 * [ 2,1,3, 		2, 3, 3, 	3] : leader = 3
		 */
		//
		assertArrayEquals(Excpected, result);
		
		
		// two
		A = new int[] {1, 2, 2, 1, 2};
		K = 4; M = 2;
		Excpected = new int[] {2, 3};
		//
		result = sol.solution(K, M, A);
		/*
		 * [ 2, 3, 3, 2,		 2] : leader = 2
		 * [ 1,		3, 3, 2, 3] : leader = 3
		 */
		//
		assertArrayEquals(Excpected, result);
		
		
		// three (if we increase M result is the same)
		A = new int[] {1, 2, 2, 1, 2};
		K = 4; M = 9;
		Excpected = new int[] {2, 3};
		//
		result = sol.solution(K, M, A);
		/*
		 * [ 2, 3, 3, 2,		 2] : leader = 2
		 * [ 1,		3, 3, 2, 3] : leader = 3
		 */
		//
		assertArrayEquals(Excpected, result);

		
		// four - an empty result
		A = new int[] {1, 2, 2, 1};
		K = 4; M = 2;
		Excpected = new int[] {};
		//
		result = sol.solution(K, M, A);
		/*
		 * [ 2, 3, 3, 2] : no leader
		 */
		//
		assertArrayEquals(Excpected, result);
		
	}
}
