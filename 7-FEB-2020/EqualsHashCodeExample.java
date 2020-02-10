import java.util.*;
class EqualsHashCodeExample{
	public static void main(String[] args) {
			Map m = new HashMap();

			Graduate first = new Graduate("Kamal",234);
			Graduate second = new Graduate("Sana",145);
			Graduate third = new Graduate("Bhaisahab",69);
			m.put(first,"IT");
			m.put(second,"CSE");
			m.put(third,"IT");
			System.out.println(m);
			m.put(new Graduate("Sana",145),"CSE");
			System.out.println(m);
			
	}
}
class Graduate{
	String name;
	Integer id;

	Graduate(String name,Integer id){
		this.name = name;
		this.id = id;
	}

	public String getName(){
		return this.name;
	}
	public Integer getId(){
		return this.id;
	}

	@Override
	public int hashCode(){
		return this.id;
	}

	@Override
	public boolean equals(Object o){
		return this.getId().equals(((Graduate)o).getId());
	}

	@Override
	public String toString(){
		return this.getName()+" "+this.getId();
	}

}