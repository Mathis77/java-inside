package fr.esipe.javainside.labtwo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SwitchesTest {

	@ParameterizedTest
	@MethodSource("getMethods")
	void testIntSwitch(String arg) {
		assertEquals("zero", Switches.intSwitch(0));
		assertEquals("one", Switches.intSwitch(1));
		assertEquals("a lot", Switches.intSwitch(2));
	}
	
	static Stream<TestDataIntSwitch> getMethods(){
		return null;
	}
	
	private static class TestDataIntSwitch{
		private int value;
		private IntFunction<String> aMethod;
	}
	
	@ParameterizedTest
	void testIntSwitchIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> Switches.intSwitch(-1));
	}

}
