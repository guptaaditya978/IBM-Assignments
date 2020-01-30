class Rough2{
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		StringBuffer sb = new StringBuffer("This is my place");
		StringBuffer sb1 = new StringBuffer("delhi madarchod hai");
		
		System.out.println(sb.append(sb1));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);

	}
}