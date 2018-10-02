package fr.esipe.javainside.labtwo;

public final class Switches {
	
	public static String intSwitch(int n) {
		switch(n) {
		case 0: return "zero";
		case 1: return "one";
		case 2: return "a lot";
		default: throw new IllegalArgumentException("You need to specified a positiv number !");
		}
	}

}
