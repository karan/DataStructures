package Sorting;

public class MergeSort {
	
/*
 * Implementation of merge-sort algorithm.
 * 
 * General working:
 * Divide and conquer. Divide array into two parts
 * and sort them recursively, and then merge them.
 * 
 * Complexity: O(n*logn) (worst)
 */

	public static void main(String[] args) {
		int[] a = {3, -6, 32, 0, -23, 0, 1, 2};
		merge_sort(a);
		print_list(a);
	}

	private static void print_list(int[] a) {
		for (int v : a) {
			System.out.print(v + " ");
		}
	}

	private static void merge_sort(int[] a) {
		if (a.length > 1) {
			// recursively merge sort array
			int[] left = left(a);
			int[] right = right(a);
			
			merge_sort(left);
			merge_sort(right);
			
			merge(a, left, right);
		}
	}

	// returns left half of a array
	private static int[] left(int[] a) {
		int[] left = new int[a.length / 2];
		for (int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}
		return left;
	}
	
	// returns right half of the array
	private static int[] right(int[] a) {
		int size = a.length / 2;
		int[] right = new int[size];
		for (int i = 0; i < size; i++) {
			right[i] = a[i + size];
		}
		return right;
	}
	
	// merges the left and right array into the given array
	private static void merge(int[] a, int[] left, int[] right) {
		int l = 0; // index for left
		int r = 0; // index for right
		
		for (int i = 0; i < a.length; i++) {
			if (r >= right.length || (l < left.length && left[l] < right[r])) {
				a[i] = left[l];
				l++;
			} else {
				a[i] = right[r];
				r++;
			}
		}
	}

}
