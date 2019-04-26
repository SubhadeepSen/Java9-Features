package feature.factoryMethod;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FactoryMethod {

	public static void main(String[] args) {
		// Creates immutable list
		List<String> letters = Arrays.asList("A", "B", "C", "D", "E");
		// letters.add("F"); //UnsupportedOperationException

		// Creates immutable list
		Collections.unmodifiableList(letters);
		// letters.add("F"); //UnsupportedOperationException
		System.out.println(letters);

		
		//Java 9 Onwards
		List<String> immutableLetters = List.of("A", "B", "C", "D", "E");
		// letters.add("F"); //UnsupportedOperationException
		System.out.println(immutableLetters);
		
		Map<String, String> emptyImmutableMap = Map.of();
		System.out.println(emptyImmutableMap);
	}
}
