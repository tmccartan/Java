package Workers;

import java.util.Queue;

import Components.Component;
import Factories.IProductFactory;

/**
 * Class representing a Supplier
 *
 *	In this solution, a supplier is just like any
 *	other worker, they just do different work
 *
 *	The supplier makes use of the Factory pattern
 *	This allows it to be decoupled from what product it supplies
 *	so when new product families are added they just need to be a
 *	new factory
 */
public class Supplier extends Robot {

	private IProductFactory _factory;
	private Queue<Component> _queue;
	private long _timeLastInsert = 0;

	public Supplier(IProductFactory factory, Queue<Component> convoy) {
		this._factory = factory;
		this._queue = convoy;
	}

	public void DoWork() {
		if (_queue.size() < 10) {
			Component comp = _factory.createObject();
			_queue.add(comp);
			_timeLastInsert = System.currentTimeMillis();
			System.out.println("Supplier added object " + comp.toString()
					+ " ,number of Items = " + _queue.size());
		} else {
			System.out.println("Maxium reached -- Head = "
					+ _queue.peek().toString());
			System.out.println("Time since last input "
					+ (System.currentTimeMillis() - _timeLastInsert));
			if (System.currentTimeMillis() - _timeLastInsert > 10000) {
				Component comp = _queue.poll();
				System.out.println("Destroyed head " + comp.toString());
			}
		}
	}
}
