class Car{
	private String chasis;
	private int reg;
	private String name, model, color, brand;

	Car(String chasis, int reg){
		this.chasis = chasis;
		this.reg = reg;
	}

	public void set(String chasis, int reg){
		this.chasis = chasis;
		this.reg = reg;
	}
	public String get(){
		return this.chasis;
	}
}
class CarWork{
	public static void main(String[] args) {
		Car car1 = new Car("BMW01",1001);
		Car car2 = new Car("MCD01",2001);
		Car car3 = new Car("JUG01",3001);
		Car car4 = new Car("BMW02",1002);
		
		System.out.println(car1.get());		
	}
}