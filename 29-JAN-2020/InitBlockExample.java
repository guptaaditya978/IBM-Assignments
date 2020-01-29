class SuperClass{
	SuperClass(){
		System.out.println("Inside SuperClass Constructor");
	}
	static{
		System.out.println("Inside static InitBlock-1");
	}
}
class InitBlockExample extends SuperClass{
	
	{
		System.out.println("Inside InitBlock");
	}

	InitBlockExample(){
		System.out.println("Inside Constructor");
	}
	public static void main(String[] args) {
		
		InitBlockExample a = new InitBlockExample();

	}

	static{
		System.out.println("Inside static InitBlock-2");
	}
}