package Strings;

/**
 * Problem: String Palindrome
 * 
 * Description: Given an input string (word), check if it reads the same way
 * backwards as it does forwards. Cannot use: return new
 * StringBuffer(word).reverse().toString().equals(word) ? true : false;
 * 
 * Time Complexity: O(n)
 */
public class StringPalindrome {

  /**
   * Checks if paramter word is a palindrome.
   * 
   * @param word input word to evaluate
   * @return true if palindrome, else false
   */
  public static boolean isPalindrome(String word) {
    word = word.trim();

    if (word.isEmpty()) {
      return false;
    }

    // Iterate half the word, comparing working inwards
    for (int i = 0; i < (word.length() / 2); i++) {
      // System.out.println("Comparing " + word.charAt(i) + " with " + word.charAt(word.length() - 1 - i));
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    System.out.println(isPalindrome("anna"));
    System.out.println(isPalindrome("madam"));
    System.out.println(isPalindrome("olaf"));
    System.out.println(isPalindrome(" anna"));
  }
}