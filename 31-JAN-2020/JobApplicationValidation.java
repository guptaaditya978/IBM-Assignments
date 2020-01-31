import java.util.*;

class JobApplicationValidation{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter The Employee Name");
		String s = sc.nextLine();
		System.out.println(validate(s));

	}
	static Boolean validate(String str){
		if(str.length()-4 >=8){
			if((str.substring(str.length()-4,str.length())).compareTo("_job") == 0){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
}