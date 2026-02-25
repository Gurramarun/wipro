package wipro;
import java.util.*;
public class Wether {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.print("enter city:");
String city=sc.nextLine();
System.out.print("enter Temp:");
float temp=sc.nextFloat();
boolean ishot=temp>30;
System.out.println("out put");
System.out.println("city:"+city);
System.out.println("Tempature:"+temp);
if(ishot)
{
	System.out.print("condition: hot day");
}
else
{
	System.out.print("condition: normal day");
}
sc.close();
sc=null;
System.gc();
	}

}
