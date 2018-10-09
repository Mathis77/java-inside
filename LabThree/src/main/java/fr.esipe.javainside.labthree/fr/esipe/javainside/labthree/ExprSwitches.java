package fr.esipe.javainside.labthree;

public final class ExprSwitches {

	/* =========== SWITCHES AVANT JAVA 12 =========== */

	public static String intSwitch(int n) {
		switch (n) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "a lot";
		default:
			throw new IllegalArgumentException("You need to specify a positiv number !");
		}
	}

	public static String intSwitch2(int n) {
		switch (n) {
		case 0:
			return "zero";
		case 10:
			return "ten";
		case 100:
			return "a lot";
		default:
			throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
		}
	}

	public static String stringSwitch(String arg) {
		switch (arg) {
		case "foo":
			return "zero";
		case "bar":
			return "ten";
		case "baz":
			return "a lot";
		case "viva zorg":
			return "zero";
		default:
			throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
		}
	}

	public static String enumSwitch(StateEnum e) {
		switch (e) {
		case DEBUG:
			return "zero";
		case WARNING:
			return "ten";
		case INFO:
			return "a lot";
		case ERROR:
			return "zero";
		default:
			throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
		}
	}

	/* =========== SWITCHES JAVA 12 =========== */

	public static String exprIntSwitch(int n) {
		String result;
		switch (n) {
		case 0:
			result = "zero";
			break;
		case 1:
			result = "one";
			break;
		case 2:
			result = "a lot";
			break;
		default:
			throw new IllegalArgumentException("You need to specify a positiv number !");
		}
		return result;
	}

	public static String exprIntSwitch2(int n) {
		return switch (n) {
					case 0 -> "zero";
					case 10 -> "ten";
					case 100 -> "a lot";
					default -> throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
				};
	}

	public static String exprStringSwitch(String arg) {
		return switch (arg) {
					case "foo" -> "zero";
					case "bar" -> "ten";
					case "baz" -> "a lot";
					case "viva zorg" -> "zero";
					default -> throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
				};
	}

	public static String exprEnumSwitch(StateEnum e) {
		return switch (e) {
					case DEBUG -> "zero";
					case WARNING -> "ten";
					case INFO -> "a lot";
					case ERROR -> "zero";
					default -> throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
				};
	}

}
