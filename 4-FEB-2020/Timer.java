class Timer extends Thread{
	public static void main(String[] args) {
		Timer t = new Timer();
		System.out.println("Your time starts now");
		t.start();


	}
	@Override
	public void run(){
		int i=0;
		System.out.print(0);
		String str;
		while(true){
			str=Integer.toString(i);
			for(int j=0;j<str.length();j++){
				System.out.print("\b");	
			}
			System.out.print(i);
			try{
				Timer.sleep(1000);
				i++;	
			}
			catch(Exception e){
				System.out.println("Timer is Stopped");
			}
			
		}
	}
}