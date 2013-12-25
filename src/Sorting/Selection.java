package Sorting;

/*
 * Implementation of selection sort algorithm.
 * 
 * General working:
 * Starting at index i, swap the value at index i with
 * the smallest value in the rest of the list.
 * 
 * Complexity: O(n^2)
 * Swaps: n
 */

public class Selection {

	public static void main(String[] args) {
		int[] a = {3, -6, 32, 0, -23, 0, 1, 2};
		selection_sort(a);
		print_list(a);
	}

	private static void print_list(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
	}

	private static void selection_sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					// swap
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}

}
