package feature.diamond.operator;

public class Main {

	public static void main(String[] args) {

		// Here on the right-hand side if we are not mentioning the type within diamond
		// operator, we will get compilation error till JDK 1.8
		// Validator<Integer> numberValidator = new Validator<Integer>() { ... }

		// But from JDK 9 onwards there is no need to mention the type.
		Validator<Integer> numberValidator = new Validator<>() {

			@Override
			public boolean isEven(Integer t) {
				if (t % 2 == 0)
					return true;
				else
					return false;
			}
		};

		System.out.println(numberValidator.isEven(6));
	}

}
