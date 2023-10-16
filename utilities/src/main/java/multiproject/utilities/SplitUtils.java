package multiproject.utilities;

import multiproject.list.LinkedList;

/**
 * SplitUtils
 */
class SplitUtils {
  /**
   * Split string by spaces to linked list
   * @param source source string
   * @return linked list containing substrings separated by spaces
   */
  public static LinkedList split(String source) {
    if (source == null) {
      return null;
    }
    int lastFind = 0;
    int currentFind = 0;
    LinkedList result = new LinkedList();

    while ((currentFind = source.indexOf(" ", lastFind)) != -1) {
      String token = source.substring(lastFind);
      if (currentFind != -1) {
        token = token.substring(0, currentFind - lastFind);
      }

      addIfValid(token, result);
      lastFind = currentFind + 1;
    }

    String token = source.substring(lastFind);
    addIfValid(token, result);

    return result;
  }

  /**
   * Add token to list if it's valid
   * @param token token to add
   * @param list target linked list
   */
  private static void addIfValid(String token, LinkedList list) {
    if (token == null || list == null) {
      return;
    }
    if (isTokenValid(token)) {
      list.add(token);
    }
  }

  /**
   * Check if given token is valid
   * @param token token to check
   * @return boolean value for validity of token
   */
  private static boolean isTokenValid(String token) {
    return token != null && !token.isEmpty();
  }
}
