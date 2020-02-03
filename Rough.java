class SuperClass{
	void add(int a){
		System.out.println(a+1);
	}
}
class SubClass extends SuperClass{
	void add(){
		System.out.println("No arguments wala");
	}
}
class Rough{
	public static void main(String[] args) {
		SuperClass a = new SubClass();
		SubClass b = new SubClass();
		// a.add();
		a.add();
	}

}