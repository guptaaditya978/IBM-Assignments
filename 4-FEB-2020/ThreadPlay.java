class Thread1 extends Thread{
	
	@Override
	public void run(){
		System.out.println("Hello Ji this is Thread 1");
	}
}
class Thread2 extends Thread{
	
	@Override
	public void run() throws NullPointerException{


		try{
			Thread2.sleep(3000);
		}catch(Exception e){
			System.out.println("Exception caught");
		}
		System.out.println("Hello Ji this is Thread 2");
	}
}
class Thread3 extends Thread{
	
	@Override
	public void run(){
		System.out.println("Hello Ji this is Thread 3");
	}
}

class ThreadPlay extends Thread{
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.setName("Thread1");
		Thread2 t2 = new Thread2();
		t2.setName("Thread2");
		Thread3 t3 = new Thread3();
		t3.setName("Thread3");	

		t1.start();
		t2.start();
		t3.start();

		System.out.println(ThreadPlay.currentThread().getName()+" "+" is running");

	}
}