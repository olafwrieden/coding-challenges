package Strings;

/**
 * Problem: Is Permutation of Palindrome?
 * 
 * Description: Given a string, check if it is a permutation of a palindrome.
 * 
 * Time Complexity: 0(n) - we can't do better as we need to iterate each
 * position at least once.
 */
public class IsPermutationOfPalindrome {

  /**
   * Returns the integer value of the input character.
   * 
   * @param c input character
   * @return integer value of c, or -1 if not a-z
   */
  static int getCharNumber(Character c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int value = Character.getNumericValue(c);

    if (a <= value && value <= z) {
      return value - a;
    }
    return -1;
  }

  /**
   * Checks if the input string is a permutation of a palindrome.
   * 
   * @param string input string to evaluate
   * @return true if permutation of palindrome, else false
   */
  static boolean isPermutationOfPalindrome(String string) {
    int countOdd = 0;
    int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

    for (char c : string.toCharArray()) {
      int x = getCharNumber(c);
      if (x != -1) {
        table[x]++;
        if (table[x] % 2 == 1) {
          countOdd++;
        } else {
          countOdd--;
        }
      }
    }
    return countOdd <= 1;
  }

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    System.out.println(isPermutationOfPalindrome("Tact Coa"));
  }
}