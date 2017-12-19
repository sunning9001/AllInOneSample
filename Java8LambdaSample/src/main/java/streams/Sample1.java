package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Sample1 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(new Integer(4));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(1));

		Stream<Integer> streams = list.stream();

		// Collections in Java 8 are extended so you can simply create streams
		// either by calling Collection.stream() or Collection.parallelStream().

		streams.filter(t -> t.intValue() % 2 == 0).map(t-> t + 1).forEach(System.out::println);
		
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		
		long t0 = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
	}
}
