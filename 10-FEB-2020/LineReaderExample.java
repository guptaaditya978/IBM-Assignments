import java.io.*;

class LineReaderExample{
	public static void main(String [] args) {
		try{
			File file = new File("DemoFile.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			int count = 1;
			while((str = br.readLine()) != null)
			{	
				System.out.println(count+++". "+str);
			}
			br.close();
		}catch(IOException e) {
			System.out.println(e);
			System.out.println("Can't read from the file currently..."); 
		}
	}
}