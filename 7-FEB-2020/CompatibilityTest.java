import java.util.*;
import p2.PreJava;
class CompatibilityTest{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		list.add(4);
		list.add(423);
		list.add(4121);
		// list.add(new String("Sd"));
		new PreJava().doSomething(list);
		System.out.println(list);		
	}
}