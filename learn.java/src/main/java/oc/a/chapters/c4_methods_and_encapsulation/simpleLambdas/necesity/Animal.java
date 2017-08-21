package oc.a.chapters.c4_methods_and_encapsulation.simpleLambdas.necesity;

public class Animal {

	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String species, boolean canHop, boolean canSwim) {
		this.species = species;
		this.canHop = canHop;
		this.canSwim = canSwim;
	}

	public boolean canHop(){
		return canHop;
	}
	
	public boolean canSwim(){
		return canSwim;
	}
	
	public String toString(){
		return species;
	}
}

class A {
}

abstract class B {
}

final class C {
}