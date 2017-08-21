package oc.a.chapters.c4_methods_and_encapsulation.simpleLambdas.necesity;

import java.util.ArrayList;
import java.util.List;

public class Search {

	List<Animal> animals;
	{
		animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));
	}

	// old way
	void print(List<Animal> lst, CheckTrait check) {
		for (Animal a : animals) {
			if (check.test(a)) {
				System.out.print(a + " ");
			}
		}
		System.out.println();
	}

	void m() {
		print(animals, new CheckIfHopper());
	}

	void m2() {
		print(animals, a -> a.canHop());
	}

	void m3() {
		print(animals, (Animal a) -> {
			return a.canHop();
		});
	}

	void m4() {
		print(animals, (a) -> a.canHop());

		print(animals, a -> {
			return a.canHop();
		});

		print(animals, a -> {
			boolean b = a.canHop();
			return b;
		});
	}

	void m5() {
		/*
		 * Lambdas are allowed to access variables.
		 */
		boolean b = false;
		print(animals, a -> !a.canHop() == b);
	}

	void m6() {
		/*
		 * compiler error: java doesn't allow to redeclare a local variable
		 */
		// print(animals, a->{int a; return false;});
//		print(animals, a->{Animal a = new Animal(null, false, false); return a.canHop();});
		print(animals, a -> {
			int aa;
			return false;
		});
	}
	
	void m7(){
		int a = 2;
		for(int i = 0; i<a; i++){
//			boolean a = false;  //compiler error: duplicate variable a;
		}
	}

	public static void main(String[] args) {
		Search s = new Search();

		s.m();
		// s.m2();
		// s.m3();

		// s.m4();

		s.m5();

	}
}
