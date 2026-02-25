package encaptulation;

public class student1 {

	private int roolnumber;
	private String name;
	private boolean isAttendance;
	public student1(int roolnumber)
	{
		this.roolnumber=roolnumber;
	}
	public void SetStudent1isAttendance(boolean flag)
	{
		this.isAttendance=flag;
			System.out.println("techer assinged ateendance");
		
	}
	public boolean getAttendance()
	{
		System.out.println("checked");
		return isAttendance;
	}

}
