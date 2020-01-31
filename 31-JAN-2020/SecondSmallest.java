import java.util.*;

class SecondSmallest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Length the Array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the Numbers of the Array");
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("The Second Samllest Number is " + getSecondSmallest(arr));
	}
	public static int getSecondSmallest(int [] arr){
		Arrays.sort(arr);
		int a= arr[0];
		int i;
		for( i = 1;i <arr.length;i++){
			if(a != arr[i]){
				break;
			}
		}
		return (arr[i]);
	}
}