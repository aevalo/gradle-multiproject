package multiproject.utilities;

import multiproject.list.LinkedList;

/**
 * StringUtils
 */
public class StringUtils {
  /**
   * Join elements from linked list to a string
   * @param source linked list to join
   * @return string containing all elements from linked list
   */
  public static String join(LinkedList source) {
    return JoinUtils.join(source);
  }

  /**
   * Split string into linked list, split by spaces
   * @param source source string to split
   * @return linked list containing elements from string split by spaces
   */
  public static LinkedList split(String source) {
    return SplitUtils.split(source);
  }
}
