package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.applyingTheSingletonPattern.lazyIntanstiation;

class LazyInstantiation
{
	private static LazyInstantiation instance;  // the variable is not final

	private LazyInstantiation()
	{
	}

	/**
	 * The implementation of V, as shown, is not considered thread‐safe in
	 * that two threads could call getInstance() at the same time, resulting in two objects
	 * being created. After both threads finish executing, only one object will be set and used by
	 * other threads going forward, but the object that the two initial threads received may not
	 * be the same.
	 */
	public static LazyInstantiation getInstance()
	{

		if (instance == null)
		{
			instance = new LazyInstantiation();
		}
		return instance;
	}

	/**
	 * The getInstance() method is now synchronized, which means only one thread will be
	 * allowed in the method at a time, ensuring that only one object is created.
	 *
	 * The disadvantage of this is that every single call to this method requires synchronization,
	 * which in practice can be very costly. Solution: Singletons with double checking locking
	 */
	synchronized public static LazyInstantiation getInstance2()
	{
		if (instance == null)
		{
			instance = new LazyInstantiation();
		}
		return instance;
	}
}
