package i.uLink.tlv;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class TestTLV {

	private static TLV tlv;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tlv = new TLV();
	}

	@Test
	public void testEmtyArray() {
		int[] arr = new int[0];

		assertTrue(tlv.tlvMethod(arr) == 0);
	}

	@Test
	public void testArrayWithOneElem() {
		int[] arr = new int[] { 1 };

		assertTrue(tlv.tlvMethod(arr) == 1);
	}

	@Test
	public void testArrayWhenElemsAreSorted() {
		int[] arr = new int[] { 5, 3, 2, 4 };
		Arrays.sort(arr);
		assertTrue(tlv.tlvMethod(arr) == 3);
	}

	@Test
	public void testArrayWhenElemsAreSortedDescending() {
		int[] arr = new int[] { 5, 3, 2, 4 };
		Arrays.sort(arr);
		int a[] = new int[arr.length];
		for (int i = arr.length - 1, j = 0; i > -1; i--, j++) {
			a[j] = arr[i];
		}
		assertTrue(tlv.tlvMethod(a) == 5);
	}

	@Test
	public void testRandomArray() {
		int[] arr = new int[] { 4, 5, 7, 10, 6, 2, 7, 8, 9, 6, 4, 1, 3, 5, };
		assertTrue(tlv.tlvMethod(arr) == 7);
	}

}
