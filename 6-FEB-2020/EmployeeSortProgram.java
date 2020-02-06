import java.util.*;
import java.lang.*;
class Employee implements Comparable{
	String name;
	int age;

	Employee(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String getName(){
		return this.name;
	}
	public Integer getAge(){
		return this.age;
	}
	@Override
	public int compareTo(Object ref){
		return this.getAge().compareTo(((Employee)ref).getAge());
	}
	@Override
	public String toString(){
		return this.getName()+" "+this.getAge();
	}
}

class SortByName implements Comparator{

	@Override
	public int compare(Object first,Object second){
		return ((Employee)first).getName().compareTo(((Employee)second).getName());
	}
}
class SortByLastName implements Comparator{
	@Override
	public int compare(Object first,Object second){
		
		String [] arrFirst = ((Employee)first).getName().split(" ");
		String [] arrSecond = ((Employee)second).getName().split(" ");
		String str1="",str2="";
		if(arrFirst.length > 1){
			str1=arrFirst[1];
		}
		if(arrSecond.length > 1){
			str2=arrSecond[1];
		}
		return str1.compareTo(str2);
	}
}
class EmployeeSortProgram{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tempName;
		int tempAge;
		ArrayList list = new ArrayList();
		char ch;
		do{
			System.out.println("Add the details of the Employee");
			System.out.println("PLease enter Employee's name");
			tempName = sc.nextLine();
			System.out.println("PLease enter Employee's Age");
			tempAge = sc.nextInt();
			list.add(new Employee(tempName, tempAge));
			System.out.println("Do you want to add more Employees.(y/n)");
			ch = sc.next().charAt(0);
			sc.nextLine();
		}while(ch=='y');

		System.out.println("Sorted by the age");
		Collections.sort(list);
		System.out.println(list);
		System.out.println("Sorted by the Name");
		Collections.sort(list, new SortByName());
		System.out.println(list);
		System.out.println("Sorted by the LastName");
		Collections.sort(list, new SortByLastName());
		System.out.println(list);
	}
}