abstract class Human{

	Human(){
		System.out.println("Human's Constructor");
	}
	void breathe(){
		System.out.println("Generic Breathing");
	}
	abstract void eat();
	abstract void run();
}
class Aditya extends Human{
	@Override
	void breathe(){
		System.out.println("Aditya's Breathing");
	}
	@Override
	void eat(){
		System.out.println("Aditya's Eating");
	}

	@Override
	void run(){
		System.out.println("Aditya's Running");
		//super.breathe();
		
	}
}
abstract class Raj extends Human{
	@Override
	void eat(){
		System.out.println("Raj's Eating");
	}
	
	// Raj(){

	// 	System.out.println("Raj's Constructor");
	// }
}
class B extends Raj{
	void swim(){
		System.out.println("B is Swimming");
	}
	@Override
	void eat(){
		System.out.println("B's Eating");
	}

	@Override
	void run(){
		System.out.println("B's Running");
		//super.breathe();
		
	}


}
class AbstractExample{
	public static void main(String[] args) {
		// Aditya a = new Aditya();
		// a.eat();
		// a.run();
		B b = new B();
		b.swim();

		//Raj r = new Raj();
		// r.eat();

	}
}