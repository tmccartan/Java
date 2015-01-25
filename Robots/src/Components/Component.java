package Components;


/**
 * Abstract class representing a Component within
 * the solution
 *
 */
public abstract class Component {
	String name;

	@Override
	public String toString() {
		return name.toString();
	}
}
