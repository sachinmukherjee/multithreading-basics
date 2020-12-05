package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callable = () -> {
			Integer sum = 0;
			for(int i=0; i<=10;i++) {
				sum = sum + i;
			}
			return sum;
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Callable<Integer>> taskList = Arrays.asList(callable);
		List<Future<Integer>> results = executor.invokeAll(taskList);
		
		for(Future<Integer> result: results) {
			System.out.println("Result is "+result.get());
		}
	}
}
