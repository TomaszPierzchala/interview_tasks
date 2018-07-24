package eu.tp.interview_tasks.tt;

import java.util.Stack;

public class Solution3 {

	public static void main(String[] args) {
		String operationsSequence = "13 DUP 4 POP 5 DUP + DUP + -";

		Solution3 sol = new Solution3();

		System.out.println("For a given operations sequence : \"" + operationsSequence
				+ "\"\nthe Word Machine returns : " + sol.solution(operationsSequence));

	}

	public int solution(String S) {
		// write your code in Java SE 8
		Integer MAX = 0b11_111_11_111_11_111_11_111;

		// System.out.println("MAX = "+ MAX);
		Stack<Integer> stack = new Stack();
		
		String[] command = S.split(" ");
		
		Integer result = -1;
		
		try {
			for (int i = 0; i < command.length; i++) {
				switch (command[i]) {
				case "DUP":
					stack.push(stack.peek());
					break;
				case "POP":
					stack.pop();
					break;
				case "+":
					Integer add = stack.pop() + stack.pop();
					if (add > MAX)
						throw new RuntimeException("Overflow Error");
					stack.push(add);
					break;
				case "-":
					Integer sub = stack.pop() - stack.pop();
					if (sub < 0)
						throw new RuntimeException("Underflow Error");
					stack.push(sub);
					break;
				default:
					Integer number = Integer.valueOf(command[i]);
					if (number < 0 || number > MAX)
						throw new RuntimeException("Machine input out of range Error");
					stack.push(number);
					break;
				}
			}

			result = stack.peek();
			
		} catch (RuntimeException rexp) {
			return -1;
		}
		return result;
	}
}
