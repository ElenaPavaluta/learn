package gtk.sort.oNLogN.mergeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
 *
 * O(nLog n)
 *
 * Merge sort keeps on dividing the list into equal halves until it can no more
 * be divided. By definition, if it is only one element in the list, it is
 * sorted. Then, merge sort combines the smaller sorted lists keeping the new
 * list sorted too.
 *
 *
 * Step 1 − if it is only one element in the list it is already sorted, return.
 *
 * Step 2 − divide the list recursively into two halves until it can no more be
 * divided
 *
 * Step 3 − merge the smaller lists into new list in sorted order.
 *
 */
public class MergeSort<E extends Comparable<E>> {

	public List<E> mergeSort(List<E> lst) {
		if (lst.size() == 1)
			return lst;

		int half = lst.size() / 2;

		List<E> a = lst.subList(0, half);
		List<E> b = lst.subList(half, lst.size());

		a = mergeSort(a);
		b = mergeSort(b);

		return merge(a, b);
	}

	private List<E> merge(List<E> a, List<E> b) {
		List<E> r = new ArrayList<>(a.size() + b.size());

		int ai = 0, bi = 0;

		while ((ai < a.size()) && (bi < b.size())) {
			if (a.get(ai).compareTo(b.get(bi)) <= 0) {
				r.add(a.get(ai++));
			} else {
				r.add(b.get(bi++));
			}
		}

		while (ai < a.size()) {
			r.add(a.get(ai++));
		}

		while (bi < b.size()) {
			r.add(b.get(bi++));
		}

		return r;
	}


}
