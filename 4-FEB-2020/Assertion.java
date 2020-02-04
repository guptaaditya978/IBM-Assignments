class Assertion{
	public static void main(String[] args) {
		// try{
			new Assertion().cal(false);	
			int p_1;
		// }catch(AssertionError a){
			// System.out.println("Caught");
		// }
		
	}
	public void cal(boolean a){
		//assert(a>0) : a;
		assert(a) : "Shandaar";
		//assert(a<0): a;
		// System.out.println("Nice...");
	}
}