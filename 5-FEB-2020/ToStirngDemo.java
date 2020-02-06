class ToStirngDemo{
	public static void main(String[] args) {
		Shirt first = new Shirt("boys","blue",34);
		Shirt second = new Shirt("girls","red",34);
		Shirt third = new Shirt("boys","blue",34);
		String s1 = "ASDF";
		String s2 = "ASDF";

		if(s1 === s2){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		
		if(first.equals(third)){
			System.out.println("Same Shirts");
		}
		else{
			System.out.println("Different Shirts");
		}

	}
}
class Shirt{
	private String gender, color;
	private int size;
	Shirt(String g,String c,int s){
		this.gender = g;
		this.color = c;
		this.size = s;
	}
	public String getColor(){
		return this.color;
	}
	public String getGender(){
		return this.gender;
	}
	public Integer getSize(){
		return this.size;
	}

	@Override
	public String toString(){
		return " For:  "+this.getGender()+" , color"+this.getColor()+" , size"+this.getSize();
	}

	@Override
	public boolean equals(Object r){
		if(r instanceof Shirt)
			return this.getSize().equals(((Shirt)r).getSize());
		return false;
	}
}