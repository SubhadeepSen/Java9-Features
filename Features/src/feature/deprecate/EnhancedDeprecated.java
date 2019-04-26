package feature.deprecate;

public class EnhancedDeprecated {

	public static void main(String[] args) {
		display("John");
	}

	@Deprecated(forRemoval = true, since = "1.5")
	private static void display(String name) {
		System.out.println("Hi! " + name);
	}

}
