import java.util.*;

class SetExample{
	public static void main(String[] args) {
		HashSet h = new HashSet();
		h.add("hello");
		h.add(678);
		h.add(3);
		//h.add(new SetExample());
		h.add(new SetExample());
		System.out.println(h);
		h.remove(3);
		System.out.println(h);

		//int ArrayListExample=0;
		//HashSet ArrayListExample = new HashSet();
	}
}