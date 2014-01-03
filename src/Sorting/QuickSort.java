package Sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class QuickSort {
	
/*
 * Implementation of quick-sort algorithm.
 * 
 * General working:
 * Divide and conquer. Divide array into two parts
 * based on value of a random pivot. Do this recursively
 * on the sublists.
 * 
 * Complexity: O(n*logn) (average), O(n^2) (worst)
 */

	public static void main(String[] args) {
		int[] a = {3, -6, 32, 0, -23, 0, 1, 2};
		a = quick_sort(a);
		print_list(a);
	}

	private static void print_list(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
	}

	private static int[] quick_sort(int[] a) {
		if (a.length > 1) {
			List<Integer> less = new LinkedList<Integer>();
			List<Integer> more = new LinkedList<Integer>();
			List<Integer> equal = new LinkedList<Integer>();
			
			Random rand = new Random();
			int pivot_index = rand.nextInt(a.length); // get pivot index (0 to len-1)
			int pivot = a[pivot_index]; // that's the pivot value
			
			// sort the list into 3 lists
			for (int i = 0; i < a.length; i++) {
				if (a[i] < pivot) {
					less.add(a[i]);
				} else if (a[i] > pivot) {
					more.add(a[i]);
				} else {
					equal.add(a[i]);
				}
			}
			
			// and then recursively sort less and more
			less = array_to_list(quick_sort(linked_to_array(less)));
			more = array_to_list(quick_sort(linked_to_array(more)));
			
			// merge the lists
			less.addAll(equal);
			less.addAll(more);
			
			// and return it
			return linked_to_array(less);
		}
		return a;
	}
	
	/*
	 * Converts a List of Integers to an array.
	 */
	private static int[] linked_to_array(List<Integer> list) {
		int[] arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}
	
	/*
	 * Converts an array of ints to a LinkedList
	 */
	private static List<Integer> array_to_list(int[] arr) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

}
