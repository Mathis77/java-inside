package fr.esipe.javainside.labthree;

import static fr.esipe.javainside.labthree.StateEnum.DEBUG;
import static fr.esipe.javainside.labthree.StateEnum.ERROR;
import static fr.esipe.javainside.labthree.StateEnum.INFO;
import static fr.esipe.javainside.labthree.StateEnum.WARNING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SwitchesTest {

	@ParameterizedTest
	@MethodSource("getIntSwitchesMethods")
	void testIntSwitch(TestDataIntSwitch arg) {
		assertEquals(arg.result, arg.aMethod.apply(arg.value));
	}

	static Stream<TestDataIntSwitch> getIntSwitchesMethods() {
		return Arrays.asList(new TestDataIntSwitch(0, "zero", ExprSwitches::intSwitch),
				new TestDataIntSwitch(1, "one", ExprSwitches::intSwitch),
				new TestDataIntSwitch(2, "a lot", ExprSwitches::intSwitch),
				new TestDataIntSwitch(0, "zero", ExprSwitches::intSwitch2),
				new TestDataIntSwitch(10, "ten", ExprSwitches::intSwitch2),
				new TestDataIntSwitch(100, "a lot", ExprSwitches::intSwitch2),

				new TestDataIntSwitch(0, "zero", ExprSwitches::exprIntSwitch),
				new TestDataIntSwitch(1, "one", ExprSwitches::exprIntSwitch),
				new TestDataIntSwitch(2, "a lot", ExprSwitches::exprIntSwitch),
				new TestDataIntSwitch(0, "zero", ExprSwitches::exprIntSwitch2),
				new TestDataIntSwitch(10, "ten", ExprSwitches::exprIntSwitch2),
				new TestDataIntSwitch(100, "a lot", ExprSwitches::exprIntSwitch2)).stream();
	}

	@ParameterizedTest
	@MethodSource("getIntSwitchesMethodsKO")
	void testIntSwitchKO(TestDataIntSwitch arg) {
		assertThrows(IllegalArgumentException.class, () -> arg.aMethod.apply(arg.value));
	}

	static Stream<TestDataIntSwitch> getIntSwitchesMethodsKO() {
		return Arrays.asList(new TestDataIntSwitch(-1, null, ExprSwitches::intSwitch),
				new TestDataIntSwitch(-1, null, ExprSwitches::intSwitch2),

				new TestDataIntSwitch(-1, null, ExprSwitches::exprIntSwitch),
				new TestDataIntSwitch(-1, null, ExprSwitches::exprIntSwitch2)).stream();
	}

	@ParameterizedTest
	@MethodSource("getStringSwitchMethod")
	void testStringSwitch(TestDataStringSwitch arg) {
		assertEquals(arg.result, arg.aMethod.apply(arg.value));
	}

	@Test
	void testStringSwitchKO() {
		TestDataStringSwitch toTestStringSwitch = new TestDataStringSwitch("blablablibli", null,
				ExprSwitches::stringSwitch);
		TestDataStringSwitch toTestExprStringSwitch = new TestDataStringSwitch("blablablibli", null,
				ExprSwitches::exprStringSwitch);
		assertThrows(IllegalArgumentException.class, () -> toTestStringSwitch.aMethod.apply(toTestStringSwitch.value));
		assertThrows(IllegalArgumentException.class,
				() -> toTestExprStringSwitch.aMethod.apply(toTestExprStringSwitch.value));
	}

	static Stream<TestDataStringSwitch> getStringSwitchMethod() {
		return Arrays.asList(new TestDataStringSwitch("foo", "zero", ExprSwitches::stringSwitch),
				new TestDataStringSwitch("bar", "ten", ExprSwitches::stringSwitch),
				new TestDataStringSwitch("baz", "a lot", ExprSwitches::stringSwitch),
				new TestDataStringSwitch("viva zorg", "zero", ExprSwitches::stringSwitch),

				new TestDataStringSwitch("foo", "zero", ExprSwitches::exprStringSwitch),
				new TestDataStringSwitch("bar", "ten", ExprSwitches::exprStringSwitch),
				new TestDataStringSwitch("baz", "a lot", ExprSwitches::exprStringSwitch),
				new TestDataStringSwitch("viva zorg", "zero", ExprSwitches::exprStringSwitch)).stream();
	}

	@ParameterizedTest
	@MethodSource("getEnumSwitchMethod")
	void testEnumSwitch(TestDataEnumSwitch arg) {
		assertEquals(arg.result, arg.aMethod.apply(arg.value));
	}

	static Stream<TestDataEnumSwitch> getEnumSwitchMethod() {
		return Arrays.asList(new TestDataEnumSwitch(DEBUG, "zero", ExprSwitches::enumSwitch),
				new TestDataEnumSwitch(WARNING, "ten", ExprSwitches::enumSwitch),
				new TestDataEnumSwitch(INFO, "a lot", ExprSwitches::enumSwitch),
				new TestDataEnumSwitch(ERROR, "zero", ExprSwitches::enumSwitch),

				new TestDataEnumSwitch(DEBUG, "zero", ExprSwitches::exprEnumSwitch),
				new TestDataEnumSwitch(WARNING, "ten", ExprSwitches::exprEnumSwitch),
				new TestDataEnumSwitch(INFO, "a lot", ExprSwitches::exprEnumSwitch),
				new TestDataEnumSwitch(ERROR, "zero", ExprSwitches::exprEnumSwitch)).stream();
	}

	static class TestDataIntSwitch {
		private final int value;
		private final String result;
		private final IntFunction<String> aMethod;

		public TestDataIntSwitch(int value, String result, IntFunction<String> aMethod) {
			this.value = value;
			this.result = result;
			this.aMethod = aMethod;
		}
	}

	static class TestDataStringSwitch {
		private final String value;
		private final String result;
		private final Function<String, String> aMethod;

		public TestDataStringSwitch(String value, String result, Function<String, String> aMethod) {
			this.value = value;
			this.result = result;
			this.aMethod = aMethod;
		}
	}

	static class TestDataEnumSwitch {
		private final StateEnum value;
		private final String result;
		private final Function<StateEnum, String> aMethod;

		public TestDataEnumSwitch(StateEnum value, String result, Function<StateEnum, String> aMethod) {
			this.value = value;
			this.result = result;
			this.aMethod = aMethod;
		}
	}

}
