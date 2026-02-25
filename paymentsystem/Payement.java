package packagecom.paymentsystem;

public abstract class Payement {
protected double amount;
public Payement(double amount)
{
	this.amount=amount;
}
	
public abstract void processpayement();
}
