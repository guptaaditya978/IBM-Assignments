class GcdDemo{
	static GcdDemo t;
	int var;
	public static void main(String[] args) {
		GcdDemo a = new GcdDemo();
		GcdDemo b = new GcdDemo();
		GcdDemo c = new GcdDemo();
		a.var=3;
		a.t = b;
		b.t = c;
		c.t = a;
		a=b=c=null;

				System.out.println(t.var);
			    System.out.println(GcdDemo.t.t.var);
	}
}