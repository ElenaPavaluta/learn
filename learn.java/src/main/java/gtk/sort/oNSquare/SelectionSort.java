package sort.oNSquare;

import java.util.List;

import sort.util.Util;

/**
 * Selection sort is an O(n^2) sorting algorithm that works by
 * searching through a list to find the minimum element and swapping it for the
 * first in the list. After every swap, selection sort is performed on the list
 * with the head removed (ie. the minimum element). Due to the way that elements
 * are swapped anywhere in the list, this is not a stable sort.
 * 
 * 
 * http://www.growingwiththeweb.com/2013/12/selection-sort.html
 * 
 * Time: O(n^2)
 *
 * Space O(1) auxiliary
 *
 */
public class SelectionSort<E extends Comparable<E>> {

	public List<E> selectionSort(List<E> lst) {
		for (int i = 0; i < lst.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < lst.size(); j++) {
				if (lst.get(j).compareTo(lst.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Util.swap(lst, i, minIndex);
			}
		}
		return lst;
	}
}
