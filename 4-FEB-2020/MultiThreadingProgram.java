class MultiThreadingProgram extends Thread{
	public static void main(String[] args) {
		MultiThreadingProgram threadA = new MultiThreadingProgram();
		MultiThreadingProgram threadB = new MultiThreadingProgram();
		MultiThreadingProgram threadC = new MultiThreadingProgram();

		threadB.setName("peehu");
		threadC.setName("raj");
		threadA.setName("aditya");
		threadC.start();
		threadB.start();
		threadA.start();
	}
	@Override
	public void run(){
		for(int i=1;i<4;i++){
			System.out.println(currentThread().getName()+" "+i);
		}
	}
}