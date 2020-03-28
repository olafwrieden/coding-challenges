import java.util.Stack;

/**
 * Problem: Balanced Parenthesis.
 * 
 * Description: Given an expression string, write a program to examine whether
 * the brackets are syntaxtically balanced.
 * 
 * Time Complexity: O(n)
 */
public class BalancedParenthesis {

  /**
   * Program entry point.
   * 
   * @param args program input parameters
   */
  public static void main(String[] args) {
    String balancedExpression = "{adf{}sd[asdf]}(ff)";
    String unbalancedExpression = "(adf{}sd[asdf]}(ff)";

    System.out.println(isBalanced(balancedExpression) ? "Balanced" : "Unbalanced");
    System.out.println(isBalanced(unbalancedExpression) ? "Balanced" : "Unbalanced");
  }

  /**
   * Checks if a bracket pair is valid.
   * 
   * @param char1 bracket 1
   * @param char2 bracket 2
   * @return true if char1 is the opening bracket for char2
   */
  static boolean isMatching(char char1, char char2) {
    if (char1 == '(' && char2 == ')') {
      return true;
    } else if (char1 == '{' && char2 == '}') {
      return true;
    } else if (char1 == '[' && char2 == ']') {
      return true;
    }
    return false;
  }

  /**
   * Checks if the input string's brackets are syntactically balanced.
   * 
   * @param expression input expression containing bracket pairs to check
   * @return true if brackets are balanced, else false
   */
  static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<Character>();

    for (Character character : expression.toCharArray()) {
      // Push opening brackets to stack
      if (character == '(' || character == '{' || character == '[') {
        stack.push(character);
      }
      // Evaluate closing brackets
      if (character == ')' || character == '}' || character == ']') {
        // If empty, it won't balance
        if (stack.isEmpty()) {
          return false;
        }
        // Pop off stack if balanced
        if (isMatching(stack.peek(), character)) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    // Finally, check if empty (balanced)
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }

}