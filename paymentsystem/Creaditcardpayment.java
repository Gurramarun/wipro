package packagecom.paymentsystem;

public class Creaditcardpayment  extends Payement{

	public Creaditcardpayment(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	public void processpayement()
	{
		System.out.println("processing creadit card payement of"+amount);
	}
	

}
