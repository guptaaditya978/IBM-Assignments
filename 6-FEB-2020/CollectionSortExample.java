import java.util.*;

class Student implements Comparable{
	String name;
	int marks;

	Student(String name,int marks){
		this.name = name;
		this.marks = marks;
	}
	public String getName(){
		return this.name;
	}
	public Integer getMarks(){
		return this.marks;
	}

	@Override
	public int compareTo(Object o){
		return ((Student)o).getMarks().compareTo(this.getMarks());
	}

	@Override
	public String toString(){
		return this.getName()+" "+this.getMarks();
	}
}
class CollectionSortExample{
	public static void main(String[] args) {
		List a = new ArrayList();
		a.add(new Student("Aditya",145));
		a.add(new Student("Sam",1127));
		a.add(new Student("Zaheer",16127));
		a.add(new Student("Peehu",17));
		
		Collections.sort(a);
		System.out.println((a));
	}
}