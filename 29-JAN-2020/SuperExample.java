class SuperSuper{
	SuperSuper(){
		System.out.println("Insisde Super super constructor");
	}
}
class Super extends SuperSuper{
	Super(int k){
		System.out.println("Inside Super constructor with int");
	}
	Super(long t){
		System.out.println("Insisde Super Constructor with long");
	}
	Super(){
		System.out.println("Inside Super constructor");
	}
}
class Sub extends Super{
	Sub(){
		super();
		System.out.println("Inside Sub class constructor");
	}
	Sub(int k){
		super(2147483648l);
		System.out.println("wewewewew");
	}
}
class SuperExample{
	public static void main(String[] args) {
		//Sub s = new Sub();
		Sub s1 = new Sub(5);
		
	}
}