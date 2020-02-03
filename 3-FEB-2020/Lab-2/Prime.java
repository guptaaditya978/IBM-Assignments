import java.util.*;
import java.lang.Math;
class Prime{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number range");
		int n = sc.nextInt();
		try{
			if(n<=0){
				throw new NullPointerException();
			}
			else{
				int k = (int) Math.sqrt(n);
				for(int i=2;i<=n;i++){
					if(isPrime(i)){
						System.out.println(i+" ");
					}
				}
			}
		}catch(NullPointerException n){
			System.out.println("Please enter the positive number");
		}
	}
	static boolean  isPrime(int n){
		int k = (int) Math.sqrt(n);
		//System.out.print(k+" ");
		int c=0;
		for(int i=2;i<=k;i++){
			if(n%i == 0){
				c=1;
				break;
			}
		}
		//System.out.print(c+" ");
		return (c == 0 ? true : false);
	}
}