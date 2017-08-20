package sort.oNLogN.mergeSort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
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
