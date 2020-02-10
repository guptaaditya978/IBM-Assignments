import java.io.*;
import java.util.ArrayList;
class FileCountExample{
	public static void main(String [] args) {
		int size = 0;
		//ArrayList<Character> in = new ArrayList<>();
		try{
			File file = new File("DemoFile.txt"); 
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			int count = 0,c=0;
			while((c = br.read())!= -1){
				count++;
			} 
			//System.out.println("Number of characters are "+ in.size());
			System.out.println(count);
			//System.out.println(br.read());
			String str = "";
			br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			count = 0;
			while((str = br.readLine()) != null)
			{	
				count++;
				sb.append(str+" ");
				//System.out.println(str);

			}
			System.out.println("Number of lines are "+count);
			String [] strarr = sb.toString().split(" .");
			System.out.println("Number of words"+strarr.length);
			br.close();
			fr.close();
		}catch(IOException e) {
			System.out.println(e);
			System.out.println("Can't read from the file currently..."); 
		}
	}
}