package fr.esipe.javainside.labfour;

public class Example1 {

	public static void main() {
		ContinuationScope scope = new ContinuationScope("hello1");
		Continuation continuation = new Continuation(scope, () -> {
			// Continuation.yield(scope);
			System.out.println("hello continuation");
			System.out.println(Continuation.getCurrentContinuation(scope));
		});
		continuation.run();
		System.out.println("hello main");
		System.out.println(Continuation.getCurrentContinuation(scope));
	}

}
