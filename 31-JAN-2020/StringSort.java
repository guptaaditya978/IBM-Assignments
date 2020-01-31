import java.util.*;
class StringSort{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the String Array");
		int n = sc.nextInt();
		String [] arr = new String[n];
		System.out.println("Enter the String Elements");
		for(int i=0;i<n;i++){
			arr[i] = sc.next().toLowerCase();
		}
		Arrays.sort(arr);
		if(n%2==0){
			n=n/2;
		}
		else{
			n = (n/2)+1;
		}
		System.out.println(n);
		for(int i=0;i<n;i++){
			arr[i] = arr[i].toUpperCase();
		}
		System.out.println(Arrays.asList(arr));
	}
}