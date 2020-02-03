import java.util.*;
class TrafficLight{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			
			System.out.println("Please Select and option");
			System.out.println("Press 1 for Red Light");
			System.out.println("Press 2 for Yellow Light");
			System.out.println("Press 3 for Green Light");
			System.out.println("Press 4 for Exit the Menu");

			try{
				int k = sc.nextInt();
				if(k>0 && k<=4){
					if(k==1){
						System.out.println("Stop");
					}
					else if(k==2){
						System.out.println("Steady");
					}
					else if(k==3){
						System.out.println("Go");
					}
					else{
						System.out.println("Thank You");
						break;
					}
				}
				else{
					throw new NullPointerException();
				}
			}catch(ArithmeticException ae){
				System.out.println("Please put the valid input as given in options");
				System.out.println();
			}catch(NullPointerException n){
				System.out.println("Please put the valid input as given in options from 0-4");
				s
			}

		}
	}
}