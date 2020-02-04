class ThreadProgram extends Thread{
	public static void main(String[] args) {
		ThreadProgram theThread = new ThreadProgram();

		theThread.start();



		
		System.out.println(Thread.currentThread().getName());

	}
	@Override
	public void run(){
		// System.out.println("Thread");
		System.out.println(Thread.currentThread().getName());
	}
}