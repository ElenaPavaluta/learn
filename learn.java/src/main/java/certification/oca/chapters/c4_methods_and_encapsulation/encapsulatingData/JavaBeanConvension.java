package chapters.c4_methods_and_encapsulation.encapsulatingData;

/**
 * Properties are private.
 * 
 * Getter methods begin with is if the property is a boolean.
 *
 *
 * Getter methods begin with get if the property is not a boolean.
 * 
 * 
 * Setter methods begin with set.
 * 
 * The method name must have a prefix of set/get/is, followed by the first
 * letter of the property in uppercase, followed by the rest of the property
 * name.
 */
public class JavaBeanConvension {

	private String string;
	private boolean bool;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

}
