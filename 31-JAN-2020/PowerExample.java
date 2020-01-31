import java.util.*;
class PowerExample{
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number");
	int n = sc.nextInt();
	int d=0;
	while(n!=0 && n>=2){
		if(n%2!=0){
			d=1;
			System.out.println("Not a power of two");
			break;
		}
		n=n/2;
	}
	if(d==0){
		System.out.println("Number is the power of two");
	}	
	}
	
}