import java.util.*;

class Fibonacci{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter the nth Number");
			int n = sc.nextInt();
			System.out.println("Please Select and option");
			System.out.println("Press 1 for Normal Method");
			System.out.println("Press 2 for Recursive Method");
			System.out.println("Press 3 for Exit");
			
			int option = sc.nextInt();
			try{

				if(option ==1 ){
					
					int prev=0,p=1;
					// int temp;
					for(int i=1;i<n;i++){
						p=prev+p;
						prev=p-prev;
					}
					System.out.println(prev);
				}
				else if (option ==2){
					System.out.println(new Fibonacci().fibofun(n));
				}
				else if(option ==3){
					System.out.println("Thank You");
					break;
				}
				else{
					throw new NullPointerException();
				}
			}catch(NullPointerException ae){
				System.out.println("Please put the valid input as given in options");
			}catch(StackOverflowError s){
				System.out.println("Stack is full");
			}
		}
		
	}
	public int fibofun(int n){
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		else{
			return fibofun(n-1) + fibofun(n-2);
		}
	}
}