class TryCatch{
	// try{
	public static void main(String[] args) {
		//System.out.println(new TryCatch().add(15,0));

		new TryCatch().met();

	}
	void met(){
			met();
		}
}
// 	int add(int a, int b){
// 		try{
// 			int r = a/b;
// 			return r;
// 		}
// 		catch(Exception e){
// 			System.out.println("Error");
// 		}
// 		finally{
// 			System.out.println("Finally");
// 		}
// 		return 0;
// 	}

// }
// // }
// // catch(Exception e){
// // 	System.out.println("outside Main");
// // }