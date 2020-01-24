class Fibonacci{
	public static void main(String[] args) {
		int pointer = 1;
		int prevpointer = 1;
		System.out.print(1+" "+1+" ");
		int next,temp;
		for(next=2;next<=89;next=pointer+prevpointer){
			System.out.print(next+" ");
			prevpointer = pointer;
			pointer = next;
		}
	}
}