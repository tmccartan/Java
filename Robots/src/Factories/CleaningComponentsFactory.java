package Factories;

import java.util.Random;

import Components.Broom;
import Components.Component;
import Components.MainUnit;
import Components.Mop;

public class CleaningComponentsFactory implements IProductFactory {

	
	@Override
	public Component createObject() {
		
		Random rn = new Random();
		int answer = rn.nextInt(3)+1;
		switch(answer)
		{
			case 1:
				return new Mop();
			case 2:
				return new MainUnit();
			case 3:
				return new Broom();
			default:
				return new MainUnit();
		}
		
	}

}
