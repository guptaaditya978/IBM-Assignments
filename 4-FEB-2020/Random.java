import java.util.Date;
import java.time.*;

// class Thread1 extends Thread{

// 	@Override
// 	public void run(){
// 		for(int i=1000;i<5000;i++){
// 			try{
// 				System.out.print(i+" ");
// 				Thread1.sleep(4999);	
// 			}catch(Exception e){
// 				System.out.println("Stopped");
// 			}
// 		}

// 	}
// }
class Thread2 extends Thread{

	@Override
	public void run(){
		{
			try{
				while(true){
					long secs = (new Date().getTime());
					String s = Long.toString(secs);
					int k =s.length();
					s=s.substring(k-4,k);
					StringBuffer sb = new StringBuffer();
					if(Integer.parseInt(s)%2==0 && s.charAt(3)!='0'){
						sb.append(s);
						s=sb.reverse().toString();
					}
					System.out.print(s+" ");
					Thread2.sleep(3000);	
				}
				
				
			}catch(Exception e){
				System.out.println("Caught");
			}
			
			
		}	
	}
		
	}
class Random extends Thread{
	public static void main(String[] args) {
	//Thread1 t1 = new Thread1();
	Thread2 t2 = new Thread2();
	//t1.setName("Aditya");
	t2.setName("Raj");
	//Random r = new Random();
	//r.start();
	t2.start();
	//t1.start();
	System.out.println();
	

	}
	@Override
	public void run(){
		while(true){
			try{
				new Thread1().start();
				
			
		}catch(Exception e){
			System.out.println("Caught bhai");
		}
		}
	}
}