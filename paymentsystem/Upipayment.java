package packagecom.paymentsystem;

public class Upipayment  extends Payement{

	public Upipayment(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	public void processpayement()
	{
		System.out.println("processing upi payement of"+amount);
	}

}
