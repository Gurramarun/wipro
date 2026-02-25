package polymarphisam;
public interface Laptop {
	public void audio();
	public void video();
	public void mouse();
	public void keyboard();
	public default void blutooth()
	{
		System.out.println("blutooth are laptop...");
	}
	public default void wifi()
	{
		System.out.println("wifi present in laptop...");
	}

}
