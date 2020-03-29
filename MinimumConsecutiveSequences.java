import java.util.Arrays;

/**
 * Problem: Minimum Consecutive Sequences
 * 
 * Description: Given an array of integers, find the minimum number of
 * consecutive sequences that can be formed using the elements of the array.
 * 
 * Time Complexity: O(n log n)
 */
public class MinimumConsecutiveSequences {

  /**
   * Counts the consecutive sequences in the array.
   * 
   * @param array input array to iterate
   * @return minimum number of consecutive sequences
   */
  static int countSequences(int[] array) {
    // Sort array
    Arrays.sort(array);

    // Iterate array and check if current element is 1 smaller than the next
    int count = 1;
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] + 1 != array[i + 1]) {
        count++;
      }
    }

    return count;
  }

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println(countSequences(array));
  }
}