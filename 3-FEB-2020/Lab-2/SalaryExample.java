import java.util.*;
import p1.EmployeeException;

class SalaryExample{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("Enter 1 for checking salary and 2 for exit");
			int k = sc.nextInt();
			if(k==1){
				System.out.println("Enter Your Salary");
				int n1 = sc.nextInt();
				try{
					if(n1 <= 3000){
						throw new EmployeeException();
					}
					System.out.println("Your are making money");
				}catch(EmployeeException a){
					a.salaryCheck();
				}
			}
			else{
				break;
			}
		}
	}
}