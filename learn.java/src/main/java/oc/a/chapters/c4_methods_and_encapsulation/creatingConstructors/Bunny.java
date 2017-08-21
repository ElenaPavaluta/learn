package oc.a.chapters.c4_methods_and_encapsulation.creatingConstructors;

public class Bunny {

	private String color;
	private int height;
	private int length;
	
	public Bunny(int length, int theHeight){
		length = this.length;  //backwards - no good
		height = theHeight;  //fine
		this.color = "white";  //fine, but redundant
	}
}
