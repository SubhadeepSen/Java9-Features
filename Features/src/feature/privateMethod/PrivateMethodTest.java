package feature.privateMethod;

public class PrivateMethodTest implements PrivateMethod{

	public static void main(String[] args) {
		PrivateMethodTest test = new PrivateMethodTest();
		test.display();
		test.show();
		PrivateMethod.printer();
	}

	@Override
	public void display() {
		System.out.println("Abstract Method");
		
	}

}
