package polymarphisam;

public class Methodoverloading {
public void m1(int a,int b)
{
	System.out.println(a);
	System.out.println(b);
}
public void m1(Double a,int b)
{System.out.println(a);
System.out.println(b);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methodoverloading m=new Methodoverloading();
		m.m1(10,20);
		m.m1(90,20);
	}

}
