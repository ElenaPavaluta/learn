package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.applyingTheSingletonPattern.lazyIntanstiation;

/**
 * This solution is better than our previous version, as it performs the synchronization
 * step only when the singleton does not exist. If our singleton is accessed thousands of
 * times over many hours or days, this means that only the fi rst few calls would require
 * `synchronization, and the rest would not.
 */
class SingletonWithDoubleCheckingLocking
{
	/**
	 * The key here is the use of the volatile keyword which ensures that any write action to this variable is visible
	 * throughout the other threads: http://tutorials.jenkov.com/java-concurrency/volatile.html
	 */
	private static volatile SingletonWithDoubleCheckingLocking instance;

	private SingletonWithDoubleCheckingLocking()
	{
	}

	public static final /**no effect */ synchronized SingletonWithDoubleCheckingLocking getInstance()
	{
		if (instance == null)
		{
			synchronized (SingletonWithDoubleCheckingLocking.class)
			{
				if (instance == null)
				{
					instance = new SingletonWithDoubleCheckingLocking();
				}
			}
		}
		return instance;
	}
}
