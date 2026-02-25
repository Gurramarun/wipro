package filehanding;
import java.io.*;
public class Fileinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
File file=new File("Demo.txt");
System.out.println("file name:"+file.getName());
System.out.println("path:"+file.getAbsolutePath());
System.out.println("writable:"+file.canWrite());
System.out.println("readable:"+file.canRead());
System.out.println("file size"+file.length());
	}

}
