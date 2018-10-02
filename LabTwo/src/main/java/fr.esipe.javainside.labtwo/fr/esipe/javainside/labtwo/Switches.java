package fr.esipe.javainside.labtwo;

/*
 * Le code du switch en bytecode indique à la machine virtuelle des "goto" en fonction des "case" du switch.
 * Par exemple : 
 * 		tableswitch {
 * 			0: <ligne instruction pour le cas 0>
 * 			1 : <ligne instruction pour le cas 1>
 * 			...
 * 		}
 */

public final class Switches {
	
	public static String intSwitch(int n) {
		switch(n) {
		case 0: return "zero";
		case 1: return "one";
		case 2: return "a lot";
		default: throw new IllegalArgumentException("You need to specified a positiv number !");
		}
	}
	
	public static String intSwitch2(int n) {
		switch(n) {
		case 0: return "zero";
		case 10: return "ten";
		case 100: return "a lot";
		default: throw new IllegalArgumentException("You need to specified either 0, 10 or 100 !");
		}
	}

}
