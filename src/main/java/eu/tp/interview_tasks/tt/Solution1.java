package eu.tp.interview_tasks.tt;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		String reservedSeats = "1A 2F 1C";
		
		Solution1 sol = new Solution1();
		sol.solution(2, reservedSeats);

	}
	
	public int solution(int N, String S) {
		// table of reserved seats, row after row
		// seats in each row are represented by bits : 1 for taken and 0 for free one
		// eg. [100_0000_000][000_1000_001]
		final int reservedSeats[] = new int[N];
		
		printSeats(reservedSeats);
		
		return 0;
	}
	
	void reserveSeats(String S, int reservedSeats[]) {
		String seats[] = S.split(" ");
		Arrays.stream(seats).forEach(System.out::println);
		
	}
	
	void convertSeatToBinary(String seat, int reservedSeat[]) {
		
	}
	
	private void printSeats(int reservedSeats[]) {
		int N = reservedSeats.length;
		System.out.println(Arrays.toString(reservedSeats));
	}
	

}
