package oc.a.chapters._2_operators_and_statements.statements;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * for(datatype instance: collection){
 * 	//curly braces required for multiple statements
 * 
 * }
 * 
 * collection: Iterable collection of elements
 *
 */
public class ForEachStatement {
	static String[] sa = new String[5];

	static{
		sa[0] = "0";
		sa[1] = "1";
		sa[2] = "2";
		sa[3] = "3";
		sa[4] = "4";
	}
	
	static void m(){
		for(String s: sa){
			System.out.println(s);
		}
		
		System.out.println("equivalent");
		
		for(int i = 0; i<sa.length; i++){
			System.out.println(sa[i]);
		}
	}
	
	static void m2(){
		List<String> ls = Arrays.asList(sa);
		
		for(String s: ls){
			System.out.println(s);
		}
		
		System.out.println("equivalent");
		
		for(Iterator<String> it = ls.iterator(); it.hasNext(); ){
			String s = it.next();
			System.out.println(s);
		}
	}
	
	
	public static void main(String[] args) {
//		m();
		m2();
	}

}

class I implements Iterable<I>{

	@Override
	public Iterator<I> iterator() {
		return null;
	}
	
}

class MyIterator implements Iterator<MyIterator>{

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MyIterator next() {
		return null;
	}
	
}
