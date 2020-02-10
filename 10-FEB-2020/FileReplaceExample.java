import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class FileReplaceExample{
	public static void main(String [] args) {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the word you want to replace");
			String s1 = sc.next();
			System.out.println("Enter the word you want to replace it with");
			String s2 = sc.next();
			File file = new File("DemoFile.txt"); 
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			StringBuilder sb = new StringBuilder();
			//count = 0;
			while((str = br.readLine()) != null)
			{	
				//count++;
				sb.append(str+" "+"\n");
				//System.out.println(str);

			}
			str = sb.toString().replaceAll(s1,""+s2);
			br.close();
			fr.close();
			FileWriter fw = new FileWriter(file); // create an actual file
// & a FileWriter obj
			fw.write(str); // write characters to
// the file
			fw.flush(); // flush before closing
			fw.close();
			System.out.println("Changes done succesfully");
			// FileWriter fw = new FileWriter(file);
			// PrintWriter out = new PrintWriter(new File("anotherFile.txt"));
			// out.println(str);
			//out.close();
			// System.out.println("Number of lines are "+count);
			// String [] strarr = sb.toString().split(" .");
			// System.out.println("Number of words"+strarr.length);
			
		}catch(IOException e) {
			System.out.println(e);
			System.out.println("Can't read from the file currently..."); 
		}
	}
}