package eu.tp.interview_tasks.tt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSolution3 {

	@Test
	public void TestSolution() {
		Solution3 sol = new Solution3();
		
		String operationsSequence = "13 DUP 4 POP 5 DUP + DUP + -";
		//
		int result = sol.solution(operationsSequence);
		//
		assertEquals(7, result);	
		
		
		operationsSequence = "5 6 + -";
		//
		result = sol.solution(operationsSequence);
		//
		assertEquals(-1, result);	
	
		
		operationsSequence = "3 DUP 5 - -";
		//
		result = sol.solution(operationsSequence);
		//
		assertEquals(-1, result);	

	}
}
