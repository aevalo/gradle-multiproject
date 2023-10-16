package multiproject.list;

/**
 * LinkedList
 */
public class LinkedList {
  /**
   * Head node for the linked list
   */
  private Node head;

  /**
   * Add new element to the linked list
   * @param element element to add
   */
  public void add(String element) {
    Node newNode = new Node(element);

    Node it = tail(head);
    if (it == null) {
      head = newNode;
    } else {
      it.next = newNode;
    }
  }

  /**
   * Get tail element for linked list
   * @param head head element to start from
   * @return tail element for the linked list
   */
  private static Node tail(Node head) {
    Node it;

    for (it = head; it != null && it.next != null; it = it.next) {}

    return it;
  }

  /**
   * Remove element from the linked list
   * @param element element to remove
   * @return true if element was found, false otherwise
   */
  public boolean remove(String element) {
    boolean result = false;
    Node previousIt = null;
    Node it = null;
    for (it = head; !result && it != null; previousIt = it, it = it.next) {
      if (0 == element.compareTo(it.data)) {
        result = true;
        unlink(previousIt, it);
        break;
      }
    }

    return result;
  }

  /**
   * Unlink an element from the linked list
   * @param previousIt previous element
   * @param currentIt current element to remove
   */
  private void unlink(Node previousIt, Node currentIt) {
    if (currentIt == head) {
      head = currentIt.next;
    } else {
      previousIt.next = currentIt.next;
    }
  }

  /**
   * Size of the linked list
   * @return number of elements in the list
   */
  public int size() {
    int size = 0;

    for (Node it = head; it != null; ++size, it = it.next) {}

    return size;
  }

  /**
   * Get element of linked list at given element
   * @param index index to the requested element
   * @return element at given index
   * @throws IndexOutOfBoundsException when index is out of bounds for the linked list
   */
  public String get(int index) {
    Node it = head;
    while (index > 0 && it != null) {
      it = it.next;
      index--;
    }

    if (it == null) {
      throw new IndexOutOfBoundsException("Index is out of range");
    }

    return it.data;
  }

  /**
   * Node - private class representing node in the linked list
   */
  private static class Node {
    /**
     * Data for given node
     */
    final String data;
    /**
     * Reference to the next element in the list
     */
    Node next;

    /**
     * Construct new node for linked list
     * @param data data for the node
     */
    Node(String data) {
      this.data = data;
    }
  }
}
