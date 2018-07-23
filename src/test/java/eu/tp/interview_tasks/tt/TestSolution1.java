package eu.tp.interview_tasks.tt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSolution1 {

	@Test
	public void TestConvertSeatToBinary() {
		Solution1 sol = new Solution1();
		
		final int N = 2;
		final int reservedSeats[] = new int[N];
		
		int expectedRow = 0b100_0000_000;
		sol.convertSeatToBinary("1A", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);
		
		expectedRow = 0b101_0000_000;
		sol.convertSeatToBinary("1C", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);
		
		expectedRow = 0b101_1000_000;
		sol.convertSeatToBinary("1D", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);
		
		expectedRow = 0b101_1010_000;
		sol.convertSeatToBinary("1F", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);
		
		expectedRow = 0b101_1010_010;
		sol.convertSeatToBinary("1J", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);

		expectedRow = 0b000_0010_000;
		sol.convertSeatToBinary("2F", reservedSeats);
		assertEquals(expectedRow, reservedSeats[1]);
		
		expectedRow = 0b000_0010_100;
		sol.convertSeatToBinary("2H", reservedSeats);
		assertEquals(expectedRow, reservedSeats[1]);

		expectedRow = 0b101_1010_011;
		sol.convertSeatToBinary("1K", reservedSeats);
		assertEquals(expectedRow, reservedSeats[0]);

	}
	
	@Test
	public void TestReserveSeats() {
		Solution1 sol = new Solution1();

		int seats[] = new int[1];
		String resevedSeats = "1C 1H 1B 1J 1D";
		int expectedRows[] = new int[] { 0b011_1000_110 };
		//
		sol.reserveSeats(resevedSeats, seats);
		//
		for(int i=0;i<seats.length; i++) {
			assertEquals(expectedRows[i], seats[i]);
		}
		
		seats = new int[2];
		resevedSeats = "1A 2F 1C";
		expectedRows = new int[] { 0b101_0000_000, 0b000_0010_000 };
		//
		sol.reserveSeats(resevedSeats, seats);
		//
		for(int i=0;i<seats.length; i++) {
			assertEquals(expectedRows[i], seats[i]);
		}
		
		seats = new int[4];
		resevedSeats = "2C 3A 1H 4J 2I 1C 4G 1G";// additional 2I should have NO influence
		expectedRows = new int[] { 0b001_0001_100, 0b001_0000_000, 0b100_0000_000, 0b000_0001_010  };
		//
		sol.reserveSeats(resevedSeats, seats);
		//
		for(int i=0;i<seats.length; i++) {
			assertEquals(expectedRows[i], seats[i]);
		}

	}
	
	@Test
	public void TestSolution() {
		Solution1 sol = new Solution1();
		
		int N = 2;
//		int seats[] = new int[N];
		String resevedSeats = "1A 2F 1C";
		//
		int result = sol.solution(N, resevedSeats);
		//
		assertEquals(4, result);
		
		N = 1;
		resevedSeats = "";
		result = sol.solution(N, resevedSeats);
		//
		assertEquals(3, result);
		
		N = 45;
		resevedSeats = "";
		result = sol.solution(N, resevedSeats);
		//
		assertEquals(3*45, result);

		N = 50;
		resevedSeats = "1C 10G 1B";
		result = sol.solution(N, resevedSeats);
		//
		assertEquals(150-2, result);
		
		N = 50;
		resevedSeats = "1C 10G 1B 7F 50K";
		result = sol.solution(N, resevedSeats);
		//
		assertEquals(150-4, result);

	}
}
