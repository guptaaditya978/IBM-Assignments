class Cal{
	void add(int... values){
		int total = 0;
		if(values.length >1)
		{
			for(int v : values){
				total += v;
			}
		}
		System.out.println("total is : "+ total);
	}
	void add (int a, int b){
				System.out.println("total is "+(a+b));
	}
}

class VarArgs{
	public static void main(String[] args) {
		// new Cal().add(35,78,67);
		// new Cal().add();
		// new Cal().add(12,13);
		// new Cal().add(12,13,25,50);
		// new Cal().add(12);
		new Cal().add(12,13);
	}
}