package fr.esipe.javainside.labone;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {

	private final static long NUMBER_OF_ITERATIONS = 10_000_000;

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Main.class.getSimpleName()).forks(1).build();

		new Runner(opt).run();
	}

	@Benchmark
	@BenchmarkMode(Mode.SampleTime)
	public void loopSumPerf() {
		Sums.loopSum(NUMBER_OF_ITERATIONS);
	}

//	@Benchmark
//	@BenchmarkMode(Mode.SampleTime)
//	public void streamSumPerf() {
//		Sums.streamSum(NUMBER_OF_ITERATIONS);
//	}

}
