package oc.a.chapters.c5_class_design.implementingInterfaces.interfaceVariables;

import utils.delimitators.Delimitators;

public class A extends AA implements InterfaceVariables{

	void m(){
//		System.out.println(super.A); //compiler error: super can be used only when extending a class
		System.out.println(this.IA);
		System.out.println(InterfaceVariables.IA);
	}
	
	void m2(){
		System.out.println(super.AAA);
		System.out.println(this.AAA);
		System.out.println(AA.AAA);
	}
	
	public static void main(String[] args) {
		A a = new A();
		
		a.m();
		Delimitators.equal();
		a.m2();
	}
}

abstract class AA{
	static final int AAA = 5;
}

