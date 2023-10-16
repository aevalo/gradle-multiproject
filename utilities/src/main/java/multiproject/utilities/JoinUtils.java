package multiproject.utilities;

import multiproject.list.LinkedList;

/**
 * JoinUtils
 */
class JoinUtils {
  /**
   * Join linked list to a string
   * @param source linked list to join
   * @return string containing elements from linked list separated by spaces
   */
  public static String join(LinkedList source) {
    if (source == null) {
      return null;
    }
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < source.size(); ++i) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(source.get(i));
    }

    return result.toString();
  }
}
