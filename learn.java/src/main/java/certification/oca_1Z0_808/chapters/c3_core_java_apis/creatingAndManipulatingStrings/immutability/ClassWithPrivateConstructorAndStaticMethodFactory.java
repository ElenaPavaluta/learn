package chapters.c3_core_java_apis.creatingAndManipulatingStrings.immutability;

public class ClassWithPrivateConstructorAndStaticMethodFactory {

	private int i;
	private String s;

	private ClassWithPrivateConstructorAndStaticMethodFactory(int i, String s) {
		this.i = i;
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public String getS() {
		return s;
	}

	public ClassWithPrivateConstructorAndStaticMethodFactory newInstance(
			ClassWithPrivateConstructorAndStaticMethodFactory c) {
		return new ClassWithPrivateConstructorAndStaticMethodFactory(c.getI(),
				c.getS());
	}
}
