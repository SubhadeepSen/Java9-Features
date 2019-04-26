package feature.process.api;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class ProcessAPI {

	public static void main(String[] args) throws InterruptedException, IOException {
		printProcessInfo(ProcessHandle.current());
		Process p = new ProcessBuilder("notepad.exe", "C:\\Users\\Subhadeep Sen\\Desktop\\textFile.txt").start();
		printProcessInfo(p.toHandle());
		p.waitFor();
		printProcessInfo(p.toHandle());
	}

	static void printProcessInfo(ProcessHandle ph) {
		System.out.println("PROCESS INFORMATION");
		System.out.println("===================");
		System.out.println("Process id: " + ph.pid());
		ProcessHandle.Info info = ph.info();
		System.out.println("Command: " + info.command().orElse("No Command"));
		String[] args = info.arguments().orElse(new String[] {});
		System.out.println("Arguments:");

		for (String arg : args)
			System.out.println("  " + arg);

		System.out.println("Command line: " + info.commandLine().orElse("No Argument"));
		System.out.println("Start time: " + info.startInstant().orElse(Instant.now()).toString());
		System.out.println("Run time duration: " + info.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis());
		System.out.println("Owner: " + info.user().orElse("System"));
		System.out.println();
	}
}
