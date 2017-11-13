package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.applyingTheSingletonPattern;

class HayStorage
{
	private int quantity = 10;

	private static final HayStorage instance; // = new HayStorage();  //instantiate the class when it's loaded

	//instantiates the class when it's loaded
	static {
		instance = new HayStorage();
		//here additional steps can be performed
	}

	/**
	 * By marking the constructors private, we have implicitly marked the class final due to the fact that any subclass
	 * constructor needs to call the super class constructor and since it's private, just can't be instantiated
	 */
	private HayStorage()
	{
	}

	public static HayStorage getInstance()
	{
		return instance;
	}

	synchronized void addHay(int quantity)
	{
		quantity += quantity;
	}

	synchronized boolean removeHay(int amount)
	{
		if (quantity < amount)
		{
			return false;
		}
		quantity -= amount;
		return true;
	}

	synchronized int getHay()
	{
		return quantity;
	}
}
