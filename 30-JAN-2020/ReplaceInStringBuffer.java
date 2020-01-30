import java.util.Scanner;
class ReplaceInStringBuffer{
	public static void main(String[] args) {
		//System.out.println(sb.length());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String s = sc.nextLine();
		StringBuffer sb = new StringBuffer(s);
		// System.out.println("Enter the  starting position you want to replace");
		// int start = sc.nextInt();
		// System.out.println("Enter the  ending position you want to replace");
		// int end = sc.nextInt();
		System.out.println("Enter the string you want to replace it with");
		String str = sc.next();
		sb.append(str,0,5);
		System.out.println(sb);
	}
}