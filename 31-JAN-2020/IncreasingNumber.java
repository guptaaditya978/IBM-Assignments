import java.util.*;
class IncreasingNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		String s = sc.nextLine().toLowerCase().replaceAll(" ","");
		String [] arr = s.split("");
		int l=0;
		for(int i=0;i<arr.length;i++){
			int k=0;
			for(int j=i+1;j<arr.length;j++){
				if(arr[i].compareTo(arr[j]) > 0){
					k=1;
					break;
				}
			}
			if(k!=0){
				System.out.println("Decreasing Number");
				l=1;
				break;
			}
		}
		if(l ==0 ){
			System.out.println("IncreasingNumber");
		}
	}
}