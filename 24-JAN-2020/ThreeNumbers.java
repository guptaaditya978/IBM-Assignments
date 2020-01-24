class ThreeNumbers{
	public static void main(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int num3 = Integer.parseInt(args[2]);
		int flag1 =0 ,flag2 = 0,flag3 = 0,flag4 = 0;
		if(num1 + num2 + num3 >=125){
			flag4 = 1;
		}
		if(num1 >= 40){
			flag1 = 1;
		}
		if(num2 >= 40){
			flag2 = 1;
		}
		if(num3 >= 40){
			flag3 = 1;
		}
		if(flag1 * flag2 * flag3 * flag4 == 1)
		{
			System.out.println("PASSING");
		}
		else
		{
			System.out.println("FAILING");
		}
	}
}