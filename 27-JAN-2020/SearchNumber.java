import java.util.Scanner;

class SearchNumber{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int []arr = new int[10];
		int val;
		for(val = 0;val < arr.length;val++)
		{
			arr[val] = val;
		}
		System.out.println("Enter The Number You Are Searching For ");
		int num = scan.nextInt();
		for(val = 0;val < arr.length;val++)
		{
			if(arr[val] == num)
			{
				System.out.println("Number is present");
				break;
			}
		}
		if(val == arr.length)
		{
			System.out.println("Number is absent");
		}
	}
}