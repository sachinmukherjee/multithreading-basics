package lambdas;

public class RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			int sum = 0;
			for(int i=0; i<=10;i++) {
				sum = sum + i;
			}
			System.out.println("Runnable Lambda Sum ===> "+sum);
		};
		System.out.println("Start Runnable");
		new Thread(runnable).start();
		System.out.println("Stop Runnable");
		
		
		System.out.println("Start Thread");
		new Thread( () -> {
			int sum = 0;
			for(int i=0; i<=10;i++) {
				sum = sum + i;
			}
			System.out.println("Thread sum is ====> "+sum);
		}).start();;
		System.out.println("Stop Thread");
	}
}
