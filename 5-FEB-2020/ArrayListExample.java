import java.util.*;

class ArrayListExample{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("hello");
		list.add(678);
		list.addFirst(4);
		list.add(3);
		list.replace(2,5);
		list.add(new ArrayListExample());
		//System.out.println(list);	
		//list.remove(3);
		System.out.println(list);
	}
}