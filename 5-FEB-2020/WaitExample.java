class WaitExample implements Runnable{
	int total;
	public static void main(String[] args) {
		WaitExample w = new WaitExample();
		Thread t = new Thread(w);
		t.start();
		synchronized(w){
			try{
				w.wait();	
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		System.out.println(w.total);

	}
	public synchronized void run(){

		for(int i=0;i<101;i++){
			total=total+i;
		}		
		try{
			this.notify();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}