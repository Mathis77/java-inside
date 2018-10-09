package fr.esipe.javainside.labthree;

public class Main {
	public static void main(String[] args) {
		var test = new ExprSwitches();
		System.out.println(test.exprIntSwitch2(10)); // ten
		System.out.println(test.exprStringSwitch("foo")); // zero
		System.out.println(test.exprEnumSwitch(StateEnum.DEBUG)); // zero
	}
}
