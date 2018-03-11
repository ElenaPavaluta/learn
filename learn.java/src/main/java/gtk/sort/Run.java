package gtk.sort;

import gtk.sort.oNLogN.mergeSort.MergeSort;
import gtk.sort.oNLogN.quickSort.QuickSort;
import gtk.sort.oNPlusK.BucketSort;
import gtk.sort.oNSquare.BubleSort;
import gtk.sort.oNSquare.InsertionSort;
import gtk.sort.oNSquare.SelectionSort;

import java.util.ArrayList;
import java.util.List;



class Run {

	private static List<Integer> lst;
	
	static {
		lst = new ArrayList<>();
		lst.add(14);
		lst.add(33);
		lst.add(27);
		lst.add(10);
		lst.add(35);
		lst.add(19);
		lst.add(42);
		lst.add(44);
		System.out.println(lst);
	}

	static void mergeSort() {
		MergeSort<Integer> sort = new MergeSort<>();
		System.out.println(sort.mergeSort(lst));
	}
	
	static void quickSort(){
		QuickSort<Integer> sort= new QuickSort<>();
		System.out.println(sort.quickSort(lst));
	}

	static void insertionSort(){
		InsertionSort<Integer> sort = new InsertionSort<>();
		System.out.println(sort.insertionSort(lst));
	}
	
	static void selectionSort(){
		SelectionSort<Integer> sort = new SelectionSort<>();
		System.out.println(sort.selectionSort(lst));
	}
	
	static void bubleSort(){
		BubleSort<Integer> sort = new BubleSort<>();
		System.out.println(sort.bubleSort(lst));
	}
	static void bucketSort(){
		BucketSort sort = new BucketSort();
		System.out.println(sort.bucketSort(lst));
	}
	
	public static void main(String[] args) {
//		mergeSort();
//		quickSort();
//		insertionSort();
//		selectionSort();
//		bubleSort();
		bucketSort();
		
		
	}

}
