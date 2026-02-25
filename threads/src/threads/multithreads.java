package threads;

public class multithreads {

	public static void main(String[] args)throws Exception
	{
		BrickDairy bd=new BrickDairy();
		Runnable r1=()->{
			for(int i=0;i<1000;i+=50)
			{
				bd.incrementbrickcount();
			}
		};
		Runnable r2=()->{
			for(int i=0;i<1500;i+=50)
			{
				bd.incrementbrickcount();
			}
		};
		Runnable r3=()->{
			for(int i=0;i<1100;i+=50)
			{
				bd.incrementbrickcount();
			}
		};
		
	Thread t1=new Thread(r1);
	Thread t2=new Thread(r2);
	Thread t3=new Thread(r3);
	t1.start();
	t2.start();
	t3.start();
	t1.join();
	t2.join();
	t3.join();
	System.out.println("final brick count is:"+bd.getBrickCount());
		
	}
	 static class BrickDairy
	{
private int brickcount=0;
		public synchronized void incrementbrickcount() {
			// TODO Auto-generated method stub
			brickcount+=50;
		}
		public int getBrickCount()
		{
			return brickcount;
		}
		
	}

}

