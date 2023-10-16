package multiproject.app;

import java.util.Locale;

/**
 * MessageUtils
 */
class MessageUtils {
  /**
   * Get message
   * @return message with default locale
   */
  public static String getMessage() {
    Labels labels = new Labels();
    return labels.appMessage();

  }

  /**
   * Get message in specified locale
   * @param locale requested locale
   * @return message in requested locale
   */
  public static String getMessage(Locale locale) {
    Labels labels = new Labels(locale);
    return labels.appMessage();
  }
}
