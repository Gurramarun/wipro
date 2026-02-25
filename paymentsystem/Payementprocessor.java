package packagecom.paymentsystem;
import java.util.*;
public class Payementprocessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.print("enter amount:");
double amount=sc.nextDouble();
System.out.println("choose payement mathod:");
System.out.println("1.credit card");
System.out.println("2.UPI");
int choice=sc.nextInt();
Payement payement=null;
Payementvalidator validator=null;
if (choice==1)
{
	payement=new Payement(amount);
	validator=(amt)->amt>0&&amt<=50000;
}
else if(choice==2)
{
	payement=new Upipayment(amount);
	validator=(amt)->amt>0&&amt<=100000;
}
else {
	System.out.println("invalid choice");
	return;
}
if (validator.validate(amount))
{
	payement.processpayement();
	System.out.println("payement successful...");
}
else
{
	System.out.println("payement validaton");
}
	}

}
