interface Remote{
	void work();
}
class Fine{

	void asd(Remote r){
		System.out.println("BAdhiya asdf");
		r.work();
	}
}
class AnnonymousInnerClass{
	public static void main(String[] args) {
		Remote ref = new Remote(){
			@Override
			public void work(){
				System.out.println("Work of interface");
			}
		};
		ref.work();
		Fine f = new Fine(){
			public void asd(){
				System.out.println("Badhiya from bahar");
			}
		}; 
		//f.asd();
		// Fine f1 = new Fine();
		// f1.asd(new Remote(){
		// 	@Override
		// 	public void work(){
		// 		System.out.println("Work in interface");
		// 	}
		// });
	}
}