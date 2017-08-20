package chapters.c1_building_blocks.destroyingObjects;

/**
 * finalize() call could run zero or one time
 * 
 *
 */

/*
 * Java allows objects to implement a method called finalize() that might get
 * called. This method gets called if the garbage collector tries to collect the
 * object. If the garbage collector doesn’t run, the method doesn’t get called.
 * If the garbage collector fails to collect the object and tries to run it
 * again later, the method doesn’t get called a second time.
 */

public class Finalizer {

	public Finalizer() {
		super(); // the super() call must be the first statement in the constructor
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("This object gets finalized()");

		super.finalize(); // Notice that needs to be the last statement where
		
	}

	public static void main(String[] args) throws Throwable {
		Finalizer f = new Finalizer();
	}
}
