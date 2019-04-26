package feature.tryResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryResource {

	public static void main(String[] args) throws IOException {

		// Till JDK 1.8
		try (BufferedReader reader_8 = new BufferedReader(new FileReader("src/feature/tryResource/text.txt"))) {
			System.out.println(reader_8.readLine());
		}

		// JDK 1.9 Improvement
		BufferedReader reader_9 = new BufferedReader(new FileReader("src/feature/tryResource/text.txt"));
		try (reader_9) {
			System.out.println(reader_9.readLine());
		}

		// System.out.println(reader_9.ready()); //java.io.IOException: Stream closed
	}
}
