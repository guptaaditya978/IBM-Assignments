import java.util.*;

class ArraysSorting{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Length the Array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the Numbers of the Array");
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		int [] result = getSorted(arr);
		for(int k : result){
			System.out.print(k+ " ");
		}
	}
	public static int[] getSorted(int [] arr){
		StringBuffer sb = new StringBuffer();
		int [] a = new int[arr.length];
		for(int i = 0;i <arr.length;i++){
			sb.append(arr[i]);
			sb.reverse();
			a[i] = Integer.parseInt(sb.toString());
			sb.delete(0,sb.length());
		}
		Arrays.sort(a);
		return (a);
	}
}