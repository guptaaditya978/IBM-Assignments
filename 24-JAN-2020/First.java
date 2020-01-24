class First{
	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int fact = 1,i = 1;
		while(i <= number)
		{
			fact = fact * i;
			i++;
		}
		System.out.println("Factorial Of The number is " + fact);
	}
}