package oc.a.chapters._4_methods_and_encapsulation.simpleLambdas.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import oc.a.chapters._4_methods_and_encapsulation.simpleLambdas.necesity.Animal;

/**
 * public interface Predicate<T> { boolean test(T t); }
 *
 */
public class PredicatesSearch {

	List<Animal> animals;
	{
		animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));
	}

	void print(List<Animal> lst, Predicate<Animal> check) {
		for (Animal a : lst) {
			if (check.test(a)) {
				System.out.print(a + " ");
			}
		}
	}

	void m() {
		print(animals, a -> a.canHop());
	}

	void m2(){
		System.out.println();
		animals.removeIf(a->!a.canHop());
		System.out.println(animals);
	}
	
	public static void main(String[] args) {
		PredicatesSearch s = new PredicatesSearch();

		s.m();
		s.m2();
	}

}
