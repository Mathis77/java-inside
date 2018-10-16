package fr.esipe.javainside.labfour;

public class Main {
	public static void main() {
		var t = new Thread(() -> {
			System.out.println("hello thread");
			System.out.println(Thread.currentThread().getName());
		});
		t.setName("threaddddd");
		t.start();
		System.out.println("hello thread");
		System.out.println(Thread.currentThread().getName());
	}
}
