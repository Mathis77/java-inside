package fr.esipe.javainside.labtwo;

/*
 * Le code du switch en bytecode indique à la machine virtuelle des "goto" en fonction des "case" du switch.
 * Par exemple : 
 * 		tableswitch {
 * 			0: <ligne instruction pour le cas 0>
 * 			1 : <ligne instruction pour le cas 1>
 * 			...
 * 		}
 * 
 * Pour le intSwitch2 :
 * 		lookupswitch {
 * 			...
 * 		}
 * 
 * Le "tableswitch" c'est lorsque les nombres se suivent et donc la machine virtuelle peut pointer directement sur le bon case.
 * Le "lookupswitch" trie les nombres pour pouvoir utiliser ensuite la dichotomie pour trouver le bon case.
 */

public final class Switches {

	public static String intSwitch(int n) {
		switch (n) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "a lot";
		case 3:
			return "zero";
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
		case 3:
			return "zero";
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

}
