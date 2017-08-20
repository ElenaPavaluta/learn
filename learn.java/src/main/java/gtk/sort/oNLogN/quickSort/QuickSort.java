package sort.oNLogN.quickSort;

import java.util.List;

import sort.util.Util;

public class QuickSort<E extends Comparable<E>> {

	private List<E> lst;

	public List<E> quickSort(List<E> lst) {
		this.lst = lst;
		sort(lst, 0, lst.size() - 1);
		return this.lst;
	}

	private void sort(List<E> lst, int low, int high) {
		if (low < high) {
			int pivotPoz = partition(lst, low, high);
			sort(lst, low, pivotPoz - 1);
			sort(lst, pivotPoz + 1, high);
		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	private int partition(List<E> lst, int low, int high) {
		E pivot = lst.get(high);

		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (lst.get(j).compareTo(pivot) <= 0) {
				i++;
				Util.swap(lst, i, j);
			}
		}

		Util.swap(lst, high, i + 1);

		return i + 1;

	}

}
