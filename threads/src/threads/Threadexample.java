package threads;

public class Threadexample {

	public static void main(String[] args) {

Employee t=new Employee("t1");
t.start();
Manager m=new Manager("t2");
m.start();
System.out.println(Thread.activeCount());
	}

}
 class Employee extends Thread
{public Employee(String tname)
	 {
	super(tname);
	 }
	 @Override
	public void run()
	{
		System.out.println("hello world");
	}
}
 class Manager extends Thread
 {
	 public Manager(String tname)
	 {
	super(tname);
	 }
	 @Override
	
public void run()
	 {
		 System.out.println("hi");
	 }
 }