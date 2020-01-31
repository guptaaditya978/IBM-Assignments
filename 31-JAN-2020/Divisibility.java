import java.util.*;

class Divisibility{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number till which we have to calculate ");
		int n = sc.nextInt();
		int sum3=0,sum5=0,sum15=0;
		for(int i=1;i<=n;i++){
			if(i%3==0){
				sum3=sum3+i;
			}
		}
		for(int i=1;i<=n;i++){
			if(i%5==0){
				sum5=sum5+i;
			}
		}
		for(int i=1;i<=n;i++){
			if(i%15==0){
				sum15=sum15+i;
			}
		}
		
		System.out.println(sum3+sum5-sum15);
	}
}