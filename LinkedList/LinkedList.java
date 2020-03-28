package LinkedList;

import java.util.NoSuchElementException;

/**
 * Node of a LinkedList
 */
class Node {
  private int value;
  private Node next;

  /**
   * Constructs a new Node
   * 
   * @param value node value
   */
  public Node(int value) {
    this.value = value;
  }

  /**
   * @return the value
   */
  public int getValue() {
    return value;
  }

  /**
   * @param next the next to set
   */
  public void setNext(Node next) {
    this.next = next;
  }

  /**
   * @return the next
   */
  public Node getNext() {
    return next;
  }
}

/**
 * LinkedList Implementation
 */
public class LinkedList {
  private Node first;
  private Node last;

  /**
   * Checks whether the LinkedList is empty.
   * 
   * @return true if empty, else false
   */
  private boolean isEmpty() {
    return first == null;
  }

  /**
   * Returns the previous Node to the input node.
   * 
   * @param node the Node for which to return the previous Node to
   * @return the Node prior to input node, else null
   */
  private Node getPrevious(Node node) {
    var current = first;
    while (current != null) {
      if (current.getNext() == node) {
        return current;
      }
      current = current.getNext();
    }
    return null;
  }

  /**
   * Adds a new item to the beginning of the LinkedList.
   * 
   * @param item item to add at the start
   */
  public void addFirst(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      first = last = node;
    } else {
      node.setNext(first);
      first = node;
    }
  }

  /**
   * Adds a new item to the end of the LinkedList.
   * 
   * @param item item to add at the end
   */
  public void addLast(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      first = last = node;
    } else {
      last.setNext(node);
      last = node;
    }
  }

  /**
   * Removes the first Node from the LinkedList.
   */
  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
      return;
    }

    var second = first.getNext();
    first.setNext(null);
    first = second;
  }

  /**
   * Removes the last Node from the LinkedList.
   */
  public void remoteLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
      return;
    }

    var previous = getPrevious(last);
    last = previous;
    last.setNext(null);
  }

  /**
   * Checks if the LinkedList contains the given item.
   * 
   * @param item the item to check for
   * @return true if found, else false
   */
  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  /**
   * Returns the index of a given item in the LinkedList.
   * 
   * @param item the item for which to return the index
   * @return index of item in LinkedList, -1 if not found
   */
  public int indexOf(int item) {
    int index = 0;
    var current = first;
    while (current != null) {
      if (current.getValue() == item) {
        return index;
      }
      current = current.getNext();
      index++;
    }
    return -1;
  }

  @Override
  public String toString() {
    String result = "";
    var currentNode = first;
    while (currentNode != null) {
      result += currentNode.getValue();
      result += currentNode.getNext() != null ? " -> " : "";
      currentNode = currentNode.getNext();
    }
    return "LinkedList: " + result;
  }
}

/**
 * Main
 */
class Main {
  public static void main(String[] args) {
    var list = new LinkedList();

    // Add Nodes
    list.addLast(10);
    System.out.println(list.toString());
    list.addLast(20);
    System.out.println(list.toString());
    list.addLast(30);
    System.out.println(list.toString());
    list.addFirst(5);
    System.out.println(list.toString());

    // Find Index
    System.out.println(list.indexOf(10));
    System.out.println(list.indexOf(30));
    System.out.println(list.indexOf(40));

    // Contains Value
    System.out.println(list.contains(40));
    System.out.println(list.contains(10));

    // Remove
    list.remoteLast();
    System.out.println(list.toString());
  }
}