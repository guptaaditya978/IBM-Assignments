class MyRunnable implements Runnable{
	
	@Override
	public void run(){

		System.out.println(Thread.currentThread().getName()+" running......");
		synchronized(this){
			for(int i = 1;i < 4;i++){
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		}
		System.out.println(Thread.currentThread().getName()+" eniding......");
	}
}
class LocksProgram{
	public static void main(String[] args) {
		MyRunnable m = new MyRunnable();

		Thread a = new Thread(m);
		Thread b = new Thread(m);
		Thread c = new Thread(m);
		a.setName("Aditya");
		b.setName("Peehu");
		c.setName("Raj");
		a.start();
		c.start();
		b.start();
		
	}
}