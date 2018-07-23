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
	
		// an underflow error
		operationsSequence = "3 DUP 5 - -";
		//
		result = sol.solution(operationsSequence);
		//
		assertEquals(-1, result);
		
		// an overflow error
		operationsSequence = "1048575 1 +";
		//
		result = sol.solution(operationsSequence);
		//
		assertEquals(-1, result);	

		
		// the limit operations
		operationsSequence = "0 1048575 -" ;
		result = sol.solution(operationsSequence);
		assertEquals(1048575, result);	
		//
		operationsSequence = "0 1048575 +" ;
		result = sol.solution(operationsSequence);
		assertEquals(1048575, result);
		//
		// as well as adding commutativity
		operationsSequence = "1048575 0 +" ;
		result = sol.solution(operationsSequence);
		assertEquals(1048575, result);	
		//
		operationsSequence = "1048575 DUP -" ;
		result = sol.solution(operationsSequence);
		assertEquals(0, result);	
		//
		
		// Machine should NOT allow push number bigger then MAX = 1048575 (0b11_111_11_111_11_111_11_111)
		operationsSequence = "91048575 DUP -" ;
		result = sol.solution(operationsSequence);
		assertEquals(-1, result);
		
		//an empty stack error
		operationsSequence = "75 POP" ;
		result = sol.solution(operationsSequence);
		assertEquals(-1, result);
	}
}
