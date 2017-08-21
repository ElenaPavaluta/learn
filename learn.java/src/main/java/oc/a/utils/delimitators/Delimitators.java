package oc.a.utils.delimitators;

public class Delimitators {
	
	private static final int NB = 10;

	public static void equal(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<NB; i++){
			sb.append("=");
		}
		System.out.println(sb.toString());
	}
	
	public static void newLine(){
		System.out.println();
	}
}
