package Factories;

import Components.Component;

/**
 * Base interface for a Product factory
 *
 */
public interface IProductFactory {
	Component createObject();
}
