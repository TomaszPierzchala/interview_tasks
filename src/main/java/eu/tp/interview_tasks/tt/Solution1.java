package eu.tp.interview_tasks.tt;

import java.util.Arrays;

public class Solution1 {
	// 3 people : 111, different, possible family configuration
	final private static int LEFT  = 0b111_0000_000;
	final private static int MID1  = 0b000_1110_000;
	final private static int MID2  = 0b000_0111_000;
	final private static int RIGHT = 0b000_0000_111;

	final private static int POSSIBLE_ROW_MAX_FAMILY_ARRANGE1 = LEFT | MID1 | RIGHT;
	final private static int POSSIBLE_ROW_MAX_FAMILY_ARRANGE2 = LEFT | MID2 | RIGHT;

	// Same time possible one family places - need for projections then for counting
	final private static int[] SAME_TIME_POSSIBLE_ONE_FAMILY_PLACES = {LEFT, MID1 | MID2, RIGHT};

	public static void main(String[] args) {
		String reservedSeats = "1A 2F 1C";
		
		Solution1 sol = new Solution1();
		
		int N = 2;
		System.out.println("Example of algorithm run :\nN = " + N 
				+ "\nfor given taken seats :\"" + reservedSeats 
				+ "\"\nresult is : " + sol.solution(N, reservedSeats) );
	}
	
	public int solution(int N, String S) {
		// table of reserved seats, row after row
		// seats in each row are represented by bits : 1 for taken and 0 for free one
		// eg. [100_0000_000][000_1000_001]
		final int[] seats = new int[N];
		
		reserveSeats(S, seats);
		// printSeats(seats);
		
		return Arrays.stream(seats) // taken seats stream
				.map(i->(i^POSSIBLE_ROW_MAX_FAMILY_ARRANGE1 | i^POSSIBLE_ROW_MAX_FAMILY_ARRANGE2)) // stream of available seats
				.map(i -> // for any available row do
						(int) Arrays.stream(SAME_TIME_POSSIBLE_ONE_FAMILY_PLACES)
								.filter(oneFamilyPlace -> (oneFamilyPlace & i) == oneFamilyPlace) // project to possible one family place
								.count() // and sum it up
				).sum(); // return the total number
	}
	
	void reserveSeats(String reservedSeats, int[] seats) {
		String[] reservedSeatsTab = reservedSeats.split(" ");
		for(String s : reservedSeatsTab) {
			convertSeatToBinary(s, seats);
		}
	}
	
	void convertSeatToBinary(String seat, int[] seats) {
		if(seat.trim().isEmpty()) return;
		
		final int INPUT_STRING_LENGTH = seat.length();
		
		int row = Integer.parseInt(seat.substring(0, INPUT_STRING_LENGTH-1)) - 1;
		int seatCode = seat.substring(INPUT_STRING_LENGTH-1, INPUT_STRING_LENGTH).toUpperCase().codePointAt(0);
		//
		int takenSeat = 0;
		if(seatCode<73) {// letter I has Unicode 73
			takenSeat = 1 << (74 - seatCode);
		} else if(seatCode>73) { // as there is No letter 'I'
			takenSeat = 1 << (75 - seatCode);
		}
		seats[row] = seats[row]  | takenSeat;
	}

	@SuppressWarnings("unused")
	private void printSeats(int[] seats) {
		System.out.println(Arrays.toString(seats));
	}
	

}
