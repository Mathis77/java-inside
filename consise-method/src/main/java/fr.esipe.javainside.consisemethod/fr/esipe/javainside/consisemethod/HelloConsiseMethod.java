package fr.esipe.javainside.consisemethod;

class HelloConsiseMethod {

	public static String getNameDay(int d) -> switch(d){
		case 1 -> "MONDAY";
		case 2 -> "TUESDAY";
		case 3 -> "WEDNESDAY";
		case 4 -> "THURSDAY";
		case 5 -> "FRIDAY";
		case 6 -> "SATURDAY";
		case 7 -> "SUNDAY";
		default -> throw new IllegalArgumentException("You need to specify a number between 1 and 7 !");
	};

	public static String toUpperCase(String arg) = String::toUpperCase;

	public static int parseInt(String number) = Integer::parseInt;

	public static void display(String msg) = System.out::println;

}