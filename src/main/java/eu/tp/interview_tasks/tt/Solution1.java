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
	
	void reserveSeats(String reservedSeats, int seats[]) {
		String reservedSeatsTab[] = reservedSeats.split(" ");
		for(String s : reservedSeatsTab) {
			convertSeatToBinary(s, seats);
		}
	}
	
	void convertSeatToBinary(String seat, int seats[]) {
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
