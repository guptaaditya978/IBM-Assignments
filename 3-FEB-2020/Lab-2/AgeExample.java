import java.util.*;

class AgeException extends Exception{
	
	public void underAge(){
		System.out.println("Your age is below 15");
	}
}
class AgeExample{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("Enter 1 for checking age and 2 for exit");
			int k = sc.nextInt();
			if(k==1){
				System.out.println("Enter Your Age");
				int n = sc.nextInt();
				try{
					if(n <= 15){
						throw new AgeException();
					}
					System.out.println("Your Age is Fine");
				}catch(AgeException a){
					a.underAge();
				}
			}
			else{
				break;
			}
		}
	}
}