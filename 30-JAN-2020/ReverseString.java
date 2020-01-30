import java.util.Scanner;
class ReverseString{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.next();
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}

}