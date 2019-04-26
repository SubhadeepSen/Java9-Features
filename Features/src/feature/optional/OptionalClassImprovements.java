package feature.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalClassImprovements {
	
	public static void main(String[] args) {

		List<Optional<Integer>> list = Arrays.asList(Optional.empty(), Optional.of(1), Optional.empty(), Optional.of(2),
				Optional.empty(), Optional.of(3));

		// JDK 1.8, filtering the list based on non-empty values
		List<Integer> filteredList = list.stream().flatMap(op -> op.isPresent() ? Stream.of(op.get()) : Stream.empty())
				.collect(Collectors.toList());
		System.out.println(filteredList);

		// stream() in Optional class
		List<Integer> filteredListJava9 = list.stream().flatMap(Optional::stream).collect(Collectors.toList());
		System.out.println(filteredListJava9);

		// ifPresentOrElse
		Optional<Integer> op = Optional.ofNullable(5);
		op.ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("Empty"));

		op = Optional.ofNullable(null);
		op.ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("Empty"));

		// or
		Optional<String> name = Optional.of("Subhadeep");
		Supplier<Optional<String>> supOp = () -> Optional.of("No Name");
		Optional<String> value = name.or(supOp);
		System.out.println(value);

		name = Optional.empty();
		System.out.println(name.or(supOp));
	}
}


