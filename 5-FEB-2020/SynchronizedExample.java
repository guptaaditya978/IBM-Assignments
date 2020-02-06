class SynchronizedExample implements Runnable{
	private	 Account sharedAccount = new Account();


	public static void main(String[] args) {
		
		SynchronizedExample mr = new SynchronizedExample();
		Thread a = new Thread(mr);
		Thread b = new Thread(mr);

		a.setName("Aditya");
		b.setName("Peehu");

		a.start();
		b.start();
	}

	@Override
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+" "+"is using ATM");
			if(i%2==0){
				makeWithdraw(10);
			}else{
				makeDeposit(10);
			}	
		}
	}
	public synchronized void makeWithdraw(int amount){
		if(sharedAccount.getBalance() >= amount){
			System.out.println(Thread.currentThread().getName()+" is withdrawing the money");
			try{
				Thread.sleep(4000);
			}catch(Exception e){
				System.out.println("Caught");
			}
			sharedAccount.withdraw(amount);
			System.out.println(" Now Balance is "+sharedAccount.getBalance());
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				System.out.println("Caught");
			}
		}
		else{
			System.out.println("Sorry there is not enough money to withdraw "+sharedAccount.getBalance());
		}
	}
	public synchronized void makeDeposit(int amount){
		System.out.println(Thread.currentThread().getName()+" is depositing the money");
			try{
				Thread.sleep(4000);
			}catch(Exception e){
				System.out.println("Caught");
			}
			sharedAccount.deposit(amount);
			System.out.println(" Now Balance is "+sharedAccount.getBalance());
			try{
				Thread.sleep(3000);
			}catch(Exception e){
				System.out.println("Caught");
			}
	}
}
class Account{
	private int balance;
	Account(){
		this.balance = 50;
	}
	void withdraw(int amt){
		this.balance = this.balance - amt;
	}
	void deposit(int amt){
		this.balance = this.balance + amt;
	}
	int getBalance(){
		return this.balance;
	}
}
