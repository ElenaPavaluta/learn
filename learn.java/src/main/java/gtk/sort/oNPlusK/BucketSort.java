package gtk.sort.oNPlusK;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gtk.sort.oNSquare.InsertionSort;

/**
 * http://www.growingwiththeweb.com/2015/06/bucket-sort.html
 * 
 * https://www.cs.usfca.edu/~galles/visualization/BucketSort.html
 * 
 * 
 * Bucket sort can be exceptionally fast because of the way elements are
 * assigned to buckets, typically using an array where the index is the value.
 * This means that more auxiliary memory is required for the buckets at the cost
 * of running time than more comparison sorts. It runs in O(n+k) time in the
 * average case where n is the number of elements to be sorted and k is the
 * number of buckets.
 *
 *
 * Bucket sort is an ideal algorithm choice when:
 * 
 * - The additional O(n + k) memory usage is not an issue
 * 
 * - Elements are expected to be fairly evenly distributed
 *
 * The most common implementation of bucket sort works by splitting the array of
 * size nn into kk buckets, each of which house a value range of n/kn/k. The
 * buckets are then sorted using a simple sorting algorithm that works well on
 * the expected data, such as insertion sort. Buckets are typically implemented
 * using either linked lists or dynamic arrays. Time: O(n+k)
 *
 * Space: O(n+k)
 *
 */
public class BucketSort{
	private static final int DEFAULT_BUCKET_SIZE = 5;
	
	public List<Integer> bucketSort(List<Integer> lst){
		return sort(lst, DEFAULT_BUCKET_SIZE);		
	}

	private List<Integer> sort(List<Integer> lst, int bucketSize) {
		if(lst.size() == 0){
			return lst;
		}
		
		//Determine min and max values
		Integer min = lst.get(0);
		Integer max = lst.get(0);
		for(int i= 1; i<lst.size(); i++){
			if(lst.get(i).compareTo(min) < 0){
				min = lst.get(i);
			}else if(lst.get(i).compareTo(max)>0){
				max = lst.get(i);
			}
		}
		//Initialize buckets 
		int bucketCount = (max -min)/bucketSize + 1;
		List<List<Integer>> buckets = new ArrayList<>(bucketCount);
		for(int i = 0; i<bucketCount; i++){
			buckets.add(new LinkedList<>());
		}
		
		//Distribute input array values into buckets
		for(int i = 0; i<lst.size(); i++){
			List<Integer> l = buckets.get((lst.get(i)- min)/bucketSize);
			l.add(lst.get(i));
		}
		
		//Sort buckets and place back into input array
		InsertionSort<Integer> sort = new InsertionSort<>();
		int currentIndex = 0;
		for(int i = 0; i<buckets.size(); i++){
			List<Integer> l = buckets.get(i);
			l = sort.insertionSort(l);
			for(int j = 0; j<l.size(); j++){
				lst.set(currentIndex++, l.get(j));
			}
		}
		
		return lst;
	}


	

}
