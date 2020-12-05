package multi_threading_basic;

public class FastFoodResturantSync {
	
	private String lastClientName;
	private int numberOfBurgers;
	
	public synchronized void buyBurger(String lastClientName) {
		aLongRunningProcess();
		this.lastClientName = lastClientName;
		numberOfBurgers++;
		System.out.println(lastClientName+" bought a burger");
	}
	
	public void aLongRunningProcess() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getLastClientName() {
		return lastClientName;
	}

	public void setLastClientName(String lastClientName) {
		this.lastClientName = lastClientName;
	}

	public int getNumberOfBurgers() {
		return numberOfBurgers;
	}

	public void setNumberOfBurgers(int numberOfBurgers) {
		this.numberOfBurgers = numberOfBurgers;
	}
	
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		FastFoodResturantSync foodResturant = new FastFoodResturantSync();
		
		//Customer 1
		Thread t1  = new Thread(() -> {
			foodResturant.buyBurger("Sachin");
		});
		//Customer 2
		Thread t2  = new Thread(() -> {
			foodResturant.buyBurger("Sumeet");
		});
		//Customer 3
		Thread t3  = new Thread(() -> {
			foodResturant.buyBurger("Bob");
		});
		//Customer 4
		Thread t4  = new Thread(() -> {
			foodResturant.buyBurger("Zack");
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("Total number of burgers sold ==> "+foodResturant.getNumberOfBurgers());
		System.out.println("Last client name is ==> "+foodResturant.getLastClientName());
		System.out.println("Total execution time is "+(System.currentTimeMillis() - startTime) +" msec");
	}
}
