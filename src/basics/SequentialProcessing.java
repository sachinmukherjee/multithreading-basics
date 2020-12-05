package basics;
/*
 * When Worker 1 sleeps whole process sleeps
 */
public class SequentialProcessing {
	
	public static void main(String[] args) {
		Worker1 worker1 = new Worker1();
		Worker2 worker2 = new Worker2();
		worker1.executeWork();
		worker2.executeWork();
	}
}

class Worker1{
	public void executeWork() {
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(100);
				System.out.println("Worker 1 is executing task "+i);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

class Worker2{
	public void executeWork() {
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(100);
				System.out.println("Worker 2 is executing task "+i);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
