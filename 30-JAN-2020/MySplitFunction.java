import java.util.Scanner;
import java.util.ArrayList;
class MySplitFunction{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.nextLine();
		System.out.println("Enter the expression");
		String e = sc.next();
		String[] array = new MySplitFunction().mySplit(str,e);
		for(String a:array){
			System.out.println(a+ " ");
		}
	}
	String[] mySplit(String s,String exp){
		
		int l = exp.length();
		String str = s; 
		int index=1;
		String s1;
		ArrayList<String> a = new ArrayList<String>();
		
		//String [] arr = new String[100];
		int arrcount = 0;
		//int [] a = new int[100];
		index = s.indexOf(exp);
		while(index != -1 ){
			
				if(index==0){
					s = s.substring(index+l,s.length());
					index = s.indexOf(exp);
				}
				else{
					s1 = s.substring(0,index);
				// arr[arrcount] = s1;
				//System.out.println(s1);
					a.add(s1);
					s = s.substring(index+l,s.length());
					index = s.indexOf(exp);
				}
				
				//System.out.println(s);
				//arrcount++;
		}
		a.add(s);
		//System.out.println(a);
		//System.out.println(a.size());
		int k = a.size();
		String [] arr = new String[k];
		for(int i=0;i<k;i++){
			arr[i] = a.get(i);
		}
		return arr;
	}

}