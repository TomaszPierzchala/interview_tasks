package eu.tp.interview_tasks.tt;

import java.util.Arrays;

public class Solution1 {

	final private static int FIRST  = 0b111_0000_000;
	final private static int SECOND = 0b000_1111_000;
	final private static int THIRD  = 0b000_0000_111;
	final private static int ROW_FAMILY_GROUPS[] = { FIRST, SECOND, THIRD}; 
	
	public static void main(String[] args) {
		String reservedSeats = "1A 2F 1C";
		
		Solution1 sol = new Solution1();
		sol.solution(2, reservedSeats);
	}
	
	public int solution(int N, String S) {
		// table of reserved seats, row after row
		// seats in each row are represented by bits : 1 for taken and 0 for free one
		// eg. [100_0000_000][000_1000_001]
		final int seats[] = new int[N];
		
		reserveSeats(S, seats);
		printSeats(seats);
		
		//IntStream rowFamilyGroups = IntStream.of(FIRST, SECOND, THIRD);
		
		return (int) Arrays.stream(seats).map(i->(i^0b111_1110_111 | i^0b111_0111_111)) // to pass empty seats only
		.flatMap(i-> ( Arrays.stream(ROW_FAMILY_GROUPS).map(famGroup-> ((i&famGroup|famGroup) == (i&famGroup)) ? 1:0) ) )
		.peek(System.out::println) /*debug only */
		.filter(r->r==1).count();
		
	}
	
	void reserveSeats(String reservedSeats, int seats[]) {
		String reservedSeatsTab[] = reservedSeats.split(" ");
		for(String s : reservedSeatsTab) {
			convertSeatToBinary(s, seats);
		}
	}
	
	void convertSeatToBinary(String seat, int seats[]) {
		if(seat.trim().length()==0) return;
		int row = Integer.parseInt(seat.substring(0, 1)) - 1;
		int seatCode = seat.substring(1, 2).toUpperCase().codePointAt(0);
		//
		int takenSeat = 0;
		if(seatCode<73) {// letter I has Unicode 73
			takenSeat = 1 << (74 - seatCode);
		} else if(seatCode>73) { // as there is No letter 'I'
			takenSeat = 1 << (75 - seatCode);
		}
		seats[row] = seats[row]  | takenSeat;
	}
	
	private void printSeats(int seats[]) {
		int N = seats.length;
		System.out.println(Arrays.toString(seats));
	}
	

}
