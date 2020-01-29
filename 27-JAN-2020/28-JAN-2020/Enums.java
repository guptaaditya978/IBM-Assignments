import java.util.Scanner;

enum PizzaSize{Small(), Medium(), Large();
	private int serves;
	private int price;

	PizzaSize(){
		
		System.out.println("Enter the size and cost of the pizza you want");
		Scanner sc = new Scanner(System.in);
		this.serves = sc.nextInt();
		this.price = sc.nextInt(); 
	}

	public int getserves(){
		//int k[] = new int[2];
		//k[0] = this.serves;
		//k[1] = this.price;
		return this.serves;
	}
	public int getprice(){
		// int k[] = new int[2];
		// k[0] = this.serves;
		// k[1] = this.price;
		return this.price;
	}

}

class Pizza{

	void getMenu(){
		// PizzaSize size = PizzaSize.Small;
		// System.out.println(size.getserves()+" "+size.getprice());

		// size = PizzaSize.Medium;
		// System.out.println(size);

		// size = PizzaSize.Large;
		// System.out.println(size);

		for(PizzaSize s :PizzaSize.values()){
			System.out.println(s.getserves()+" "+s.getprice());
		}
	}
}

class Enums{
	public static void main(String[] args) {
		new Pizza().getMenu();
	}
}