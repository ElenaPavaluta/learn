package oc.a.oracle.chapters.c_3_lexicalStructure.literals;
import static utils.print.Print.*;
public class CharLiteral {

	/**
	 * CharacterLiteral: 
	 * ' SingleCharacter ' (InputCharacter but not ' or \)
	 * ' EscapeSequence '
	 * 
	 */
	
	static char min = '\u0000';
	static char max = '\uffff';
	
	static char c;
	
	static void m(){
		print("min", min);
		print("max", max);
		print ("c", c);
		
		c = '\\';
		print ("c2", c);
		
		c = '\'';
		print ("c3", c);
	}
	
	public static void main(String[] args) {
		m();
	}
	
}
