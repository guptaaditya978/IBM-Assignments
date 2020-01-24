class Tables{
	public static void main(String[] args) {
		int number=Integer.parseInt(args[0]);
		int limit=Integer.parseInt(args[1]);
		for(int i = 1; i <= limit; i++){
			System.out.println(number+" "+"*"+" "+i+" "+"="+" "+number * i);
		}
	}
}