package Sorting;

/*
 * Implementation of insertion sort algorithm.
 * 
 * General working:
 * Maintain two sublists, one being sorted, other being 
 * unsorted. Place each element from unsorted part into
 * correct position in sorted list.
 * 
 * Complexity: O(n^2) (avg and best)
 * Swaps: n
 */

public class Insertion {

	public static void main(String[] args) {
		int[] a = {3, -6, 32, 0, -23, 0, 1, 2};
		insertion_sort(a);
		print_list(a);
	}

	private static void print_list(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
	}

	private static void insertion_sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int num = a[i]; // the pointer that separates the two lists
			int j = i; // j keeps track of sorted part
			while (j > 0 && num < a[j - 1]) {
				// we have a number less than previous number
				a[j] = a[j - 1]; // shift to the right
				j--; // move j back a step
			}
			a[j] = num; // put the number at right place
		}
	}

}
