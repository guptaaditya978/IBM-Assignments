class Rough{
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		StringBuilder sb = new StringBuilder("This is my place");
		StringBuilder sb1 = new StringBuilder("delhi madarchod hai");
		
		System.out.println(sb.append(sb1));
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
}