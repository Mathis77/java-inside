package fr.esipe.javainside.labone;

import java.util.stream.LongStream;

public class Sums {
	
	public static long loopSum(long n) {
		long result = 0;
		for(long i = 1 ; i <= n ; i++) {
			result += i;
		}
		return result;
	}
	
	public static long streamSum(long n) {
		return LongStream.range(0, n+1).reduce(0, (a, b) -> a+b);
	}

}
