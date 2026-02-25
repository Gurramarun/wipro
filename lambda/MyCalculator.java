package lambda;
interface Hello
{
	void sayhello();
}

public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Hello h=()->System.out.println("hello java lambda");
h.sayhello();
	}

}
