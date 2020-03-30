package Strings;

import java.util.Arrays;

/**
 * Problem: Check Permutations
 * 
 * Description: Given two strings, write a method to decide if one is a
 * permutation of the other.
 * 
 * Time Complexity:
 */
public class CheckPermutations {

  /**
   * Sort the string by character.
   * 
   * @param string input to sort
   * @return a concatenated sorted char array as String
   */
  static String sort(String string) {
    char[] chars = string.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  /**
   * Checks if string1 is a permutation of string2
   * 
   * @param string1 first string
   * @param string2 second string
   * @return true if permutation, else false
   */
  static boolean isPermutation(String string1, String string2) {
    if (string1.length() != string2.length()) {
      return false;
    }
    return sort(string1).equals(sort(string2));
  }

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    String string1 = "olaf";
    String string2 = "falo";

    System.out.println(isPermutation(string1, string2) ? "It's a permutation!" : "It's not a permutation!");
  }
}