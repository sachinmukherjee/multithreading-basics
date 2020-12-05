package multi_threading_basic;

public class VolatileExample {
	
	public static volatile boolean flag = false;
	
	public static void main(String[] args) {
		
		new Thread(() -> {
				for(int i=0; i<=2000;i++) {
					System.out.println("Value of i from Thread 1 is "+i);
				}
				flag = true;
				System.out.println("Value of Flag is "+flag);
		}).start();
		
		new Thread(() -> {
			int i=1;
			while(!flag) {
				++i;
			}
			System.out.println("Value of i from Thread 2 "+i);
			
		}).start();
		
	}
}


