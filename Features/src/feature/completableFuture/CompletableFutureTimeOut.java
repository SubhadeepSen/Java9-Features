package feature.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
Till JDK, we had a problem in CompletableFuture that it did not have time-out option. 
To remove this drawback, the time-out option has been added in JDK 9 to improve the performance further.
 */

public class CompletableFutureTimeOut {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		
		//completeOnTimeout added in java 9
		//cf.completeOnTimeout(500, 3, TimeUnit.SECONDS);
		future.orTimeout(2, TimeUnit.SECONDS); // setting time out for this completion stage.
		
		process(future);
		
		//forcing thread to sleep for so that the completion stage throws time out exception. 
		//Changing it less than 2000 will not throw any exception and will successfully complete the stage.
		sleep(3000);  
		
		future.complete(5);
		
		System.out.println("Output: " + future.get(2, TimeUnit.SECONDS));
	}

	private static CompletableFuture<Integer> process(CompletableFuture<Integer> future) {
		return future.thenApply(data -> data + 5)
					 .thenApply(data -> data * 2)
					 .thenApply(data -> data / 10)
					 .exceptionally(throwable -> handleException(throwable))
					 .toCompletableFuture();
	}

	private static int handleException(Throwable throwable) {
		System.out.println(throwable.getMessage());
		return 400;
	}
	
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
