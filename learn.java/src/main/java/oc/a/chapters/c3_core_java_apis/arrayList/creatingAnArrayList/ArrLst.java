package oc.a.chapters.c3_core_java_apis.arrayList.creatingAnArrayList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList()
 * 
 * ArrayList(Collection<? extends E> c)
 *
 * ArrayList(int initialCapacity)
 */

/**
 * ArrayList implements toString()
 */
public class ArrLst {

	{
		ArrayList<String> al = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>(al);
		ArrayList<String> al3 = new ArrayList<>(5);
	}

	ArrayList<Integer> arrlst;
	{
		arrlst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(arrlst);
	}
	
	public static void main(String[] args) {
		new ArrLst();
	}
}
