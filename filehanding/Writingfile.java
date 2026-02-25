package filehanding;
import java.io.*;
public class Writingfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	FileWriter writer=new FileWriter("Demo.txt");
writer.write("hello arun\n");
writer.write("welcome to java file handling");
writer.close();
System.out.println("data writen successfully");
}
catch(IOException e)
{
	System.out.println("error occurred");
}
	}

}
