class BinaryNumber{
	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		String s="";
		while(number != 0)
		{
			s = number % 2 + s;
			number = number / 2;
		}
		System.out.println(s);
	}
}