
class Work{
	void letitgo(){
		Thread t = new Thread(new Runnable(){
				@Override
				public void run(){
				System.out.println("thread is runnning");
			}
		});
		t.start();
		}

	// class MyTask implements Runnable{
	// 	@Override
	// 	public void run(){
	// 	System.out.println("running");
	// 	}
	// }
}
class MyThread{
	public static void main(String[] args) {
		
		new Work().letitgo();
	}
}
