class Human{
	void breathe(){
		System.out.println("Human breathing");
	}
	void eat(){
		System.out.println("Human eating");
	}
	void run(){
		System.out.println("Human running");
	}
	void sleep(){
		System.out.println("Human sleeping");
	}
}
class Aditya extends Human{
	void eat(){
		System.out.println("Shruti is eating");
	}
}
class Raj extends Human{
	
	void run(){
		//super.run();
		System.out.println("Raj is runing..........");
	}
	void swim(){
		System.out.println("Raj is swimming");
	}
}
class Inheritance{
	public static void main(String[] args) {
		
		Aditya a = new Aditya();
		a.eat();
		a.sleep();
		new Raj().run();
		// new Raj().run(5);
		new Raj().swim();
	}
} 