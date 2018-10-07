package fr.esipe.javainside.labtwo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwitchesTest {

	@Test
	void testIntSwitch() {
		assertEquals("zero", Switches.intSwitch(0));
		assertEquals("one", Switches.intSwitch(1));
		assertEquals("a lot", Switches.intSwitch(2));
	}
	
	@Test
	void testIntSwitchIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> Switches.intSwitch(-1));
	}

}
