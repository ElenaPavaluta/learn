package sort.util;

import java.util.List;

public class Util {

	public static <E> void swap(List<E> lst, int i, int j){
		E temp = lst.get(i);
		lst.set(i, lst.get(j));
		lst.set(j, temp);
	}
}
