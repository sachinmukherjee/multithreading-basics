package multi_threading_basic;

public class CourseNotifier {
	
	public static void main(String[] args) {
		final Course course = new Course("Java Programming");
		
		//create two threads for students waiting for notification
		//one for the instructor who is writing the course
		
		new Thread(() -> {
			synchronized (course) {
				System.out.println(Thread.currentThread().getName()+" is waiting for the course: "+course.getTitle());
				try {
					course.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" the course: "+course.getTitle()+" is now completed");
			}
		},"Student A").start();
		
		
		new Thread( () -> {
			synchronized (course) {
				System.out.println(Thread.currentThread().getName()+" is waiting for the course: "+course.getTitle());
				try {
					course.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" the course: "+course.getTitle()+" is now completed");
			}
		},"Student B").start();
		
		new Thread( () -> {
			synchronized (course) {
				System.out.println(Thread.currentThread().getName()+" is starting a new course");
				try {
					Thread.sleep(5000);
					course.notifyAll();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		},"Instructor").start();
	}
}

class Course{
	private String title;
	private boolean completed;
	
	public Course(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}

 
