package multi_threading_basic;

import java.util.stream.IntStream;

public class RunnableExample  {
	public static int[] examples = IntStream.rangeClosed(0, 5000).toArray();
	public static int sum = 0;
	public static int totalSum = IntStream.range(0, 5000).sum(); 
	public static void main(String[] args) throws InterruptedException {
		
		Worker1 worker1 = new Worker1(examples);
		Worker2 worker2 = new Worker2(examples);
		
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println("Sum of Numbers using Runnable is ===> "+sum);
		System.out.println("Sum of Numbers using IntStream is ===> "+totalSum);
		 
	}
	
	public static void sum(int toAdd) {
		sum  = sum + toAdd;
	}
}

class Worker1 implements Runnable{
	
	int array[];
	int sum = 0;
	public Worker1(int[] array) {
		this.array = array;
	}
	@Override
	public void run() {
		for(int i=0;i<array.length/2;i++) {
			sum = sum + array[i];
		}
		RunnableExample.sum(sum);
	}
	
}

class Worker2 implements Runnable{
	
	int array[];
	int sum = 0;
	
	public Worker2(int array[]) {
		this.array = array;
	}
	
	@Override
	public void run() {
		for(int i=array.length/2; i<array.length;i++) {
			sum = sum + array[i];
		}
		RunnableExample.sum(sum);
	}
}
