package gtk.sort.oNSquare;

import java.util.List;

import gtk.sort.util.Util;

/**
 * Bubble sort is an O(n^2)O sorting algorithm that gets its name because it
 * �bubbles up� elements to their correct positions. This is done by iterating
 * through the list multiple times, swapping elements with their neighbours if
 * they are not in the correct order.
 *
 * http://www.growingwiththeweb.com/2014/02/bubble-sort.html
 *
 * Time: O(n^2)
 *
 * Space O(1) auxiliary
 * 
 */
public class BubleSort<E extends Comparable<E>> {

	public List<E> bubleSort(List<E> lst) {
		for (int i = 0; i < lst.size() - 1; i++) {
			for (int j = 1; j < lst.size(); j++) {
				if (lst.get(j - 1).compareTo(lst.get(j)) > 0) {
					Util.swap(lst, j - 1, j);
				}
			}
		}
		return lst;
	}
	
	public List<E> bubleSortOptimised(List<E> lst){
		int unsortedBellow  = lst.size();
		while(unsortedBellow != 0){
			int lastSwap = 0;
			for(int i = 1; i<lst.size(); i++){
				if(lst.get(i-1).compareTo(lst.get(i))>0){
					Util.swap(lst, i-1, i);
					lastSwap = i;
				}
			}
			unsortedBellow = lastSwap;
		}
		
		return lst;
	}
}
