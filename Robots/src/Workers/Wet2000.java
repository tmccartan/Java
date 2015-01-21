package Workers;

import java.util.Queue;

import Components.Component;
import Components.MainUnit;
import Components.Mop;

public class Wet2000 extends Robot {

	private Queue<Component> _queue;
	private int _mainUnitCount = 0;
	private int _mopCount = 0;
	
	public Wet2000(Queue<Component> queue)
	{
		this.name = "Wet2000";
		this._queue = queue;
	}
	public void PrintStatus()
	{
		System.out.println("Wet = Main unit count = "+ this._mainUnitCount +" Mop count = "+this._mopCount);
	}
	@Override
	public void BuildProduct() throws InterruptedException {
		
		if(_mainUnitCount == 1 && _mopCount == 2 )
		{
			//sleepcount = 3000;
			Thread.sleep(3000);
			this.totalProductCount++;
			System.out.println("I've created "+ this.totalProductCount +" Wet Robots");
			this._mopCount = 0;
			this._mainUnitCount = 0;
		}
		else if(_queue.peek() instanceof MainUnit && _mainUnitCount != 1)
		{
			MainUnit newMop = (MainUnit) _queue.poll();
			this._mainUnitCount = this._mainUnitCount +1;
			System.out.println("Wet took Main Unit");
		}
		else if(_queue.peek() instanceof Mop && _mopCount != 2)
		{
			Mop newMop = (Mop) _queue.poll();
			this._mopCount = this._mopCount +1;
			System.out.println("Wet took Mop Unit");
		}
		PrintStatus();
		// TODO Auto-generated method stub
	}
}
