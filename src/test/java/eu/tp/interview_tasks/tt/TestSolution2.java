package eu.tp.interview_tasks.tt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
		 * [ 2,1,3,1,		  3, 3, 4] : leader = null
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
	
		
		// five
		A = new int[] {3, 2, 1};
		K = 1; M = 3;
		Excpected = new int[] {2, 3};
		//
		result = sol.solution(K, M, A);
		/*
		 * [ 4,			  2,1] : no leader
		 * [ 3,		3,		1] : leader = 3
		 * [ 3,2,		 	2] : leader = 2
		 */
		//
		assertArrayEquals(Excpected, result);

	}
	
	@Test
	public void TestFindLeaderAndAddItToResultSet() {
		Solution2 sol = new Solution2();
		// map { (0 : 1), (1: 5), (4: 3), (7: 10) };
		final Map<Integer, Long> map = new HashMap<>();
		map.put(0, 1l);
		map.put(1, 5l);
		map.put(4, 3l);
		map.put(7, 10l);
		
		final int tableLength = 18;
		
		final Set<Integer> expectedSet = new TreeSet<Integer>();
		// Expected Leader is 7 
		expectedSet.add(7);
		
		final Set<Integer> resultSet = new TreeSet<Integer>();
// RUN		
		sol.findLeaderAndAddItToResultSet(tableLength, map, resultSet);
// TEST
		assertEquals(expectedSet, resultSet);
		
		// now remove key=7 we are left with
		// map { (0 : 1), (1: 5), (4: 3)};
		map.remove(7);
		// we do NOT expect key=1 to be added, as tableLength is 18 (2*5 is not > 18)
// RUN
		sol.findLeaderAndAddItToResultSet(tableLength, map, resultSet);
// TEST
		assertEquals(expectedSet, resultSet);
		
		// decreasing tableLength to 9, key=1 will become another leader
		// map { (0 : 1), (1: 5), (4: 3)};
		int newTableLength = 9;
		expectedSet.add(1);
// RUN
		sol.findLeaderAndAddItToResultSet(newTableLength, map, resultSet);
// TEST
		assertEquals(expectedSet, resultSet);
		
		// calling once again with same parameters NOTHING change
// RUN
		sol.findLeaderAndAddItToResultSet(newTableLength, map, resultSet);
// TEST
		assertEquals(expectedSet, resultSet);
	}
}
