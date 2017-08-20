package sort.oNSquare;

import java.util.List;

/**
 * Insertion sort works by looking at each item in an array (starting with the
 * second) and comparing it with the item before. If the item before is larger,
 * they are swapped. This continues until the item is smaller at which point we
 * do the same for the next item.
 * 
 * 
 * http://www.growingwiththeweb.com/2012/11/algorithm-insertion-sort.html
 *
 * Time: O(n^2)
 *
 * Space O(1) auxiliary
 *
 */
public class InsertionSort<E extends Comparable<E>> {

	public List<E> insertionSort(List<E> lst) {
		for (int i = 1; i < lst.size(); i++) {
			E item = lst.get(i);
			int itemIndex = i;
			while (itemIndex > 0 && lst.get(itemIndex - 1).compareTo(item) > 0) {
				lst.set(itemIndex, lst.get(--itemIndex));
			}
			lst.set(itemIndex, item);
		}
		return lst;
	}
}
