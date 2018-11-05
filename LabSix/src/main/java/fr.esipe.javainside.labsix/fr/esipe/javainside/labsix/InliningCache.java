package fr.esipe.javainside.labsix;

import static java.lang.invoke.MethodHandles.constant;
import static java.lang.invoke.MethodHandles.dropArguments;
import static java.lang.invoke.MethodHandles.guardWithTest;
import static java.lang.invoke.MethodHandles.insertArguments;
import static java.lang.invoke.MethodHandles.lookup;
import static java.lang.invoke.MethodHandles.privateLookupIn;
import static java.lang.invoke.MethodType.methodType;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MutableCallSite;
import java.util.List;
import java.util.Objects;

public class InliningCache {

	private final static MethodHandle testEqualsMH;

	static {
		try {
			testEqualsMH = lookup().findVirtual(String.class, "equals", methodType(boolean.class, Object.class))
					.asType(methodType(boolean.class, String.class, String.class));
		} catch (ReflectiveOperationException e) {
			throw new IllegalStateException(e);
		}
	}

	public static MethodHandle stringSwitch(String... elts) {
		Objects.requireNonNull(elts);
		var fallbackMH = dropArguments(constant(int.class, -1), 0, String.class);
		for (var i = 0; i < elts.length; i++) {
			var testMH = insertArguments(testEqualsMH, 0, Objects.requireNonNull(elts[i]));
			var targetMH = dropArguments(constant(int.class, i), 0, String.class);
			fallbackMH = guardWithTest(testMH, targetMH, fallbackMH);
		}
		return fallbackMH;
	}

	public static MethodHandle stringSwitch2(String... matches) {
		return new InliningCache2(matches).dynamicInvoker();
	}

	static class InliningCache2 extends MutableCallSite {
		private static final MethodHandle SLOW_SWITCH_STRING;
		static {
			try {
				SLOW_SWITCH_STRING = privateLookupIn(InliningCache2.class, lookup()).findVirtual(InliningCache2.class,
						"slowStringSwitch", methodType(int.class, String.class));
			} catch (ReflectiveOperationException e) {
				throw new IllegalStateException(e);
			}
		}

		private final List<String> matches;

		public InliningCache2(String... matches) {
			super(methodType(int.class, String.class));
			this.matches = List.of(matches);
			setTarget(insertArguments(SLOW_SWITCH_STRING, 0, this));
		}

		private int slowStringSwitch(String value) {
			Objects.requireNonNull(value);
			var i = 0;
			for (String str : matches) {
				if (value.equals(str)) {
					return i;
				}
				i++;
			}
			return -1;
		}
	}

}
