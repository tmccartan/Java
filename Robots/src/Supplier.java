import java.util.Queue;

import Components.Component;
import Components.Mop;
import Factories.IProductFactory;


public class Supplier implements Runnable {

	
	private IProductFactory _factory;
	private  Queue<Component> _convoy;
	private long _timeLastInsert = 0;
	public Supplier(IProductFactory factory, Queue<Component> convoy)
	{
		this._factory = factory;
		this._convoy = convoy;
	}
	public void Supply()
	{
		if(_convoy.size() < 10)
		{
			Component comp = _factory.createObject();
			_convoy.add(comp);
			_timeLastInsert = System.currentTimeMillis();
			System.out.println("Supplier added object " +comp.toString() +" ,number of Items = "+_convoy.size());
		}
		else
		{
			System.out.println("Maxium reached -- Head = "+_convoy.peek().toString());
			System.out.println("Time since last input "+( System.currentTimeMillis() - _timeLastInsert ));
			if(System.currentTimeMillis() - _timeLastInsert > 10000)
			{
				Component comp = _convoy.poll();
				System.out.println("Destroyed head "+comp.toString());
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Supplier Started");
		
			//if time since last add is greater than 10 sec's remove head
			

		try {
			while(true)
			{
				Thread.sleep(1000);
				Supply();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
