package feature.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIImprovements {

	public static void main(String[] args) {

		// takeWhile() method takes all the values until the predicate returns false
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).takeWhile(n -> n != 5).forEach(System.out::print);

		System.out.println();

		// dropWhile() method throws away all the values at the start until the predicate
		// returns true
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).dropWhile(n -> n <= 5).forEach(System.out::print);

		System.out.println();

		// iterate() method now has hasNext predicate as parameter which stops the loop
		// once hasNext predicate returns false
		IntStream.iterate(1, x -> x < 10, x -> x + 2).forEach(System.out::println);

		// ofNullable() method is introduced to prevent NullPointerExceptions and to avoid
		// null checks for streams. This method returns a sequential Stream containing
		// single element, if non-null, otherwise returns an empty Stream
		long count = Stream.ofNullable("Hello").count();
		System.out.println("Count: " + count);

		count = Stream.ofNullable(null).count();
		System.out.println("Count: " + count);
	}
}
