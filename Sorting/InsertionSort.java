package Sorting;

import java.util.Arrays;

/**
 * Sorting Algorithm: Insertion Sort
 * 
 * Description: We divide the array into two subsets (sorted and unsorted). As
 * we need something to compare to, we start iteratations from index 1.
 * Insertion sort removes next element from unsorted subset, finds the location
 * in the sorted subset where it belongs, and inserts it there.
 * 
 * Time Complexity: O(n^2) at worst (when array is reverse sorted), O(n) at best
 * (already sorted)
 * 
 * Space Complexity: O(1) for iterative solution below, O(n) for recursive stack
 */
public class InsertionSort {

  /**
   * Applies Insertion Sort to the input array.
   * 
   * @param array arrat to sort
   */
  static void insertionSort(int[] array) {
    // Compare second element with previous element
    for (int i = 1; i < array.length; i++) {
      int value = array[i];
      int j = i;

      // Find the index j within the sorted subset array[0..i-1] where element
      // array[i] belongs
      while (j > 0 && array[j - 1] > value) {
        array[j] = array[j - 1];
        j--;
      }

      // Insert value at correct position
      array[j] = value;
    }
  }

  public static void main(String[] args) {
    int[] array = { 3, 8, 5, 4, 1, 9, -2 };

    System.out.println("Unsorted: " + Arrays.toString(array));
    insertionSort(array);
    System.out.println("Sorted: " + Arrays.toString(array));
  }
}