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
}
