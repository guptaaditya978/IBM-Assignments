import java.io.*;
import java.util.*;

class UserFileExample{
	public static void main(String[] args) {
		try { // warning: exception possibilities here
			boolean newFile = false;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the File name");
			String name = sc.next();
			File file = new File(name);
			if(file.exists()){
				System.out.println("File Exists");
			}
			else{
				System.out.println("File does not exsts but now have been created successfully");
				file.createNewFile();		
			}
			if(file.canRead()){
				System.out.println("You can read");
			}
			else{
				System.out.println("You can't read");
			}
			if(file.canWrite()){
				System.out.println("You can write");
			}
			else{
				System.out.println("You can't write");
			}
			System.out.println("Type of File is :"+name.substring(name.lastIndexOf(".")));
			System.out.println("Total Bytes Length :"+file.length());

		}catch(IOException e){
			System.out.println("Some issues while creating the file..."); 
		}
	}
}