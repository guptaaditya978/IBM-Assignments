import java.util.*;

class TreeMapExample{
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		// map.put(Object r,Object s);
		a.add("Aditya");
		a.add("Kapil");
		a.add("neraj");
		a.add("Vasu");
		a.add("sad");

		//System.out.println("Value is "+map.get("Vasudev"));

		// Set set =map.entrySet();

		// for(Object obj : set){
		// 	Map.Entry ref = (Map.Entry)obj;
		// 	System.out.print(ref.getKey());
		// 	System.out.println(":"+ref.getValue());
		// }
		// System.out.println(map.size());
		// // map.put("Vasudev", 124.0239320);
		// // System.out.println(map.size());
		// Double currBalance = (Double) map.get("Vasudev");

		// map.put("Vasudev",1000+currBalance);
		// System.out.println(map.size());
		System.out.println(a.get("Vasu"));

	}
}