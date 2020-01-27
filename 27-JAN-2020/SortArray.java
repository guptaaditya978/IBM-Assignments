import java.util.Scanner;

class SortArray{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int []arr = new int[5];
		int []arr1 = new int[5];
		int val;
		System.out.println("Enter The Numbers Of Array");
		for(val = 0;val < arr.length; val++){
			arr[val] = scan.nextInt();
		}
		for(int i = 0;i < arr.length; i++){
			for(int j = i+1; j<arr.length; j++ ){
				if(arr[j]<arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					//System.out.println("hello");
				}
			}
		}
		System.out.println("Array After Selection Sort");
		for(val = 0;val < arr.length; val++){
			System.out.print(arr[val]+" ");
		}
		System.out.println("Enter The Numbers Of Array");
		for(val = 0;val < arr1.length; val++){
			arr1[val] = scan.nextInt();
		}
		System.out.println();
		for(int i = 0;i < arr1.length; i++){
			for(int j = 0;j < arr1.length-1; j++){
				if(arr1[j]>arr1[j+1]){
					int temp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = temp;					
				}
			}
		}
		System.out.println("Array After Bubble Sort");
		for(val = 0;val < arr1.length; val++){
			System.out.print(arr1[val]+" ");
		}
	}
}

sdaf