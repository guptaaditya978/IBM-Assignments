import java.util.*;

class HashMapExample{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		// map.put(Object r,Object s);
		map.put("Aditya", 670);
		map.put("Kapil", 234);
		map.put(new HashMapExample(),"abc");
		map.put("Vasudev", 124.0239320);
		map.put("sad", new HashMapExample());

		System.out.println("Value is "+map.get("Vasudev"));

		Set set =map.entrySet();

		for(Object obj : set){
			Map.Entry ref = (Map.Entry)obj;
			System.out.print(ref.getKey());
			System.out.println(":"+ref.getValue());
		}
		System.out.println(map.size());
		// map.put("Vasudev", 124.0239320);
		// System.out.println(map.size());
		Double currBalance = (Double) map.get("Vasudev");

		map.put("Vasudev",1000+currBalance);
		System.out.println(map.size());


	}
}