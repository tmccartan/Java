import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import Workers.Dry2000;
import Workers.Supplier;
import Workers.Wet2000;
import Components.Component;
import Factories.CleaningComponentsFactory;

public class RobotMain {

	public static void main(String[] args) {
		System.out.println("Welcome to the Cleaning Factory");
		// By using the ConcurrentLinkedQueue we are guaranteed thread safeness
		// other options are available but I felt this is a strong base so if the number
		// of worker threads increase on the convoy, it can handle it.
		Queue<Component> convoy = new ConcurrentLinkedQueue<Component>();
		Thread supplier = new Thread(new Supplier(
				new CleaningComponentsFactory(), convoy));
		supplier.start();
		Thread dryCreator = new Thread(new Dry2000(convoy));
		dryCreator.start();
		Thread wetCreator = new Thread(new Wet2000(convoy));
		wetCreator.start();
	}

}
