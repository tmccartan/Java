package Workers;

public abstract class Robot implements Runnable {

	String name;
	int totalProductCount;
	
	@Override
	public void run()
	{
		System.out.println(this.name+ " started");
		try {
			
			while(true)
			{
				Thread.sleep(1000);
				BuildProduct();
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	abstract void BuildProduct() throws InterruptedException;
	
}
