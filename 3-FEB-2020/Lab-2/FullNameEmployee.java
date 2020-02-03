import java.util.*;
class UserDefinedException extends Exception{

	UserDefinedException(){

	}
	boolean nameFaultException(String str1, String str2){

		if((str1.compareTo("")!=0)&&(str2.compareTo("")!=0)){
		return true;
		}
		else{
			return false;
		}
	}
}

class Employee{

	void work(String s,String r) {
			try{
			throw new UserDefinedException(); 	
		}catch(UserDefinedException m){

			// String a ="Hello";
			// String b ="hello";

			if(!(m.nameFaultException(s,r.toLowerCase()))){
				System.out.println("PLease check your Firstname or Lastname.It can't be blank.");
			}
		}
	}
}

class FullNameEmployee{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the First Name");
	String f = sc.nextLine();
	System.out.println("Enter the Middle Name");
	String m = sc.nextLine();
	System.out.println("Enter the Last Name");
	String l = sc.nextLine();
	Employee e = new Employee();
	e.work(f,l);


	}
}