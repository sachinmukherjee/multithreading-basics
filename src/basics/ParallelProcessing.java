package basics;

public class ParallelProcessing {
	public static void main(String[] args) {
		WorkerParallel1 worker1 = new WorkerParallel1();
		WorkerParallel2 worker2 = new WorkerParallel2();
		worker1.start();
		worker2.start();
	}
}

class WorkerParallel1 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(100);
				System.out.println("Worker 1 is executing task "+1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class WorkerParallel2 extends Thread{
	@Override
	public void run() {
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

