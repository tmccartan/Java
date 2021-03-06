package Workers;

import java.util.Queue;

import Components.Broom;
import Components.Component;
import Components.MainUnit;

/**
 * Class representing the Dry2000 worker
 *
 */
public class Dry2000 extends Robot {

	private Queue<Component> _queue;
	private int _mainUnitCount = 0;
	private int _broomCount = 0;
	private int totalProductCount;
	
	public Dry2000(Queue<Component> queue) {
		this.name = "Dry2000";
		this._queue = queue;
	}

	public void PrintStatus() {
		System.out.println("Dry = Main unit count = " + this._mainUnitCount
				+ " Broom count = " + this._broomCount);
	}

	@Override
	public void DoWork() throws InterruptedException {

		if (_mainUnitCount == 1 && _broomCount == 2) {
			Thread.sleep(3000);
			this.totalProductCount = this.totalProductCount + 1;
			System.out.println("I've created " + this.totalProductCount
					+ " dryRobots");
			this._broomCount = 0;
			this._mainUnitCount = 0;
		} else if (_queue.peek() instanceof MainUnit && _mainUnitCount != 1) {
			_queue.poll();
			this._mainUnitCount = this._mainUnitCount + 1;
			System.out.println("Dry took Main Unit");
		} else if (_queue.peek() instanceof Broom && _broomCount != 2) {
			_queue.poll();
			this._broomCount = this._broomCount + 1;
			System.out.println("Dry took Broom Unit");
		}
		PrintStatus();
	}

}
