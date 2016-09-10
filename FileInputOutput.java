import java.io.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileInputOutput {

	public static void write(Object obj){
		
		try{
			
			FileOutputStream File = new FileOutputStream("testFile.dat");
			ObjectOutputStream Output = new ObjectOutputStream(File);
			
			Output.writeObject(obj);
			File.close();
			Output.close();
			
		}
		catch(IOException E){
			System.out.println(E);
		}
	}
	
	public static Object getFile(){
		
		Object Output = new Object();
		try{
			
			FileInputStream File2 = new FileInputStream("testFile.dat");
			ObjectInputStream Input = new ObjectInputStream(File2);
			Output = Input.readObject();
			File2.close();
			Input.close();
			
		}
		catch(ClassNotFoundException E){
			System.out.println(E);
		}
		catch(IOException E){
			System.out.println(E);
		}
		
		return Output;
		
	}
	
}
