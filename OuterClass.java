class Outer{
	
	private boolean b;


	void met(){     
		int var = 78;                 //Only final and effectively final in local inner class
		class Inner{
			boolean b=true;
			void work(){
				boolean b=false;
				System.out.println("Local"+b);
				System.out.println("Inner"+this.b);
				System.out.println("Outer"+Outer.this.b);
			}
		}
		// var++;
		Inner in = new Inner();
		in.work();
	}
}
class OuterClass{
	public static void main(String[] args) {

		Outer out = new Outer();
		out.met();
		// Outer.Inner in = out.new Inner();
		// in.own();
	}
}