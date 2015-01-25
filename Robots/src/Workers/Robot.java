package Workers;
/**
 * Abstract class all workers will be based on
 *
 *	Having it done this way allows for new robots to 
 *	be added easily, by just extending this class and
 *	implementing their work
 */
public abstract class Robot implements Runnable {

	String name;	
	@Override	
	public void run() {
		try {

			while (true) {
				Thread.sleep(1000);
				DoWork();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// Method each thread will implement that represents what work
	// they need to do
	abstract void DoWork() throws InterruptedException;
	
}
