package i.uLink.square;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDrawMultipleSquares {
	
	private static Square square;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		square = new Square();
	}


	@Test
	public void testWhenEmptyArray() {
		int[] arr = new int[0];
		
		String expected = "";
		
		assertEquals(expected, square.drawMultipleSquares(arr));
	}

	@Test
	public void testWhenArrayContainsOneElem() {
		int[] arr = new int[]{3};
		
		String expected = "###\n# #\n###\n";
		
		assertEquals(expected, square.drawMultipleSquares(arr));
	}
	
	@Test
	public void testWhenArrayContainsMoreElems() {
		int[] arr = new int[]{3, 5};
		
		String expected = "#####\n# # #\n### #\n#   #\n#####\n";
		
		assertEquals(expected, square.drawMultipleSquares(arr));
	}
	
}
