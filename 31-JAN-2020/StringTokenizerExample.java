import java.util.*;
class StringTokenizerExample{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the set of numbers");
		StringTokenizer s = new StringTokenizer(sc.nextLine());
		int sum = 0;
		while(s.hasMoreTokens()){
			int k = Integer.parseInt(s.nextToken());
			System.out.println(k);
			sum = sum + k;
			//s.nextToken();
		}
		System.out.println(sum);
	}
}