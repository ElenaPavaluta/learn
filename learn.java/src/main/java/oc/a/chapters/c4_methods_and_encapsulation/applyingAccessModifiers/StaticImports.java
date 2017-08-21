package oc.a.chapters.c4_methods_and_encapsulation.applyingAccessModifiers;

/*
 * compiler error: Arrays is a class. We can import all static fields in methods by using: import static java.util.Arrays.*, but not a whole class
 */
//import static java.util.Arrays; 


//static import java.util.Arrays.*;  //compiler error: import must be first

import static java.util.Arrays.*;
import java.util.ArrayList;
import java.util.List;

/**
 * If we create an asList method in our class, Java would give it preference
 * over the imported one (import static java.util.Arrays.asList;) and the method
 * we coded would be used.
 *
 */
public class StaticImports {

	@SuppressWarnings("unchecked")
	static <T> List<T> asList(T... arr) {
		return new ArrayList<T>();
	}

	static void m() {
		List<String> lst = asList("Ana", "are", "mere"); // the local defined
															// method is called
															// // here
		System.out.println(lst.size());
	}

	static void m2() {
		int i = binarySearch(new String[] { "Ana", "are", "mere" }, "are");
		System.out.println(i);
	}

	public static void main(String[] args) {
		m(); // so the result is obvious 0
		m2(); // 1
	}
}
