package Strings;

/**
 * Problem: Unique Chars In String
 * 
 * Description: Implement an algorithm to determine if a string has all unique
 * characters.
 * 
 * Time Complexity: O(n) - but can argue O(1) as we never iterate > 128 chars
 */
public class UniqueCharsInString {

  /**
   * Checks if the input string has only unique characters.
   * 
   * @param string input to check
   * @return true if only unique chars, else false
   */
  static boolean isUniqueChars(String string) {
    // ASCII = 128, EXTENDED ASCII = 256
    if (string.length() > 128) {
      return false;
    }

    boolean[] charSet = new boolean[128];
    for (int i = 0; i < string.length(); i++) {
      int val = string.charAt(i);
      if (charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }
    return true;
  }

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    String unique = "uni";
    String nonUnique = "nonunique";

    System.out.println("String is: " + (isUniqueChars(unique) ? "Unique!" : "Not Unique!"));
    System.out.println("String is: " + (isUniqueChars(nonUnique) ? "Unique!" : "Not Unique!"));
  }
}