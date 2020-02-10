import java.io.*;

class CopyDataThread implements Runnable{
	@Override
	public void run(){
		try{
			File srcFile = new File("source.txt");
			FileReader fr = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			File trgtFile = new File("target.txt");
			FileWriter fw = new FileWriter(trgtFile);
			int c =0,count=0;
			String str="";
			while((c = br.read())!= -1){
				if(count == 9){
					fw.write(sb.toString());
					count = 0;
					sb.delete(0,sb.length());
					System.out.println("10 characters are copied");
					Thread.sleep(5000);
				}
				sb.append(((char)c));
				count++;
			}
			if(sb.length()!=0){
				fw.write(sb.toString());	
			}
			fw.close();
			br.close();
			fr.close();
		}catch(Exception e){
			System.out.println("Bhai galat hai kuch");
		}
	}
}
class FileTransfer{
	public static void main(String[] args) {
		
		CopyDataThread c = new CopyDataThread();
		Thread t = new Thread(c);
		t.start();

	}
}