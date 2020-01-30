import java.util.Scanner;
class Pallindrome{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.next();
		StringBuffer sb = new StringBuffer(str);
		StringBuffer sbrev=new StringBuffer(sb);
		// System.out.println(sbrev);
		// sb.reverse();
		// System.out.println(sb);
		// System.out.println(sbrev);
		
		if((sbrev.compareTo(sb.reverse()) == 0)){
			System.out.println("Pallindrome");
		}
		else{
			System.out.println("Not a Pallindrome");
		}
	}

}