package fr.esipe.javainside.labone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumsTest {

	@Test
	void testLoopSum() {
		assertEquals(3, Sums.loopSum(2));
		assertEquals(15, Sums.loopSum(5));
	}

	@Test
	void testStreamSum() {
		assertEquals(3, Sums.streamSum(2));
		assertEquals(15, Sums.streamSum(5));
	}

}
