import java.util.Scanner;
class CharSearch{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.nextLine();
		//StringBuffer sb = new StringBuffer(str);
		System.out.println("Enter the character you want to search");
		char c = sc.next().charAt(0);
		//System.out.println(c);
		int flag=0;
		for(int i=0; i<str.length();i++)
		{
			if(str.charAt(i) == c){
				flag=1;
				System.out.println("Found the Character");
				break;
			}
		}
		if(flag == 0){
			System.out.println("Not Found");
		}
	}

}