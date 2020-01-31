import java.util.*;
class ArmstrongNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		int num = sc.nextInt();
		int total=0;
		int k = num;
		while(num>0){
			total = total + cube(num%10);
			//System.out.println(total);
			num=num/10;
		}
		System.out.println(total);
		// if(total == k){
		// 	System.out.println("Yes its an armstrong Number");
		// }
		// else{
		// 	System.out.println("No its not an armstrong Number");
		// }
	}
	public static int cube(int x){
		return x*x*x;
	}
}