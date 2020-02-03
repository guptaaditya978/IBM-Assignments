class MyException extends Exception{

	MyException(){

	}
	boolean stringNoMatchException(String str1, String str2){

		if(str1.compareTo(str2)==0){
		return true;
		}
		else{
			return false;
		}
	}
}

class People{

	void work() throws MyException{
			throw new MyException();
	}
}

class CustomisedException{
	public static void main(String[] args) {
		new CustomisedException().whatsup("hello","Hello");
	}
	public void whatsup(String s,String r){
		try{
			new People().work(); 	
		}catch(MyException m){

			// String a ="Hello";
			// String b ="hello";

			System.out.println(m.stringNoMatchException(s,r.toLowerCase()));
		}
	}
}