import java.util.*;

class Difference{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till which we have to calculate ");
		int n = sc.nextInt();
		int sum1=0,sum2=0;
		sum1 = n*(n+1)/2;
		sum2 = n*(n+1)*(2*n+1)/6;
		System.out.println((sum1*sum1)-sum2);
	}
}