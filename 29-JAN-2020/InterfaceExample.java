interface Human{

	int var=10;

	void breathe();// public abstract
	void eat();
	void run();
	static void talk(){
		System.out.println("Start talking guys!!");
	}
}
interface Emp extends Human{

	void work();
	void run();

}
class Aditya implements Human{

	public void talk(){
		System.out.println("Aditya is talking");
	}
	public void breathe(){
		System.out.println("Aditya is breathing");
		// this.var=19;
		System.out.println(Human.var);
	}
	public void eat(){
		System.out.println("Aditya is eating");
	}
	public void run(){
		System.out.println("Aditya is running");
	}
}
class Raj extends Aditya implements Emp{

	public void breathe(){
		System.out.println("Raj is breathing");
		// this.var=19;
		System.out.println(Human.var);
	}
	public void eat(){
		System.out.println("Raj is eating");
	}
	public void run(){
		System.out.println("Raj is running");
	}
	public void work(){
		System.out.println("Raj goes to work");
	}
	public void talk(){
		System.out.println("Raj is talking");
	}
}
class InterfaceExample{
	public static void main(String[] args) {
	
		Aditya a = new Aditya();
		a.breathe();
		a.run();
		a.talk();

		Raj r = new Raj();
		r.work();
		r.eat();
		r.breathe();
		r.run();
		r.talk();

	}
}
