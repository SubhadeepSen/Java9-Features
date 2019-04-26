package feature.privateMethod;

public interface PrivateMethod {
	int CODE = 101;
	
	public void display();
	
	public default void show() {
		System.out.println("Default Method");
		System.out.println("Executing private and private-static methods from Default Method");
		executer();
		parser();
	}
	
	public static void printer() {
		System.out.println("Static Method");
		System.out.println("Executing private-static method from Static Method");
		parser();
	}
	
	// private or private static cannot be executed from outside
	// private or private static must be called from default method
	// private static method can also be called form static method
	private void executer() {
		System.out.println("Private Method");
	}
	
	private static void parser() {
		System.out.println("Private Static Method");
	}
}