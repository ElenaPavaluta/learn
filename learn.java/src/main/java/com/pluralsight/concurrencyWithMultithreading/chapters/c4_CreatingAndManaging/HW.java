package com.pluralsight.concurrencyWithMultithreading.chapters.c4_CreatingAndManaging;

/**
 * Program shutdown
 * 
 * the main thread exists main
 * 
 * spawned non-daemon threads exists run
 *
 */
class HW {

	public static class Greeter extends Thread {

		private String country;

		public Greeter(String country) {
			super(country + " thread");
			this.country = country;
		}

		/*
		 * Standard thread persists until exiting run
		 *
		 * Exception: daemon threads
		 */
		@Override
		public void run() {
			long id = Thread.currentThread().getId();
//			long id = getId();
			System.out.println(id + " Hello: " + country);
		}

	}

	public static void main(String[] args) {
		String countries[] = { "France", "India", "China", "USA", "Germany" };
		
		System.out.println("main thread id: " + Thread.currentThread().getId() + "\n");
		
		for (String s : countries) {
			new Greeter(s).start();
			
			/*
			 * The main thread is run
			 */
//			new Greeter(s).run(); 
		}
	}
}
